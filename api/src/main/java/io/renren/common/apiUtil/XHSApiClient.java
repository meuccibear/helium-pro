package io.renren.common.apiUtil;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.packetCapture.HtmlUtil;
import io.renren.common.gitUtils.packetCapture.WebmagicUtil;
import io.renren.common.github.http2.OkHttpUtil;
import lombok.Getter;
import lombok.Setter;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

public class XHSApiClient {

    OkHttpUtil okHttpUtil = OkHttpUtil.getInstance(10, 10, 10);

    /*
        BASE_URL 设置为你自己的网易云音乐API地址
     */
    private static final String BASE_URL = "https://edith.xiaohongshu.com/api";
    private static final String API_URL = BASE_URL + "/sns/web/";

//    private final String BASE_URL = "https://edith.xiaohongshu.com/api";
//    private final String API_URL = BASE_URL + "/sns/web/";
    private final String WEBSITE_URL = "https://www.xiaohongshu.com/";
    private final JSONObject INITIAL_STATE = new JSONObject();

    //https://edith.xiaohongshu.com/api/sns/web/v2/note/collect/page
    // ?num=30&cursor=&user_id=5a177936e8ac2b535e9441b3&image_formats=jpg,webp,avif&xsec_token=&xsec_source=
    /**
     * 收集
     *
     * @param cursor eg: 6624e7e100000000010332f2
     * @param userId eg: 5a177936e8ac2b535e9441b3
     * @return json
     */
    public JSONObject noteCollect(String cursor) {
//        String url = API_URL + "v2/note/collect/page?num=30&cursor=" + cursor + "&user_id=" + getUserId() + "&image_formats=jpg,webp,avif&xsec_token=&xsec_source=";
//        String url = "v2/note/collect/page?num=30&cursor=" + cursor + "&user_id=" + getUserId();
//        url = "https://edith.xiaohongshu.com/api/sns/web/v2/note/collect/page?num=30&cursor=&user_id=5a177936e8ac2b535e9441b3&image_formats=jpg,webp,avif&xsec_token=&xsec_source=";
        String url = API_URL + "v2/note/collect/page?num=30&cursor=6624e7e100000000010332f2&user_id=5a177936e8ac2b535e9441b3&image_formats=jpg,webp,avif&xsec_token=&xsec_source=";
        return sendApi(url);
    }

    /**
     * 专辑
     *
     * @param cursor
     * @return
     */
    public JSONObject album(int page) {
        String url = API_URL + "v1/board/user?user_id=" + getUserId() + "&page=" + page + "&num=30";
        return sendApi(url);
    }

    /**
     * 获取参数
     *
     * @param parameters 参数
     * @return data
     */
    public Object getValue(Parameters parameters) {
        if (!INITIAL_STATE.containsKey(parameters.getJsonKey())) {
            switch (parameters.getJsonKey()) {
                case "explore":
                    parseHtml(explore(), "explore");
                    break;
                case "userProfile":
                    parseHtml(userProfile(), "userProfile");
                    break;
            }
        }
        return JSONUtils.jsGetData(INITIAL_STATE.getJSONObject(parameters.getJsonKey()), parameters.getPath());
    }

    /**
     * 首页
     *
     * @return html
     */
    public String explore() {
        String url = WEBSITE_URL + "explore";
        String html = okHttpUtil.send(new Request.Builder().url(url), headStr);
        if (null == html) {
            throw new IllegalArgumentException("user_id is null");
        }
        return html;
    }

    /**
     * 用户配置文件
     *
     * @return html
     */
    public String userProfile() {
        if (null == getUserId()) {
            throw new IllegalArgumentException("user_id is null");
        }
        String url = WEBSITE_URL + "user/profile/" + getUserId() + "?tab=fav&subTab=note";
        String html = okHttpUtil.send(new Request.Builder().url(url), headStr);
        if (null == html) {
            throw new IllegalArgumentException("html is null");
        }
        return html;
    }

    @Getter
    @Setter
    String headStr = null;

    @Setter
    String userId = null;

    public String getUserId() {
        if (null == userId) {
            userId = (String) getValue(Parameters.userId);
            if (null == userId) {
                throw new IllegalArgumentException("user_id is null");
            }
        }
        return userId;
    }

    @Setter
    public String startCursor;

    public String getStartCursor() {
        if (null == startCursor) {
            setStartCursor((String) getValue(Parameters.startCursor));
        }
        return startCursor;
    }


    JSONObject sendApi(String url) {
//        return okHttpUtil.sendToJSON(new Request.Builder().url(generalParameters(url)), headStr);
        return okHttpUtil.sendToJSON(new Request.Builder().url(url), headStr);
    }

    JSONObject sendApi(String url, Map<String, Object> params) {

        // 初始化请求的URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        generalParameters(params);

        // 添加查询参数
        params.keySet().forEach(key -> urlBuilder.addQueryParameter(key, String.valueOf(params.get(key))));

        return sendApi(urlBuilder.build().toString());
    }

    void generalParameters(Map<String, Object> params) {
        params.put("user_id", getUserId());
        params.put("image_formats", "jpg,webp,avif");
        params.put("xsec_token", "");
        params.put("xsec_source", "");
    }

    public String generalParameters(String url) {
       return API_URL + url + "&image_formats=jpg,webp,avif&xsec_token=&xsec_source=";
    }

    void parseHtml(String html, String key) {
        String jsData = WebmagicUtil.getJsData(html, "window.__INITIAL_STATE__=", "<");
        System.out.println("jsData: " + jsData);
        Object result = HtmlUtil.parseJSDatatoJson(jsData, "__INITIAL_STATE__");
        JSONObject jsonObject = JSONUtils.toJSONObject(result);
        INITIAL_STATE.put(key, jsonObject);
    }

    // 文本文件
    enum Parameters {
        userId("userId", "explore", "user.userInfo.user_id"),
        startCursor("startCursor", "userProfile", "user.noteQueries.1.cursor");

        @Getter
        private final String key;

        @Getter
        private final String jsonKey;

        @Getter
        private final String path;

        private Class<?> validatorGroupClass;

        Parameters(String key, String jsonKey, String path) {
            this.key = key;
            this.jsonKey = jsonKey;
            this.path = path;
        }
    }
//    public void parseHtml() throws ScriptException {
//
//        String responseText = readResult();
//        Page page = new Page();
//        page.setRequest(new us.codecraft.webmagic.Request("http://my.oschina.net/flashsword/blog"));
//        page.setUrl(new PlainText("http://my.oschina.net/flashsword/blog"));
//        page.setHtml(new Html(responseText));
//
//        String cursor = null;
//        Object jsonObject = HtmlUtil.parseJSDatatoJson(WebmagicUtil.getJsData(page.getHtml(), "window.__INITIAL_STATE__=", "<"), "__INITIAL_STATE__");
//        cursor = (String) JSONUtils.jsGetData(JSONUtils.toJSONObject(jsonObject), "user.noteQueries.1.cursor");
//        System.out.println(cursor);
//
//    }

}
