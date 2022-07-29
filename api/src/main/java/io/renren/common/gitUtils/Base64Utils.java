package io.renren.common.gitUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @program: helium-pro-new
 * @ClassName Base64Utils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-18 21:40
 * @Version 1.0
 **/
public class Base64Utils {


    /**
     * BASE64解密
     *
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    /**
     *
     */
    public static void main(String[] args) throws Exception {
        String str = "chengdusichuanchina";
        //BASE64加密解密
//        String data = encryptBASE64(str.getBytes());
        String data = "Y2hlbmdkdXNpY2h1YW5jaGluYQ==";
        System.out.println("sun.misc.BASE64 加密后：" + data);

        byte[] byteArray = decryptBASE64(data);
        System.out.println("sun.misc.BASE64 解密后：" + new String(byteArray));
    }

}
