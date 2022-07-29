package io.renren.common.gitUtils.http;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.network.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

/**
 * @program: demo
 * @description:
 * @author: Zhuozhuang.Lv
 * @create: 2019-10-05 14:47
 */
@Slf4j
public class HttpHostFactory {

    public static HttpHost builds(String proxyAddr, String scheme) {
        Object[] objects = new Object[0];
        try {
            objects = IPUtils.formatIP(proxyAddr);
        } catch (MsgException e) {
            e.printStackTrace();
        }
        String hostname = (String) objects[0];
        Integer port = (Integer) objects[1];
        System.out.println(String.format("hostname:%s\tport:%s\tscheme:%s", hostname, port, scheme));
        return new HttpHost(hostname, port, scheme);
    }


    public static RequestConfig build(String proxyAddr) {
        return build("http", proxyAddr);
    }

    public static RequestConfig build(String scheme, String proxyAddr) {
        Object[] objects = new Object[0];
        try {
            objects = IPUtils.formatIP(proxyAddr);
        } catch (MsgException e) {
            e.printStackTrace();
        }
        String hostname = (String) objects[0];
        Integer port = (Integer) objects[1];
        log.info("scheme:{}\thostname:{}\tport:{}", scheme, hostname, port);
        return RequestConfig.custom().setProxy(new HttpHost(hostname, port)).setConnectTimeout(6000).setConnectionRequestTimeout(2000).setSocketTimeout(6000).build();
//        return RequestConfig.custom().setProxy(new HttpHost(hostname, port)).build();
    }

}
