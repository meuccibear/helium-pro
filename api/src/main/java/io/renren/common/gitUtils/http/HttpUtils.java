package io.renren.common.gitUtils.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

/*
  网络工具类

    依赖：
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpcore</artifactId>
        <version>4.4.10</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.6</version>
    </dependency>

 */
@Slf4j
public class HttpUtils {
    private final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @title 请求类型
     * @description
     * @updateTime 2022/4/12 3:05
     * @throws
     */
    public static enum Method {POST, GET;}

    /**
     * @throws
     * @title 发送请求
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 3:37
     */
    public HttpResultData send(Method method, String url) throws MsgException {
        return send(method, url, null);
    }

    public HttpResultData send(Method method, String url, Object entityParameter) throws MsgException {
        return send(method, url, entityParameter, null);
    }

    public void sendBefore(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
    }

    public HttpResultData send(Method method, String url, Object entityParameter, Map<String, String> headers) throws MsgException {
        LocalDateTime now = LocalDateTime.now();

        Long time = DateUtils.localDateTimeToTimestamp(now);

        log.info("\n{}\n============================>\ntime:{}\nheaders:{}\nparameter:{}\nentityParameter:{}", url, DateUtils.asDate(now).getTime(), JSON.toJSON(headers), JSON.toJSON(entityParameter));
        HttpResultData httpResultData = null;
        sendBefore(method, url, entityParameter, headers, httpResultData, time);
        if (ObjectUtils.isEmpty(httpResultData)) {
            httpResultData = getSetting().initHttp(method, url, entityParameter, headers, getSetting().numberOfRetries);
            sendAfter(method, url, entityParameter, headers, httpResultData, time);
        }
        log.info("\n<============================\ntime:{}\n所消耗的时间{}\n{}", DateUtils.asDate(now).getTime(), DateUtils.calculationTimeConsuming(now), JSON.toJSON(httpResultData));

        return httpResultData;
    }

    public void sendAfter(Method method, String url, Object entityParameter, Map<String, String> headers, HttpResultData httpResultData, Long time) {
    }

    /**
     * 获取文件
     *
     * @param url 链接
     * @return 字节流
     * @throws MsgException 异常信息
     */
    public byte[] getFile(String url) throws MsgException {
        //通过输入流获取图片数据
        InputStream inStream = url(url);
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        return Option.readInputStream(inStream);
    }

    public BufferedImage getImg(String url) throws MsgException {
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        try {
            return ImageIO.read(url(url));
        } catch (IOException e) {
            throw new MsgException("数据流异常~");
        }
    }

    public InputStream url(String url) throws MsgException {

        try {
            // 将string转成url对象
            URL realUrl = new URL(url);

            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
//            connection.setConnectTimeout(100);
            // 开始实际的连接
            connection.connect();

            return connection.getInputStream();

        } catch (SocketException e) {
            throw new MsgException("链接不能访问~");
        } catch (FileNotFoundException e) {
            throw new MsgException("链接文件不存在~");
        } catch (UnknownHostException e) {
            if (getSetting().isProxy()) {
                throw new MsgException(String.format("代理：%s 不能访问~", getSetting().generateProxyAddr()));
            } else {
                throw new MsgException("链接不能访问~");
            }
        } catch (Exception e) {
            LOGGER.error("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 发送请求获取字符流
     *
     * @param url 链接
     * @return 返回的字符串
     */
    public String getStr(String url) throws MsgException {

        InputStream inStream = url(url);

        // 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();

        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));

//             用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                // 遍历抓取到的每一行并将其存储到result里面
                result.append(new String(line.getBytes(), StandardCharsets.UTF_8)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 使用finally来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result.toString();
    }


    public HttpSetting getSetting() {
        return new HttpSetting() {{
        }};
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class HttpSetting {
        private final Logger LOGGER = LoggerFactory.getLogger(HttpSetting.class);

        Integer numberOfRetries = 3;

        //唯一值
        public String proxyID;

        //代理厂商
        public Integer proxyType = -1;

        public boolean isProxy = false;

        // 原生 Http Basic 模式 所需参数
        public String accountInfo;

        private boolean checkStatusCode = false;

        /**
         * 设置 Http Basic 用户验证
         *
         * @param userName
         * @param userPassword
         */
        public void setAccount(String userName, String userPassword) {
            accountInfo = String.format("%s:%s", userName, userPassword);
        }

        String getFilePath() {
            return ObjectUtils.notIsEmpty(proxyID) ? "./proxyAddr_" + proxyID : "";
        }

        public String getProxyAddr() throws MsgException {
            String filePath = getFilePath();
            if (ObjectUtils.isEmpty(filePath)) {
                return generateProxyAddr();
            }
            return FileUtils.readLine(filePath);
        }

        public String generateProxyAddr() throws MsgException {
            return "127.0.0.1:8866";
        }

        public String refresh() throws MsgException {
            String proxyAddrConfig = generateProxyAddr();
            log.info("代理地址{}", proxyAddrConfig);
            if (ObjectUtils.notIsEmpty(getFilePath())) {
                log.info("文件地址{}", getFilePath());
                FileUtils.write(getFilePath(), proxyAddrConfig, true, false);
            }
            return proxyAddrConfig;
        }

        RequestConfig setingRequestConfig() throws MsgException {
            String proxyAddrConfig = getProxyAddr();
            log.info("【proxyAddrConfig】{}", proxyAddrConfig);
            if (ObjectUtils.isEmpty(proxyAddrConfig)) {
                proxyAddrConfig = refresh();
            }
            return HttpHostFactory.build(proxyAddrConfig);
        }

        List<String> headerKeys = new ArrayList<String>() {
            {
                add("content-length");
                add("Content-Length");
                add(":method");
                add("Authorization");
                add("Host");
            }
        };


        @SneakyThrows
        URI generateURIBuilder(String url, Object parameter) {
            //创建URIBuilder
            URIBuilder uriBuilder = new URIBuilder(url);
            //设置参数
//            uriBuilder.addParameters(ObjectUtils.isEmpty(parameter) ? new ArrayList<>() : Option.buildHttpPost(parameter));
            if (null == parameter) {
                return uriBuilder.build();
            }

            JSONObject parameterJson = BeanUtils.toJSONObject(parameter);
            for (String s : parameterJson.keySet()) {
                uriBuilder.addParameter(s, String.valueOf(parameterJson.get(s)));
            }
            return uriBuilder.build();
        }

        /**
         * @return
         * @throws
         * @title 初始化请求
         * @description
         * @author Mr.Lv lvzhuozhuang@foxmail.com
         * @updateTime 2022/4/12 3:35
         */
        public HttpResultData initHttp(Method method, String url, Object entityParameter, Map<String, String> headers, Integer errFrequency) throws MsgException {
            HttpUriRequest request;
            switch (method) {
                case GET:
                    HttpGet httpGet = new HttpGet(generateURIBuilder(url, entityParameter));

                    //代理
                    if (isProxy) {
                        httpGet.setConfig(setingRequestConfig());
                    }
                    request = httpGet;
                    break;
                case POST:
//                    HttpPost httpPost = new HttpPost(generateURIBuilder(url, urlParameter));
                    HttpPost httpPost = new HttpPost(url);

                    //代理
                    if (isProxy) {
                        httpPost.setConfig(setingRequestConfig());
                    }

                    //包装成一个Entity对象
                    StringEntity stringEntity = null;

                    //body请求
                    if (entityParameter instanceof String) {
                        stringEntity = new StringEntity((String) entityParameter, "UTF-8");
                    }

                    //url请求
                    if (entityParameter instanceof Map && ObjectUtils.notIsEmpty(entityParameter)) {
                        try {
                            JSONObject parameterJson = BeanUtils.toJSONObject(entityParameter);
                            List<NameValuePair> ps = new ArrayList<>();
                            for (Object key : parameterJson.keySet().toArray()) {
                                ps.add(new BasicNameValuePair((String) key, parameterJson.getString((String) key)));
                            }

                            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(ps, "UTF-8");
                            stringEntity = urlEncodedFormEntity;
                        } catch (UnsupportedEncodingException e) {
                            throw new MsgException("不支持的编码异常");
                        }
                    }

                    if (ObjectUtils.notIsEmpty(stringEntity)) {
                        httpPost.setEntity(stringEntity);
                    }


                    request = httpPost;

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + method);
            }

            //设置请求头信息
            if (null == headers) {
                headers = new HashMap<>();
            }
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");

            for (String key : headers.keySet()) {
                if (!headerKeys.contains(key)) {
                    request.setHeader(new BasicHeader(key, headers.get(key)));
                }
            }

            // HttpClient 三种 Http Basic 验证方式 0、标准模式 1、抢先模式 2、原生 Http Basic 模式
            //请求用户登录
            if (ObjectUtils.notIsEmpty(getAccountInfo())) {
                //String a = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes());
                //添加http头信息
                request.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString(getAccountInfo().getBytes()));
                request.addHeader("Content-Type", "application/json");
                //httpPost.addHeader("Authorization","Basic "+a);
            }

            //创建一个httpclient对象
            CookieStore store = new BasicCookieStore();
            HttpClient client = SSLClient.sslClient(store);

            //执行请求
            HttpResponse response = null;
            try {
                response = client.execute(request);
            } catch (Exception e) {
                if (getSetting().isProxy) {
                    if (--errFrequency >= 0) {
                        log.info("\nExecute问题!{}\n{}\n<><><><><><><><>\n正在重试【{}】", e.getMessage(), url, (getSetting().numberOfRetries - errFrequency));
                        refresh();
                        return initHttp(method, url, entityParameter, headers, errFrequency);
                    }
                    throw new MsgException("连接失败！", e);
                } else {
                    throw new MsgException("Execute异常！", e);
                }
            }

            //获取返回对象
            HttpEntity entity = response.getEntity();

            //通过EntityUitls获取返回内容
            String result = null;
            try {
                result = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                throw new MsgException("IO异常");
            }

            //获取响应码
            int statusCode = response.getStatusLine().getStatusCode();
            if (getSetting().checkStatusCode && statusCode != 200) {
                if (--errFrequency > 0) {
                    if (getSetting().isProxy) {
                        log.info("状态码问题!");
                        log.info("\n{}\n<><><><><><><><>\n正在重试{}", url, (getSetting().numberOfRetries - errFrequency));
                        // 刷新代理
                        refresh();
                    }
                    return initHttp(method, url, entityParameter, headers, errFrequency);
                }
                throw new MsgException(String.format("\n【请求出错】\n状态码：%d\nresult:%s", statusCode, result));
            }

            return new HttpResultData(statusCode, result, Option.getCookie(store));
        }

        /**
         * @return
         * @throws
         * @title 初始化请求
         * @description
         * @author Mr.Lv lvzhuozhuang@foxmail.com
         * @updateTime 2022/4/12 3:35
         */
//        public HttpResultData initHttp(Method method, String url, Object parameter, Map<String, String> headers, Integer errFrequency) throws MsgException {
//            HttpUriRequest request;
//            switch (method) {
//                case GET:
//                    HttpGet httpGet = new HttpGet(generateURIBuilder(url, parameter));
//
//                    //代理
//                    if (isProxy) {
//                        httpGet.setConfig(setingRequestConfig());
//                    }
//                    request = httpGet;
//                    break;
//                case POST:
//                    HttpPost httpPost = new HttpPost(generateURIBuilder(url, parameter));
//
//                    //代理
//                    if (isProxy) {
//                        httpPost.setConfig(setingRequestConfig());
//                    }
//
//                    //body请求
//                    if (parameter instanceof String) {
//                        //包装成一个Entity对象
//                        httpPost.setEntity(new StringEntity((String) parameter, "UTF-8"));
//                    }
//
//                    request = httpPost;
//
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + method);
//            }
//
//            if (ObjectUtils.isEmpty(headers)) {
//                headers = new HashMap<>();
//            }
//            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");
//
////            return request;
//
//
//            /*
//             * ps：
//             * Content-Type 请求头部编码
//             * Accept 返回编码
//             */
//            //设置请求头信息
//            if (null != headers) {
//                for (String key : headers.keySet()) {
//                    if (!headerKeys.contains(key)) {
//                        request.setHeader(new BasicHeader(key, headers.get(key)));
//                    }
//                }
//            }
//
//            // HttpClient 三种 Http Basic 验证方式 0、标准模式 1、抢先模式 2、原生 Http Basic 模式
//            //请求用户登录
//            if (ObjectUtils.notIsEmpty(getAccountInfo())) {
//                //String a = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes());
//                //添加http头信息
//                request.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString(getAccountInfo().getBytes()));
//                request.addHeader("Content-Type", "application/json");
//                //httpPost.addHeader("Authorization","Basic "+a);
//            }
//
//            //创建一个httpclient对象
//            CookieStore store = new BasicCookieStore();
//            HttpClient client = SSLClient.sslClient(store);
//
//            //执行请求
//            HttpResponse response = null;
//            try {
//                response = client.execute(request);
//            } catch (Exception e) {
////                e.printStackTrace();
//                if (getSetting().isProxy) {
////                    if (getSetting().automaticExceptionHandling) {
//                    if (--errFrequency >= 0) {
//                        log.info("\nExecute问题!{}\n{}\n<><><><><><><><>\n正在重试【{}】", e.getMessage(), url, (getSetting().numberOfRetries - errFrequency));
//                        refresh();
//                        return initHttp(method, url, parameter, headers, errFrequency);
//                    }
//                    throw new MsgException("连接失败！", e);
////                    } else {
////                        throw new MsgException("IO异常！", MsgException.ErrEnum.IOException, e);
////                    }
//                } else {
//                    throw new MsgException("Execute异常！", e);
//                }
//            }
//
//
//            //获取返回对象
//            HttpEntity entity = response.getEntity();
//
//            //通过EntityUitls获取返回内容
//            String result = null;
//            try {
//                result = EntityUtils.toString(entity, "UTF-8");
//            } catch (IOException e) {
//                throw new MsgException("IO异常");
//            }
//
//            //获取响应码
//            int statusCode = response.getStatusLine().getStatusCode();
//
//            if (statusCode != 200) {
//                if (--errFrequency > 0) {
//                    if (getSetting().isProxy) {
//                        log.info("状态码问题!");
//                        log.info("\n{}\n<><><><><><><><>\n正在重试{}", url, (getSetting().numberOfRetries - errFrequency));
//                        refresh();
//                    }
//                    return initHttp(method, url, parameter, headers, errFrequency);
//                }
//                throw new MsgException(String.format("\n【请求出错】\n状态码：%d\nresult:%s", statusCode, result));
//            }
//
//            HttpResultData httpResultData = new HttpResultData(statusCode, result, Option.getCookie(store));
//            if (ObjectUtils.isEmpty(httpResultData)) {
//                throw new MsgException("loginInfo 接口网络问题~");
//            }
//
//            return httpResultData;
//        }

        /**
         * 发送请求
         *
         * @param request 请求
         * @return 返回 HttpResultData 对象
         * @throws IOException 异常信息
         */
//        HttpResultData send(HttpUriRequest request, Map<String, String> headers, Integer errFrequency) throws MsgException {
//            /*
//             * ps：
//             * Content-Type 请求头部编码
//             * Accept 返回编码
//             */
//            //设置请求头信息
//            if (null != headers) {
//                for (String key : headers.keySet()) {
//                    if (!headerKeys.contains(key)) {
//                        request.setHeader(new BasicHeader(key, headers.get(key)));
//                    }
//                }
//            }
//
//            // HttpClient 三种 Http Basic 验证方式 0、标准模式 1、抢先模式 2、原生 Http Basic 模式
//            //请求用户登录
//            if (ObjectUtils.notIsEmpty(getAccountInfo())) {
//                //String a = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes());
//                //添加http头信息
//                request.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString(getAccountInfo().getBytes()));
//                request.addHeader("Content-Type", "application/json");
//                //httpPost.addHeader("Authorization","Basic "+a);
//            }
//
//            //创建一个httpclient对象
//            CookieStore store = new BasicCookieStore();
//            HttpClient client = SSLClient.sslClient(store);
//
//            //执行请求
//            HttpResponse response = null;
//            try {
//                response = client.execute(request);
//            } catch (IOException e) {
////                e.printStackTrace();
//                if (getSetting().isProxy) {
//                    if (getSetting().automaticExceptionHandling) {
//                        if (--errFrequency > 0) {
//                            log.info("正在重试{}", errFrequency);
//                            refresh();
//                            return send(request, headers, errFrequency);
//                        }
//                        throw new MsgException("连接失败！", e);
//                    } else {
//                        throw new MsgException("IO异常！", MsgException.ErrEnum.IOException, e);
//                    }
//                } else {
//                    throw new MsgException("IO异常！", e);
//                }
//            }
//
//            //获取响应码
//            int statusCode = response.getStatusLine().getStatusCode();
//
//            if (statusCode == 400) {
//                if (--errFrequency > 0) {
//                    if (getSetting().isProxy) {
//                        refresh();
//                    }
//                    return send(request, headers, errFrequency);
//                }
//                throw new MsgException("400 Bad Request!");
//            }
//
//            //获取返回对象
//            HttpEntity entity = response.getEntity();
//
//            //通过EntityUitls获取返回内容
//            String result = null;
//            try {
//                result = EntityUtils.toString(entity, "UTF-8");
//            } catch (IOException e) {
//                throw new MsgException("IO异常");
//            }
//
//            HttpResultData httpResultData = new HttpResultData(statusCode, result, Option.getCookie(store));
//            if (ObjectUtils.isEmpty(httpResultData)) {
//                throw new MsgException("loginInfo 接口网络问题~");
//            }
//
//            return httpResultData;
//        }
    }

    public static class Option {

        public Map<String, String> toMap(String json) {

            if (json == null) {
                return new HashMap<>();
            }
            String[] cooices = json.trim().split("&");

            Map<String, String> hashMap = new HashMap<>();

            for (String cooice : cooices) {
                String[] item = cooice.split("=");
                String name = "", value = "";
                if (!ObjectUtils.isEmpty(item) && item.length >= 1) {
                    name = item[0];
                    if (item.length >= 2) {
                        value = item[1];
                    }
                }
                hashMap.put(name, value);
            }

            return hashMap;
        }

        public Map<String, String> oToMap(Object o) {

            if (null != o) {
                JSONObject jsonObject = (JSONObject) JSONObject.toJSON(o);
                return JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Map<String, String>>() {
                });
            }
            return new HashMap<>();
        }


        /**
         * @throws
         * @title 流转二进制
         * @description
         * @author Mr.Lv lvzhuozhuang@foxmail.com
         * @updateTime 2022/4/12 3:41
         */
        public static byte[] readInputStream(InputStream inStream) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            if (ObjectUtils.notIsEmpty(inStream)) {
                //创建一个Buffer字符串
                byte[] buffer = new byte[1024];
                //每次读取的字符串长度，如果为-1，代表全部读取完毕
                int len = 0;
                //使用一个输入流从buffer里把数据读取出来
                while (true) {
                    try {
                        if (!((len = inStream.read(buffer)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                    outStream.write(buffer, 0, len);
                }
                //关闭输入流
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //把outStream里的数据写入内存
            return outStream.toByteArray();
        }


        /**
         * eadres str 转 对象
         *
         * @param headresStr
         * @return
         */
        public Map<String, String> getHeadres(String headresStr) {
            headresStr = headresStr.trim();
            Map<String, String> result = new HashMap<>();

            if (ObjectUtils.isEmpty(headresStr)) {
                return result;
            }
            String[] headers = headresStr.split("\n");
            for (String header : headers) {
                if (ObjectUtils.notIsEmpty(header)) {
                    String[] aa = header.split(":");
                    if (aa.length == 2) {
                        if (ObjectUtils.isEmpty(aa[0]) || ObjectUtils.isEmpty(aa[1])) {
                            continue;
                        }
                        result.put(aa[0], aa[1]);
                    }
                }
            }
            return result;
        }


        /**
         * 封装参数
         *
         * @param parameter 参数
         * @return List<NameValuePair>
         */
        static List<NameValuePair> buildHttpPost(Object parameter) {
            Map<String, String> params = BeanUtils.toJavaObject(parameter, new TypeReference<Map<String, String>>() {
            });
            List<NameValuePair> ps = new ArrayList<>();
            if (params != null && !params.isEmpty()) {
                for (String key : params.keySet()) {
                    ps.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
            return ps;
        }

        public static Map<String, String> getCookie(Object store) {
            CookieStore cookieStore = (CookieStore) store;
            Map<String, String> map = new HashMap<>();
            for (Cookie cookie : cookieStore.getCookies()) {
                map.put(cookie.getName(), cookie.getValue());
            }
            return map;
        }
    }


}
