package io.renren.run;

import com.alibaba.fastjson.JSON;
import com.uber.h3core.H3Core;
import io.renren.modules.business.dao.BusinessDeviceMapper;
import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.helium.HexUtils;
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
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HexDemo {

    @Resource
    BusinessDeviceMapper businessDeviceMapper;

    @Autowired
    HeliumApi heliumApi;

    @SneakyThrows
    @Test
    public void run() {
        int res = 6;
        // 每天一次
//        updateDBHex5(res);

        depley(heliumApi.getHotspotsByAddress("11pFCP3GhMpXqUFwMnjCs14BLqp39fio68NLhgLXhvPrQeebgu4"), res, 2);
    }

    H3Core h3Core;

    @SneakyThrows
    @Before
    public void before() {
        h3Core = H3Core.newInstance();
    }

    public void depley(Device device, int res, int k) throws IOException {

        updateDBHex5(res);

        String hexR = h3Core.h3ToParentAddress(device.getLocation_hex(), res);

        log.info("中心点:{}", hexR);
        List<String> strings = h3Core.kRing(hexR, k);
        log.info("周围方块:{}", JSON.toJSONString(strings));
        List<BusinessDevice> devices = businessDeviceMapper.selectAllByHex5(strings);
        for (BusinessDevice businessDevice : devices) {
            log.info("{} {}", businessDevice.getOneLevelName(), businessDevice.getTwoLevelName());
        }
    }

    public void updateDBHex5(int res) {
        // 刷新hex5
        List<BusinessDevice> devices = businessDeviceMapper.selectAll();

        for (BusinessDevice businessDevice : devices) {
            businessDeviceMapper.updateHex5ByAddress(HexUtils.h3.h3ToParentAddress(businessDevice.getHex(), res), businessDevice.getAddress());
        }
    }
}
