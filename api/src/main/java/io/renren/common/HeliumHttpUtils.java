package io.renren.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.HotsPottyHttpUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.entity.DataHttp;
import io.renren.modules.sys.service.DataHttpService;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.ArrayList;
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

        public String generateProxyAddr() {
            try {
//                String dp = AuthFactory.build().get_dp();
//                HttpResultData httpResultData = new HttpUtils().send(Method.GET, "http://tps.kdlapi.com/api/gettps/?orderid=934995251093492&num=1&signature=9yuleppjwfa8do8nsmwoirlfjco89d1a&pt=1&format=json&sep=1");
////                log.info("获取代理信息~", JSON.toJSONString(httpResultData));
//                JSONObject jsonObject = JSONUtils.toJSONObject(httpResultData.getResultV());
//                Integer code = (Integer) JSONUtils.getJSONObject(jsonObject, "code");
//                String dp = (String) JSONUtils.getJSONObject(jsonObject, "data.proxy_list.0");
//                setAccount("767140550@qq.com", "Zp19491225");
//                String dp = "tps432.kdlapi.com:15818";
                String dp = "tps432.kdlapi.com:15818";
                log.info("【dp】{}", dp);
                return dp;
            } catch (Exception e) {
                log.error("获取快代理IP失败！", e);
                throw new IllegalArgumentException("获取快代理IP失败！");
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

    @Override
    public void sendAfter(Object requestData, Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
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
    public List<LeanData> getCHexsByHex(String parentHex, int res) {
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

    public Result getResult(Website website, String url) {
        String result = get(website, url);
        return BeanUtils.toJavaObject(result, new TypeReference<Result>() {
        });
    }
//    http=127.0.0.1:8866;https=127.0.0.1:8866
//    http=tps432.kdlapi.com:15818;https=tps432.kdlapi.com:15818


    public String get(Website website, String url) {
        return get(website, url, null);
    }

    public String get(Website website, String url, Map<String, String> parameter) {
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

    public JSONObject client(String address) {
        HttpResultData httpResultData;
        httpResultData = send(Method.GET, String.format("http://23.248.162.239:8797/client/%s", address), null);
        if (httpResultData.getStatus() != 200) {
//            return "err_" + httpResultData.getStatus();
            return null;
        }
        String[] split = httpResultData.getResult().split("\n");
//        log.info("【split】", JSON.toJSONString(split));
//        log.info("【split】",split[0]);
        JSONObject jsonObject = JSONUtils.toJSONObject(JSONUtils.toJSONObject(split[0]));
//        log.info("【client】" + JSONUtils.getJSONObject(jsonObject, "client.usesig") + "\t" + JSONUtils.getJSONObject(jsonObject, "client.hid"));
//        log.info(JSONUtils.toJSONObject(split[0]).getString("result"));


//        return StringUtils.outStr("\t", address, JSONUtils.getJSONObject(jsonObject, "client.usesig"), JSONUtils.getJSONObject(jsonObject, "client.hid"));
//        return StringUtils.outStr("\t", address, JSONUtils.getJSONObject(jsonObject, "client.usesig"));
        return jsonObject;
//        return String.valueOf(JSONUtils.getJSONObject(jsonObject, "client.usesig"));
    }

    public HttpResultData post() {
        return send(HttpUtils.Method.POST, "http://165.154.41.169:4949", "{\"jsonrpc\":\"2.0\",\"id\":\"id\",\"method\":\"peer_ping\",\"params\": {\"addr\":\"/p2p/112FSx6xeGeA2mGaQgp8aocX8fYv2uBSmsdKdNJFGfTYQwbnshd9\"}}");
    }

    public void test() {
        for (int i = 0; i < 100; i++) {
            // 普通 Get 请求
            send(Method.GET, "http://118.193.33.251:8080/test.json");

        }
        // 普通 Get 请求
//        send(Method.GET, "https://explorer-api.helium.com/api/makers");
    }

}
