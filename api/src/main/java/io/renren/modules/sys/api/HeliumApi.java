package io.renren.modules.sys.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.HotspotsProfit;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.service.WebsiteApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName HeliumApi
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-17 19:02
 * @Version 1.0
 **/
@Slf4j
@Component
public class HeliumApi {

    @Resource
    WebsiteApiService websiteApiService;

    /**
     * @return
     * @throws
     * @title 根据设备地址获取设备信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:18
     */
    public Device getHotspotsByAddress(String address) throws MsgException {
        JSONObject result = (JSONObject) getResultV("getHotspotsByAddress", address);
        return BeanUtils.toJavaObject(JSONUtils.jsGetData(result, "data"), new TypeReference<Device>() {
        });
    }

    public JSONObject getMinerJson(String ip) throws MsgException {
        return getResultVS("miner", ip);
    }


    public RestBean getAllDevice(String address) throws MsgException {
        JSONObject result = (JSONObject) getResultV("getAllDevice", address);
        return BeanUtils.toJavaObject(result, new TypeReference<RestBean>() {
        });
    }

    public Double getHotspotsTotal(int typeId, String address) throws MsgException {
        Map<String, String> parameter = new HashMap<>();
        parameter.put("address", address);
        parameter.put("min_time", "-30 day");
        parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
        parameter.put("bucket", "day");
        switch (typeId) {
            case 1:
                parameter.put("min_time", "-48 hour");
                parameter.put("bucket", "hour");
                break;
        }

        Result result = getResultKV("getEarningsByAddress", parameter);
//        JSONArray jsonArray = (JSONArray) JSONUtils.jsGetData(jsonObject, "data");
        JSONArray jsonArray = BeanUtils.toJavaObject(result.getData(), new TypeReference<JSONArray>() {{
        }});

        List<HotspotsProfit> hotspotsProfits = BeanUtils.toJavaObject(jsonArray, new TypeReference<List<HotspotsProfit>>() {
        });
//        System.out.println("------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ");
        Double total = 0.0;
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
    }


    public Boolean denylist(String address) throws MsgException {
        HttpResultData httpResultData = websiteApiService.sendV("isDenylist", address);
        log.info("Result{}", httpResultData.getResult());
        if (ObjectUtils.isEmpty(httpResultData.getResult())) {
            return null;
        }
        JSONArray jsonArray = (JSONArray) JSONUtils.jsGetData(httpResultData.getResult(), "denylists");
        return jsonArray.size() > 0;
    }

    public List<Device> getHotspotsByCities(String address) throws MsgException, URISyntaxException {
        JSONObject result = (JSONObject) getResultV("getHotspotsByCities", address);
        List<Device> devices = BeanUtils.toJavaObject(JSONUtils.jsGetData(result, "data"), new TypeReference<List<Device>>() {{
        }});
        return devices;
    }

    /**
     * 根据坐标(hex)获取设备
     *
     * @param proximity_hex
     * @return
     * @throws MsgException
     * @throws URISyntaxException
     */
    public List<LeanData> getHotspotsByProximityHex(String proximity_hex) throws MsgException {
//        int res = HexUtils.h3.h3GetResolution(proximity_hex);
//        if (12 != res) {
//            proximity_hex = HexUtils.h3.h3ToCenterChild(proximity_hex, 12);
//        }
        JSONObject result = (JSONObject) getResultV("getHotspotsByProximityHex", proximity_hex);
        List<LeanData> leanDataList = BeanUtils.toJavaObject(JSONUtils.jsGetData(result, "data"), new TypeReference<List<LeanData>>() {{
        }});
        return leanDataList;
    }


    /**
     * @throws
     * @title 挑选位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/19 13:56
     */
    public List<List<GeoCoord>> picklocations(String groupStr) throws MsgException {
        List<List<String>> groupTable = StringUtils.toTableList(groupStr);
        List<List<GeoCoord>> geoCoordss = new ArrayList<>();
        List<GeoCoord> geoCoords;
        List<GeoCoord> picklocation;
        int res;
        for (List<String> lines : groupTable) {
            geoCoords = new ArrayList<>();
            picklocation = picklocation(lines.get(0), Integer.parseInt(lines.get(1)));
            res = HexUtils.h3.h3GetResolution(lines.get(0));
            for (GeoCoord geoCoord : picklocation) {
                geoCoord.setSouHex(HexUtils.h3.h3ToParentAddress(geoCoord.cHex, res));
                geoCoords.add(geoCoord);
            }
            geoCoordss.add(geoCoords);
        }
        return geoCoordss;
    }


    public List<LeanData> getCHexsByHex(String parentHex) throws MsgException {
        //获取该CHex的父级分辨率
        int res = HexUtils.h3.h3GetResolution(parentHex);
        String sonHex = HexUtils.h3.h3ToCenterChild(HexUtils.h3.h3ToParentAddress(parentHex, 4), 12);
        //圈里的设备的父级分辨率
        String sonParentHex;
        List<LeanData> cHex = new ArrayList<>();
        List<LeanData> leanDataList = getHotspotsByProximityHex(sonHex);
        for (LeanData leanData : leanDataList) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(leanData.getL(), res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(leanData);
            }
        }
        return cHex;
    }


    public List<GeoCoord> picklocation(String parentHex, int num) throws MsgException {

        int res = HexUtils.h3.h3GetResolution(parentHex);
//        log.info("parentHex:{} res：{}" , parentHex,res);
        List<LeanData> hotspotsByProximityHex = getCHexsByHex(parentHex);
        List<String> nearbyHexs = new ArrayList<>();
        for (LeanData byProximityHex : hotspotsByProximityHex) {
            List<String> nearbyHex = HexUtils.getNearbyHex(byProximityHex.getL(), 8);
            for (String hex : nearbyHex) {
                log.info("parentHex:{}   res {}  {}" , parentHex, res, HexUtils.h3.h3ToParentAddress(hex, res));
                if (!nearbyHexs.contains(hex) && parentHex.equals(HexUtils.h3.h3ToParentAddress(hex, res))) {
                    nearbyHexs.add(hex);
                }
            }
        }

        log.info("[nearbyHexs]:{}", JSONObject.toJSONString(nearbyHexs));
        List<GeoCoord> geoCoords = new ArrayList<>();
        Map<String, String> hashM = new HashMap<>();
        for (int i = 0; i < nearbyHexs.size(); i++) {
            if (0 != nearbyHexs.size() && num != geoCoords.size()) {
                GeoCoord randomDevice = getRandomDevice(nearbyHexs);
                if (ObjectUtils.notIsEmpty(randomDevice) && !hashM.containsKey(randomDevice.getCHex())) {
                    hashM.put(randomDevice.getCHex(), randomDevice.getCHex());
                    geoCoords.add(randomDevice);
                }
            } else {
                break;
            }
        }
        return geoCoords;

    }

    /**
     * @throws
     * @title 随机位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/19 13:56
     */
    private GeoCoord getRandomDevice(List<String> nearbyHexs) throws MsgException {
        if (ObjectUtils.notIsEmpty(nearbyHexs)) {
            String cHex = nearbyHexs.get(NumUtils.intervalRandom(nearbyHexs.size()));
            boolean existingEquipmentB = existingEquipment(cHex);
            GeoCoord geoCoord = null;
            try {
                geoCoord = existingEquipmentB ? null : GeoCoord.build(cHex, H3Core.newInstance().h3ToGeo(cHex));
            } catch (IOException e) {
            }
            if (ObjectUtils.isEmpty(geoCoord)) {
                return getRandomDevice(nearbyHexs);
            }
            return geoCoord;
        }

//        throw new MsgException("没有可以使用的位置设备了 ");
        log.error("没有可以使用的位置设备了 ");
        return null;
    }


    //    getHotspotsByHex5
    void dashboard(String proximity_hex) throws MsgException, URISyntaxException {
        List<LeanData> leanDatas = getHotspotsByProximityHex(proximity_hex);

    }

    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public Boolean existingEquipment(String hex) throws MsgException {
        JSONObject result = (JSONObject) getResultV("existingEquipment", hex);
//        if(null == result.getData()){
//            return null;
//        }
        Boolean aBoolean = ObjectUtils.notIsEmpty(JSONUtils.jsGetData(result, "data"));
        log.info("hex{} {}", hex, aBoolean ? "存在" : "不存在");
        return aBoolean;
    }

    public JSONObject getResultVS(String apiKey, Object... data) throws MsgException {
        HttpResultData httpResultData = websiteApiService.sendV(apiKey, data);
        if (httpResultData.getStatus() != 200) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
            }
            httpResultData = websiteApiService.sendV(apiKey, data);
        }
        if (ObjectUtils.notIsEmpty(httpResultData.getResult())) {
            return JSONObject.parseObject(httpResultData.getResult());
        }
        return new JSONObject();
    }

    public Object getResultV(String apiKey, Object... data) throws MsgException {
        HttpResultData httpResultData = websiteApiService.sendV(apiKey, data);
        if (httpResultData.getStatus() != 200) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
            }
            httpResultData = websiteApiService.sendV(apiKey, data);
        }

        if (ObjectUtils.notIsEmpty(httpResultData.getResult())) {
            return BeanUtils.toJSON(httpResultData.getResult());
        }
        return null;
    }

    public Result getResultKV(String apiKey, Object data) throws MsgException {
        HttpResultData httpResultData = websiteApiService.sendKV(apiKey, data);
        if (ObjectUtils.notIsEmpty(httpResultData.getResult())) {
            return BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<Result>() {
            });
        }
        return new Result();
    }

}
