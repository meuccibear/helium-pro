package io.renren.run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uber.h3core.H3Core;
import io.renren.Hex;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.map.NumMap;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.helium.*;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.api.HeliumApi;
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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName HeliumMapTest
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-15 19:53
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@EnableAsync
public class HeliumTest {
    @Autowired
    HeliumApi heliumApi;

    @Autowired
    Bobcat bobcat;

    @Autowired
    HeliumHttpUtils heliumHttpUtils;

    @Autowired
    BusinessDeviceService businessDeviceService;

    @Autowired
    GlobalDeviceService globalDeviceService;


    //        String groupStr =
//                "8519518ffffffff\t13\n" +
//                        "852d3307fffffff\t14\n" +
//                        "861e1b2b7ffffff\t6\n" +
//                        "861e1b297ffffff\t4\n" +
//                        "851f5237fffffff\t10\n" +
//                        "861f25327ffffff\t7\n" +
//                        "861f25337ffffff\t6\n" +
//                        "861f8326fffffff\t4\n" +
//                        "861f83267ffffff\t5\n" +
//                        "8639223b7ffffff\t7\n" +
//                        "863922397ffffff\t6\n" +
//                        "852db18bfffffff\t14";

//    String groupStr =
//                "8519518ffffffff\t13\n" +
//                        "852d3307fffffff\t14\n" +
//                        "861e1b2b7ffffff\t6\n" ;

    /**
     * @throws
     * @title 显示可用hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 15:22
     */
    @Test
    public void showAvailableHexs() throws MsgException {
        String groupStr =
                        "852db1a3fffffff\t8\n" +
                                "8639220cfffffff\t4\n" +
                                "8639220efffffff\t4\n" +
                                "861e1b2b7ffffff\t4\n" +
                                "861e1b297ffffff\t4\n" +
                                "861ec0d6fffffff\t4\n" +
                                "861ec099fffffff\t4\n" +
                                "86194d1b7ffffff\t4\n" +
                                "86194d1a7ffffff\t4\n" +
                                "863f68d87ffffff\t4\n" +
                                "863f68d8fffffff\t4\n" +
                                "863f6811fffffff\t4\n" +
                                "863f6812fffffff\t4"  ;
        String filePath = "../data/result/坐标_" + System.currentTimeMillis();

        List<List<String>> groupTable = StringUtils.toTableList(groupStr);
        for (List<String> strings : groupTable) {
            try {
                getLocations(filePath, strings.get(0), Integer.parseInt(strings.get(1)));
            } catch (Exception e) {
                e.printStackTrace();
                FileUtils.writeln(String.format(filePath, strings.get(0)), "【有问题】" + strings.get(0), true, true);
            }
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
        String wall = "";
        Map<String, String> ownerNo = formatOwnerNo(wall);
        List<List<String>> lists = ObjectUtils.averageAssign(lines, 200);
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).size() > 0){
                log.info("num{}\t{}\t{}", i, lists.get(i).size(), JSON.toJSONString(lists.get(i)));
                businessDeviceService.getDevice(ownerNo, lists, i, filePath);
            }
        }
    }

    /**
     * @title 获取Bobcat设备的miner信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/7/28 14:41
     * @throws
     */
    @Test
    public void getBobcatMinerJson() throws MsgException {
        String filePath = String.format("%s\\bobcat_%d", "../data/result/", System.currentTimeMillis());

        String ips =
                "192.168.4.47\n" +
                        "192.168.4.75\n" +
                        "192.168.4.51";
        String[] split = ips.split("\n");

        for (String s : split) {
            bobcat.re(s, filePath);
        }
    }



    @Test
    /**
     * @title 显示可用hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 15:22
     * @throws
     */
    public void clients() throws MsgException {
        List<String> strings = FileUtils.readLines("./data/hotspotty.txt");
        String filePath = "../data/" + System.currentTimeMillis();
        JSONObject jsonObject;
        String client;
        for (String string : strings) {
            jsonObject = null;
            client = "";

            jsonObject = heliumHttpUtils.client(string);
            client = ObjectUtils.notIsEmpty(jsonObject) ? String.valueOf(JSONUtils.jsGetData(jsonObject, "client.usesig")) : "";
            FileUtils.writeln(filePath, client, true, true);
        }

    }

    /**
     * 获取坐标周围没有定位的坐标
     */
    @Test
    public void showAvailableHex() throws MsgException {
        List<String> hexs = Hex.kRing("8840e274c3fffff", 1);
        List<String> rows = new ArrayList<>();

        for (String hex : hexs) {
            if (!heliumApi.existingEquipment(hex)) {
                com.uber.h3core.util.GeoCoord geoCoord = HexUtils.h3.h3ToGeo(hex);
                rows.add(geoCoord.lat + "\t" + geoCoord.lng + "\t" + hex + "\t" + HexUtils.h3.h3ToParentAddress(hex, 5));
            }
        }
        rows.forEach(row -> {
            System.out.println(row);
        });
    }

    @Test
    public void run () throws MsgException {
        JSONArray makers = (JSONArray) heliumApi.getResultV("makers");
        JSONObject jsonObject;
        for (int i = 0; i < makers.size(); i++) {
            jsonObject = makers.getJSONObject(i);

            System.out.println(String.format("INSERT INTO `makers`(`makers_id`, `address`, `name`) VALUES (null, '%s', '%s');", JSONUtils.jsGetData(jsonObject, "address"), JSONUtils.jsGetData(jsonObject, "name")));
        }
    }

    /**
     * @return
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public void getLocations(String filePath, String hex, int num) throws MsgException, IOException {
        // 获取方块等级
        int res = H3Core.newInstance().h3GetResolution(hex);

        // 检验方块等级
        if (res < 0 || res > 8) {
            throw new IllegalArgumentException(String.format("resolution %d is out of range (must be 0 < res < 8)", res));
        }

//        List<LeanData> cHexs = getDuplicateRemovalCHexsByHex(hex);
        // 获取所有的方块
        List<String> cHexs = getNullLocalhost(hex);

        if (num > cHexs.size()) {
            FileUtils.writeln(filePath, String.format("%s 可以使用的位置只有%d个, 不够%d个", hex, cHexs.size(), num), true, true);
            num = cHexs.size();
        }

        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0), res);
        StringUtils.writeList("\t", "【getLocations】 hex:", hex, "num:", num, "hex3:", hex3, "cHexs.size:", cHexs.size());
//        StringUtils.writeList("\t", "【cHexs】 ", JSON.toJSONString(cHexs));

        // 输出
        if (ObjectUtils.notIsEmpty(cHexs)) {
            List<GeoCoord> geoCoords = getRandomDevices(hex, res, num, cHexs);
            for (GeoCoord geoCoord : geoCoords) {
                //FileUtils.write(String.format(filePath, geoCoord.getSouHex()), geoCoord.getLat() + "\t" + geoCoord.getLng() + "\t" + geoCoord.getGroup() + "\t" + geoCoord.getCHex() + "\t" + geoCoord.getSouHex());
                FileUtils.writeln(filePath, geoCoord.getLat() + "\t" + geoCoord.getLng() + "\t" + geoCoord.getCHex() + "\t" + geoCoord.getSouHex(), true, true);
            }
        }
    }

    /**
     * 获取随机设备
     *
     * @param hex
     * @param res
     * @param num
     * @param cHexs
     * @return
     * @throws IOException
     * @throws MsgException
     */
    public List<GeoCoord> getRandomDevices(String hex, int res, int num, List<String> cHexs) throws IOException, MsgException {
        // 存放坐标
        List<GeoCoord> geoCoords = new ArrayList<>();
        // 临时存放随机设备
        GeoCoord randomDevice;
        Map<String, String> geoCoordMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            randomDevice = getRandomDevice(cHexs);
            randomDevice.setSouHex(H3Core.newInstance().h3ToParentAddress(randomDevice.getCHex(), res));
            // 设置分组
            // randomDevice.setGroup(group);
            if (!geoCoordMap.containsKey(randomDevice.getCHex()) && hex.equals(randomDevice.getSouHex())) {
                geoCoordMap.put(randomDevice.getCHex(), randomDevice.getCHex());
                geoCoords.add(randomDevice);
            } else {
                i -= 1;
            }
        }

        return geoCoords;
    }


    /**
     * 获取空位置
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public List<String> getNullLocalhost(String hex) throws MsgException {
        int res = 8;

        List<String> leanDataHexs = new ArrayList<>();
        for (LeanData removalCHexsByHex : getDuplicateRemovalCHexsByHex(hex)) {
            leanDataHexs.add(Hex.h3ToParentAddress(removalCHexsByHex.getL(), res));
        }

        List<String> sonHexs = Hex.getSonHexs(hex, res);
        List<String> resultHex = new ArrayList<>();
        for (String sonHex : sonHexs) {
            if (!leanDataHexs.contains(sonHex)) {
                resultHex.add(sonHex);
//                FileUtils.writeln("../data/resultHex", sonHex, true, true);
            }
        }
        System.out.println(String.format("%d-%d=%d", sonHexs.size(), leanDataHexs.size(), resultHex.size()));

        return resultHex;
    }


    /**
     * 获取所有的坐标并且去掉重复的坐标
     *
     * @param parentHex
     * @param res
     * @return
     * @throws MsgException
     */
    public List<LeanData> getDuplicateRemovalCHexsByHex(String parentHex) throws MsgException {
        List<LeanData> cHexsByHex = getCHexsByHex(parentHex, Hex.getResolution(parentHex));
        NumMap hexNumMap = new NumMap();
        List<LeanData> result = new ArrayList<>();
        for (LeanData hexsByHex : cHexsByHex) {
            if (!hexNumMap.add(HexUtils.h3.h3ToParentAddress(hexsByHex.getL(), 8))) {
                result.add(hexsByHex);
            }
        }
        return result;
    }

    /**
     * @param parentHex 父级Hex
     * @param res       分辨率 1-9-c
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 12:09
     */
    public List<LeanData> getCHexsByHex(String parentHex, int res) throws MsgException {
        //获取该CHex的父级分辨率

        String sonHex = HexUtils.h3.h3ToCenterChild(HexUtils.h3.h3ToParentAddress(parentHex, 4), 12);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<LeanData> cHex = new ArrayList<>();
        List<LeanData> leanDataList = new HotsPottyHttpUtils().getHotspotHexByCHex(sonHex);
        for (LeanData leanData : leanDataList) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(leanData.getL(), res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(leanData);
            }
        }
        return cHex;
    }


    /**
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public GeoCoord getRandomDevice(List<String> cHexs) throws MsgException {
        StringUtils.writeList("\t", "剩余", cHexs.size());
//        StringUtils.writeList("\t", "剩余", cHexs.size(), JSON.toJSONString(cHexs));
        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size()));
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord)) {
                return getRandomDevice(cHexs);
            }
            System.out.println("[geoCoord.hex] " + JSON.toJSONString(geoCoord));
            return geoCoord;
        }
        throw new MsgException("没有可以使用的位置设备了 ");
    }

    /**
     * @param hex
     * @return
     */
    public GeoCoord lookAround(String hex) {
        boolean sw = false;
        try {
            sw = notIsDevice(hex);
        } catch (MsgException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        StringUtils.writeList("\t", "【hex】 ", hex, sw);
        if (sw) {
            return null;
        } else {
            return GeoCoord.build(hex, Hex.h3ToGeo(hex));
        }
    }

    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public boolean notIsDevice(String hex) throws MsgException, URISyntaxException {
        Result result = heliumHttpUtils.getResult(HeliumHttpUtils.Website.Blockjoy, String.format("v1/hotspots/hex/%s", hex));
        if (ObjectUtils.isEmpty(result)) {
            return false;
        }
        return ObjectUtils.notIsEmpty(result.getData());
    }


    @SneakyThrows
    @Test
    /**
     * 获取全球设备
     */
    public void getAllDevice() {
        String cursor = "eyJoZWlnaHQiOjEzOTU4MDEsImZpbHRlcl9tb2RlcyI6WyJmdWxsIiwibGlnaHQiLCJkYXRhb25seSJdLCJiZWZvcmVfYmxvY2siOjExOTE1NjksImJlZm9yZV9hZGRyZXNzIjoiMTFZYUxFQkhhRlZMellSckFvRWRKYzhDQ1NXdnBYZUZqTFNTa0JzVGZNNkhhcFIxSzhjIn0";
        while (null != cursor) {
            cursor = globalDeviceService.addNetHeliumDevice(cursor);
            System.out.println(cursor);
        }
    }

    @Test
    public void hotspottyDashboard() throws MsgException {
        List<String> lines = FileUtils.readLines("../data/hotspotty.txt");
        String filePath = String.format("./result/hotspottyDashboard_%s", System.currentTimeMillis());
        for (int i = 0; i < lines.size(); i++) {
            FileUtils.writeln(filePath, HeliumUtils.dashboard(lines.get(i)), true, i != 0);
        }
    }


    /**
     * @throws
     * @title 分析尸体
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/27 16:38
     */
    @SneakyThrows
    @Test
    public void analysis() {
        String filePath = String.format("%s\\%d", "../data/result/", System.currentTimeMillis());
        FileUtils.writeln(filePath, StringUtils.outStr("\t", "hex5", "总数", "离线", "在线", "国家", "城市编号", "区域设备",
                        "最低分值", "城市", "离线率"),
                true, true);
        List<SourceCorpse> sourceCorpses = globalDeviceService.findsourceCorpses5ByLongCountry(null, filePath);

//        for (SourceCorpse sourceCorps : sourceCorpses) {
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                            sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                            sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
//                    true, true);
//        }
    }

    /**
     * @throws
     * @title 钱包格式化
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/22 15:43
     */
    public Map<String, String> formatOwnerNo(String str) {
        Map<String, String> map = new HashMap<>();

        if (ObjectUtils.notIsEmpty(str)) {
            for (String s : str.split("\n")) {
                String[] split = s.split("\t");
                map.put(split[1], split[0]);
            }
        }
        return map;
    }


}
