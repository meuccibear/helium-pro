package io.renren.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.common.gitUtils.kdl.AuthFactory;
import io.renren.modules.sys.entity.DataHttp;
import io.renren.modules.sys.service.DataHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import io.renren.modules.sys.dao.WebsiteApiMapper;
import io.renren.modules.sys.entity.WebsiteApi;
import io.renren.modules.sys.service.WebsiteApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WebsiteApiServiceImpl extends HttpUtils implements WebsiteApiService {

    @Resource
    private WebsiteApiMapper websiteApiMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return websiteApiMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WebsiteApi record) {
        return websiteApiMapper.insert(record);
    }

    @Override
    public int insertSelective(WebsiteApi record) {
        return websiteApiMapper.insertSelective(record);
    }

    @Override
    public WebsiteApi selectByPrimaryKey(Integer id) {
        return websiteApiMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WebsiteApi record) {
        return websiteApiMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WebsiteApi record) {
        return websiteApiMapper.updateByPrimaryKey(record);
    }

//    @Resource
//    private WebsiteApiMapper websiteApiMapper;

    @Resource
    private DataHttpService dataHttpService;

    Map<String, WebsiteApi> websiteApiMap = new HashMap<>();

    void init() {
        setWebsiteApiMapper();
    }

    public void setWebsiteApiMapper() {
        List<WebsiteApi> websiteApis = websiteApiMapper.findAllByType(3);
        for (WebsiteApi websiteApi : websiteApis) {
            websiteApiMap.put(websiteApi.getKey(), websiteApi);
        }
//        log.info("websiteApiMap{}", JSON.toJSONString(websiteApiMap));
    }

    HttpUtils.HttpSetting httpSetting = new HttpUtils.HttpSetting() {
        {
            setProxy(false);
//            setProxy(true);
//        setProxyType(0);
            setProxyID("HeliumHttpUtils");
//            setAutomaticExceptionHandling(false);
        }

        public String generateProxyAddr() throws MsgException {
            try {
                return "tps432.kdlapi.com:15818";
            } catch (Exception e) {
                log.error("获取快代理IP失败！", e);
                throw new MsgException("获取快代理IP失败！");
            }
        }
    };

    @Override
    public HttpResultData sendKV(String key, Object data) throws MsgException {
        init();
        if (!websiteApiMap.containsKey(key)) {
            throw new IllegalArgumentException(String.format("没有该接口信息~", key, data));
        }

        WebsiteApi websiteApi = websiteApiMap.get(key);
        return send(getMethod(websiteApi.getMethod()), StringUtils.formatV(websiteApi.getFullLink(), data),
                BeanUtils.toJavaObject(StringUtils.formatKV(websiteApi.getParameter(), data), new TypeReference<HashMap>() {{}})
                , BeanUtils.toJavaObject(websiteApi.getHeaders(), new TypeReference<HashMap>() {{
        }}));
    }

    public HttpResultData send(HttpUtils.Method method,String url, Object data, Object headers) throws MsgException {
        return send(method, url,
                BeanUtils.toJavaObject(data, new TypeReference<HashMap>() {{}})
                , BeanUtils.toJavaObject(headers, new TypeReference<HashMap>() {{
                }}));
    }

    public HttpResultData sendV(String key, Object... data) throws MsgException {
        init();

        if (!websiteApiMap.containsKey(key)) {
            throw new IllegalArgumentException(String.format("没有该接口信息~", key, data));
        }
        WebsiteApi websiteApi = websiteApiMap.get(key);
        return send(getMethod(websiteApi.getMethod()), StringUtils.formatV(websiteApi.getFullLink(), data), null, BeanUtils.toJavaObject(websiteApi.getHeaders(), new TypeReference<HashMap>() {{
        }}));
    }

//    @Override
//    public HttpResultData sendV(String key, Object... data) throws MsgException {
//        return sendV(key, new Object[][]{data, null, null});
//    }

    @Override
    public void sendBefore(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
//        Http byAll = httpService.findByAll(new Http(null, url, JSON.toJSONString(urlParameter), null, null, method.name()));
//        if (ObjectUtils.notIsEmpty(byAll)) {
//            httpResultData = BeanUtils.toJavaObject(byAll.getRespone(), new TypeReference<HttpResultData>() {{
//            }});
//        }
    }

    @Override
    public void sendAfter(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
        dataHttpService.insert(new DataHttp(method.name(), url, entityParameter, headers, httpResultData.getStatus(), 200 != httpResultData.getStatus() ? JSON.toJSONString(httpResultData) : ""));

        if (200 != httpResultData.getStatus()) {
            if (407 == httpResultData.getStatus()) {
                try {
                    AuthFactory.build().set_ip_whitelist(httpResultData.getResult().replaceAll("White IP Failed: ", ""));
                } catch (Exception e) {
                    log.error("【快代理】获取白名单失败~", e);
                }
            }
            DataHttp allByAll = dataHttpService.findAllByAll(new DataHttp(method.name(), url, entityParameter, headers, 200));
            if (ObjectUtils.notIsEmpty(allByAll)) {
                httpResultData = BeanUtils.toJavaObject(allByAll.getRespone(), new TypeReference<HttpResultData>() {{
                }});
            }
        }
    }

    HttpUtils.Method getMethod(int type) {
        switch (type) {
            case 1:
                return HttpUtils.Method.GET;
            case 2:
                return HttpUtils.Method.POST;
            default:
                throw new IllegalArgumentException(String.format("没有该请求类型~~", type));
        }
    }

    public HttpUtils.HttpSetting getSetting() {
        return httpSetting;
    }

}
