package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
//import com.uber.h3core.util.GeoCoord;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.HotspotsProfit;
import io.renren.modules.helium.domain.Location;
import io.renren.modules.helium.domain.Result;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro
 * @ClassName HeliumUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-08 14:27
 * @Version 1.0
 **/
public class HeliumUtils {


    /**
     * @param typeId   天
     * @param hotspots 24小时
     * @return
     * @throws MsgException
     */
    public static double getHotspotsTotal(int typeId, String hotspots) throws MsgException {
        String url = "https://helium-api.stakejoy.com/v1/hotspots/%s/rewards/sum";
        url = String.format(url, hotspots);
//        System.out.println(url);

        Map<String, String> parameter = new HashMap<>();
        switch (typeId) {
            case 1:
                parameter.put("min_time", "-30 day");
                parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
                parameter.put("bucket", "day");
                break;
            case 2:
                parameter.put("min_time", "-48 hour");
                parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
                parameter.put("bucket", "hour");
                break;
        }

//        System.out.println(JSON.toJSONString(parameter));
        JSONObject jsonObject = getJSONObject(url, parameter);
        JSONArray jsonArray = (JSONArray) JSONUtils.getObjectBycol(jsonObject, "data");

        List<HotspotsProfit> hotspotsProfits = BeanUtils.toJavaObject(jsonArray, new TypeReference<List<HotspotsProfit>>() {
        });
//        System.out.println("------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ");
        double total = 0.0;
        LocalDateTime date = hotspotsProfits.get(0).getTimestamp();
        date = date.minusDays(1);
//        System.out.println(DateUtils.asStr(4, date));
        for (HotspotsProfit hotspotsProfit : hotspotsProfits) {
            if (date.compareTo(hotspotsProfit.getTimestamp()) < 0) {
                total += hotspotsProfit.getTotal();
//                System.out.println(DateUtils.asStr(4, hotspotsProfit.getTimestamp()) + " " + hotspotsProfit.getSum() + " " + hotspotsProfit.getTotal());
            }
        }
//        System.out.println(total);
        return total;
//        System.out.println(progressBar((int) (total * 100)));
    }


    /**
     * @throws
     * @title 根据设备地址获取设备信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:18
     */
    public static Device getHotspotsByAddress(String address) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://helium-api.stakejoy.com/v1/hotspots/%s", address)), new TypeReference<Result>() {
        });
        Device device = BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
        return device;
    }

    /**
     * @throws
     * @title 根据钱包地址获取钱包设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:21
     */
    public static List<Device> getWalletByAddress(String address) throws MsgException {

        get(String.format("https://helium-api.stakejoy.com/v1/accounts/%s/hotspots", address));

        Result result = BeanUtils.toJavaObject(null, new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }


    /**
     * @throws
     * @title 根据Hex获取HotspottyId
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    public static List<String> getHotspotIdsByHex(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://etl.hotspotty.org/api/v1/hotspots/history/summary-v2/%s", hex)), new TypeReference<Result>() {
        });
        System.out.println(JSON.toJSONString(result.getData()));
        JSONArray datas = JSONUtils.getJSONArray(BeanUtils.toJSON(result), "data");
        JSONObject data;
        List<String> hotsPottyIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            data = datas.getJSONObject(i);
            hotsPottyIds.add((String) JSONUtils.getObjectBycol(data, "id"));
        }
        return hotsPottyIds;
    }

    /**
     * @throws
     * @title 根据Hex获取HotspottyCHex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    public static List<String> getHotspotHexByCHex(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://etl.hotspotty.org/api/v1/hotspots/search-lean/?proximity_hex=%s", hex)), new TypeReference<Result>() {
        });
        StringUtils.writeList("\t", "【data】", JSON.toJSONString(result.getData()));
        JSONArray datas = JSONUtils.getJSONArray(BeanUtils.toJSON(result), "data");
        JSONObject data;
        List<String> hotsPottyIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            data = datas.getJSONObject(i);
            hotsPottyIds.add((String) JSONUtils.getObjectBycol(data, "l"));
        }
        return hotsPottyIds;
    }


    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public static boolean notIsDevice(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://helium-api.stakejoy.com/v1/hotspots/hex/%s", hex)), new TypeReference<Result>() {
        });
        System.out.println(JSON.toJSONString(result.getData()));
        return ObjectUtils.notIsEmpty(result.getData());
    }

    public static GeoCoord lookAround(String hex) {
        String resultHex = "";
        boolean sw;
        for (Object o : HexUtils.hex8Offset.keySet().toArray()) {
            try {
                resultHex = HexUtils.offset(hex, (String) o, 8);
                sw = notIsDevice(resultHex);
                StringUtils.writeList("\t", "【hex】 ", hex, o, resultHex, sw);
                if (sw) {
                    return null;
                } else {
                    return GeoCoord.build(resultHex, H3Core.newInstance().h3ToGeo(resultHex));
                }
            } catch (MsgException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Device> getHotspotsByWalletId(String wallId) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://helium-api.stakejoy.com/v1/accounts/%s/hotspots", wallId)), new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }

    public static String get(String url) throws MsgException {
        System.out.println(url);
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtils.get(url, HttpUtils.getHeadres(headersStr));
        return httpResultData.getResult();
    }


    public static JSONObject getJSONObject(String url, Map<String, String> parameter) throws MsgException {
        HttpResultData httpResultData = HttpUtils.get(url, parameter, new HashMap<>());
        return JSON.parseObject(httpResultData.getResult());
    }


    /**
     * 随机设备【递归|单用】
     *
     * @param completedRewardsBean
     * @return
     * @throws MsgException
     */
    public static GeoCoord getRandomDevice(CompletedRewardsBean completedRewardsBean) throws MsgException {
        if (ObjectUtils.notIsEmpty(completedRewardsBean) && ObjectUtils.notIsEmpty(completedRewardsBean.getHotspotIds())) {
            String id = completedRewardsBean.getHotspotIds().get(NumUtils.intervalRandom(completedRewardsBean.getHotspotIds().size()));
            completedRewardsBean.getHotspotIds().remove(id);
            Device device = getHotspotsByAddress(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            GeoCoord geoCoord = lookAround(device.getLocation_hex());
//            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
            StringUtils.writeList("\t", "【reward_scale】 ", device.getReward_scale());
            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
//                if (ObjectUtils.isEmpty(device.getReward_scale())) {
//                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
//                }
                return getRandomDevice(completedRewardsBean);
            }
            return geoCoord;
        }

        throw new MsgException("没有可以使用的位置设备了 " + completedRewardsBean.getHex());
    }

    /**
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public static GeoCoord getRandomDevice(List<String> cHexs) throws MsgException {

        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size()));
            cHexs.remove(cHex);
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord)) {
                return getRandomDevice(cHexs);
            }
            geoCoord.setCHex(cHex);
            return geoCoord;
        }

        throw new MsgException("没有可以使用的位置设备了 ");
    }

//
//    /**
//     * @throws
//     * @title 极速随机Hex
//     * @description
//     * @author Mr.Lv lvzhuozhuang@foxmail.com
//     * @updateTime 2022/3/15 7:10
//     */
//    public static GeoCoord getRandomDevice(List<String> cHexs, int num) throws MsgException {
//        List<GeoCoord> geoCoords = new ArrayList<>();
//        Map<String, String> keys = new HashMap<>();
//        GeoCoord geoCoord;
//        while (keys.size() != num) {
//            geoCoord = getRandomDevice(cHexs);
//            if(geoCoord.){
//
//            }
//            geoCoords.add();
//            keys.put()
//        }
//
//
//        throw new MsgException("没有可以使用的位置设备了 ");
//    }


    /**
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public static Location getLocation(String address, int num) throws MsgException {
        List<String> cHexs = getCHexsByAddress(address, 5);
        Location location = new Location();
        if (ObjectUtils.notIsEmpty(cHexs)) {
//            if (num < cHexs.size()) {
//                throw new MsgException(String.format("该地区不够%d个位置~", num));
//            }
            System.out.println(cHexs.size());
            List<GeoCoord> geoCoords = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                geoCoords.add(getRandomDevice(cHexs));
//            System.out.println(String.format("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
//            System.out.println(String.format("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
            }
            location = new Location(address, HexUtils.h3.h3ToParentAddress(cHexs.get(0), 5), geoCoords);
        }
        return location;
    }


    /**
     * 根据设备地址及分辨率获取设备
     *
     * @param address 设备地址
     * @param res     分辨率 1-9-c
     * @return
     * @throws MsgException
     */
    public static List<String> getCHexsByAddress(String address, int res) throws MsgException {
        Device device = getHotspotsByAddress(address);
        //获取该CHex的父级分辨率
        String parentHex = HexUtils.h3.h3ToParentAddress(device.getLocation(), res);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<String> cHex = new ArrayList<>();
        for (String hex : getHotspotHexByCHex(device.getLocation())) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(hex, res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(hex);
            }
//            StringUtils.writeList("\t", "【父级】", HexUtils.h3.h3ToParentAddress(hex, res));
        }
        return cHex;
    }


    //筛选 空的位置
    //        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
    //        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
    //        GeoCoord geoCoord = getRandomDevice(completedRewardsBean);
    //        System.out.println(geoCoord.toString());

    @Test
    public void asd() throws MsgException, IOException {

        //        System.out.println(JSON.toJSONString(getHotspotsByWalletId("14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob")));
//        h3ToParentAddress
        H3Core h3Core = H3Core.newInstance();
//        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
//        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
//        Device device;
//
////        device.getLocation_hex()
//        for (String hotspotId : completedRewardsBean.getHotspotIds()) {
//            device = getHotspotsByAddress(hotspotId);
//            StringUtils.writeList("\t", "【父级】", h3Core.h3ToParentAddress(device.getLocation_hex(), 5));
////            HexUtils.
//        }


        List<String> cHexs = getCHexsByAddress("112b5iBRmR5ps5eWpCbB6CoqyDimWDZgDjVMCvbigKDiUmTghJUn", 5);

        System.out.println(cHexs.size());
        System.out.println(getRandomDevice(cHexs).toString());


//        String hex5 = h3Core.h3ToParentAddress("8c180cd8c8e35ff", 5);
//
//        Device device;
//        for (String hex : getHotspotHexByCHex("8c180cd8c8e35ff")) {
////            device = getHotspotsByAddress(hotspotId);
//            StringUtils.writeList("\t", "【父级】", h3Core.h3ToParentAddress(hex, 5));
//        }
//
//        StringUtils.writeList("\t", "【hex】", hex5);


        //8c180cd8c8e35ff GeoCoord{lat=51.552836, lng=-9.507861}
        //88180cd8c9fffff GeoCoord{lat=51.555244, lng=-9.507171}
//        System.out.println(HexUtils.h3.h3ToGeo("88180cd8c9fffff").toString());
    }
}
