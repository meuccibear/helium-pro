package io.renren.run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.dao.BusinessDeviceMapper;
import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.sys.api.HeliumApi;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HexDemo {

    @Resource
    BusinessDeviceMapper businessDeviceMapper;

    @Autowired
    HeliumApi heliumApi;

    @SneakyThrows
    @Before
    public void before() {
        h3Core = H3Core.newInstance();
    }

    H3Core h3Core;

    String filePath = "../data/csv/";

    int res = 6;

    /**
     * 更新数据库位置信息
     * eg :
     * 更改方块等级 第一次运行 需要执行该操作
     */
    @Test
    public void updateDBHex5() {
        // 刷新hex5
        List<BusinessDevice> devices = businessDeviceMapper.selectAll();

        for (BusinessDevice businessDevice : devices) {
            if (ObjectUtils.notIsEmpty(businessDevice.getHex())) {
                businessDevice.setHex5(h3Core.h3ToParentAddress(businessDevice.getHex(), res));
            }
        }

        Map<Object, List<Object>> classify = JSONUtils.classify(devices, "hex5", "address");
        for (Object o : classify.keySet().toArray()) {
            businessDeviceMapper.updateHex5ByAddress((String) o, BeanUtils.toJavaObject(classify.get(o), new TypeReference<List<String>>() {
            }));
        }

    }

    /**
     * 查找周围设备
     */
    @Test
    public void getAroundDevice() {
        List<String> lines = FileUtils.readLines("./data/aroundDevice.txt");
        int k = 2;
        String path = filePath + System.currentTimeMillis();
        List<JSONObject> jsons = new ArrayList<>();
        for (String line : lines) {
            jsons.addAll(depley(line, res, k));
        }
        JSONUtils.toCsv(path, jsons.toArray());

    }

    public List<JSONObject> depley(String address, int res, int k) {
        Device device = heliumApi.getHotspotsByAddress(address);
        String hexR = h3Core.h3ToParentAddress(device.getLocation_hex(), res);
        log.info("中心点:{}", hexR);
        List<String> strings = h3Core.kRing(hexR, k);
        log.info("周围方块:{}", JSON.toJSONString(strings));
        List<BusinessDevice> devices = businessDeviceMapper.selectAllByHex5(strings);
        JSONObject jsonObject;

        List<JSONObject> jsons = new ArrayList<>();
        for (BusinessDevice businessDevice : devices) {
            jsonObject = BeanUtils.toJSONObject(businessDevice);
            jsonObject.put("corePoint", address);
            jsons.add(jsonObject);
        }

        return jsons;
    }

}
