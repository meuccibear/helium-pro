package io.renren.common.gitUtils.kdl;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 用于保存用户orderid, apiKey, 以及计算签名的对象。
 */
@Slf4j
public class AuthFactory {

//    private static final String orderId = "904990230074791";
//    private static final String apiKey = "jd7agnyak6utmyw77qpbod3cdn352a8z";

    private static final String orderId = "934995251093492";
    private static final String apiKey = "9yuleppjwfa8do8nsmwoirlfjco89d1a";

    public static Client build() {
        Auth auth = new Auth(orderId, apiKey);
        return new Client(auth);
    }

    public static String useKDL() {
        return useKDL(null);
    }

    public static String useKDL(String id) {
        return useKDL(3, id);
    }

    /**
     * @return
     * @throws
     * @title 使用快代理
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/14 11:48
     */
    public static String useKDL(int num, String id) {
        String filePath = "./proxyAddr";
        if (ObjectUtils.notIsEmpty(id)) {
            filePath += "_" + id;
        }

        for (int i = 0; i < num; i++) {
            String proxyAddr = null;
            try {
                proxyAddr = useKDLIP(filePath);
            } catch (Exception e) {
                log.error("【获取快代理IP失败！】", e);
            }
            if (ObjectUtils.notIsEmpty(proxyAddr)) {
                return proxyAddr;
            }
        }
        throw new IllegalArgumentException("尝试三次均不成功呢！");
    }

    public static String useKDLIP(String filePath) throws Exception {
        String proxyAddrConfig = FileUtils.readLine(filePath);
        log.info("【proxyAddrConfig】{}", proxyAddrConfig);
        if (ObjectUtils.notIsEmpty(proxyAddrConfig) && AuthFactory.build().check_dps_valid(proxyAddrConfig)) {
            return proxyAddrConfig;
        } else {
            String dp = AuthFactory.build().get_dp();
            FileUtils.write(filePath, dp, true, false);
            return useKDLIP(filePath);
        }
    }

    public void check_dps_valid(String proxyAddrConfig) {
        HttpUtils httpUtils = new HttpUtils() {
            @Override
            public HttpSetting getSetting() {
                return new HttpSetting() {
                    {
                        setProxy(true);
                    }

                    @Override
                    public String generateProxyAddr() {
                        log.info("[proxyAddrConfig]{}", proxyAddrConfig);
                        return proxyAddrConfig;
                    }
                };
            }


        };
            HttpResultData send = httpUtils.send(HttpUtils.Method.GET, "https://explorer.helium.com/hotspots/hex/883098b303fffff");
            System.out.println(JSON.toJSONString(send));
    }

    @SneakyThrows
    @Test
    public void asd() {
//        check_dps_valid("117.84.59.13:19810");
//        check_dps_valid("180.120.211.88:19110");
        AuthFactory.build().add_ip_whitelist("113.65.30.153");
    }

}
