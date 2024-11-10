/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren;
import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
//import io.renren.common.apiUtil.HeliumHttpUtils;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HeliumDBTest {

//    @Autowired
//    HeliumHttpUtils heliumHttpUtils;

    @Autowired
    GlobalDeviceService globalDeviceService;

    @Autowired
    HeliumApi heliumApi;
    @Autowired
    private BusinessG5DeviceService businessG5DeviceService;

    @SneakyThrows
    @Test
    public void run() {
//        System.out.println(JSON.toJSONString(heliumHttpUtils.getCHexsByHex("8565010ffffffff", 5)));
        businessG5DeviceService.updateAddress();
//        heliumApi.getG5Devices("11QMM7ggrqP1aN9Hn1i3Jv7sinxu7XYEAvxVYE7a5S1YU3hVNhE");
    }

    /**
     * @title 查询尸体
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/27 16:58
     * @throws
     */
    @Test
    public void findCorpse () throws MsgException {
//        List<SourceCorpse> sourceCorpses = globalDeviceService.findsourceCorpses5ByLongCountry("China");
//        log.info(JSON.toJSONString(sourceCorpses));
//        String filePath = String.format("./result/hotspottyDashboard_%s", System.currentTimeMillis());
//        for (SourceCorpse sourceCorps : sourceCorpses) {
//            System.out.println(StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                    sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                    sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)));
//
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                            sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                            sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
//                    true, true);
//        }
    }


//    @Test
    /** 获取去重之后的Hex
     * @title getDuplicateRemovalCHexsByHex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/13 16:24
     * @throws
     */
//    public void getDuplicateRemovalCHexsByHex() {
//        try {
//            heliumHttpUtils.getDuplicateRemovalCHexsByHex("8531a877fffffff", 5);
//        } catch (MsgException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void hotspottyDashboard() throws MsgException {
        List<String> lines = FileUtils.readLines("../data/hotspotty.txt");
        String filePath = String.format("./result/hotspottyDashboard_%s", System.currentTimeMillis());
        for (int i = 0; i < lines.size(); i++) {
            FileUtils.writeln(filePath, HeliumUtils.dashboard(lines.get(i)), true, i != 0);
        }
    }

//    @Test
//    public void getHotspotsByAddress() throws MsgException {
////        heliumHttpUtils.getHotspotsByAddress("11KdepEV6ePzbCvBnoLD9fauw5j6wb44w4ckHFmNMGkGFYLVMtP");
//        List<String> lines = FileUtils.readLines("../data/hotspotty.txt");
//
//        Map<String,String> h = new HashMap<>();
//        for (String line : lines) {
//            if(!h.containsKey(line)){
//                System.out.println(HeliumUtils.dashboard(line));
//                h.put(line, line);
//            }
//        }
//
//    }

}
