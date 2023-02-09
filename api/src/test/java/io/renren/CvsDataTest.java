package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.api.domain.CorpseUtil;
import io.renren.modules.sys.dao.LocationsMapper;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.SourceCorpseService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName CvsDataTest
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-16 20:01
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@Slf4j
public class CvsDataTest {
    @Autowired
    private LocationsMapper locationsMapper;

    @Autowired
    BusinessG5DeviceService g5DeviceService;


    @Autowired
    private BusinessDeviceService businessDeviceService;

    @Autowired
    private HeliumApi heliumApi;

    @Autowired
    CorpseUtil corpseUtil;

    @Autowired
    SourceCorpseService sourceCorpseService;

    @SneakyThrows
    @Test
    public void findCorpses() throws MsgException {

        String[] countrys = new String[]{
                //北欧
                "Sweden",
                "Norway",
                "Iceland",
                "Denmark",
//                "Germany",
                "Faroe",
                //东欧
                "Estonia",
                "Latvia",
                "Lithuania",
                "Moldova",
                "Belarus",
                "Russia",
                "Ukraine",
                //中欧
                "Poland",
                "Czech",
                "Slovakia",
                "Hungary",
                "Germany",
                "Austria",
                "Switzerland",
                "Liechtenstein",
                //西欧
                "Ireland",
                "Netherlands",
                "Belgium",
                "Luxembourg",
                "France",
                "Monaco",
                //南欧
                "Albania",
                "Greece",
                "Italy",
                "Malta",
                "Spain",
                "Portugal",
                "Andorra",
                "Gibraltar"

        };

        String filePath = String.format("%s\\%d", "../data/result", System.currentTimeMillis());
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

        List<List<String>> lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(cityids, 200), new TypeReference<List<List<String>>>() {{
        }});

        for (int i = 0; i < lists.size(); i++) {
            updateData1(lists, i, filePath);
        }

    }

    @Async("taskExecutor")
    public void updateData1(List<List<String>> lists, int index, String filePath) throws Exception {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String cityid = null;

        for (int i = 0; i < addresss.size(); i++) {
            cityid = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));

            try {
                List<Device> devices = heliumApi.getHotspotsByCities(cityid);
                List<SourceCorpse> sourceCorpses = corpseUtil.checkDevice(devices, 5);
                for (SourceCorpse sourceCorps : sourceCorpses) {
                    FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
                                    sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
                                    sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
                            true, true);
                }
            } catch (MsgException | URISyntaxException e) {
                log.error("[findCorpseS]", e);
            }
        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }


    public void findCorpse(List<String> cityids, String filePath) throws Exception {
        for (String cityid : cityids) {
            String location = Base64Utils.encryptBASE64(cityid.getBytes()).replaceAll("==", "").replaceAll("\r\n", "");
            try {
                List<Device> devices = heliumApi.getHotspotsByCities(location);
                List<SourceCorpse> sourceCorpses = corpseUtil.checkDevice(devices, 5);
                for (SourceCorpse sourceCorps : sourceCorpses) {
                    FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
                                    sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
                                    sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8), sourceCorps.getCountry(), sourceCorps.getCity()),
                            true, true);
                }
            } catch (MsgException | URISyntaxException e) {
                log.error("[findCorpseS]", e);
            }
        }
    }

    @SneakyThrows
    @Test
    public void dashboard() {
        List<String> hexs = sourceCorpseService.findHex();
        for (int i = 0; i < hexs.size(); i++) {
            List<LeanData> hotspotsByProximityHex = heliumApi.getHotspotsByProximityHex(hexs.get(i));
            corpseUtil.checkLeanData(hotspotsByProximityHex, 5);
        }
    }

    /**
     * @throws
     * @title 挑选位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/19 13:55
     */
    @Test
    public void picklocationTest() throws MsgException {
        String groupStr =
                "851955cbfffffff\t8\n" +
                        "861ec96dfffffff\t8\n" +
                        "861ec9a9fffffff\t8";
        String group = "分组";
        String filePath = String.format("%s\\picklocationTest_%d", "../data/result", System.currentTimeMillis());
        List<List<GeoCoord>> geoCoordss = heliumApi.picklocations(groupStr);
        Map<String, String> hash = new HashMap<>();
        for (int i = 0; i < geoCoordss.size(); i++) {
            for (GeoCoord geoCoord : geoCoordss.get(i)) {
                FileUtils.writeln(filePath, StringUtils.outStr("\t", geoCoord.getLat(), geoCoord.getLng(), group + i, geoCoord.getCHex(), geoCoord.getSouHex(), hash.containsKey(geoCoord.getCHex())), true, true);
                hash.put(geoCoord.getCHex(), geoCoord.getCHex());
            }
        }

        log.info("{}", filePath);
    }

    @SneakyThrows
    @Test
    public void findCorpse() {
        String location = "eXVuY2hlbmcgc2hpc2hhbnhpIHNoZW5nY2hpbmE";
        String filePath = String.format("%s\\picklocationTest_%d", "../data/result", System.currentTimeMillis());
        List<Device> devices = heliumApi.getHotspotsByCities(location);
        List<SourceCorpse> sourceCorpses = corpseUtil.checkDevice(devices, 5);

        for (SourceCorpse sourceCorps : sourceCorpses) {
            for (Device device : sourceCorps.getDevices()) {
                System.out.println(StringUtils.outStr("\t", sourceCorps.getHex(), device.getAddress(), device.getName()));
            }
            FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
                    sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount()
                    , sourceCorps.getCountry(), sourceCorps.getCity()), true, true);
//            log.info("{}", JSON.toJSONString(sourceCorps));
        }
    }


    /**
     * @throws
     * @title 周围的方块
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/22 13:00
     */
    @SneakyThrows
    @Test
    public void surroundingSquares() {
        //周围的方块 顺序是从9点钟方向逆时针转
        List<String> strings = HexUtils.h3.kRing("881e1b2905fffff", 1);
//        List<String> strings = HexUtils.h3.kRing("8840905715fffff", 1);
        System.out.println(JSON.toJSONString(strings));

        List<String> rows = new ArrayList<>();
        for (String string : strings) {
            com.uber.h3core.util.GeoCoord geoCoord = HexUtils.h3.h3ToGeo(string);
            if (!heliumApi.existingEquipment(string)) {
                rows.add(geoCoord.lat + "\t" + geoCoord.lng + "\t" + string + "\t" + HexUtils.h3.h3ToParentAddress(string, 5));
            }
        }

        rows.forEach(row -> {
            System.out.println(row);
        });
    }

    public static H3Core H3C;

    static {
        try {
            H3C = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void surroundingSquaress(String hex) throws MsgException {
//        int res = H3C.h3GetResolution(hex);
//
//        String sonCenHex = HexUtils.h3.h3ToCenterChild(hex, res + 1);
//        System.out.println(sonCenHex);
//
//        //周围的方块 顺序是从9点钟方向逆时针转
//        List<String> strings = HexUtils.h3.kRing(sonCenHex, 1);


        List<String> strings = HexUtils.h3.kRing("8840905715fffff", 1);
        System.out.println(JSON.toJSONString(strings));

        List<String> rows = new ArrayList<>();
        for (String string : strings) {
            com.uber.h3core.util.GeoCoord geoCoord = HexUtils.h3.h3ToGeo(string);
            if (!heliumApi.existingEquipment(string)) {
                rows.add(geoCoord.lat + "\t" + geoCoord.lng + "\t" + string + "\t" + HexUtils.h3.h3ToParentAddress(string, 5));
            }
        }

        rows.forEach(row -> {
            System.out.println(row);
        });
    }


    @Test
    public void asd() {
        BusinessGateway gateway = new BusinessGateway();
        gateway.setGatewayId("HL-2221-00023146");
        gateway.setAddress("112bVsPwQXFAZdiSYhc5bqK1xVg6yAdFk8EvDRPLbProemh2j1z5");

//        gateway.setGatewayId("HL-2221-00023146");
//        gateway.setAddress("112RMRGV9R8NqbCMLxbc7sTWyE3TKwZSdxWNJ5gsbNXfCXgn84n9");

//        gateway.setGatewayId("HL-2221-00023119");
//        gateway.setAddress("112NyouASkDR7e2sjABpDJ7EBV23eg5MKp3dqCdAyYRsRuYsBwKm");
//        gateway.setOwner("13UTFy2QrNJEZLVd3gmiYjEY73AU5xbfRCJ4dVsWQYnYBsSpJtb");
        g5DeviceService.income(gateway);

        log.info("{}", JSONObject.toJSONString(gateway));
    }

}
