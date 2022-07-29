package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.entity.DataHttp;
import io.renren.modules.sys.service.DataHttpService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pros
 * @ClassName HotsPottyUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-16 14:25
 * @Version 1.0
 **/
@Component
public class HotsPottyHttpUtils extends HttpUtils {
    String WWW = "https://etl.hotspotty.org/";

//    @Autowired
    DataHttpService httpService;

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
        httpService.insert(new DataHttp( method.name(), url, JSON.toJSONString(entityParameter), JSON.toJSONString(httpResultData), 1));
    }



    /**
     * @return
     * @throws
     * @title 根据Hex获取HotspottyCHex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    @SneakyThrows
    public List<LeanData> getHotspotHexByCHex(String hex) {
        Result result = null;
        result = BeanUtils.toJavaObject(get(String.format("api/v1/hotspots/search-lean/?proximity_hex=%s", hex)), new TypeReference<Result>() {
        });
        JSONArray datas = (JSONArray) JSONUtils.jsGetData(BeanUtils.toJSONObject(result), "data");
        JSONObject data;
        List<LeanData> leanDatas = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            data = datas.getJSONObject(i);
            leanDatas.add(BeanUtils.toJavaObject(data, new TypeReference<LeanData>() {{
            }}));
        }
        return leanDatas;
    }


    /**
     * @throws
     * @title 根据Hex获取HotspottyCHex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 5:52
     */
    public List<String> getHotspotByCHex(String hex) {
        Result result = null;
        result = BeanUtils.toJavaObject(get(String.format("api/v1/hotspots/search-lean/?proximity_hex=%s", hex)), new TypeReference<Result>() {
        });
        StringUtils.writeList("\t", "【data】", JSON.toJSONString(result.getData()));
        JSONArray datas = (JSONArray) JSONUtils.jsGetData(BeanUtils.toJSONObject(result), "data");
        JSONObject data;
        List<String> hotsPottyIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            data = datas.getJSONObject(i);
            hotsPottyIds.add((String) JSONUtils.jsGetData(data, "l"));
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
    public List<String> getHotspotIdsByHex(String hex) {
        Result result = BeanUtils.toJavaObject(get(String.format("api/v1/hotspots/history/summary-v2/%s", hex)), new TypeReference<Result>() {
        });
        System.out.println(JSON.toJSONString(result.getData()));
        JSONArray datas = (JSONArray) JSONUtils.jsGetData(BeanUtils.toJSONObject(result), "data");
        JSONObject data;
        List<String> hotsPottyIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            data = datas.getJSONObject(i);
            hotsPottyIds.add((String) JSONUtils.jsGetData(data, "id"));
        }
        return hotsPottyIds;
    }

    @SneakyThrows
    public String get(String url)  {
        HttpResultData httpResultData = send(Method.GET, WWW + url);
        return httpResultData.getResult();
    }

//    @SneakyThrows
//    @Test
//    public void run(){
//        System.out.println(JSON.toJSONString(getHotspotHexByCHex("8c65056000001ff")));
//    }

}
