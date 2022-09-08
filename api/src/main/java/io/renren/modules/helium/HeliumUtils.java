package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtilsx;
import io.renren.modules.helium.domain.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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
@Slf4j
public class HeliumUtils {

    //    static String WWW = "https://helium-api.stakejoy.com/";
    static String WWW = "https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/";
    private static String proIP;

    /**
     * @param typeId   天
     * @param hotspots 24小时
     * @return
     * @throws MsgException
     */
    public static double getHotspotsTotal(int typeId, String hotspots) throws MsgException {
        String url = "v1/hotspots/%s/rewards/sum";
        url = String.format(url, hotspots);
//        System.out.println(url);

        Map<String, String> parameter = new HashMap<>();

        LocalDateTime maxTime = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        String localDateTime = df.format(maxTime);
        maxTime = LocalDateTime.parse(localDateTime, df);

        switch (typeId) {
            case 1:
                parameter.put("min_time", "-30 day");
                parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
                parameter.put("bucket", "day");
                break;
            case 2:
                parameter.put("min_time", "-48 hour");
                parameter.put("max_time", DateUtils.asStr(maxTime, "UTC"));
                parameter.put("bucket", "hour");
                break;
        }

        JSONObject jsonObject = getJSONObject(url, parameter);
//        if (null != jsonObject) {
            JSONArray jsonArray = (JSONArray) JSONUtils.jsGetData(jsonObject, "data");

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
//        }
//
//        return -1;
//        System.out.println(progressBar((int) (total * 100)));
    }


    /**
     * @return
     * @throws
     * @title 根据设备地址获取设备信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:18
     */
    public static Device getHotspotsByAddress(String address) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("v1/hotspots/%s", address)), new TypeReference<Result>() {
        });
        Device device = BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
        return device;
    }

    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public static boolean notIsDevice(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get("https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/", String.format("v1/hotspots/hex/%s", hex)), new TypeReference<Result>() {
        });
        System.out.println("notIsDevice:\t" + JSON.toJSONString(result.getData()));
        return ObjectUtils.notIsEmpty(result.getData());
    }

    /**
     * @param hex
     * @return
     */
    public static GeoCoord lookAround(String hex) {
        String resultHex = "";
        boolean sw;
        for (Object o : HexUtils.hex8Offset.keySet().toArray()) {
            try {
                resultHex = HexUtils.offset(hex, (String) o, 8);
                sw = notIsDevice(resultHex);
                StringUtils.writeList("\t", "【hex】 ", hex, o, resultHex, HexUtils.h3.h3ToParentAddress(resultHex, 5), sw);
                if (sw) {
                    continue;
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
        Result result = BeanUtils.toJavaObject(get(String.format("v1/accounts/%s/hotspots", wallId)), new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }

    public static String get(String url) throws MsgException {
        return get(WWW, url);
    }

    public static String get(String qUrl, String url) throws MsgException {
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtilsx.get(qUrl + url, HttpUtilsx.getHeadres(headersStr));
        return httpResultData.getResult();
    }


    /**
     * @return true 黑 false 白
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/18 20:06
     */
    public static boolean denylist(String address) throws MsgException {
        JSONObject jsonO = JSON.parseObject(get("https://denylist-api.herokuapp.com/", "api/hotspots/" + address));
        return jsonO.getJSONArray("denylists").size() > 0;
    }

    public static JSONObject getJSONObject(String url, Map<String, String> parameter) throws MsgException {
//        try {
//            if(ObjectUtils.isEmpty(proIP)){
//                proIP = AuthFactory.builds().get_dp();
//                HttpUtilsx.setProxyAddr(proIP);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        HttpResultData httpResultData = HttpUtilsx.get(WWW + url, parameter, new HashMap<>());
        log.info("httpResultData:{}{}", url, JSON.toJSONString(httpResultData));

//        if (200 != httpResultData.getStatus()) {
            return JSON.parseObject(httpResultData.getResult());
//        }
//        return null;
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
    public static GeoCoord getRandomDevice(List<LeanData> cHexs) throws MsgException {

        StringUtils.writeList("\t", "getRandomDevice", cHexs.size(), JSON.toJSONString(cHexs));
        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size())).getL();
            cHexs.remove(cHex);
            HEXS.containsKey(cHex);
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord)) {
                return getRandomDevice(cHexs);
            }
            HEXS.put(cHex, cHex);
            System.out.println("[geoCoord.hex] " + JSON.toJSONString(geoCoord));
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
//    public static Location getLocation(String address, int num) throws MsgException {
//        List<String> cHexs = getCHexsByHex(address, 5);
//        Location location = new Location();
//        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0), 5);
//        if (ObjectUtils.notIsEmpty(cHexs)) {
////            if (num < cHexs.size()) {
////                throw new MsgException(String.formatKV("该地区不够%d个位置~", num));
////            }
//            System.out.println(cHexs.size());
//            List<GeoCoord> geoCoords = new ArrayList<>();
//            for (int i = 0; i < num; i++) {
//                geoCoords.add(getRandomDevice(cHexs));
////            System.out.println(String.formatKV("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
////            System.out.println(String.formatKV("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
//            }
//            location = new Location(hex3, address, geoCoords);
//        }
//        return location;
//    }

    static Map<String, String> HEXS = new HashMap<>();

    /**
     * @return
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public static Map<String, List<GeoCoord>> getLocations(String address, int num) throws MsgException {
        StringUtils.writeList("\t", "【getLocations】 ", address, num);

        List<LeanData> cHexs = getCHexsByHex(address, 5);

        Map<String, List<GeoCoord>> geoMap = new HashMap<>();
        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0).getL(), 5);
        StringUtils.writeList("\t", "【getLocations】 ", cHexs.size());

        if (ObjectUtils.notIsEmpty(cHexs)) {
//            if (num < cHexs.size()) {
//                throw new MsgException(String.formatKV("该地区不够%d个位置~", num));
//            }
            List<GeoCoord> geoCoords = new ArrayList<>();
            GeoCoord randomDevice;
            for (int i = 0; i < num; i++) {
                randomDevice = getRandomDevice(cHexs);
//                if(ObjectUtils.isEmpty(randomDevice)){
//                    i--;
//                    continue;
//                }
                geoCoords.add(randomDevice);
//            System.out.println(String.formatKV("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
//            System.out.println(String.formatKV("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
            }
            StringUtils.writeList("\t", "【getLocations】 ", JSON.toJSONString(geoCoords));

            geoMap.put(hex3, geoCoords);
//            location.json = new Location(hex3, address, geoCoords);
        }
        return geoMap;
    }


    /**
     * 根据设备地址及分辨率获取设备
     *
     * @param address 设备地址
     * @param res     分辨率 1-9-c
     * @return
     * @throws MsgException
     */
//    public static List<String> getCHexsByAddress(String address, int res) throws MsgException {
//        Device device = getHotspotsByAddress(address);
//        //获取该CHex的父级分辨率
//        String parentHex = HexUtils.h3.h3ToParentAddress(device.getLocation(), res);
//        //圈里的设备的父级分辨率
//        String sonParentHex;
//        List<String> cHex = new ArrayList<>();
//        for (String hex : HotsPottyUtils.getHotspotHexByCHex(device.getLocation())) {
//            sonParentHex = HexUtils.h3.h3ToParentAddress(hex, res);
//            if (parentHex.equals(sonParentHex)) {
//                cHex.add(hex);
//            }
////            StringUtils.writeList("\t", "【父级】", HexUtils.h3.h3ToParentAddress(hex, res));
//        }
//        return cHex;
//    }

    /**
     * @param address 设备地址
     * @param res     分辨率 1-9-c
     * @return
     * @throws
     * @title 根据设备地址及分辨率获取设备
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/16 15:32
     */
    public static List<LeanData> getCHexsByHex(String parentHex, int res) throws MsgException {
        //获取该CHex的父级分辨率

        String sonHex = HexUtils.h3.h3ToCenterChild(HexUtils.h3.h3ToParentAddress(parentHex, 4), 12);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<LeanData> cHex = new ArrayList<>();
        List<LeanData> leanDataList = HotsPottyUtils.getHotspotHexByCHex(sonHex);
        for (LeanData leanData : leanDataList) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(leanData.getL(), res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(leanData);
            }
        }
        return cHex;
    }

//    public void saveLocations(String text) throws MsgException {
//        List<List<String>> groupTable = StringUtils.toTableList(text);
//
//        Map<String, Location> locationNums = new HashMap<>();
//
//        for (List<String> lines : groupTable) {
//            if (lines.size() >= 2) {
//                locationNums.put(lines.get(0), HeliumUtils.getLocation(lines.get(0), ObjectUtils.toInt(lines.get(0))));
//            }
//        }
//
////        FileUtils.write("./data/locations", JSON.toJSONString(locations));
//    }

    public static List<Role> roles(String hotspotsId, String cursorNo, int index) throws MsgException {
        JSONObject rolesJ = null;
        List<Role> roleL = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            rolesJ = roles(hotspotsId, null, cursorNo);
            Object data = JSONUtils.jsGetData(rolesJ, "data");
            if (ObjectUtils.notIsEmpty(data)) {
                for (Role role : BeanUtils.toJavaObject(data, new TypeReference<List<Role>>() {
                })) {
                    role.setAdditionalparameters(hotspotsId, cursorNo);
                    roleL.add(role);
                }
            }
            cursorNo = (String) JSONUtils.jsGetData(rolesJ, "cursors");
        }
        return roleL;
    }

    public static List<Role> roles(String hotspotsId) throws MsgException {
        String cursorNo = "";
        if (cursor.containsKey(hotspotsId)) {
            cursorNo = cursor.get(hotspotsId);
        } else {
            JSONObject json = roles(hotspotsId, "", null);
            if (json.containsKey("cursors")) {
                cursor.put(hotspotsId, (String) json.get("cursors"));
                cursorNo = cursor.get(hotspotsId);
            }
        }

//        return roles(hotspotsId, cursorNo);
        return roles(hotspotsId, cursorNo, 4);
//        JSONObject roles = roles(hotspotsId, null, cursorNo);
//        return BeanUtils.toJavaObject(roles, new TypeReference<RestBean>() {});

    }

    /**
     * Activity
     *
     * @param hotspotsId  地址
     * @param filterTypes 筛选
     * @param cursor      当前页序列码
     * @return
     */
    public static JSONObject roles(String hotspotsId, String filterTypes, String cursor) {
        String url = String.format("%sv1/hotspots/%s/roles", WWW, hotspotsId);

        Map<String, String> parameter = new HashMap<>();
        if (null != filterTypes) {
            parameter.put("filter_types", filterTypes);
        }
        if (ObjectUtils.notIsEmpty(cursor)) {
            parameter.put("cursor", cursor);
        }

        return getJSONO(url, parameter);
    }

    public static String roleTransactions(Role role) {
        JSONObject json = transactions(role.getHotspottyId(), role.getHash());
        switch (role.getRole()) {
//            case "gateway":
//                break;
//            case "challenger":
//                break;
            case "reward_gateway":
                return String.format("Total:%s", JSONUtils.jsGetData(json, "data.rewards"));
//                break;
//            case "challengee":
//                break;
            default:
                System.out.println(String.format("roleTransactions %s\t|\t%s", role.getType(), role));
                return json.toJSONString();
        }
    }

    public static JSONObject transactions(String hotspotsId, String hash) {
        String url = String.format("%sv1/transactions/%s", WWW, hash);
        Map<String, String> parameter = new HashMap<>();
        parameter.put("actor", hotspotsId);
        return getJSONO(url, parameter);
    }

    @SneakyThrows
    public static JSONObject getJSONO(String url, Map<String, String> parameter) {
        return JSONObject.parseObject(getStr(url, parameter).getResult());
    }

    @SneakyThrows
    public static HttpResultData getStr(String url, Map<String, String> parameter) {
        System.out.println(String.format("=============>>\n get %s \n %s", url, JSON.toJSONString(parameter)));

        String headStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36\n";
        HttpResultData httpResultData = HttpUtilsx.get(url, parameter, headStr);

        System.out.println(String.format("<<=============\n %s", JSON.toJSONString(httpResultData.getResult())));
        System.out.println(String.format("<<=============\n %s", JSON.toJSONString(JSONUtils.jsGetData(httpResultData.getResult(), "data"))));
        return httpResultData;
    }

    static String cursorFilePath = "cursors.txt";

    static Map<String, String> cursor = new HashMap<>();


    public HeliumUtils open() throws MsgException {
        List<String> strings = FileUtils.readLines(cursorFilePath);
        if (ObjectUtils.notIsEmpty(strings)) {
            cursor = BeanUtils.toJavaObject(strings.get(0), new TypeReference<Map<String, String>>() {
            });
        }
        return this;
    }

//    public static String activity(String hotspotsId) throws MsgException {
//
//
//
//        JSONObject json = roles(hotspotsId);
//        String result = (String) json.get("cursors");
////        info(result);
//
////        String result = HttpUtils.getInputStream(WWW + "v1/hotspots/" + hotspotsId + "/activity");
////        JSONObject json = JSONObject.parseObject(result);
//
//        throw new MsgException("没有找到数据~");
//    }

    public void close() throws MsgException {
        FileUtils.write(cursorFilePath, JSON.toJSONString(cursor));
    }

    //筛选 空的位置
    //        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
    //        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
    //        GeoCoord geoCoord = getRandomDevice(completedRewardsBean);
    //        System.out.println(geoCoord.toString());

    public static void showRoles(String id) throws MsgException {
        List<Role> restBean = roles(id);
        for (Role role : restBean) {
            role.init();
        }
        for (Role role : restBean) {
            System.out.println(role.getMsg());
        }
    }

    /**
     * @throws
     * @title 查看Hotspotty网站Hex情况
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/13 13:51
     */
    public static String dashboard(String hex) throws MsgException {
        List<LeanData> leanDataL = getCHexsByHex(hex, 5);
        int onlineNum = 0;
        Double scF = null;
        Double scL = null;
        for (LeanData leanData : leanDataL) {
//            log.info("【leanData.JSON】{}", JSON.toJSONString(leanData));
//            log.info(StringUtils.outStr("\t", leanData.getN().replaceAll("-", " "), leanData.getD(), leanData.getOnline()));
            if (leanData.getOnline()) {
                onlineNum++;
            }
            if (ObjectUtils.isEmpty(scL)) {
                scL = leanData.getRs();
            } else if (scL < leanData.getRs() && leanData.getRs() > 0) {
                scL = leanData.getRs();
            }

            if (ObjectUtils.isEmpty(scF)) {
                scF = leanData.getRs();
            } else if (scF > leanData.getRs() && leanData.getRs() > 0) {
                scF = leanData.getRs();
            }
        }

        //坐标地址  总数  离线数量    在线数量    尸体百分比 最低scanl  最高scanl
        return StringUtils.outStr("\t", hex, leanDataL.size(), leanDataL.size() - onlineNum, onlineNum, (((leanDataL.size() - onlineNum) * 100) / leanDataL.size()) + "%", scF, scL);
    }


    public static void main(String[] args) throws MsgException {
        showRoles("112Qg8YJPzAhiVvuMS6HKtr5t2ttYDFSrUz9CYr7dqW2CpUZFBzA");
    }
}
