/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.sys.dao.LocationsMapper;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时刷新数据测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@Slf4j
public class TimedRefreshDataTest {
    @Autowired
    private GlobalDeviceService globalDeviceService;

    @Autowired
    private LocationsMapper locationsMapper;

    @Autowired
    BusinessDeviceService businessDeviceService;

    @SneakyThrows
    @Test
    public void run() {
//        List<List<String>> lists = ObjectUtils.averageAssignPartition(businessDeviceService.findAll(), 5);
//        for (int i = 0; i < lists.size(); i++) {
//            businessDeviceService.updateData(makersDictionary, lists, i);
//        }
//        businessDeviceService.updateData(lists.get(0), "0");
//        businessDeviceService.updateData(new ArrayList<String>() {{
//            add("112FTJDurzT9SQTwRQkL9Cv22qXLiF9PuaSYhz3qMy7Y1QGghXF8");
//            add("112WsyGBHyPWgadjVZQMkCZgFP5XXAEWSNGgspmM7GVbdfF41ZEh");
//        }});
//        112FTJDurzT9SQTwRQkL9Cv22qXLiF9PuaSYhz3qMy7Y1QGghXF8
//        {"result":"{\"error\":\"Not Found\"}","cookie":{},"status":404}
    }


    /**
     * @throws
     * @title 获取设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/27 16:38
     */
    @SneakyThrows
    @Test
    public void getDevice1() {
        String filePath = String.format("%s\\%d", "../data/result/", System.currentTimeMillis());
        List<SourceCorpse> sourceCorpses = globalDeviceService.findsourceCorpses5ByLongCountry("China", filePath);
        for (SourceCorpse sourceCorps : sourceCorpses) {
            FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
                            sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
                            sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
                    true, true);
        }
    }

    /**
     * @throws
     * @title 获取设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/27 16:38
     */
    @SneakyThrows
    @Test
    public void getDevice() {
        String filePath = String.format("%s\\%d", "../data/result/", System.currentTimeMillis());
//        List<SourceCorpse> sourceCorpses = globalDeviceService.findsourceCorpses5ByLongCountry("US", filePath);
//        for (SourceCorpse sourceCorps : sourceCorpses) {
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                            sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                            sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
//                    true, true);
//        }
//        log.info(JSON.toJSONString(sourceCorpses));
        List<String> lines = FileUtils.readLines("./data/hotspotty.txt");
//
        List<List<String>> lists = ObjectUtils.averageAssignPartition(lines, 200);
//        设备地址	黑名单（true:黑机 false:白机器）	名称	钱包	状态	网络地址	国家	城市	24H收益	经纬度
        for (int i = 0; i < lists.size(); i++) {
            log.info("num{}\t{}\t{}", i, lists.get(i).size(), JSON.toJSONString(lists.get(i)));
//            businessDeviceService.getDevice(null, lists, i, filePath);
        }
    }

    /**
     * @throws
     * @title 获取设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/27 16:38
     */
    @SneakyThrows
    @Test
    public void dashboard() {
        String filePath = String.format("%s\\%d", "../data/result/", System.currentTimeMillis());
//        List<String> sourceCorpses = globalDeviceService.selectHex5ByLongCountry("China");
        List<String> sourceCorpses = FileUtils.readLines("./data/hex5s");

        List<List<String>> lists = ObjectUtils.averageAssignPartition(sourceCorpses, 200);
        for (int i = 0; i < lists.size(); i++) {
            log.info("num{}\t{}\t{}", i, lists.get(i).size(), JSON.toJSONString(lists.get(i)));
            businessDeviceService.dashboard(lists, i, filePath);
        }
    }


    @SneakyThrows
    @Test
    public void addHeliumGlobalDevice() {
        //欧洲
        /*        String[] countrys = new String[]{
                //北欧
                "Sweden",
                "Norway",
                "Iceland",
                "Denmark",
//                "Germany",
                "Faroe",
                //东欧
                "Estonia" ,
                "Latvia" ,
                "Lithuania" ,
                "Moldova" ,
                "Belarus" ,
                "Russia" ,
                "Ukraine",
                //中欧
                "Poland" ,
                "Czech" ,
                "Slovakia" ,
                "Hungary" ,
                "Germany" ,
                "Austria" ,
                "Switzerland" ,
                "Liechtenstein",
                //西欧
                "Ireland" ,
                "Netherlands" ,
                "Belgium" ,
                "Luxembourg" ,
                "France" ,
                "Monaco",
                //南欧
                "Albania" ,
                "Greece" ,
                "Italy" ,
                "Malta" ,
                "Spain" ,
                "Portugal" ,
                "Andorra" ,
                "Gibraltar"
        };*/

        String[] countrys = new String[]{"China"};

        String filePath = String.format("%s\\%d", "../data/result/", System.currentTimeMillis());
        List<String> cityids = locationsMapper.findCityidByLongcountry(countrys);
        log.info("查询到了{}条数据", cityids.size());
        Map<String, String> mm = new HashMap<>();
        for (String cityid : cityids) {
            String location = Base64Utils.encryptBASE64(cityid.getBytes()).replaceAll("==", "").replaceAll("\r\n", "");
            mm.put(location, location);
        }
        cityids = BeanUtils.toJavaObject(mm.keySet().toArray(), new TypeReference<List<String>>() {{
        }});
        log.info("查询到了{}条数据", cityids.size());

        List<List<String>> lists = ObjectUtils.averageAssignPartition(cityids, 200);

        for (int i = 0; i < lists.size(); i++) {
            businessDeviceService.addHeliumGlobalDevice(lists, i, filePath);
        }
    }

    @SneakyThrows
    @Test
    public void addHeliumGlobalDevicev2() {
        String filePath = String.format("%s\\%d", "../data/result", System.currentTimeMillis());
        List<String> cursors = FileUtils.readLines("./data/cursors");
        log.info("查询到了{}条数据", cursors.size());
//        @Autowired
//        GlobalDeviceService globalDeviceService;
        List<List<String>> lists = ObjectUtils.averageAssignPartition(cursors, 400);
        for (int i = 0; i < lists.size(); i++) {
            if(ObjectUtils.notIsEmpty(lists.get(i))){
                businessDeviceService.addHeliumGlobalDevicev2(lists, i, filePath);
            }
        }
    }

}
