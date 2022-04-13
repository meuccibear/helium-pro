package io.renren.common.gitUtils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.helium.*;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.entity.Http;
import io.renren.modules.sys.service.HttpService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
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
@Component
public class HeliumHttpUtils extends HttpUtils{

    @Autowired
    HttpService httpService;

//    @Autowired
//    HttpUtils httpUtils;

    String WWW = "https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/";

    HotsPottyHttpUtils hotsPottyHttpUtils = new HotsPottyHttpUtils();

    @Override
    public void sendBefore(Method method, String url, Map<String, String> parameter, Map<String, String> headers, HttpResultData httpResultData) {
        if (ObjectUtils.notIsEmpty(httpService)) {
            return;
        }
        Http byAll = httpService.findByAll(new Http(null, url, JSON.toJSONString(parameter), null, null, method.name()));
        if (ObjectUtils.notIsEmpty(byAll)) {
            httpResultData = BeanUtils.toJavaObject(byAll.getRespone(), new TypeReference<HttpResultData>() {{
            }});
        }
    }

    @Override
    public void sendAfter(Method method, String url, Map<String, String> parameter, Map<String, String> headers, HttpResultData httpResultData) {
        super.sendAfter(method, url, parameter, headers, httpResultData);
        httpService.insert(new Http(null, url, JSON.toJSONString(parameter), JSON.toJSONString(httpResultData), 1, method.name()));
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
     * @return
     * @throws
     * @title 指定数量获取位置
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:42
     */
    public Map<String, List<GeoCoord>> getLocations(String address, int num) throws MsgException {
        StringUtils.writeList("\t", "【getLocations】 ", address, num);
        Map<String, String> HEXS = new HashMap<>();
        List<LeanData> cHexs = getCHexsByHex(address, 5);

        Map<String, List<GeoCoord>> geoMap = new HashMap<>();
        String hex3 = HexUtils.h3.h3ToParentAddress(cHexs.get(0).getL(), 5);
        StringUtils.writeList("\t", "【getLocations】 ", cHexs.size());

        if (ObjectUtils.notIsEmpty(cHexs)) {
            List<GeoCoord> geoCoords = new ArrayList<>();
            GeoCoord randomDevice;
            for (int i = 0; i < num; i++) {
                randomDevice = getRandomDevice(cHexs, HEXS);
                geoCoords.add(randomDevice);
            }
            StringUtils.writeList("\t", "【getLocations】 ", JSON.toJSONString(geoCoords));
            geoMap.put(hex3, geoCoords);
        }
        return geoMap;
    }

    Map<String, String> HEXS = new HashMap<>();

    /**
     * @throws
     * @title 极速随机Hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 7:10
     */
    public GeoCoord getRandomDevice(List<LeanData> cHexs, Map<String, String> HEXS) throws MsgException {

        if (ObjectUtils.isEmpty(HEXS)) {
            HEXS = new HashMap<>();
        }
        StringUtils.writeList("\t", "getRandomDevice", cHexs.size(), JSON.toJSONString(cHexs));
        if (ObjectUtils.notIsEmpty(cHexs)) {
            String cHex = cHexs.get(NumUtils.intervalRandom(cHexs.size())).getL();
            cHexs.remove(cHex);
            GeoCoord geoCoord = lookAround(cHex);
            if (ObjectUtils.isEmpty(geoCoord) || HEXS.containsKey(cHex)) {
                return getRandomDevice(cHexs, HEXS);
            }
            HEXS.put(cHex, cHex);
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
        Result result = BeanUtils.toJavaObject(get("https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/", String.format("v1/hotspots/hex/%s", hex)), new TypeReference<Result>() {
        });
        System.out.println("notIsDevice:\t" + JSON.toJSONString(result.getData()));
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
    public Device getHotspotsByAddress(String address) throws MsgException, URISyntaxException {
        Result result = BeanUtils.toJavaObject(get(String.format("v1/hotspots/%s", address)), new TypeReference<Result>() {
        });
        System.out.println(JSON.toJSONString(result));
        Device device = BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
        return device;
    }

    public String get(String url) throws MsgException, URISyntaxException {
        return get(WWW, url);
    }

    public String get(String qUrl, String url) throws MsgException, URISyntaxException {
        HttpResultData httpResultData = send(HttpUtils.Method.GET, qUrl + url);
        return httpResultData.getResult();
    }

    public boolean denylist(String address) throws MsgException, URISyntaxException {
        JSONObject jsonO = JSON.parseObject(get("https://denylist-api.herokuapp.com/", "api/hotspots/" + address));
        return jsonO.getJSONArray("denylists").size() > 0;
    }

}
