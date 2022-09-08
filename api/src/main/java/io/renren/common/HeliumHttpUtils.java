package io.renren.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.common.gitUtils.map.NumMap;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.HotsPottyHttpUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.HotspotsProfit;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.entity.DataHttp;
import io.renren.modules.sys.service.DataHttpService;
import lombok.extern.slf4j.Slf4j;
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
 * @ClassName DBHttpUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-12 04:11
 * @Version 1.0
 **/
@Slf4j
public class HeliumHttpUtils extends HttpUtils {

    DataHttpService httpService;

    public static H3Core h3;

    static {
        try {
            h3 = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    https://api.helium.io/v1/hotspots/:address

    public enum Website {
        //        Blockjoy("https://api.helium.io/"),
        Blockjoy("https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/"),
        Herokuapp("https://denylist-api.herokuapp.com/");

        private String value;

        private Website(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }


    public HeliumHttpUtils(DataHttpService httpService) {
        this.httpService = httpService;
    }

    public HeliumHttpUtils() {
    }

    HotsPottyHttpUtils hotsPottyHttpUtils = new HotsPottyHttpUtils();

    HttpSetting httpSetting = new HttpSetting() {
        {
            setProxy(false);
//            setProxy(true);
//        setProxyType(0);
            setProxyID("HeliumHttpUtils");
//            setAutomaticExceptionHandling(false);
        }

        public String generateProxyAddr() throws MsgException {
            try {
//                String dp = AuthFactory.build().get_dp();
//                HttpResultData httpResultData = new HttpUtils().send(Method.GET, "http://tps.kdlapi.com/api/gettps/?orderid=934995251093492&num=1&signature=9yuleppjwfa8do8nsmwoirlfjco89d1a&pt=1&format=json&sep=1");
////                log.info("获取代理信息~", JSON.toJSONString(httpResultData));
//                JSONObject jsonObject = BeanUtils.toJSONObject(httpResultData.getResultV());
//                Integer code = (Integer) JSONUtils.getJSONObject(jsonObject, "code");
//                String dp = (String) JSONUtils.getJSONObject(jsonObject, "data.proxy_list.0");
//                setAccount("767140550@qq.com", "Zp19491225");
//                String dp = "tps432.kdlapi.com:15818";
                String dp = "tps432.kdlapi.com:15818";
                log.info("【dp】{}", dp);
                return dp;
            } catch (Exception e) {
                log.error("获取快代理IP失败！", e);
                throw new MsgException("获取快代理IP失败！");
            }
        }
    };

    public HttpSetting getSetting() {
        return httpSetting;
    }

    public HttpSetting getHttpSetting() {
        return httpSetting;
    }

    public void setHttpSetting(HttpSetting httpSetting) {
        this.httpSetting = httpSetting;
    }

    public double getHotspotsTotal(int typeId, String hotspots) throws MsgException {
        String url = "v1/hotspots/%s/rewards/sum";
        url = String.format(url, hotspots);
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

        JSONObject jsonObject = JSON.parseObject(get(Website.Blockjoy, url, parameter));
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
    }

    @Override
    public void sendBefore(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
        if (ObjectUtils.isEmpty(httpService)) {
            return;
        }
//        Http byAll = httpService.findByAll(new Http(null, url, JSON.toJSONString(urlParameter), null, null, method.name()));
//        if (ObjectUtils.notIsEmpty(byAll)) {
//            httpResultData = BeanUtils.toJavaObject(byAll.getRespone(), new TypeReference<HttpResultData>() {{
//            }});
//        }
    }

    @Override
    public void sendAfter(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
        if (ObjectUtils.isEmpty(httpService)) {
            return;
        }
        httpService.insert(new DataHttp(method.name(), url, JSON.toJSONString(entityParameter), JSON.toJSONString(httpResultData), 1));
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
        List<LeanData> leanDataList = hotsPottyHttpUtils.getHotspotHexByCHex(sonHex);
        for (LeanData leanData : leanDataList) {
            sonParentHex = HexUtils.h3.h3ToParentAddress(leanData.getL(), res);
            if (parentHex.equals(sonParentHex)) {
                cHex.add(leanData);
            }
        }
        return cHex;
    }

    /**
     * 获取所有的坐标并且去掉重复的坐标
     *
     * @param parentHex
     * @param res
     * @return
     * @throws MsgException
     */
    public List<LeanData> getDuplicateRemovalCHexsByHex(String parentHex, int res) throws MsgException {
        List<LeanData> cHexsByHex = getCHexsByHex(parentHex, res);
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
     * @return
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public Map<String, List<GeoCoord>> getLocations(String address, int num, String group) throws MsgException {
        StringUtils.writeList("\t", "【getLocations】 ", address, num);
        int res = h3.h3GetResolution(address);
        if (res < 0 || res > 8) {
            throw new IllegalArgumentException(String.format("resolution %d is out of range (must be 0 < res < 8)", res));
        }
        List<LeanData> cHexs = getDuplicateRemovalCHexsByHex(address, res);

        Map<String, List<GeoCoord>> geoMap = new HashMap<>();
        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0).getL(), res);
        StringUtils.writeList("\t", "【getLocations】 ", cHexs.size());
        StringUtils.writeList("\t", "【cHexs】 ", JSON.toJSONString(cHexs));

        if (ObjectUtils.notIsEmpty(cHexs)) {
            List<GeoCoord> geoCoords = new ArrayList<>();
            GeoCoord randomDevice;
            Map<String, String> geoCoordMap = new HashMap<>();
            for (int i = 0; i < num; i++) {
                randomDevice = getRandomDevice(cHexs);
                randomDevice.setSouHex(h3.h3ToParentAddress(randomDevice.getCHex(), res));
                randomDevice.setGroup(group);
                if (!geoCoordMap.containsKey(randomDevice.getCHex()) && address.equals(randomDevice.getSouHex())) {
                    geoCoordMap.put(randomDevice.getCHex(), randomDevice.getCHex());
                    geoCoords.add(randomDevice);
                } else {
                    i -= 1;
                }
            }
            StringUtils.writeList("\t", "【getLocations】 ", JSON.toJSONString(geoCoords));
            geoMap.put(hex3, geoCoords);
        }
        return geoMap;
    }

    /**
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public GeoCoord getRandomDevice(List<LeanData> cHexs) throws MsgException {
        StringUtils.writeList("\t", "getRandomDevice", cHexs.size(), JSON.toJSONString(cHexs));
        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size())).getL();
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
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public void getRandomDevice(Map<String, GeoCoord> geoCoordMap, List<LeanData> cHexs) throws MsgException {
        StringUtils.writeList("\t", "getRandomDevice", cHexs.size(), JSON.toJSONString(cHexs));

        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size())).getL();
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord) || geoCoordMap.containsKey(geoCoord.getCHex())) {
                getRandomDevice(geoCoordMap, cHexs);
            }
        }
        throw new MsgException("没有可以使用的位置设备了 ");
    }

    /**
     * @param hex
     * @return
     */
    public GeoCoord lookAround(String hex) {
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
            } catch (MsgException | IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 查看该区域是否有设备
     *
     * @param hex
     * @return
     * @throws MsgException
     */
    public boolean notIsDevice(String hex) throws MsgException, URISyntaxException {
        Result result = getResult(Website.Blockjoy, String.format("v1/hotspots/hex/%s", hex));
        if (ObjectUtils.isEmpty(result)) {
            return false;
        }
        return ObjectUtils.notIsEmpty(result.getData());
    }

    /**
     * @return
     * @throws
     * @title 根据设备地址获取设备信息
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:18
     */
    public Device getHotspotsByAddress(String address) {
        Result result = getResult(Website.Blockjoy, String.format("v1/hotspots/%s", address));
        if (ObjectUtils.isEmpty(result)) {
            return null;
        }
        return BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
    }

    public Boolean denylist(String address) throws MsgException, URISyntaxException {
        JSONObject jsonO = JSON.parseObject(get(Website.Herokuapp, "api/hotspots/" + address));
        if (!jsonO.containsKey("denylists")) {
            return null;
        }
        return jsonO.getJSONArray("denylists").size() > 0;
    }

    public Result getResult(Website website, String url) {
        String result = null;
        try {
            result = get(website, url);
        } catch (MsgException e) {
            log.error("【请求接口错误】 ", e);
            return null;
        }
        return BeanUtils.toJavaObject(result, new TypeReference<Result>() {
        });
    }
//    http=127.0.0.1:8866;https=127.0.0.1:8866
//    http=tps432.kdlapi.com:15818;https=tps432.kdlapi.com:15818


    public String get(Website website, String url) throws MsgException {
        return get(website, url, null);
    }

    public String get(Website website, String url, Map<String, String> parameter) throws MsgException {
        HttpResultData httpResultData;
        httpResultData = send(Method.GET, website.getValue() + url, parameter);
//        if (httpResultData.getStatus() == 407) {
//            String whiteIp = httpResultData.getResultV().replaceAll("White IP Failed: ", "");
//            log.info("【White】 ", whiteIp);
//            try {
//                AuthFactory.build().set_ip_whitelist(whiteIp);
//            } catch (Exception e) {
//                throw new MsgException("白名单错误！");
//            }
//        }
        return httpResultData.getResult();

    }

    public JSONObject client(String address) throws MsgException {
        HttpResultData httpResultData;
        httpResultData = send(Method.GET, String.format("http://23.248.162.239:8797/client/%s", address), null);
        if(httpResultData.getStatus() != 200){
//            return "err_" + httpResultData.getStatus();
            return null;
        }
        String[] split = httpResultData.getResult().split("\n");
//        log.info("【split】", JSON.toJSONString(split));
//        log.info("【split】",split[0]);
        JSONObject jsonObject = BeanUtils.toJSONObject(BeanUtils.toJSONObject(split[0]));
//        log.info("【client】" + JSONUtils.getJSONObject(jsonObject, "client.usesig") + "\t" + JSONUtils.getJSONObject(jsonObject, "client.hid"));
//        log.info(BeanUtils.toJSONObject(split[0]).getString("result"));


//        return StringUtils.outStr("\t", address, JSONUtils.getJSONObject(jsonObject, "client.usesig"), JSONUtils.getJSONObject(jsonObject, "client.hid"));
//        return StringUtils.outStr("\t", address, JSONUtils.getJSONObject(jsonObject, "client.usesig"));
        return jsonObject;
//        return String.valueOf(JSONUtils.getJSONObject(jsonObject, "client.usesig"));
    }

    public HttpResultData post() throws MsgException {
        return send(HttpUtils.Method.POST, "http://165.154.41.169:4949", "{\"jsonrpc\":\"2.0\",\"id\":\"id\",\"method\":\"peer_ping\",\"params\": {\"addr\":\"/p2p/112FSx6xeGeA2mGaQgp8aocX8fYv2uBSmsdKdNJFGfTYQwbnshd9\"}}");
    }

    public void test() {
        for (int i = 0; i < 100; i++) {
            // 普通 Get 请求
            try {
                send(Method.GET, "http://118.193.33.251:8080/test.json");
            } catch (MsgException e) {
                e.printStackTrace();
            }
        }
        // 普通 Get 请求
//        send(Method.GET, "https://explorer-api.helium.com/api/makers");
    }

}
