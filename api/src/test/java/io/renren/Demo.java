package io.renren;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtilsx;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

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
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

//            System.out.printf(get("https://www.linshiyouxiang.net/mailbox/y6u7i8o98888/646b16ae9db944000798bcc6"));

        System.out.printf(new Demo().sharks().toJSONString());

    }

    public static String get(String url) throws MsgException {
        String headersStr = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36";
        HttpResultData httpResultData = HttpUtilsx.get(url, HttpUtilsx.getHeadres(headersStr));
        return httpResultData.getResult();
    }

    public JSONObject sharks() {


        String headStr =
                ":authority:\n" +
                        "edith.xiaohongshu.com\n" +
                        ":method:\n" +
                        "GET\n" +
                        ":path:\n" +
                        "/api/sns/web/v2/note/collect/page?num=30&cursor=&user_id=5a177936e8ac2b535e9441b3&image_formats=jpg,webp,avif&xsec_token=&xsec_source=\n" +
                        ":scheme:\n" +
                        "https\n" +
                        "accept:\n" +
                        "application/json, text/plain, */*\n" +
                        "accept-encoding:\n" +
                        "gzip, deflate, br, zstd\n" +
                        "accept-language:\n" +
                        "en,zh-CN;q=0.9,zh;q=0.8\n" +
                        "cookie:\n" +
                        "gid=yY0ySjWW8KYjyY0ySjWKqi1v4YVqSWWTl4q4IjU9VKyIKFq8qx2JqA888jyYj8J8SD4JdfYf; abRequestId=c1d099ec-875c-5db3-b08f-d0c5c0c44e3f; webBuild=4.41.1; a1=192fd08cbefsslrmh2l8kooc4ogfnwzcdgbg4t77330000106408; webId=8ac1d8f8d320f3337240ea2d65a2779a; acw_tc=11b84cde76bf4e09143d94d03bcbeb0a70e04182699a9575aedf5c5e274e3a8e; web_session=040069768e88b16411e52c181f354b17067630; unread={%22ub%22:%226714d93e0000000024015a19%22%2C%22ue%22:%2267186f6c000000002401b603%22%2C%22uc%22:22}; xsecappid=ugc; customer-sso-sid=68c517433843732345462753dd9011d16a2b1132; x-user-id-creator.xiaohongshu.com=5a177936e8ac2b535e9441b3; customerClientId=499592909421768; access-token-creator.xiaohongshu.com=customer.creator.AT-68c517433843732344105443adqozz7fwwpf70fw; galaxy_creator_session_id=RDErIxGMu5KWIIJ2bnPFjgUZ0J2bt44ZB2US; galaxy.creator.beaker.session.id=1730826621326073680496; websectiga=8886be45f388a1ee7bf611a69f3e174cae48f1ea02c0f8ec3256031b8be9c7ee; sec_poison_id=d25c31ed-0a56-4f56-a093-91cea84bfbd6\n" +
                        "origin:\n" +
                        "https://www.xiaohongshu.com\n" +
                        "priority:\n" +
                        "u=1, i\n" +
                        "referer:\n" +
                        "https://www.xiaohongshu.com/\n" +
                        "sec-ch-ua:\n" +
                        "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"\n" +
                        "sec-ch-ua-mobile:\n" +
                        "?0\n" +
                        "sec-ch-ua-platform:\n" +
                        "\"macOS\"\n" +
                        "sec-fetch-dest:\n" +
                        "empty\n" +
                        "sec-fetch-mode:\n" +
                        "cors\n" +
                        "sec-fetch-site:\n" +
                        "same-site\n" +
                        "user-agent:\n" +
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36\n" +
                        "x-b3-traceid:\n" +
                        "4114971d0bfda6dc\n" +
                        "x-s:\n" +
                        "XYW_eyJzaWduU3ZuIjoiNTUiLCJzaWduVHlwZSI6IngyIiwiYXBwSWQiOiJ4aHMtcGMtd2ViIiwic2lnblZlcnNpb24iOiIxIiwicGF5bG9hZCI6IjkyMjkzZWNhODA4ZDliNjg0OWQzN2U5NjlhNmJmZGY0Yzc4NjQyOGM2OTc2ZmM3Nzk3MjdiZTdhNjVlYmVhNDI4Y2Y1NzAyOTlhZjU5YmEwYmM0NTVmYTE1ZjEzZWIwNzYwNjRlZmY0NDU5MTcyYmE4YTk5OTgzYTAxYzM5YmI5ODI3MmFhNDY5ZmI3MTJkZGI0MDdhNjY3NWJlODRmM2YxZTJmYmE2Yzk0Y2NmMTliOWIwZjYzZjQ1MjdkY2VjZjE4NmIwNGVjNmE5NTY2ZWI1NzQ3NGZjYzkwYzczZGQ1Nzk0ZjYyOWMxMjQ5MmMwYzU1ZDg0Y2FjNDc2YmE0MTAzZmY1NGE2MDMxMmMyZjM2MTMyODBlOTkzNWFmODBlMjFmMWI4ZmZmYmQ4MzA2YmY5ZjNlYTQyMWZhMDZkMDI0ZWEyZWM0YzBlZWM1NmJhMDQ0NmM4YmQ2NzNkNjMwOTUxNWQ2MmVjYjE3M2M3OTM3NzJiYjYzMGZiNmQ3YTFkYWZkNGNlNTRjODhmNTkwZmFiZjM5OGUwMzgyNDAxZDFiIn0=\n" +
                        "x-s-common:\n" +
                        "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\n" +
                        "x-t:\n" +
                        "1730826652406\n" +
                        "x-xray-traceid:\n" +
                        "c97ea765797d6466111684411cdfb40d" +
                        "";


        headStr = "Host:edith.xiaohongshu.com\n" +
                "//User-Agent:Fiddler-Everywhere\n" +
                "sec-ch-ua-platform:\"macOS\"\n" +
                "sec-ch-ua:\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"\n" +
                "x-xray-traceid:c97ec6dfa6a516343bb9b8c8a5081cfe\n" +
                "sec-ch-ua-mobile:?0\n" +
                "x-t:1730830778191\n" +
                "x-b3-traceid:f2161d42c9c783c9\n" +
                "x-s-common:2UQAPsHCPUIjqArjwjHjNsQhPsHCH0rjNsQhPaHCH0P1wsh7HjIj2eHjwjQ+GnPW/MPjNsQhPUHCHdYiqUMIGUM78nHjNsQh+sHCH0c1+er1PaHVHdWMH0ijP/DU8fcIwB+j8n8Aq9lUJnWUJeY3J9R0+BRd8fE72f+D89Qd+oc7+APAPeZIPerI+0cIwsHVHdW9H0il+APIwePI+AqhP/DlNsQh+UHCHSY8pMRS2LkCGp4D4pLAndpQyfRk/SzpyLleadkYp9zMpDYV4Mk/a/8QJf4EanS7ypSGcd4/pMbk/9St+BbH/gz0zFMF8eQnyLSk49S0Pfl1GflyJB+1/dmjP0zk/9SQ2rSk49S0zFGMGDqEybkea/8QyS8i/nkVyMkrzfS+zbrM/gkVJLFUz/QwprQk/gk++rML8AzyzrbCnSzm+pSCc/+wzFDl/pzm+LELy7SOpMphnfMzPLMLz/zyyDSCnfk32bSgpgk+yf4E/pzVyDET/fY+zBqlnnk8+rMrL/zOzFFl/Lz0PMSTa/z+PSDF/nk0PLMryAzwpr83/gkm2rEr8AQ+zbpCnnMz2rRLa/++pFEx/dkp2SSgp/bwzMS7/MznJbkx//+8PDMhnnkaJpSx8748PDS7/S4b2bSCnflOzMp7nfk+PbkxGAmwzbDMnSzayDRrG748PDEk/dkp+bkLc/z8pMLMnfMz2bkxn/++yfz3/MziypSgngS8prQk/gk02DRoz/pyzB+C/gkd2SDU/fYwyDkk/DzByLRryA+wyfPl/S4b2LRgzgSwpMbhnnksyrEoag4wzr8xnD4aybkL8AmwPSrl/M4wybSxafMyzrLI/SzQPMkLyApwpFDA//QpPLRgzg4wzrDM/pztJpkxng48ySkxn/Qp+bkxLfYypBqF/M4pPFMgLgk+prLl//QtJpDU/gY+prQi/nMp2bSLLfYwpbrInS4nJLErJBSw2Db7nS4ByFMCpgS8yDQi/S4nypkrcfT8yfPI/fk82LRrzfS8JpSC//Qb+rEx8BMOzB4h/Mz3+LMr//+OpF8i/nkQPMkgnfSOpBqInSzyJrMCy7Yw2DQV/Mz+PFFULfTwzMb7//QpPSSx/fk+JLDlanhIOaHVHdWhH0ija/PhqDYD87+xJ7mdag8Sq9zn494QcUT6aLpPJLQy+nLApd4G/B4BprShLA+jqg4bqD8S8gYDPBp3Jf+m2DMBnnEl4BYQyrkS8B8+zrTM4bQQPFTAnnRUpFYc4r4UGSGILeSg8DSkN9pgGA8SngbF2pbmqbmQPA4Sy9MaPpbPtApQy/8A8BE68p+fqpSHqg4VPdbF+LQfqLkQ4D8j/DlztMkc4A4Q2BzA2op7q0zl4BTQy7Q7anD6q9TyGA+QcFlDa/+O8/mM4BIUcLzyqFIM8Lz/ad+/Lo4GaLp9q9Sn4rkOLoqhcdp78SmI8BpLzb4OagWFpDSk4/8yLo4jadbFPrShaoS6/LbSpdpFpFS94dPl4gzUanTbaFSkJgQC804An/So8biI4d+84gzTJ7H68/mVzeS6J9RSnnllnDDA89prqgzCaLpSq9kn4M+jJbcI/9RnzFS989pkqgzaNMSd8gYDqeYQybS0aLpCqpbdaBzQPMz1a7kI8FSkyn8Ipd4maL+UpDk6P9prGd8SyM8FJrShP7PIp/8A8f4M+rSb/dP9zbiA2gpFyLS3J7PlJ78AyMD6q9Tn4AQSJDEALMm7pDSet7+Ac/4SL7p7y94da7+rqg4Aa/++JDDAyAbs4gq3Ggp7z9RYyoklGfpAyfbwq9SM4sTQy9pSLMpDqA8jy/bQyFTAPomSqA+1p0SQyURSpb8FzrS3LbpOpd474bmFcFDAJ9pkpdzDanTNqM8c4MzQzg8A8S8F+FEn4AYA4g4Vag8McFDAaB4ocD88+rSd8gYl4e4QyrSNanD78nzc4AzynfTFcSp9q9kmLLzQyAW3/db7/B+n4bQQ4fRAngp7t7zQJ7PlL78Sy7Qo/DSbafpka/FRHjIj2eDjw0rMP0r7+AWUPAqVHdWlPsHCP/HEKc==\n" +
                "user-agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36\n" +
                "accept:application/json, text/plain, */*\n" +
                "x-s:XYW_eyJzaWduU3ZuIjoiNTUiLCJzaWduVHlwZSI6IngyIiwiYXBwSWQiOiJ4aHMtcGMtd2ViIiwic2lnblZlcnNpb24iOiIxIiwicGF5bG9hZCI6IjVhMjlkZDFiMDQ5MzlmM2E2NTBiMzM4MTg4ZDAzZTA5YzA3NGI1MTA5NTkyOWUxZmQ1MTE4ZjIzZjkxYWUzMjgyMTljNmNhMDg1YjY4MDQ4OGM1MDc3YmI4M2Y4Mjc1MDk4NTFkMzAxNDg2MDUzYmQxOTI3MWNjNzUzYWU1NGYwOTVlZjM3Y2MxYjRmYjgwY2IwNWExYzZlOGUwZjM0Zjc0NDY5ZTRjODcwY2NiNzU4ZTA4YWU5ZmQxZjY3MjdkOThiYWYyYTBiMzczOGE5ZDczMzgzY2NhNjJiNDFiODk3Njc1NWEyOWEyNWQxYjBhNGIwNDFjZGRhZTg0N2Q1OWNhYjJmZDE0NTI3ZTk5NWI3M2U1OWEwNDI5MTJmZjYwYjZjY2U4ZjRhZTg4OWU3MWQzMTE1M2JmY2MxMTBhMmUxYTRhNTQ0ZWVmNDliNzAwZWFkMzUyYjBhNWViZDBkYjc0NjYyODFiYmYzM2E4NjdmODgxOTk5MDM3OWFhMjI3ZWZiOTg0ZTZlMzkxNzBlOTM3M2RkNGQwM2U2YjNjMmI1In0=\n" +
                "origin:https://www.xiaohongshu.com\n" +
                "sec-fetch-site:same-site\n" +
                "sec-fetch-mode:cors\n" +
                "sec-fetch-dest:empty\n" +
                "referer:https://www.xiaohongshu.com/\n" +
                "accept-encoding:gzip, deflate, br, zstd\n" +
                "accept-language:en,zh-CN;q=0.9,zh;q=0.8\n" +
                "priority:u=1, i\n" +
                "cookie:gid=yY0ySjWW8KYjyY0ySjWKqi1v4YVqSWWTl4q4IjU9VKyIKFq8qx2JqA888jyYj8J8SD4JdfYf; abRequestId=c1d099ec-875c-5db3-b08f-d0c5c0c44e3f; a1=192fd08cbefsslrmh2l8kooc4ogfnwzcdgbg4t77330000106408; webId=8ac1d8f8d320f3337240ea2d65a2779a; web_session=040069768e88b16411e52c181f354b17067630; customer-sso-sid=68c517433843732345462753dd9011d16a2b1132; x-user-id-creator.xiaohongshu.com=5a177936e8ac2b535e9441b3; customerClientId=499592909421768; access-token-creator.xiaohongshu.com=customer.creator.AT-68c517433843732344105443adqozz7fwwpf70fw; galaxy_creator_session_id=RDErIxGMu5KWIIJ2bnPFjgUZ0J2bt44ZB2US; galaxy.creator.beaker.session.id=1730826621326073680496; xsecappid=xhs-pc-web; webBuild=4.41.1; acw_tc=62ccb90b3cc8f0573d3838591c3097405919661f5a1489013d642eeb27f71535; websectiga=29098a4cf41f76ee3f8db19051aaa60c0fc7c5e305572fec762da32d457d76ae; sec_poison_id=aa44f449-7b75-451d-b657-102ec8da4d66"
        ;
        try {
            Map<String, String> headres = HttpUtilsx.getHeadres(headStr);
//            HttpUtils.setProxyAddr("127.0.0.1:8866");
            HttpResultData resultData = HttpUtilsx.get("https://edith.xiaohongshu.com/api/sns/web/v2/note/collect/page?num=30&cursor=6624e7e100000000010332f2&user_id=5a177936e8ac2b535e9441b3&image_formats=jpg,webp,avif&xsec_token=&xsec_source=", headres);
            return BeanUtils.toJavaObject(resultData.getResult(), new TypeReference<JSONObject>() {
            });

        } catch (MsgException e) {
            info(e.getMessage());
        }
//        catch (HttpHostConnectException e) {
//            info("Http主机连接异常!");
//        }
        return null;
    }


    void info(String msg) {
        logger.info("msg:\t{}", msg);
    }
}
