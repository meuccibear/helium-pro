package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.domain.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: helium-pros
 * @ClassName HotsPottyUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-16 14:25
 * @Version 1.0
 **/
public class HotsPottyUtils {
    static String WWW = "https://etl.hotspotty.org/";


    /**
     * @throws
     * @title 根据Hex获取HotspottyCHex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    public static List<String> getHotspotHexByCHex(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("api/v1/hotspots/search-lean/?proximity_hex=%s", hex)), new TypeReference<Result>() {
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
     * @throws
     * @title 根据Hex获取HotspottyId
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    public static List<String> getHotspotIdsByHex(String hex) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("api/v1/hotspots/history/summary-v2/%s", hex)), new TypeReference<Result>() {
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

    public static String get(String url) throws MsgException {
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtils.get(WWW +url, HttpUtils.getHeadres(headersStr));
        return httpResultData.getResult();
    }

}
