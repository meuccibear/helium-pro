package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.HotspotsProfit;
import io.renren.modules.helium.domain.Result;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
        JSONArray jsonArray = (JSONArray) get(jsonObject, "data");

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


    public static Device getHotspotsById(String id) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://helium-api.stakejoy.com/v1/hotspots/%s", id)), new TypeReference<Result>() {
        });
        Device device = BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
        return device;
    }


    public static List<Device> getWalletById(String wallId) throws MsgException {

        get(String.format("https://helium-api.stakejoy.com/v1/accounts/%s/hotspots", wallId));

        Result result = BeanUtils.toJavaObject(null, new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices;
    }

    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public static boolean notDevice(String hex) throws MsgException {

        get(String.format("https://helium-api.stakejoy.com/v1/hotspots/hex/%s", hex));

        Result result = BeanUtils.toJavaObject(null, new TypeReference<Result>() {
        });
        List<Device> devices = BeanUtils.toJavaObject(result.getData(), new TypeReference<List<Device>>() {
        });
        return devices.size() > 0;
    }

    public static GeoCoord lookAround(String hex)  {
        String resultHex = "";
        for (Object o : HexUtils.hex8Offset.keySet().toArray()) {
            try {
                resultHex = HexUtils.offset(hex, (String) o, 8);
                if(notDevice(resultHex)){
                    return H3Core.newInstance().h3ToGeo(resultHex);
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


    public static Object get(JSONObject jsonObject, String... keys) {
        if (null != keys) {
            String key = "";
            for (int i = 0; i < keys.length; i++) {
                key = keys[i];
                if (i < keys.length) {
                    return jsonObject.get(key);
                } else {
                    jsonObject = jsonObject.getJSONObject(key);
                }
            }
        }
        return jsonObject;
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
            Device device = getHotspotsById(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            GeoCoord geoCoord = lookAround(device.getLocation_hex());
//            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
            System.out.println("\t\t\t【reward_scale】 "+device.getReward_scale());
            if (ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(geoCoord) || device.getStatus().getOnline().equals("")) {
                if (ObjectUtils.isEmpty(device.getReward_scale())) {
                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
                }
                return getRandomDevice(completedRewardsBean);
            }
            return geoCoord;
        }

        throw new MsgException("没有可以使用的位置设备了 " + completedRewardsBean.getHex());
    }



    public static void main(String[] args) throws MsgException {
//        System.out.println(JSON.toJSONString(getHotspotsByWalletId("14AhgRBQewe9CJwW6fQ9Dz1NEniUxP2bZem7wmPwsXobfDSHXob")));
        HexUtils hexUtils = new HexUtils("./data/Hexs_shcz.txt");
        CompletedRewardsBean completedRewardsBean = hexUtils.getHex("85180cdbfffffff");
        GeoCoord geoCoord = getRandomDevice(completedRewardsBean);

        System.out.println(geoCoord.toString());
    }
}
