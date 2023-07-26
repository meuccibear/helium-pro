package io.renren;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtilsx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: helium-pro-new
 * @ClassName Demo
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-30 21:14
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) {
        try {
            System.out.printf(get("https://www.linshiyouxiang.net/mailbox/y6u7i8o98888/646b16ae9db944000798bcc6"));
        } catch (MsgException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get(String url) throws MsgException {
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtilsx.get( url, HttpUtilsx.getHeadres(headersStr));
        return httpResultData.getResult();
    }
}
