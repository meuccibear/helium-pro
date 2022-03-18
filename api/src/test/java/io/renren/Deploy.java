package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.Location;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.Gateway;
import org.junit.Test;

import java.util.*;

public class Deploy {
    String path = "../data/";

    //    String filderPath = "../data/";
    //    String fileName = "gateway_%s_%s.json";
//    String logPath = filderPath + "%s-%d-" + DateUtils.asStr(3, new Date());
//    = filderPath + "%s-%d-" + DateUtils.asStr(3, new Date());


    @Test
    /**
     * 构建信息
     */
    public void run() throws MsgException {

        int startIndex = 502;
        int groupStartIndex = 467;

        String groupName = "sh-cz";
//        String groupName = "cd-lz";
//        String groupName = "hn-cz";

        // 山猫：1680 黑豹: 1681
//        int port = 1680;
        int port = 1681;

//        int[] typeIds = {1, 2, 3};
//        int[] typeIds = {1};
//        int[] typeIds = {2};
        int[] typeIds = {3};

        String groupStr =
                "851e1373fffffff\t7\n" +
                        "851e1377fffffff\t7\n" +
                        "851e841bfffffff\t7\n" +
                        "851e8443fffffff\t7\n" +
                        "851f0d0bfffffff\t7\n" +
                        "851f0d57fffffff\t7\n" +
                        "8539444bfffffff\t8\n" +
                        "8539444ffffffff\t8\n" +
                        "851f0613fffffff\t8\n" +
                        "851f061bfffffff\t8\n" +
                        "8519698bfffffff\t8\n" +
                        "8519698bfffffff\t8\n" +
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n"+
                        "8539444bfffffff\t7\n";

        String walletStr = "13HnqargmvQGo7fjF8MqgLZL1i2GaYZmaKN265F4VoBZ4GkwWfq\told-key1\n" +
                "13hzimKiYJWxScsWrDBRcY6mMmZXLcXFUmXrptAWSakEKGiyiU6\told-key2\n" +
                "143HzDdvTHR3y15Kg5QKZ9xSyrQpGzysWAGzdRgnQmvbhkM2x23\told-key3\n" +
                "13zQiu4tjGt8FRs5moPrqBTiC3E7sSEJu3C8d5CMGZKmbpoJPBt\told-key4\n" +
                "14oepjcKsw2h8FBJBZNiApHUoQTMX3oewVj3AMreUyeTSsQM8R9\told-key5\n" +
                "13NEqtDRiPxHcZeH13jzuaMurCSVgz1ykwLLF9F8DszD2AAvGEF\told-key6\n" +
                "13SR3vNF88MojW65mKepDkVR253j33hqvcXCpVUiMEsx4JcyWud\told-key7\n" +
                "13NjvxWSTghaMrJifPSfeUakutZfkLrSnE3UatqRHzUjQfwhCE6\told-key8\n" +
                "14cF6somKz4NWnJ5aKAary9Bpy6UvzKNC2mM5AuWoGybPwMSDvK\told-key9\n" +
                "14kSZsx5Vp9H4CcFKpcefd9n4cTevqRm61nHQWhjCmoSZiEJYYU\told-key10\n" +
                "14gcqyUh3bEtXeeMP7kWERu472vDonfW1mMKZeFAiN1vbzNmQ22\told-key11\n" +
                "14n2DTYzWxVmELrcphtPUy6wH94NwWQdcJBRsZpZwD6mnMzrMym\told-key12\n" +
                "14JeaT1M5XWKD5HE3XP3fgsJ5U1QBi5PbKgTm2xqiuTkHJwuCmG\told-key13\n" +
                "14DkqGih8YMnzyn2DvGVQqUfRcCwRQLzBz8G6ghp3saEdyKF5ub\told-key14\n" +
                "138uGZsvCi245deCfwzVQiqp23CmUcVZvLcaexAvna3jyy3iM1n\told-key15\n" +
                "14Vxj5jBhscwV5ZUuPLZLfY7wf2KharCWgUZzPwJfihTiX1vKLn\told-key16\n" +
                "14gpKVtqbZpvvQe4EsjCh1iD4EmktKH4LBHBF4EQPpyeRj2FiEo\told-key17\n" +
                "13czhG8H6GYJn7wAfoDyvDztRXXGmteF6CWHZikcJJvjFwhrywd\told-key18\n" +
                "14K8ZAuzxMepVqTpxAYFzF6Cj6EV37wBHpo7Cs6ECNCMLbTpYCr\told-key19\n" +
                "14L2GAiESzgivRmLb36GVYDWVaRVUPNavkZSmNnTig9cJvNWyRK\told-key20\n" +
                "138hWCrnnjJcB7dNTR7BKarzP9FRGneBDVJBs9jqTHmwqGszWfN\told-key21\n" +
                "14M6NWYmz9MD6VPjeY9WtGbHMmU1xMkpUSR9mW3kkCFPUSVg8Z2\told-key22\n" +
                "138uGZsvCi245deCfwzVQiqp23CmUcVZvLcaexAvna3jyy3iM1n\told-key23\n" +
                "14tR7C7j87uuJ1iSgGEBRdXbAADk9q4RYdafVywY9d4EGLX8eqf\told-key24\n";

        String deviceTableStr =
                "192.168.11.92\t11doprVqqD6J3schwWkebq1itvEnaG56gUvbJqALYfLBRkbmBWb\n" +
                        "192.168.11.93\t1128eBueY3uT5HASQ8HZqeiKw4KDrefhdiC9BCz8ktmYhqpE5fXM\n" +
                        "192.168.11.97\t11R3HBcWezhaPz86Fu6SoPXJjQ75LXyYNVjvEMYnsZC4CZt6hqV\n" +
                        "192.168.11.98\t112URXSZ917Mu1JCBPia1YYnAQarfH2crhzN67gi929whsTp1sNR\n" +
                        "192.168.11.99\t112R84UScfxbRCKpTjbky4ermqsvuuGBeMMmqBEKH6LzsUSZfGYB\n" +
                        "192.168.11.101\t11J71nTbKyjMMJoWK1nSksqr38Dhur6KLAHmoRjRJWVwfwnn9uZ\n" +
                        "192.168.11.133\t118iydLsMK81msVHuVcXEwKuX8NCQPBkcN2A7tNrCfgAdn5z46S\n" +
                        "192.168.11.104\t112WbwBx1qknEeo5a54RKB6Z6P5jTbitTcBVCWG1uAx7EVudpBQ3\n" +
                        "192.168.11.105\t112WKq6NJ1Ln1EBLK8TTjzGD2KUF3MgujLXRZaiCWMo4ZvfkLtqd\n" +
                        "192.168.11.106\t1121812KGvLk8xSYZwsPV91d3svbxTwrQTMS8h9y316eWX944Gq3\n" +
                        "192.168.11.107\t112fCnVAjzCsvW7WyWQfgcLVg2qRJYsR68W6KWBD5n111hMTB6T9\n" +
                        "192.168.11.109\t11wc6SfHSEgm9smWbAfKSPrxvAV7A4x2fJXZm1n7C4Gh56az2CX\n" +
                        "192.168.11.111\t118Mt679D7js3i1xgrVbyXYacgUNp5mhwpoBqKB9e31gNaRjdtk\n" +
                        "192.168.11.112\t112KouZJtHRgD4ANCPZmdDp3z9TDhpyDtRjVsAs8ea4Zb94jttHb\n" +
                        "192.168.11.113\t11tpHTNU5f7DHGnMKwJQncbHZzA3zgFMQqqzkVooJeHeDVjGftp\n" +
                        "192.168.11.114\t112WXjJHH49TcUihi3aP1HKYCnrpZHnUqCpcVGod2nu7doMALtxn\n" +
                        "192.168.11.117\t112GsPpdUxaqwWCJyq312EX77kRuwKcVsAhE37eaTSv18aQJ3JZa\n" +
                        "192.168.11.119\t112CSYJuw54WautQfvM3vHcbySdFnJsTeUH16mUYDB4HyaRaa5HF\n" +
                        "192.168.11.122\t112oDd83uQJVQFKZkNTm2UKoric9TspPNmUMqoyKCFqcSdrWVVWv\n" +
                        "192.168.11.124\t112nJZzBMDsLnMdR5Rpc4QHwr1g4mSj26Dcd4RJKXaKgYAJt3uY3\n" +
                        "192.168.11.125\t115VLAyYb9mCZVaHGxsCQ8nu9Nd9hfLHJELyFkQpVptYo7A4QzB\n" +
                        "192.168.11.129\t11QDY9qfYMJaa82mrdDdHbHdjRojXBzpB21zEXMgcDEy3hktzya\n" +
                        "192.168.11.130\t112tdLqQMFk7AKMMuws6ZUpn4QrJUFrEDS7UdVVX3dMYZZyADJse\n" +
                        "192.168.11.131\t11JsJbF87KKtxNxfg1T1VdJHYkpnhcaVeoRSGcqgytFsyByZjgE\n" +
                        "192.168.11.132\t112QRDJQGgPEwUwq3U16TfLtzTUCbz2nrzS4yMGn1QpnJCbTaPct\n" +
                        "192.168.11.134\t112957Pt8swjePqTaBd8yYhES9pduRquG6ryZZRHuJ2K9kjMMV19\n" +
                        "192.168.11.138\t112bQ92MbEpid4gk8w5c3NAoyx12F8k4CDLkab28mQbxSBRznKBq\n" +
                        "192.168.11.139\t112VEWsPbcLUMrKcFyFXxSLAewFqonY68ZSjgLbvacRnkTwvh5hg\n" +
                        "192.168.11.140\t112fW8c2kmzvxE5T85tBnHPQcPdNfTu2hXxicGdc2mA4awistDeJ\n" +
                        "192.168.11.141\t112uH4YWjrt2zoKNwMuqZRoqQ4MntuRdV8oYV7az5dyWYPZtDLPq\n" +
                        "192.168.11.144\t11VZDb6WLVGEpXfJLBj1oWt8QpiY4u4psizrBfXJJcDENRqJvuD\n" +
                        "192.168.11.148\t11ypgeCv2p9GiKCgoJgv2H7GLgTAh6i4nyKgAMUoYgFuVDMm7FY\n" +
                        "192.168.11.149\t112XLaSFw6rvkAb5XRQzpFaUBXfmZ5k6ezYTM4XPxT3nnRTnrtXd\n" +
                        "192.168.11.152\t1121itxbZ42t32GiVVVQDu9pTdwRVCEeGVVzG35cvStLF5A1kQ11\n" +
                        "192.168.11.153\t1126qMmAw8Vhjqf3GNYPjCShjBUwTEsWAaWiBiFb1EWAYpdFwhLR\n" +
                        "192.168.11.155\t112Sjvh5FPaCexXfFctKsrjmPZ7s2Qa65Vst6i19ijqTzgxyQLsw\n" +
                        "192.168.11.157\t11V3FwrAkcxBbsphfpS1TxyQyGyCG8KaJxLA3ymjTt2oNmvPTss\n" +
                        "192.168.11.159\t112EMYDHqutuki19Bkp2Mno4HuPd1VD5E5DmzsqMEmBcMaQKAoM3\n" +
                        "192.168.11.160\t11289EtfFdZTNS9hMqto4XJiAqY3hfiKVuKVk3gExfZs5kseDTW9\n" +
                        "192.168.11.164\t112R3NbxqFVQLaa8zo4FUBDb11dwDjpeuvdepXiLwDDnVFXv8SFa\n" +
                        "192.168.11.165\t11N4CN2pJNuPrjMkeBnVxoSqnxMx7UunZkr4hWPn9ChdKyPVfac\n" +
                        "192.168.11.166\t112MAoqnK3bo3K8iGQartPMp57AcXrVwiyaEgT54GzXJxnaGNDhY\n" +
                        "192.168.11.167\t112mjGCQhJ6KWBXAggjpEa9nKYEiejiXvpQYNF6v9DUipYGcpSQg\n" +
                        "192.168.11.168\t11QHzBQVpLa47ck6Ze9pALTvd667v6i5eaM8gh4mNB6Stm5LBZH\n" +
                        "192.168.11.179\t11EbuZcnpHsdA5gUpqNx3ztDz2e3VoBcnZkffR9KSJ6zvdjAyic\n" +
                        "192.168.11.174\t11qmyuKsZriEpNjf1BowauNfnXBh7XPxfvvnzV4H6ozHrA67YQM\n" +
                        "192.168.11.171\t11QwKPKxRixZqYnY4mEh5u5DNhGcFr64CZZtVeDPXvfhrDRUp5N\n" +
                        "192.168.11.181\t11g4WxbvWwc93v6jT52J5WZT2GBBGdM7nEmWXV7mcLhJY913SSo\n" +
                        "192.168.11.182\t11Ujh3e4fq95wz2ddW4x7prpCQfZdYGVPVFPLHSRxfNM4vKTsit\n" +
                        "192.168.11.183\t1122nBVTsxmuSoEMUReGccfCSrBpxuYiux6aoxTPFdEJ6wT1r1kb\n" +
                        "192.168.11.184\t112a4yPULKF4Kmc52gfJEGkEmR1nkJkdkZcKABTK8yYHGMDxEDJx\n" +
                        "192.168.11.186\t112wKS5R9e5vpPRakoEZye7zC6gcsoHriX9mvL2EDgQBFT8Hdjsv\n" +
                        "192.168.11.187\t11r3md5Nd6j2HNioQxdXRSg7Jrubhat6b5hK3a4QKmdKeJWDjgE\n" +
                        "192.168.11.188\t1117yN75nKydJFmVYtb2MR1WCupy4tWyD1yx8csbbPhaXg1N88S\n" +
                        "192.168.11.189\t11k4YMQemowd4VvwdQnQ5EYFnYdgX7w3692UEEsnfs8uWJkbFCD\n" +
                        "192.168.11.192\t11gsBcrBXpR1pgk45STaY5CmS7ACm1EJyURTzktR4q7EyEN2Nfz\n" +
                        "192.168.11.193\t112AEQbHRLi8sFoPq4tNHToZ5XXwRkhFJnhn1NjZEdRNMM1Kd6q7\n" +
                        "192.168.11.195\t11m4jBJhrNzQKcjkBEBjLzLt2MkdARLX8n9h6wd2edp8sfxd1Mq\n" +
                        "192.168.11.198\t112Zto2GsE3MB2qug5NrC2yMkk8JAuijWmGkPzvFoR7JfzrENyJ5\n" +
                        "192.168.11.199\t11qNipstjuEnyodfHduDNpnN7YehEUJHNYPYraFcPHm2PPbsV72\n" +
                        "192.168.11.201\t112uuQzqgjBtPLybwHGXvxQSiin93vDmuT75ncHapuxSdGjkTXUp\n" +
                        "192.168.11.211\t11dXpmAdFKHd7DF4tb91NbL5tZqhyhoCus3piGSgPBujGacukjr\n" +
                        "192.168.11.213\t112VbHeHqB8PzLntu1te9bZ7JYAAjhWwTwm2eo5iNGMWVKesLnLo\n" +
                        "192.168.11.219\t1129TVRpHRmFue7n71yVYpM11VgHGsrbpUokFouurXdgYbkbfbt2\n" +
                        "192.168.11.224\t112F4mHJiFRZmpaSC6ZyADYiNLSHDU2mayJMGw7DpwB3UuHfFg6b\n" +
                        "192.168.11.225\t11CQMTwcGjzK9xNaTr3TtNtEK5FY3YfKZMhEhy52RUTLtUHirxo\n" +
                        "192.168.12.1\t112AX96cCvTwuHdWABJYxPvABSTnLuPUY8CGCjxQ8f9kMYSGc6VA\n" +
                        "192.168.12.3\t11z76iXu2rpgmqujct4GbBTRd2krHL3vCnSbe2jucFbdSfhagko\n" +
                        "192.168.12.5\t116gAuUeh1CW9Jgt4NDd7TwBEB7fkMZXH7MvkX3TAHY7rtacHVj\n" +
                        "192.168.12.6\t112nPicqNJgb2EF1gGqn57vqmdiE2PX42GKs1gXVdjjQMb2pQDwg\n" +
                        "192.168.12.7\t112Q7HE31ngAGRGpSf5GKNJWDhWqm6UfU6yadV1R97keBUaKARJw\n" +
                        "192.168.12.8\t11xBjWoZhH2Yg1hHBguzjJ863TxiuCSm96qp9mmHaKEipATqR8D\n" +
                        "192.168.12.9\t112ESPwec2MwUj5KUuxX4pUCzRkaZJSGWHiPfSA4Ffu2NAHhzZqo\n" +
                        "192.168.12.10\t112t4aZbAirat7t2i6hfpij7cp4AnkmkYV8yu7HqkygMxbJwMk7M\n" +
                        "192.168.12.11\t11nDxLJ5gYinb2YmrtWeRQ8msPGHDuPxdwvS4b44CtdJeGwCcUw\n" +
                        "192.168.12.14\t1123SnvV9mkNydktQ2pPvMhnWLGsYXjMgAdhPEzyzKLYj9kQKuaS\n" +
                        "192.168.12.15\t1125Vd7wNw8JUuZ1WoPoR6zWwtQVBZbMWSHG41yf5tmoKefAqeNH\n" +
                        "192.168.12.22\t11nfksSBHhJKVGuPQb683c5kVcC55aPJFU1dFimhLk4Z3BBuCKa\n" +
                        "192.168.12.25\t11Wc8hkd1x78hmrRTv8qMrk9ZSQaLeVfCrVR7pordvAb3W3QcPY\n" +
                        "192.168.12.26\t11CM6GkiiAMFe3iCjodRfRVGUPwB7soNe6F3qJa6XChgP3cA9y7\n" +
                        "192.168.12.32\t11RaMQWNjiwvxSBYSUtqo7zoLgYfeLCt6vWBBVe3XR9efSDFYNE\n" +
                        "192.168.12.33\t1121MePsxbJULDMz9DF8kXPkPSBM6NHcR1cmyCwCFYfSCbpznbPu\n" +
                        "192.168.12.34\t112L5XZkzjja6sUmoDQJ7aMpsi1xnasRjw6s1comeqe2V87Wg6iw\n" +
                        "192.168.12.35\t112UvmdvPwExPNZPu6c8JRr9dXNhePDedhMWD8U66p7N1kzJCZPg\n" +
                        "192.168.12.36\t112DmBUJnvbT5mcLPEyWukRC3WGuWVKGNf9o7yiduru817zrYCS1\n" +
                        "192.168.12.37\t11L3WkbYryXECpZDkUoh6K9JJP25En2uZmGZQRo7wXe4drwuYJk\n" +
                        "192.168.12.38\t112iPZZr3a5CmGDtyyyR5yta7gvqSEPQyCrnHUimbARYMU1HsyV2\n" +
                        "192.168.12.39\t11YWJTSK5Hku3xrSSf2g9KZVLDrxvi347XuYY5sgjLbCJ9sCgFf\n" +
                        "192.168.12.40\t112THzjpMFpEnERdDTL2BuHyDsPeyxrThPbtvnP2Bf3N7DGNnEoR\n" +
                        "192.168.12.41\t1129DdUXNBWRDNsgJbQkwTznF4Km8ffXCH6Wrke2oZG8VKYtdfmc\n" +
                        "192.168.12.42\t11pFE2XQrM9KUoPDBZNJr2VdgnuNw3jtkxP8BU4MtTnenJNMDuv\n" +
                        "192.168.12.43\t112Vep4G5LQqANncfbWw1Zekmx91bd3Yt5GQT2ScReuo6Q12jqKK\n" +
                        "192.168.12.46\t112EnmE9duLc2LikFXyUSkCLg58QxPBWumjEJZZt28iBqbvCJKV4\n" +
                        "192.168.12.47\t11LMJqpxpzqvhuvRErom5zu7yBMvUAtvJpzhjApicZYQ6nCUKtb\n" +
                        "192.168.12.51\t11NeNwA9VUnWEjp1PhwW1iQGZK7Ci6sWiLvTfxjEVxJUCW9vMpS\n" +
                        "192.168.12.53\t1175PnALw54WKpXQg91Zf1Eh6UrSyzaew7cFNfVmAmkEZ1K6Vcp\n" +
                        "192.168.12.54\t112DnGcqAKXQCN8qCydjsZ2L6yJBM5tTM7jWQm3JeBEZ2oevqDAa\n" +
                        "192.168.12.55\t11Sdk87r6r2hAfMsF4PCCqtSJY3U8d2iH6mNwm8MAJhP3HEwCw8\n" +
                        "192.168.12.60\t112KpsibX7hky1betBmKVZN8NG8jXEYfWTRdu6VNtaaWwiW9bVgn\n" +
                        "192.168.12.66\t112L3XAcbNFr7jXNH5pyJvEve6Q8JeRgYqZ9F4LpVgJzPieVfS7n\n" +
                        "192.168.12.67\t1125bHrjc5qmZhxRxqqUWTZT5um9n6oMuHDhYBMQ84vXnL4vSCkb\n" +
                        "192.168.12.70\t11SannJFnaFJ1f44WMoaQ1mMtEU8QVyH9qRLa3xS492idEfzGdK\n" +
                        "192.168.12.77\t112GDzgggt2GcFesiB8V1FHixdUWFhWYYexC1b86QAsUACn3G6qH\n" +
                        "192.168.12.78\t11uburCJP68HCE28druD1p4AAHfAw2zzdUF4kRhV4wajwhGiieY\n" +
                        "192.168.12.81\t112i44w2avdjrr8wyDnp3Q2Ypb4bybrv1MEtLpxrD8XsqrhtF95p\n" +
                        "192.168.12.82\t112LRc7iRoPRFHt7wEf98evwWn9ddEyhQ16Hepk7Ej4oVMnyseHq\n" +
                        "192.168.12.83\t112en4Kv8S5Ve3EnvBbkD1CxPy9GZMJbvxtCGUPD5heYTCCjqqXk\n" +
                        "192.168.12.88\t112uRNo7perfTkx5R1RY5h5b6bn9UctkjBqSQuanGn574kLnaE18\n" +
                        "192.168.12.93\t113FsWMDByxLgpB9deUCSBPjR4DAmWvqobPeXfZUVp16heY7MJC\n" +
                        "192.168.12.94\t112mR8pNbvnSTS6EEPuvqBdHs14jeQsg8SD4cgxub86F9oe2E2xg\n" +
                        "192.168.12.99\t112rRYp6sdeKvz8tCY9p2LyEa5fAjSBKmKAi2dR7v1ABR1SkaKNB\n" +
                        "192.168.12.100\t11GCtmifgKdiLVphtgeDNeGaKizJ2jtyNvzukTLYJvZ3uPitFS5\n" +
                        "192.168.12.102\t1192hbtbUTfXBSxNKNtuiz5oS5dFXPDowsnoxdzX5c7pZA7M1e2\n" +
                        "192.168.12.111\t11DDUmqF92iuve8PKvPEbZaeQsPAahyvkZZb11NFuFCKaFGL1xQ\n" +
                        "192.168.12.112\t1123FvFYrXZUhdhgJrQb6izbwa3HjuA6zxTEX3dFWr4Y4g8KM5Ro\n" +
                        "192.168.12.115\t112EtT82iVYhHZd5rvAHJPYXqZJKTGPRFkn62j3QaaqVFz1Vu9Jt\n" +
                        "192.168.12.116\t112KjUDmmdczjoLDPefqx7GYrbiowXReXbgkVzGrZV7ovaUad155\n" +
                        "192.168.12.117\t112CoQJGzytgaTS1jhBPNv3q2urLjEtszAwHH5Xs6RZW5ZhBHEdB\n" +
                        "192.168.12.120\t11mD7qtno7VCM9s9pLshWmudN9oZ1VjVgBmCxH4QoJXRTuFQtKT\n" +
                        "192.168.12.122\t112w1sVFL8nf1itfR2bka4HnHC7YTG9mZfPeBR7AF6z4jaxnyA4z\n" +
                        "192.168.12.124\t11oHNaL9i7SRomDC1NbQcoZgXL8eBzbcovCijVjRh3iauYTAxBh\n" +
                        "192.168.12.128\t119hb94bXSgTerYVc1ryKLsqUwQjyQVyC668qkEgU5J9gjTe9GW\n" +
                        "192.168.12.130\t11AxcxWxoGnBETjZirHpCzAmynDcgLDM83fJVGZHDij2QTDRJHK\n" +
                        "192.168.12.132\t11DEpPifRkc89cL7e6VL1k2z6UzizJUE3UdYGSkrhXcdecdei4K\n" +
                        "192.168.12.133\t11j8m2EebxLSCXysqznxE2sfMBkbvy8P7dUeErP8ttWGsTa3Qer\n" +
                        "192.168.12.134\t112UCttiCgkQqc6GSNaiewBD3oCAVe4jD9vWCiVSwiyrxv579zmQ\n" +
                        "192.168.12.136\t112muupzMiiJSi3To7T13nBWp9R2AZRJqWWU4cLCCRUVasSPgDgS\n" +
                        "192.168.12.137\t11Xn5C1ZE72FLANGBqy8fDzdbKLQbTWfJ82ihB5TyVAswMVcQPy\n" +
                        "192.168.12.138\t112kQ4aUYuqp2Ke8z1NMugBQaTvnmSicdgTJnrSmEET9ieupYp41\n" +
                        "192.168.12.139\t112gRonhHwJ5RKiBDd2VLekRc17kTcjLFWtYxpQc5HuccPNMgJZR\n" +
                        "192.168.12.142\t11R1qWaLozZgFKjMrUpS9QDj2Yk34marqS3n2oCBrP8K2JjRQen\n" +
                        "192.168.12.144\t112SxN6arEQqTF4JhasSqydeCzJUtgqYKfqnBGjAtjcXEF7zTeWy\n" +
                        "192.168.12.147\t112sHZrcLJ6LkLs8U8mRj1CGTf8C4QBy3ASUagW7kiRV4nbchcSK\n" +
                        "192.168.12.149\t116RKv4QEzadfNz3n2SX6qk8AoYFgc3aJAdnsiiisM5KmLt1VV2\n" +
                        "192.168.12.152\t11HwESXqgCNk7WPbKMYUiH5QueSk7JVTnQAQgUAZTmK7jGk4a68\n" +
                        "192.168.12.156\t11k3uvzZUxuyAAjin6pPTwG7W1YVXAUt7G13uKcstrYo6DfiQah\n" +
                        "192.168.12.157\t112UNZJQqYgU1aSULA2zXBdctHCZ6ZxpdyECcPzXKR4qqQoNPXzh\n" +
                        "192.168.12.162\t112E9s92L5Ec8dp8eSjCqksy5F7KXU8cg8ojgZWySmsy37qTsSSt\n" +
                        "192.168.12.163\t11PXDGKjqJS9fwAHnMCQ4jvgg1ye5Zz1N88k4WUrfF3b47oSJEs\n" +
                        "192.168.12.164\t11N5zHFUMCYamm4JRwkEnb2UUpHaaVTWK5mbqDdfnWTBgQ18rRV\n" +
                        "192.168.12.166\t112iYRXsZrLgc6xv9E1u1KiJUQGJYi3Mm5Pb9o4TSt8oVRPgB47W\n" +
                        "192.168.12.169\t112GeguKHXBH8LzJofHe3NrWDLkothXF8zNkJzwmkWeYeK1bbxVD\n" +
                        "192.168.12.170\t11jQfiL2h94wWWcvUKJM6xDPUfAunTVhsmTLJMXM9ogsdsnQfux\n" +
                        "192.168.12.173\t113bXbQHZXdtMp2wWw5BLF2NrpDkHL8WyrCYD4EHZbCWzzuAUub\n" +
                        "192.168.12.177\t11oD8hXY8NWcyBJ4axx3qh44xSaEim1t8Xy6HoKHHw7QmnFu1jj\n" +
                        "192.168.12.180\t118fJTiocjQRpzdYoSBcWmL1HfJgJqwRck7APk4T62f53Hnq5FE\n" +
                        "192.168.12.182\t112teWok1udGGDRwygzouwgFfnTgiG312vKMKVhX4qkzsYfG9dbs\n" +
                        "192.168.12.183\t11D36U9w2fC7fBVkEqnz4KhbPkuqophuPG8xRf1FvrBt7fCK7zm\n" +
                        "192.168.12.184\t11WKFfPRUroSnLMHpeUKxnjzje87kTWV1rg5EHuWud1hcdz1LNd\n" +
                        "192.168.12.186\t112cSw3gnLHzYfUMqvRinpCS74czz7qy3FtZUGR2Euus2XCnskNN\n" +
                        "192.168.12.187\t11x8Zs7DXxvSoSJnEuXBm31f2Y1nkpBw44BKEsDuLuDaDkh7zkm\n" +
                        "192.168.12.188\t11tCVLbdYEE8REaxjoRd6m5J1YENrUMP6Z3SfE2yxGGfTMPV38z\n" +
                        "192.168.12.189\t11yeCxpVNTqTNwWYG3osUa3qHvMo8zdLV46GPx9GGrk2CHKkQb2\n" +
                        "192.168.12.191\t112S2qMgNf51jvYnDMEEi6nBnPjeoKB6oi2iopignJyXk6tPSWU2\n" +
                        "192.168.12.193\t119JvGwyAdEq5rYR7DHYFJfKKFKH2VV5wNaTFK9XDq7yVu1P3PY\n" +
                        "192.168.12.195\t11vCUqCXUDedoHnWzyGFEcT1PpaobfhpRZ8AzFEKsByHMEnEBAv\n" +
                        "192.168.12.196\t11p4UNnz4b361Xy2kKA4TE4V2LUhLuMGc1BiKWJcitG9hsSmKaB\n" +
                        "192.168.12.197\t11PHitUHTM2zK4Hja8NMRcXpne4JvvT4by4EusAKHYvi7FNxDTt\n" +
                        "192.168.12.199\t112prRvRd8F47iguYuhD2z2fze7TAj9rFbHDoxjHDYA2p7YCwRSA\n" +
                        "192.168.12.200\t11DqXKavrfK4NzBstur6vRt6qiLmq6L1xbnqgNL1F5di69EechV\n" +
                        "192.168.12.201\t112bktNr6887GSFnVLV7DADjM1g7dGKCmGJ8zyWAi2m2PXY7M9cx\n" +
                        "192.168.12.206\t112caqjquDQsixxoFD2MGqKEKpvPrQyVFuL9sc7MAFTCsJugCNCz\n" +
                        "192.168.12.209\t11XWNQ19EywEEVGBdzUrnGdGG4M9v4N41aZFmg92g8v76kBYRaz\n" +
                        "192.168.12.211\t112Kdf6v5nvohQoDasx9uMYVTi6in6vJ2PBYdW7K8q2hoCEbrr3m\n" +
                        "192.168.12.212\t11FcTTdDDLmx2PCRajMPbFECgFn5KKbahfbB2d5ZaAZXZjx4kiq\n" +
                        "192.168.12.216\t114NLubYDcipk8j1w7DzuvfqPZmNYKWaXqHLMQLfPmkwmRsK19m\n" +
                        "192.168.12.219\t112uyXrhUZayNSsQPyz2SadLVdV67jAAFcQfRT7dqLqHnUprRBs1\n" +
                        "192.168.12.221\t11q3CuSGziw92XqCcoubYB6TFDBHkkhiXieGJJ3DfuQNsMpsxGc\n" +
                        "192.168.12.222\t112rtrhH4gh7tyzw86y2FhXURnmGPkCpovgPAg2XNqkyTXu2qPsf\n" +
                        "192.168.12.223\t11256397USRAQtmaAJxzrHff3vkphAWPAZ9C8M2YBjfNENacPrgp\n" +
                        "192.168.12.224\t1115n4V99X1jUwasyWaeNztaD1UJ3kMyeqkWr8h1P31SXQZqzQL\n" +
                        "192.168.12.227\t11qAPJMtevmSZXpZTA1RrAYtaTaAKPXKUHF5t13rahQsWiDjrJk\n" +
                        "192.168.12.231\t11V2h6rqCzMgpSFUHkShTyMABXUYYurkKmBgziCs5KbMtjL12rb\n" +
                        "192.168.12.233\t112rhRvyD6bFtJQf82V2hMzHEuMu4nU45orx2MZrjE7WTQsgTiND\n";

        path += String.format("%s/%s-%d/", groupName, DateUtils.asStr(6, new Date()), deviceTableStr.split("\n").length);
        String locationPath = String.format("%s/location.json", path);
        String devicePath = String.format("%s/device.txt", path);
        String denylistPath = String.format("%s/denylist.txt", path);
        for (int typeId : typeIds) {
            switch (typeId) {
                case 1:
                    saveLocation(locationPath, groupStr);
                    break;
                case 2:
                    List<JSONObject> jsonArray = ExcelUtils.readTxt("ip\taddress\n" + deviceTableStr);
                    Device device;
                    FileUtils.writeln(devicePath, "ip\taddress\tname\towner", true, true);

                    String address;
                    List<String> denylist = new ArrayList<>();
                    for (JSONObject jsonO : jsonArray) {
                        address = (String) jsonO.get("address");
                        if (HeliumUtils.denylist(address)) {
                            denylist.add(address);
                        }
                        device = getHotspotsById((String) jsonO.get("address"));
                        if (ObjectUtils.notIsEmpty(device)) {
                            FileUtils.writeln(devicePath, StringUtils.outStr("\t", (String) jsonO.get("ip"), device.getAddress(), device.getName(), device.getOwner()), true, true);
                        } else {
                            FileUtils.writeln(devicePath, StringUtils.outStr("\t", (String) jsonO.get("ip"), (String) jsonO.get("address"), "", ""), true, true);
                        }
                    }
                    System.out.println("黑机器↓↓↓↓~");
                    for (String deny : denylist) {
                        System.out.println(deny);
                        FileUtils.writeln(denylistPath, deny, true, true);
                    }
                    break;
                case 3:
                    List<JSONObject> deviceTable = ExcelUtils.readFile(devicePath);

                    Map<String, List<GeoCoord>> geoMap = BeanUtils.toJavaObject(FileUtils.readLine(locationPath), new TypeReference<Map<String, List<GeoCoord>>>() {
                    });
                    structureInfo(toTableMap(walletStr), groupStr, geoMap, deviceTable, startIndex, groupStartIndex, groupName, "001c16eeae", port);
                    break;
            }
        }
    }


    /**
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/18 22:03
     */
    public void structureInfo(Map<String, String> wallet, String groupStr, Map<String, List<GeoCoord>> geoMap, List<JSONObject> deviceTable, int startIndex, int groupStartIndex,
                              String groupName, String gateway_ID, int port) throws MsgException {


//        for (JSONObject jsonObject : deviceTable) {
//            System.out.println(jsonObject.toJSONString());
//        }

        List<List<String>> locations = StringUtils.toTableList(groupStr);
        Gateway gateway;
        int ipIndex = 0;
        for (List<String> row : locations) {
            ++groupStartIndex;
            for (int i = 0; i < Integer.valueOf(row.get(1)); i++) {
                if (deviceTable.get(ipIndex).size() > 2) {
                    gateway = new Gateway(++startIndex,
                            row.get(0),
                            deviceTable.get(ipIndex).getString("ip"),
                            deviceTable.get(ipIndex).getString("address"),
                            (groupName + groupStartIndex),
                            geoMap.get(row.get(0)).get(i),
                            deviceTable.get(ipIndex).getString("name"),
                            deviceTable.get(ipIndex).getString("owner")
                    );

                    gateway.saveExcelFiles(path, wallet);
                    gateway.saveConfigFile(path, gateway_ID + "000000", port, false);
                } else {
                    gateway = new Gateway(++startIndex,
                            row.get(0),
                            deviceTable.get(ipIndex).getString("ip"),
                            deviceTable.get(ipIndex).getString("address"),
                            (groupName + groupStartIndex),
                            geoMap.get(row.get(0)).get(i),
                            deviceTable.get(ipIndex).getString("name"),
                            deviceTable.get(ipIndex).getString("owner")
                    );

                    gateway.saveExcelFiles(path, wallet, true);
                    gateway.saveConfigFile(path, gateway_ID + "000000", port, true);
                }

                ipIndex++;
            }
        }

    }


    /**
     * @param groupStr
     * @throws MsgException
     */
    public void saveLocation(String filePath, String groupStr) throws MsgException {
        List<List<String>> groupTable = toTableList(groupStr);
        Map<String, List<GeoCoord>> locations;
        Map<String, List<GeoCoord>> geoMap = new HashMap<>();

        for (List<String> lines : groupTable) {
            locations = HeliumUtils.getLocations(lines.get(0), Integer.parseInt(lines.get(1)));
//            locations = HeliumUtils.getLocations(lines.get(0), 20);
            if (ObjectUtils.notIsEmpty(locations)) {
                geoMap.putAll(locations);
            }
        }
        FileUtils.write(filePath, JSON.toJSONString(geoMap));
    }

    public Map<String, List<GeoCoord>> getLocation(String groupStr) throws MsgException {
        String path = "./data/location.json";
        return BeanUtils.toJavaObject(FileUtils.readLine(path), new TypeReference<Map<String, List<GeoCoord>>>() {
        });
    }


    public List<List<String>> toTableList(String groupStr) {
        String[] vals;
        List<List<String>> table = new ArrayList<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
            table.add(BeanUtils.toJavaObject(vals, new TypeReference<List<String>>() {
            }));
        }
        return table;
    }


    public List<Location> structureInfos(String groupStr) throws MsgException {
        List<List<String>> groupTable = toTableList(groupStr);
        List<Location> locations = new ArrayList<>();
        for (List<String> lines : groupTable) {
            locations.add(HeliumUtils.getLocation(lines.get(0), Integer.parseInt(lines.get(1))));
        }
        FileUtils.write("" + System.currentTimeMillis() + ".txt", JSON.toJSONString(locations));
        return locations;
    }

    public Map<String, String> toTableMap(String groupStr) {
        String[] vals;
        List<List<String>> table = new ArrayList<>();
        Map<String, String> resultMap = new HashMap<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
            resultMap.put(vals[0], vals[1]);
        }
        return resultMap;
    }

    @Test
    /**
     * 显示表格
     */
    public void showTable() {
        String groupStr = "192.168.99.9\t11YoHxPnH14y6QoyM8nYKnh8gzpSDFVnDNmXyo1eFk7ak7fyH53\n" +
                "192.168.99.6\t112DNL9uZV31t1RMv47worRKHM7reLvPTSHy9in9CZev6abmE6xw\n" +
                "192.168.99.13\t112b59GHotCp7YffkdWvorRL2hXvSSCgiBggtYZmDK4T3C6vUSPy\n" +
                "192.168.99.7\t112efYYTU2rPsZcwRG8MWVRKwSeZJP66Es4AjKeo2VcXdDEA1rdp\n" +
                "192.168.99.10\t112aKEDCuqnrQ2j3epfvzLx1RmumjcypfFXupfaAy5Zw9xnbxW6T\n" +
                "192.168.99.5\t11HVpageFBUaAKsFehWAXfBY7hhABMTJb5m8VH7Bpqm41VNGYD2\n" +
                "192.168.99.11\t11ce8SK6TGW769LG9iYmi7sLQKFZrcXspSkM4hPJz5aN9zS2XhV\n" +
                "192.168.99.4\t112G5wD2AwAiVUiB8tjCvS2KhztUDGykcTrs7z55Kb1BRw9jmaBV\n" +
                "192.168.99.12\t112Dsfytc4UYj39QCLaQFiV1qPfNG8mVGWiSHhtkGrFijcU6jBy6\n" +
                "192.168.99.8\t11htcJGGWcKrA5QqXrRXFHiFUT9NVjCH7GPDRoWJsRrZbeKixrX\n";
        String[] vals;


        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
        }
    }

    /**
     * 随机设备【递归|单用】
     *
     * @param completedRewardsBean
     * @return
     * @throws MsgException
     */
    public Device getRandomDevice(CompletedRewardsBean completedRewardsBean) throws MsgException {
        if (ObjectUtils.notIsEmpty(completedRewardsBean) && ObjectUtils.notIsEmpty(completedRewardsBean.getHotspotIds())) {
            String id = completedRewardsBean.getHotspotIds().get(NumUtils.intervalRandom(completedRewardsBean.getHotspotIds().size()));
            completedRewardsBean.getHotspotIds().remove(id);
            Device device = getHotspotsById(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            if (ObjectUtils.isEmpty(device) && device.getStatus().getOnline().equals("")) {
                if (ObjectUtils.isEmpty(device.getReward_scale())) {
                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
                }
                return getRandomDevice(completedRewardsBean);
            }
            return device;
        }

        throw new MsgException("没有可以使用的位置设备了 " + completedRewardsBean.getHex());
    }

    /**
     * 获取设备信息
     *
     * @param id
     * @return
     * @throws MsgException
     */
    public Device getHotspotsById(String id) throws MsgException {
        HttpResultData httpResultData = HttpUtils.get(String.format("https://helium-api.stakejoy.com/v1/hotspots/%s", id));
        Result result = BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<Result>() {
        });
        return BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
    }

}
