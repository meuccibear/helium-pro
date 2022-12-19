package io.renren.run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.dao.BusinessDeviceMapper;
import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.MakersService;
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
    Helium helium;

    @Resource
    BusinessDeviceMapper businessDeviceMapper;

    @Autowired
    HeliumApi heliumApi;

    @Autowired
    MakersService makersService;
    @Autowired
    BusinessDeviceService businessDeviceService;

    @SneakyThrows
    @Before
    public void before() {
        h3Core = H3Core.newInstance();
    }

    H3Core h3Core;

    String filePath = "../data";
    String resultPath = filePath + "/result";

    int res = 5;

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
        List<String> lines = FileUtils.readLines("../data/aroundDevice.txt");
        int k = 2;
        String path = String.format("%s/%d【周围设备】", resultPath, System.currentTimeMillis()) ;
        List<JSONObject> jsons = new ArrayList<>();
        for (String line : lines) {
            jsons.addAll(depley(line, res, k));
        }

        String[] keys = new String[]{"status", "corePoint", "hex5", "depllist", "twoLevelName", "ip",  "address", "total24h"};
        List<String> strings = BeanUtils.toJavaObject(keys, new TypeReference<List<String>>() {{
        }});
        JSONUtils.toCsvTitle(path, strings);
//        log.info("{}",JSON.toJSONString(strings));
        JSONUtils.toCsv(path, strings, jsons.toArray());
    }

    @Test
    public void getDevice() {
        String filePath = String.format("%s/%d【设备信息】", resultPath, System.currentTimeMillis());

        List<String> lines = FileUtils.readLines("../data/hotspotty.txt");
        Map<String, String> makersDictionary = makersService.getMakersDictionary();
        List<List<String>> lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(lines, 200), new TypeReference<List<List<String>>>(){{}});
        List<String> tmp;
        for (int i = 0; i < lists.size(); i++) {
            tmp= lists.get(i);
            if (tmp.size() > 0) {
                log.info("num{}\t{}\t{}", i, tmp.size(), JSON.toJSONString(lists.get(i)));
                businessDeviceService.getDevice(makersDictionary, new HashMap<>(), lists, i, filePath);
            }
        }
    }

    /**
     * @throws
     * @title 显示可用hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 15:22
     */
    @Test
    public void showAvailableHexs() {

        String groupStr =
                        "881f12ae17fffff\t1\n" +
                                "881f12aee1fffff\t1\n" +
                                "881f12ae91fffff\t1\n" +
                                "881f12aebbfffff\t1\n" +
                                "881f12aea7fffff\t1\n" +
                                "881f12ac1dfffff\t1\n" +
                                "881f12acc5fffff\t1\n" +
                                "881f12acc3fffff\t1\n" +
                                "8819420147fffff\t1\n" +
                                "8819420169fffff\t1\n" +
                                "8819421897fffff\t1\n" +
                                "88194218b3fffff\t1\n" +
                                "8819421895fffff\t1\n" +
                                "8819421993fffff\t1\n" +
                                "8819420a0bfffff\t1\n" +
                                "8819420a29fffff\t1\n" +
                                "87182ca9bffffff\t3\n" +
                                "88182ca981fffff\t1\n" +
                                "88182ca98dfffff\t1\n" +
                                "88182ca9c7fffff\t1\n" +
                                "88182ca9d3fffff\t1\n" +
                                "88182ca9c5fffff\t1\n" +
                                "862da5367ffffff\t4\n" +
                                "862da536fffffff\t4\n" +
                                "861f4481fffffff\t2\n" +
                                "861f44817ffffff\t2\n" +
                                "861f448a7ffffff\t2\n" +
                                "861f448afffffff\t2\n" +
                                "8639567b7ffffff\t4\n" +
                                "8639567a7ffffff\t4";
        String filePath = String.format("%s/%d【坐标】", resultPath, System.currentTimeMillis());
        List<List<String>> groupTable = StringUtils.toTableList(groupStr);

        helium.getLocations(filePath, groupTable);

    }

    List<JSONObject> depley(String address, int res, int k) {
        Device device = heliumApi.getHotspotsByAddress(address);
        String hexR = h3Core.h3ToParentAddress(device.getLocation_hex(), res);
        log.info("中心点:{}", hexR);
        List<String> strings = h3Core.kRing(hexR, k);
        log.info("周围方块:{}", JSON.toJSONString(strings));
        List<BusinessDevice> devices = businessDeviceMapper.selectAllByHex5(strings);
        JSONObject jsonObject;

        List<JSONObject> jsons = new ArrayList<>();
        for (BusinessDevice businessDevice : devices) {
            jsonObject = JSONUtils.toJSONObject(businessDevice);
            jsonObject.put("corePoint", address);
            jsons.add(jsonObject);
        }

        return jsons;
    }

}
