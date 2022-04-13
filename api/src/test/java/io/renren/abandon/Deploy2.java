package io.renren.abandon;

import io.renren.common.gitUtils.exception.MsgException;
import org.junit.Test;

/**
 * @program: helium-pro-new
 * @ClassName 生成配置文件
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-25 20:12
 * @Version 1.0
 **/
public class Deploy2 {

//        String groupName = "sh-cz";
//        String groupName = "cd-lz";
//        String groupName = "hn-cz";

    //        int[] typeIds = {1};
//        int[] typeIds = {2};
//        int[] typeIds = {3};
//        int[] typeIds = {2, 3};
//        int port = 1680;
//        int port = 1681;
    @Test
    public void run() throws MsgException {
        String groupName = "hncz";
//        Integer startIndex = 267, groupStartIndex = 12;
        Integer startIndex = 232, groupStartIndex = 7;
//        Integer startIndex = 232, groupStartIndex = 11;
        // 山猫：1680 黑豹: 1681
        int[] ports = new int[]
                {
                        1680,
                        1680
                };
        Integer[][] typeIds = new Integer[][]
                {
                        {
                                1,
                                2,
                                3
                        },
                        {
                                1,
                                2,
                                3
                        }
                };
        String[] groupStr = new String[]
                {
                        "8540a1affffffff\t11\n" +
                                "85409463fffffff\t11\n" +
                                "85409043fffffff\t11\n" +
                                "8531997bfffffff\t11\n" +
                                "8540c4d3fffffff\t7\n" +
                                "8540c4c3fffffff\t2\n" +
                                "853083cbfffffff\t7\n",
                        "8530b02ffffffff\t7\n" +
                        "8530b077fffffff\t7"
                };
        String[] deviceTableStr = new String[]
                {
                        "192.168.88.21\t112TTwYkgGDMn4wgKyEU9jtHrfgZ87dCNQGZPYkqqxALAdX6zNah\n" +
                                "192.168.88.22\t112G9GU8pfe529dg8ehGXocoM1QGFxHJ73PDFTfvnsTGX1YeQL8R\n" +
                                "192.168.88.23\t1122Y3jCJ4KvcxDioSmwsM99GZv9LoVNKU2bmTsRi74wicP8fZm5\n" +
                                "192.168.88.24\t1129mrB2xDyqbKeDUcGsAvFjPAFV8RH232W93sCWRuf9rsEa4da1\n" +
                                "192.168.88.25\t1126PpFGiYS7d3bQhtAy8By2WjpFhKreNgATsfKSnMkL2ccg5Vo6\n" +
                                "192.168.88.26\t11Fx6gRntmhm26hDgDZuft8askNmztFUvqDzwuswqB2p3ZZ1zvf\n" +
                                "192.168.88.27\t112LjnAXeWDTtyiaRj21jUSCNiLDNsYBKamnmV6oZZd9RKGSzpKo\n" +
                                "192.168.88.28\t112LgWpv5aSyfy4kqs4Ftzkyhhd8si55UHiN8GP2hPzBmKGRUK1p\n" +
                                "192.168.88.29\t112jYGYTCtMGLxYzkGCLg1wtnnL7oaRmVqiHd5qJCyKZEv7zWANi\n" +
                                "192.168.88.30\t11k9befcbh6fJMbVnhmB17Jc6ftxKaVVempcjoFHQYRrAxQkzf8\n" +
                                "192.168.88.31\t113mHyeVwMdg3wbJRAYaALUrEXCBrDo2azKBjqsQtLzx2ZWT7TS\n" +
                                "192.168.88.32\t112wfGBMnRfoja7qHvUQLyJpEjsMT8t8JDFjfkGqgwEAQNcY9jBe\n" +
                                "192.168.88.33\t116HUrZS3RhoW84Ej2nYhJSoPFx2A9Qjf9DQUoCd5XhMHX5M9oE\n" +
                                "192.168.88.34\t1124Yq9UUFgawidSNxptXkJxMFmo3caLv5Zwjd4mvuxTA9BLfsyQ\n" +
                                "192.168.88.35\t11282pjU91xNxzByFSTVEkCtFE5dKjRKewexztkrEHgnowdQiojV\n" +
                                "192.168.88.36\t112mShKLPZCoPXPcKKRnxMMdTX1Z5isj3L3ek4dHKtfDjYXQrFAM\n" +
                                "192.168.88.37\t11QDx6KLv6vFhrmsnLDCSVNLCGpG6X9gRF85AzPBembYaEwU5Ws\n" +
                                "192.168.88.38\t11gnHW31h7nmsHreoyjewXxKKB3HZszzc3GAE1JzZWqqcJxWHFt\n" +
                                "192.168.88.39\t112XZ5FjcMcmBGoUisEJof2ZvQ9FmK8GRJwdfJXLkzxcDp2hu3iv\n" +
                                "192.168.88.40\t11hF33CQ3RxRisFSQk2jmLr3G5ASFeTJwp5qoUYetrvZPt7BAC\n" +
                                "192.168.88.41\t112jfB9iyb9mXwRuqDUMnh9W7W1W4QwMSXwFTiQW6FyhPaPaY4c\n" +
                                "192.168.88.42\t11bkiGEm7ndNuwhuVdXCp79SjhRiRCAZzHg4q3fJXbZTDuqpBhb\n" +
                                "192.168.88.44\t112X1r9XqJuuGKDuaosdw2AX89Yr9mHmfNSbBxG1mGuYZBmVZUwa\n" +
                                "192.168.88.45\t1126XMV4QexqYzv9upqtvSfHaQ3k4y3nwXzpnB76vUi8e7r4ueat\n" +
                                "192.168.88.53\t112XBq8uF1BG4XJ1X7ZZby4vG1bK8WTnEC4AJUa1WPmwkreKoa43\n" +
                                "192.168.88.54\t11tRAMSWtHzDapHDFoNKJPSA6JNhi1RjCVW44FqCCTifWqa2cGQ\n" +
                                "192.168.88.55\t11EHgdBu1nSDzb5p56qYjoWjHQAHYGG9z4zSsSuvrHAJdysQWaV\n" +
                                "192.168.88.56\t114upMAjpWSCcYoL5Y17zEWeUjmFFao85YNGk8g2S89z6tw7uFp\n" +
                                "192.168.88.57\t11XrjCF4gEKXM9qnArFX7vyEvPUco1KHZFYefcRPGvsz8ymcJ3w\n" +
                                "192.168.88.58\t11o2BVLZi7ze4vHk6w3Q4TCLRWuLCeE7dEzmk7GKnj5o1AmPbk2\n" +
                                "192.168.88.59\t11MSnHkCvNB9vhbxdsQGb7VXM2ksxhjP1P9wpn3HFNStdfKArFU\n" +
                                "192.168.88.60\t112BT6m6sDgVu9vT7qYcLjGZV6F8KKRjRWSr9XNkFvHEupB5jQod\n" +
                                "192.168.88.61\t11QvJ2fEbGa5EtkFJuzUQ8CbX3e9zQccwZBV4G2jcyQhXzfVWZ5\n" +
                                "192.168.88.62\t11a7bJrwmkF1cdRF7oz5EU7o2gYhN62usuRvc1BDRgasmUZPqNH\n" +
                                "192.168.88.63\t11pFbKwAkjJmV1Cd3jfb35PLcjBvSKSbcPkLDrSVQA4wGypsoN1\n" +
                                "192.168.88.64\t118fYuAWNRmB1EnrfKfGU3LDbeSFihf3aK4RrJrfmWonk3vpcoA\n" +
                                "192.168.88.65\t112UbnsSRmS5r7G8mHFhRjdxhHhCPvAJ3GMz34tmk4iyZnEoc19F\n" +
                                "192.168.88.66\t112AccgjaTJoGn2S3CQHoXsv2HeSm2qS1FfFFEyYkbA54rLywzAz\n" +
                                "192.168.88.67\t11QzXtSy4bauHnR4yVpju7qJsAh2jPTRDzmooL6oVRQwd3fygBY\n" +
                                "192.168.88.68\t1123e4xE4ZcT48cGihjzch9xGNUdTrQgFXFQaiUjeT7h1NMg8Bqe\n" +
                                "192.168.88.69\t112r1Etwpzw1L4AXbqgt9BondxXKtak8Hhe6FWw9fr2hN7RC8xvh\n" +
                                "192.168.88.70\t112KcoiE79dHeZ3ENgPugHnfbesBW9g9g2GkWs7kde4uk1Mmu1w1\n" +
                                "192.168.88.71\t11FJnbQt2UMTpruAmfsrzZjqpTL2Jzad6XN9oh1Z28SkuuHEgua\n" +
                                "192.168.88.72\t11EntZBFfsMHgtFQ8tFqHnkpz9Q5GbdEtmLBJNTgytXmpUjggMF\n" +
                                "192.168.88.73\t115AkoUiFVkgRgyKGmfYaoFcdQ7AcKcujvXdDzKhTAmXz6c4CUY\n" +
                                "192.168.88.74\t1122XVWCEVnsAmxRwmSoGXm4vkwxLH6vxPg9eSM5KcMho2n75PdS\n" +
                                "192.168.88.75\t1121oADqpE5kpCooE7nBEs44LpLvzUiWGdmtPV7xETjgapGYJ455\n" +
                                "192.168.88.76\t112k9nWSaNunKrukGGxhXNghhZNZ9SYJ8aoBr8xVzAFTSy2JxxWm\n" +
                                "192.168.88.77\t11Q4K8E6FGG4HF4t4ZHsWiDUEWeEzHNjkA3cTMzDdTrRC9KoHYM\n" +
                                "192.168.88.78\t11m7SjGTFxJ69gwjB1nAZoMwpEyzvq3XPbKUAwuT6XfCuBWrqKz\n" +
                                "192.168.88.79\t112McazaSnhyQoY3K5f8dWLQ6LPYpfjRVupPioS819k5WEqvGyug\n" +
                                "192.168.88.80\t11Hpxnn7h3Trq6spEpFJc4T2pfryYAnpunmSR5AriJ5HaHAGp9K\n" +
                                "192.168.88.81\t112YYDAupXsk7prZNTp59TFefh3peo6j3mSi4Ww53aYfg2xrvS6r\n" +
                                "192.168.88.82\t11hgcMPBxnvT1P2o9yXEakBp67vjRhTDSiLwsN1rpyMKpdmY3b6\n" +
                                "192.168.88.83\t112TNoWezKpyvzzAkFWSReK37tdB2Jtsi18NSSCYGWsUwW4N4Dyo\n" +
                                "192.168.88.84\t112hW5ajRBrZrQGTgScoZsKXGiUPZ4PHypoDa8sXfnYXCmBjXsGW\n" +
                                "192.168.88.85\t11aBSN85TqUTtDUitZoGqt89jEARAspuRcqN4jqQAhkdrV2o4Mg\n" +
                                "192.168.88.86\t112VT5kHdvwAe6nfF4MsAGhmF2q84FfxMWwFpVJDudnWSjScdHP4\n" +
                                "192.168.88.87\t11s8tHeXiGyUF5yD1HPUc2t7ig7hG4dqwyJEzLRz8trKf36oZGh\n" +
                                "192.168.88.88\t112gYVKQccx2nH2e2DPucDYmLaexYuaQCnrKZYYPtrc2pmhdM31o\n" ,

                        "192.168.39.1\t11RepePp4KAeXwDv61SkGk1XsKZPzak9bpJELivD4UXmBM5r46W\n" +
                                "192.168.39.2\t112JatsodT2sfnZ8nnx33Ym9yZsroTP3KvqgKqPDacLkF9WKuMet\n" +
                                "192.168.39.3\t11XorxhGxKii1hjpK2o9YT6PKMMz8ZHQSTGQCLwThU2tPbuF3ZF\n" +
                                "192.168.39.4\t112YUFbhCWeWezTW6GjvtxdPPdDwxEExpzDGvMK1Cfy7KP15r4W4\n" +
                                "192.168.39.5\t11wACYVrSmba8WAmAYCF1DXh8C96C1EFRbJTzXUdD4NjqZsfKin\n" +
                                "192.168.39.6\t112M1LV6wGmS6xZuzu6Nf7VYVcQ8Upz9KzKzg1uj6vmy2pM3PmMJ\n" +
                                "192.168.39.7\t112jGpikuFgkVVF7RnS7zjnWyademMhKND434qLEucypJmNorcQt\n" +
                                "192.168.39.8\t11o3oNGCJ5syT76QjvNS3ifCEHNmRaSoAtgVwteLNrqAETPis98\n" +
                                "192.168.39.9\t1131tAEv1k8xGCT4UbEZLVTrmxaHdArP2fwuHKhMgJdQ8vTZdP4\n" +
                                "192.168.39.10\t112rHUd8weS2xGRgdp1G6SdCPAkfhD4GL8fh8N1dYqqbGGLHhDdK\n" +
                                "192.168.39.11\t11UZLQo8bGhTgZM2d2TQADpDRcQoZ5fX3xzzqa12aZVG95t7pTY\n" +
                                "192.168.39.12\t11ENydMPJKy7YjbXwhovSnjomr1XbdyK9P9s6XicFXq3dA9bcMt\n" +
                                "192.168.39.13\t112QuKKq96MX8FuTfzx99R62d9f3bz1rGLGbcBULM7T5WqJ6izTu\n" +
                                "192.168.39.14\t11V8V7xSiNfUAq12txPY4dVKyCVoCT7BrQnmKj36ZF1xiWMXort\n"
                };

        String walletStr = "14Wtm98sgAV6ix3iWNpeBb8cnXpSruNUmCBTJG1jVoo3nprU369\told-key1\n" +
                "14Bd99MkXT9vxNfBE7WJiadZvYeZnDSAS3GPQwYk1vFhifwERR7\told-key2\n" +
                "13q8QvWnNDJBiwtS4WyMDbEHfdvMWxzn1JcTZXgpRhjMuvUzPGt\told-key3\n";
        int i = 0;
        new Deploy(startIndex, groupStartIndex).run(groupName, ports[i], deviceTableStr[i], typeIds[i], groupStr[i], walletStr, "20220411214210-84");
    }


    @Test
    public void xiaoping() throws MsgException {
        String groupName = "default";
        Integer startIndex = 3424, groupStartIndex = 100;
        // 山猫：1680 黑豹: 1681
        int[] ports = new int[]{1680};
        Integer[][] typeIds = new Integer[][]
                {
                        {
                                1,
                                2,
                                3
                        }
                };
        String[] groupStr = new String[]
                {
                        "85405e8bfffffff\t13\n" +
                                "8530b06bfffffff\t13\n"
                };
        String[] deviceTableStr = new String[]
                {
                        "172.88.88.1\t1122Q9UyYiDgZ4pP1GtP5eBjaivCYTnhqihRo4zV7MdNm4B1LsDL\n" +
                                "172.88.88.5\t112bF8vYBb84NxQXUbNk6wS4LKY79QYnrFvcF8R56nZ5X7kE26y3\n" +
                                "172.88.88.7\t112e8KRKBZamYK2weYgn17n4yyURtxuKfudpscKPYnfE4ozZr2Uu\n" +
                                "172.88.88.30\t11Q1kQSGoPY6Ez5Npyj9o5pgBjhexAAWZGUd44JP4NEV1CSAZRC\n" +
                                "172.88.88.48\t11zN6fA4w1k9Q1eL7yCWdXvS7X3vnKUKysVVouNGK1UTTFrZhTf\n" +
                                "172.88.88.49\t112LKuvzySTnatHQuAqyFjFXCzLbCBHTAVghzeMyrsvZaq53o3oQ\n" +
                                "172.88.88.57\t112SeYUYepKBNUFG8UXbXYom6xmE1uHaWo5mf9eJr4g3yjcL29Y9\n" +
                                "172.88.88.62\t112cgixv66hLfxDwYfPpdRiNJueY6NG469KhpJFaf3xfsByrUvzL\n" +
                                "172.88.88.65\t11DSJRQxamNrNEjJGxsJjGgKaRGS4dt8DPka7ZinkwpaCoPppVp\n" +
                                "172.88.88.68\t112CEYZEnJWgMxJVtKYVg2U5XgnhnfBHrEbKviP9BAVoqFTUqwzY\n" +
                                "172.88.88.71\t112JT6xTikRp2RXyCBTxxpi3zNRonhoWpXSg5x6fARjqL4jZuAGY\n" +
                                "172.88.88.73\t11RQ3VEfTq7KH7wSm2v7wf11xXxFUE3YC4FYJoHkbkuzpkuJw1Y\n" +
                                "172.88.88.79\t112ehVwSvNWrezpbFghFJ4HBKdd8xQZnizfzbJisjGSXZfo64fBa\n" +
                                "172.88.88.91\t11YnF1WH3agWc4Vom21gzayzQqSs78fYq9Y4Xg57ESUYZs3dqWJ\n" +
                                "172.88.88.93\t11gFHXYfg4mhxkGsMz4kiWGXs45MByjNpKU7w21Jfburvc7QKgK\n" +
                                "172.88.88.99\t112HCBTD1hNJKPwvovukgs4EsRAwefUYGX491kp6bL4zoKe7oUYp\n" +
                                "172.88.88.101\t11iyce5jTkJLSpH3GaG8uZS6VrLfUzruMagzXNhuzioeh6K28sy\n" +
                                "172.88.88.102\t117QGAfJPBJeGsYkHKNboGW8oowV2rBZycCf7zcnmxasrdzFpF5\n" +
                                "172.88.88.104\t11tbbJyJQixPdPgLhmTxvMJwfpk6NbNdfHERREMwjfUkRbLhkXj\n" +
                                "172.88.88.111\t112kTiWwDjBrrT2B7JhY8znCdE5397xLRdVkz6cgMiAKyFoLhcHr\n" +
                                "172.88.88.113\t112uHKVG5M6QWipwJjb1TxJUQ2L6aFxCWgaiaGNPS5JP7MD4ZbBg\n" +
                                "172.88.88.114\t11NpmMS7v6EZsU5MqPe373CbeLiT9zNHhNqniQZso59H45PsVh5\n" +
                                "172.88.88.122\t112NezcA9D22AhVkEQLj8WcWXSH8GZzMeCYSou8161Yj5Q37Rnka\n" +
                                "172.88.88.127\t112az1KNpMYeUMTafAkQzC4RyGBKuXvP9mqsQzq3ci38vsUo7mUB\n" +
                                "172.88.88.137\t112LqaMzT5k14E8vjkGRrj3iHDG3k3QntgBh6XWPNyukQjV795Ef\n" +
                                "172.88.88.143\t11teRmqAdooLBVE3fFouiTCetxXDQsL6v43JX2eeDGFvC36tafn\n",
                };

        String walletStr = "14r3SqsgM9aT9msidoRrfuhV4cPHhf7fLLQB5gmXXcsXwSmdJc9\told-key1";
        int i = 0;
        new Deploy(startIndex, groupStartIndex).run(groupName, ports[i], deviceTableStr[i], typeIds[i], groupStr[i], walletStr, "");
    }



    @Test
    public void huangshaui() throws MsgException {
        String groupName = "default";
        Integer startIndex = 3424, groupStartIndex = 100;
        // 山猫：1680 黑豹: 1681
        int[] ports = new int[]{1680};
        Integer[][] typeIds = new Integer[][]
                {
                        {
                                1,
//                                2,
//                                3
                        }
                };
        String[] groupStr = new String[]
                {
                        "8531aaa3fffffff\t15\n" +
                                "8531aaabfffffff\t15\n" +
                                "854194dbfffffff\t15\n" +
                                "8540919bfffffff\t15\n" +
                                "853181bbfffffff\t15\n" +
                                "8531818ffffffff\t15\n" +
                                "85318b73fffffff\t15\n" +
                                "85318ed7fffffff\t15\n" +
                                "85408a17fffffff\t15\n" +
                                "85309043fffffff\t15\n"
//                                +
//                                "8564a5c3fffffff\t15\n" +
//                                "85410e2bfffffff\t15\n"
                };
        String[] deviceTableStr = new String[]
                {
                                "hs_nj2\t112ibJozq4GBogYuAPY6EWtrVHsvHUQhgnCcmAY94mKVRsns8Q4L\n" +
                                "hs_nj2\t112NSqAyzKVP2yFEPVACq4QyLr8TemxoVPL5wjGZ9LKEqDnomNFm\n" +
                                "hs_nj2\t11yv3Su1HeeMNiZtLNWdzUhymLUS6zmvFgxDCDN4JfPTjPstKVb\n" +
                                "hs_nj2\t11yYN9fci17VHqoWX2EzCTpPR3vKLm8p26wmUkjTzeDpkAqtrAj\n" +
                                "hs_nj2\t112ZeSkuN8RyQryvsPK8vvTPx7veEtxyMcmc9xSBeE4WEQrTppwF\n" +
                                "hs_nj2\t112pjQEmKNEGUV4RYZrg2BR7x186Q5H7pRXZ4sZLrcpZk2acSVcx\n" +
                                "hs_nj2\t11mcacXsxo3HqzFj2zZKXArgPChpeSRY5wzXdE9zWs3gG87c9zb\n" +
                                "hs_nj2\t11c4seJTFv7tjowiPvF2vKNRruRN3tm4YZu6g7uG5JCjYLBQzMs\n" +
                                "hs_nj2\t112FRmJhSK4a5Sm8ZVYbUF91adVqQikM2FuhFRJwA3ffATXUA6bA\n" +
                                "hs_nj2\t11STb5xLMBi8PgjBbpNghXzmkr4L59F7FqAnN7sEm8SXBFEwSmV\n" +
                                "hs_nj2\t112wPgXoQjuqUMPWXeUpnrt3vYzicF2u8sTgthEuzh8eJafonjpU\n" +
                                "hs_nj2\t11aahzMWKV7rTZPsu4AKFs9tJDcjcr47CZBnqinNhEifxDXsuPu\n" +
                                "hs_nj2\t112KqHo5j24F29sitdAzGdhAhPDzkzTrNRrfZZAWycEYF7HDVisZ\n" +
                                "hs_nj2\t112QwGmYU8Nt5YPkqgsEMzmj2AiNUszG4SFCXkmPKAfiTST6ssd3\n" +
                                "hs_nj2\t112WjJDp7AQzrcW4Pueme63hNodvr4CJvEdACHFJuyecZkrrc3BR\n" +
                                "hs_nj2\t11C6RaLZJAPxHBiNKyjPWxkfM4Rrv94KPyawTTJxLfNyF9DtwgX\n" +
                                "hs_nj2\t11TZZyHpc2KbBi1GSvU19gdyS6rWKCS4WCeboKFiE9gLLN6ecyX\n" +
                                "hs_nj2\t11dUsFa8MprvxhR6AsevJZTZHpnvHVnv5WbCEevRztjZdZyM5jC\n" +
                                "hs_nj2\t11oC1kEyGsbidFYKXWXoj4PwsZUHW9yAvRgMho9PNcai7TkDUnX\n" +
                                "hs_nj2\t112HKhyJ2eMv8VGvd1PZ25EJM2ByQEjQxpYFFMqULcHtq2UwmYkG\n" +
                                "hs_nj2\t112LW8jvGz2dhkdhGB1h5FYfJCnyVJnxuJfiYhjW4MD1JxmGfB3s\n" +
                                "hs_nj2\t112u53dYudZpPjYps5M77rt82dRrP2AAP5AZ9n65fMxbWMLeywBc\n" +
                                "hs_nj2\t11AP5jiAfoT1JJ6VzrEpHj1n4SfBuNcy6zFCuvHbPmGzikA2udd\n" +
                                "hs_nj3\t112MmNcZzuRM35rudkpqZTi5SdpvKBMvvvUyunJzRoLtsm5j4Hdz\n" +
                                "hs_nj3\t1197QohkFuYzrtsh65HSkpf52qLSYWKGGk4sVjKFvmf6ZHLhWL8\n" +
                                "hs_nj3\t11nyMa5PDcu2kuTuLadzwZiN2A8omKgFaayrj8x12iLXquX1MYt\n" +
                                "hs_nj3\t112WST3hLitXgqb14jLD7Srpf8A3642u2ASBDdrkcqzxBstMDe43\n" +
                                "hs_nj3\t112Yao126hcbMtJcgaw6gH4Tk6bQqV86dNLWqJgp2keyGvXsHpLm\n" +
                                "hs_nj3\t112amGdAheAv9FweMQyddGNjKaqdw1fpFcrEsrTpLc3jfvVM6hyF\n" +
                                "hs_nj3\t11jBjzs9ysrAwRavexf2LVRYXdJwdKZ1iC2QW2rzQuX9e8RVhq7\n" +
                                "hs_nj3\t112U4ETuv2K4YBXXTZqLmtxcYb5ovh5u46jaxL24tYMfvd5uM2uP\n" +
                                "hs_nj3\t112UsJDnNfxKvgyALBB4BPaehkp83RPyovAcGAekUEea3AFR1gVB\n" +
                                "hs_nj3\t112cb1YWaCMA3NBMVD1gZeCvfKG56RoXwPEEGRqX46cBK8PQVthw\n" +
                                "hs_nj3\t11kWZgSGLyvBUpaVjGz6oNHjMpUwCZbV3HhJBr68nCLkv6J3qou\n" +
                                "hs_nj3\t111AytiVyNi73zuLiVoRDdFATLLU7RjgPvBhGee3DsoeHHYQti1\n" +
                                "hs_nj3\t11DzEooTm1gruhdGdX6UeNqMgJeV7e2GjATqav9pqbrVZsJ9wUy\n" +
                                "hs_nj3\t112dfjdNsFk33AapaDDezic8tG63U3BanVf284rFdcsYSm8LhFHf\n" +
                                "hs_nj3\t11cjEVAbd66Q5g5WSeWjck2UtR3zDQ4UxShACzxBXgovDzttMG3\n" +
                                "hs_nj3\t11HwPEJeoeSiNQq9H6SWi5QX2mL4eFc58tUbqH3MCJ3ZJKRfBh5\n" +
                                "hs_nj3\t11GZCxxhpctrNiqCSFsJRihFsARYmZPcfy6KCkX3SQ77jtrX2Rx\n" +
                                "hs_nj3\t112h2vtakAPN5FSoA8eAkbTchVWanArGaJoR54yttcHk8YUWtgmn\n" +
                                "hs_nj3\t1132WVbUmvD6RstDUDGQ5M3cbrssYJsr1yEbnHveSChBuPwo8XT\n" +
                                "hs_nj3\t11hWB7XfLEkkShghYZpQxGn7xUgYG9i3tpnKFVLnsMi8wVKqByd\n" +
                                "hs_nj3\t11BQqcKurHiPYaLueZUzLJzjS9Gqt3sVvKkrA3scjuuNjQtp9Sr\n" +
                                "hs_nj3\t11jwY5sYZu7XWYRwUNwZbuDrVsNFKtLFk2W15dwR4pGSycznTNs\n" +
                                "hs_nj3\t11Guaz9tuCqhND8wGULDNBKLYd3jbTKafzWo9i2asorTfqvE3HH\n" +
                                "hs_nj1\t11b6t8XZ6rbiRCsauV5PLxDU5FtfoJqSZSzNH357hpncH8QTYA\n" +
                                "hs_nj1\t11ccuCavNhmV8xM46bRFcESJ6Q9wUgqSQUAqKhsJbXJjxqmHQd3\n" +
                                "hs_nj1\t11HPfT1tvnGmEA3YWGxTQuFrHEnrRC9iP32vwbwAQVcmixjAfqy\n" +
                                "hs_nj1\t112Wcg85NYf2TW44hJf1u14HHmDHQsjJ2Xvt6DB2StTHCcBmexVW\n" +
                                "hs_nj1\t11aFvH9LJkNoGFy62aizhuvKvrXRtViE7BcnDtmeNQwP4vDRxPg\n" +
                                "hs_nj1\t11NUK1hBdR6CVFWdDhnCCReP9TQGWdENnAaekuZosHNtBYJyiVX\n" +
                                "hs_nj1\t112r4rF9KT4NDFgiVnm7XuABmwixiFhVPJvFMn4NbzK5dRPnwcxu\n" +
                                "hs_nj1\t119qDHnWAD3eN9vctks3QXRKQLFsJ3ejtXkMAoHHRDo5zPXHecG\n" +
                                "hs_nj1\t112tj3GG14F3fNBxC6dNjUi8mzLn12gcfuJAiYHPLXtuRYD3wJjK\n" +
                                "hs_nj1\t11RyCe1ms3QvHap5NSoWTY1V6F7xpYdfxr5eb66Wu1BKpS9WWdC\n" +
                                "hs_nj1\t11Nf7eff4xmD2MoSbDtVt7YYwgAUyKWXVh4Myp61hPUWZ9ABiPp\n" +
                                "hs_nj1\t112vZdUhoxKBxfqiBYhMQ5TCkchDQHRudhr6y37oHw5s1pbiV1k9\n" +
                                "hs_nj1\t11bhBJAZ4wiSe3bJaC5e6tibRjeCrtt3TG6MnftndQU38E6DACK\n" +
                                "hs_nj1\t1128QLBBMBXNC2LvN1q8f161bwKwTBPLvAuvkcf6DHhCruJdiXNQ\n" +
                                "hs_nj1\t1123C3JjR47diyzx6nsLTx7cYDwcrhotfdFtRoN6f6ZVAawLSps9\n" +
                                "hs_nj1\t112jg79QTWdBbi2o3i6YghibvWDkk8BT3VsTc7uTFMTMZk3Mk4fV\n" +
                                "hs_nj1\t11XbCUQC6B9vM8numAd6aG2NAMesevrqu9EUVRjKrU1XCL7Y7sL\n" +
                                "hs_nj1\t112q5W1sxcaXReeBsPAxgcFrCy7FDQCgXSp4e6ZWkqkmgSyQKofK\n" +
                                "hs_nj1\t11ScmSP6qKFDHHgz78AY8tytq76xfaggZ3v8J542Zaqa7cdj8wq\n" +
                                "hs_nj1\t112UGsK9EbaxFHePiR5kexpL5SYfE6eezxZkzwZDX8qc3UbXfcmw\n" +
                                "hs_nj1\t112NyAFfNpH3v7MVTPp2HFL6LruY1WrXEu7eZUVuS3ivFbJMH1uu\n" +
                                "hs_nj1\t112qZLTbe1BpJGV7Fd6DsaGwaERoUmPVCESnuDKjnzmB4zL5d4Ee\n" +
                                "hs_nj1\t112n85yZ8Vh5KVFpdLC9Et7xDwAeNqCCQfHe7PN3qzi7bokAJ8S8\n" +
                                "hs_nj1\t112i1T8JGpq45z6XmTo787CQz78Km7JXoCMVRf4pDE7eB9iGm18R\n" +
                                "hs_nj1\t11wTrJmbVzo94cfcAGfYyDMAD1HzoHPa6TH4xXEEys3NkKVAcGc\n" +
                                "hs_nj1\t112efWkmF9NZHAFmp8bQAW3EhLTUEm578b4w2uxq32c9HNcnSyMi\n" +
                                "hs_nj1\t11UEFXC8xAFnGFnNJpFc6CT5GBwGdyoMJu6ZtTH7JPkmPkjDE1N\n" +
                                "hs_nj1\t11P4KY6SrAn8kPXQt9gP9g4ErGkp9WcUepJ8qMZwBmiEbD7oXuf\n" +
                                "hs_nj1\t112QCvcErHfoEnaKzLpXbkMz9MT6WmupeQ9uG7S3GsRZUGko4AZV\n" +
                                "hs_nj1\t112k9yBKXrHXbdcjJA4cepzehwCfakaKYZRQexfWCoeRtDKfBNzF\n" +
                                "hs_nj1\t11oyJegdTnxiZ1VTv43nUY9FHfdzH7rqq4zRMcuobfrKd78t7yJ\n" +
                                "hs_nj1\t1125bwUibrAX8bvKbZFsJEDcMMNDe6GAkFVQmnNqt5bhAoL6VfnE\n" +
                                "hs_nj1\t11BwEGtw1SAxUFR59nzZn6cKCXx8EnhUPZpMXjG7qYoKFV7YeMv\n" +
                                "hs_nj1\t112qom5DjTwTJBtrW6mhevWWSHBVQMJen48tdDnzZFQGLhq4bjxK\n" +
                                "hs_nj1\t112SbTsJoJw6YxNL9HfB7MoWGptnuwKhpPxyPFcDJcn1n3PA6n9C\n" +
                                "hs_nj1\t11UcoHTMYsofdagPMYw1RprHTAAtDWixiiFuGncYNdULywFjNW\n" +
                                "hs_nj1\t112RpP8CDDxt9zwJPXJMgLET9Ak2DEoNsUVLCW3mo47fkp3BjRHG\n"
                };

        String walletStr = "13We8MN4gzrCT53uzY72JPwb4KExvpYry32vWDUgM889hqY4oPi\twallet1\n" +
                "12xX8STNcZaUPCkdgBGcFfPfacXM9gkELx2FnCTyy2xpKQivCVP\twallet2\n" +
                "13VNTsUeWerzqT7u71GEtv6qABxr2bKuiTRA8vE9BFYVAAFRUFC\twallet3\n" +
                "12yqNMxzLNPQzhijsW43g1eHNL8NYsvEpmgfRprRX2grtL6PyP1\twallet4\n" +
                "13LmSPN99K2QZGzgjv5JUM6JP6fbvDvR4SUq4NkkkS6AxHaneaZ\twallet5\n" +
                "14ZjeTtLvc2c55PK8ChBcTNKpqKWh582W49FENSs1Vn6Brrqu7k\twallet6\n" +
                "13mnjYHaVKdQX6SHs4VaZqkTU7Jt5xVre6UokdzFVvJmEdSPUfV\twallet7\n" +
                "137vXvhUsPjf1drbGu3eUYvmFxMWVrqTbeLnQqH2PW5fGCS97Dy\twallet8\n" +
                "13QRKVcz1NpsgMPS3KnSA2iGRhVYFq8qUzFnifXWVSXftQWsAjK\twallet9\n" +
                "12zsT2Ji6wjcPs6axeUfP7hvics6nWcY6HLvQoVPSAKbMnSC4cH\twallet10\n" +
                "13T1yVo8qaFvGWMcaumpbwmLuG6oAZ8emrh87rya6EQVrR2TWFK\twallet11\n" +
                "13JBzkvBC9FRZUiQDeVDq1CiWfs4BQGeL8idLiJHn2WCLwSExMF\twallet12\n" +
                "12zFfhwtU6v74VDfbJyWANPFMr2twre3q9N9eKMwZmiNG1wBC3T\twallet13\n" +
                "13japDocgJbTCqJr7kacxbbzEuDc5UN5T4qYr6pXyhEDGWAbJ7W\twallet14\n" +
                "14Y8EAqGhGTJQcXgy1aQjGsP7bb6Ez9PR7Hxx9P5AyhpFnjBwe3\twallet15\n" +
                "13tuoNQuKUwxAMpEdm1n1vEz3ALSRDcEVWk3Vvy2MLeRJeFqppA\twallet16\n" +
                "13kj1pJgovvXakyQSqJX4DKTVmNXRqo4fUX9ww2EEcbq53pVrf7\twallet17\n" +
                "13GK19wrQjb6puMDnxfTRStzoQB6PL5kmn6ttZeSa52pqeqhiaC\twallet18\n" +
                "139NjFoPsSkCs6qgjMBV7oAZiEvZsHqEEVKuBbcgjDvjrXKWqGN\twallet19\n" +
                "14LHf3wfYfmYUvQsaHMTJwxhFvHAgVpJnujp211cMpJC48zHYWp\twallet20\n" +
                "134ek2zND2boMc6KUtsKe1buzA5KAEbGC5THvTCKJ4GNuARRs8f\twallet21\n" +
                "13ADTv9zSH8R5gwdqSMLzqTGMdfMdK7GyL9cUbrWpBNd1aPwkGr\twallet22\n" +
                "14VxPJKmDLoSnjkKmwD3S424JC6Jqf9JYCzvyfdunP5hwT9z9ey\twallet23\n" +
                "13ZWj1RgsvfHpR9aM6CU136gUcQzfDmiNnuGwSydw6X4L718Guc\twallet24\n" +
                "1376B4UnTQcpFoaE1SkHo1SACbRjwfDGkMLM6xveGQGaqNNJXNp\twallet25\n" +
                "139mgFYCTp17TUcDozRqNCPjNhp1cNLqb4Qj2vBp3cogc7khRQ1\twallet26\n" +
                "13c6zYf1kDcRBQpZ5uakvtc1UZ8Nu2JD3SaNcBP9uCzLZSRRNCV\twallet27\n" +
                "13PDxnBUKNH2vj1zCpGdMbdGWPpTNzfWzuErL36rvjMmF9Q6sVU\twallet28\n" +
                "145S3KkV6icnbqp4659bGzimHjnkEVWQ5Jmzzg7JqsBACoL18Ym\twallet29\n" +
                "13EJx4tZzA4qD8PXzwi2yUTy9jhkPjqDWeLL2LqssExE6HbyRmR\twallet30\n" +
                "13f7C9i1Unkj443HaNKS2Z4WqyFXVhufAykqBcLeNGyUqtSgLa6\twallet31\n" +
                "143cKDq8QykQo3qYAisehoFCJyPPe9Ci1Kg7k2HkPbhB8CEfBRp\twallet32\n" +
                "14XtNLJyfsTjakjxSfov6ny6vF4jrLXuSDBtktiGz1YNdgVSwPG\twallet33\n" +
                "13MsbfzHvby4kuFemydpaKNHQx94rPug47zN5mfDo8KbyEHWW5s\twallet34\n" +
                "13eAK5sEwqxX5TLpkwXejovwmLAXTNoKfXoCxqXzTEMWz4ajoq1\twallet35\n" +
                "13i8cYZASdkYZ32ucQNc2pkShHdQcGRgHN57ja7Z6pdVRm1Jo8M\twallet36\n" +
                "149fDdZ5oNTycs5CeqbrNp6bdFXJRdpZrzVfP97sxWuHeR7e3XX\twallet37\n" +
                "149hSPRK3wnThox8mvg1PQ6n7VngtnJGVE2ay6fKRn7oPuG1g18\twallet38\n" +
                "13nyz29qdZrt2EqDnwf4NfiDs6aa9jn46VN3YELK1B1Bgppdj8p\twallet39\n" +
                "14R9fx1Ee1RPEXsHG3EG5NrLattfrcHxciXNiRg9hPCXWbNhKjP\twallet40\n" +
                "14LVSjJyjZ5VZ5MLbPJj4QtB284AUWayb2XWjCYrNSLwYD3i7CS\twallet41\n" +
                "13Hg3YiK4QLTdJ5e55h4DaisEHdnqvCHyUvwMw9vuXbe9WzCrEc\twallet42\n" +
                "14t6ER6xL2nK97yMyf7KyJ1zqQSobima2BWKHZjVY7BnSzazKx1\twallet43\n" +
                "1368kjsjf5T4nDA2QJneGYucZeJNn7tMumx48W2wM4btWpWLdE1\twallet44\n" +
                "13Bz7AGW1AMPDZtisL4goXw5VE1keXZPTv3MVpZeSTKvby2Lnju\twallet45\n" +
                "14DRdf175h5SWN3Exs5F8WEVxhWnAVoVywbbtnUYVoKS3wVeS9Z\twallet1\n" +
                "13zWdr7LjseTkxeobPuscS8JTNX9Yd6XKxwgA1AWjTMcbZBZUxd\twallet2\n" +
                "13SRwDZJyci6GREN9Wb3MJDp9YRTA1eTadYe9diGfK2sGCAdsRf\twallet3\n" +
                "13tzwJ1t2f5pGAEBxKV6X1otV7U8ArDzRuGorodeKoa1trzhRLk\twallet4\n" +
                "148SkX7Kk5emyJWLednhKKw1zwqbC9msGpjCYyPvGZ8imzbURGr\twallet5\n" +
                "14PMqD6ASLP2aBPWdtwGB7sKWtq5yZvk4ycSMcKZo2aCjzZLcia\twallet6\n" +
                "13f2gX27xNA9ANSTGgQZyDXDXGmJUmW25rJ2snR29VmSbciYJgj\twallet7\n" +
                "13LpMDWEyLYAUofFw5ypYjUGXQjygkA3kfTpG1bz57s1xQ5y2bw\twallet8\n" +
                "14JmVLFM3vsdWB82eBf1gYj7m2AuXnGjkX3WitYkNpR2ZbRzSBh\twallet9\n" +
                "13xnZ1LwRPrX5vuUE92X3X4iBYbhrpFeGY2Mca7qKBpfmkf6kGY\twallet10\n" +
                "14Emw6wFgj7nM4mzBSZZUjtVLgj9szDnv7CPyNY7XG1SSwQsV2g\twallet11\n" +
                "14gKUt41XiGAecV4atHD1dZqcL2RtAeHWbKUFbEX1SEuYQPVcmF\twallet12\n" +
                "14MxuRVN5nX2EbsHtWqaAZWJovTv9NiJc5YMwDWPBuGs9Q3GgQL\twallet13\n" +
                "13aFcLdfChnpMnzB8oAfbgNFFm8KXnLNt9LFFcD14hERzNHpAdz\twallet14\n" +
                "14r2nsAFeQPggvBrbMhdvcHNwda11dGkaVjJbGrpyWyRjAU3DAA\twallet15\n" +
                "13L4vhTD56jnXEJ2c6sB5Q6VDnYSXp4twEMV431KNTaEJL9vwAf\twallet16\n" +
                "14Y1zvikeD4MhvumePagb3HZQmaVMap1QXvSzpGeTZwemQvKUbF\twallet17\n" +
                "13nNdcVZb7uJejk7FjxSEfEQEHpmohwgE9K9xCZB4RmBJrkdB5q\twallet18\n" +
                "14izaZhoE1JmCdUZvDF9kfysNYsYtWEfKpAszrZCBv3yjpD5Na5\twallet19\n" +
                "14UyGc2ptShRNpigRaRaZpb8zav8hvzZLQQTXzmdDMZZhSVLpah\twallet20\n" +
                "13E18sMVPCC7379nz33SGze2e6DUXtx6gSkERrsxPqaBXnaZRmK\twallet21\n" +
                "14pJXuPJ55uWiM26iqjHXwnmtCvU22SWDYpUsn1CpmsDVM7sfyi\twallet22\n" +
                "13ayfJBzUbzpx7BwGtGKdDb9Y6Gv1Cux2AouCXA4sctM7j4vsPE\twallet23\n" +
                "13K9geYJt7USzVSueKJmXdLQxW71eEwrbG6aftfv1eB125Lv7cv\twallet24\n" +
                "14sSdMD5buFosJmzTQNjN5uJ6hKG4DcWzTRAhRmBKDXWEyXhVN7\twallet25\n" +
                "13BX4fxoseZBaUtwaiDz9tdxZbQDQjmzW1TuAJ2H6vVKtgRV15n\twallet26\n" +
                "12xFrbgpsjiStg4VvDJsSYkh7UbA5A9vfcGy2scswwhpvrFb64o\twallet27\n" +
                "14ETLWdxXsdFkavMvALTRJxtZMbcQq2hSoaiTgRuFy81YXf8RbZ\twallet28\n" +
                "137fb46SZbbDPyuCVXBTuP5yfKaYkTPHsaSeThyqUBLLueztctB\twallet29\n" +
                "14NB7JvRGYkQSajxZHNDRUmFRhcGux3MecrLNNM7Qwvsek9Rem1\twallet30\n" +
                "13mB1FpouBWxmF3o2hNNnSniXyyerbiPrWGhySce1W5So3bcv6d\twallet31\n" +
                "13seapbh3QEfJFuVYuZep1ypGBaUPtmg9UoWzVRf862UikNXkpC\twallet32\n" +
                "13b6qWcNUrXXv773Noii5bhpFEcdpMEXmyw8yeWvbtANRBeRn29\twallet33\n" +
                "13zvdvWxrZJyYmBkpChuKiheW6mxpyqwBJRgwWm8RjdHHRMJB3K\twallet34\n" +
                "13R6KHDtVKpEzi4NDy9me7jas3FYnGCq8wHM17s2T4Tdc6p4nFo\twallet35\n" +
                "133LRAknApLvnGUUMcNbFrjtBudEKjf9GQQT1r3gnZVeVbepjEb\twallet36\n" +
                "14cVzDLh7VgCQvP3FeYgmvGWrEDqoL4W7XGQu6JRsiSxpDCYsZL\twallet37\n" +
                "14HQQD58Ty2Ez1d3U7zWQgrBgxfpo2bTXE41WgVL2vTt58KLwC7\twallet38\n" +
                "13kvxHLhTAK27gKdkM1TeJtDmR9aLCuPRSUv3hsyqERAQaCnMZW\twallet39\n" +
                "145qwfhu8T3FaUVtFC8t8CChYWQEQmqUgVxkn4yTR7yumEgzv6j\twallet40\n" +
                "144hLbeKmonxgqvefrLNvqirj6gLh6wXUNmudTbEi5xCLtykDBV\twallet41\n" +
                "13H36mMnxsEjzrNqYf6LPuQmpUMoULMgEJeWxdeQbARA5vWeCSE\twallet42\n" +
                "13Eo8T89JzsiQWzXBL63Dg87uycSnt6H9PRkMWMk1bSsdxpf2h8\twallet43\n" +
                "13WdHgSKDJjKaGosiVov3wGPpGps3wW2Z4bqiLeBpqQfjg4qck3\twallet44\n" +
                "143TQjSRptHDdvWx6Jcs1KVHNV8BrAj9cGVuQxc9BfNZFs69QZb\twallet45\n" +
                "12znL6MLCJ3bJV5woHt6ncZXPet2wFpjaHsAiRb9Z6bPjxNZVQc\twallet46\n" +
                "138umzCyEBePxCTHGHUUhEmFTrYH46krZnffBZrcDbinUFTmEuF\twallet47\n" +
                "131RRvbKSDE3NoPE86sYqfRPdD2MHh6iP62BJb2mYip7Sw47qxu\twallet48\n" +
                "14qkRom5qVf46QSjjx3K4fYoXGxGz2zNReSLdM8Jg5s2etW1vL9\twallet49\n" +
                "13YUAvnSXMxPByYJGSd6isx6jT2gNRpxQQcn5QbTpg8jbzhh4XR\twallet50\n" +
                "144QBrVNJMoDf4K1GGX3t1738VpP1jctezDMPdk74nXyR2YSZps\twallet51\n" +
                "13NfgbvbWtE1GkUZNnMKFWQA8CXsbQtLhNfFXbBtx9p1AtYVJMw\twallet52\n" +
                "13RL13LBux9DQU2vntjaEgAPuM65fpGUcbb2sERWBbA5MCQ4JWu\twallet53\n" +
                "13eUpbQ65VyDgzya2U1Kub3m9aqTXdkD6ptmKDn8y9PMGPkSafj\twallet54\n" +
                "13jZ5rDg5C54YnC4fJAK2jvcHUGxSXPNUq3eWbrbM1yEzD7zWrK\twallet55\n" +
                "14TaHUYp3aPBwUeMn2JzFiGeBxPLyDpsS3LgnX9NE2qVnPZMAf7\twallet56\n" +
                "141EzbzV2FAkdeqA6PKCzVTTVedNWzuffQR7zhhch1k6zzuK1JT\twallet57\n" +
                "135i57ZFSHi8J83dydXdVJsYJwFwSbobv6BFMp2sifXWEaDF7tn\twallet58\n" +
                "13hBtSTPN4YvVtNi8hkrTYjMUdTgRNUWJwwg6ni1hspVVSySZAD\twallet59\n" +
                "14ERQponNwG7eSo8ta2YhEGVvpYyrGUnMDBvDz1NGS1qknLMXXb\twallet60\n" +
                "14tDCtgFj9MF3X3vDMrCUVPYPtTAyBXojqSBviVbMuvw1YP8tcZ\twallet61\n" +
                "14LaFfXdrE4KEPcxWQZ3faQYGbXB5BNU47fkE1xjfpUS3Ge5HHx\twallet62\n" +
                "147tgGnHqD7961LyfmKvQVHk3zADj9SSc1D4gLoETeV6YzcBots\twallet63\n" +
                "14dP5Tu444jyWm5WzUFLMTvu4wwjibyDJECsWuXe5VWay6dHBi1\twallet64\n" +
                "14Hkw7nV9ShB5zFdtQFUKYVWd51shYVNJGf5i789ukAn1aTZCmu\twallet65\n" +
                "14tCysovBCw3y5aJq8FW4ZfnP67SweCPsN8fzijg5xe1nb44v8M\twallet66\n" +
                "13N4QALw8bh29zEKtE5pDqhykFisc4pp46ZZNSn8QDkY5Wdno82\twallet67\n" +
                "14Gv5YyazqDsmQ3RSKnYvwKHk8NTJRsqqHpMjTrNmduR8a9YJZ4\twallet68\n" +
                "14HDhBHLNji5ZDsuUiBtykxoqMeH62NJu6WctVA8gG3UciGBngD\twallet69\n" +
                "14QAjc2NfNhTrtc3rsER43oVnhhAitUk7bY8LRL5MCkVoJb8hiw\twallet70\n" +
                "13GHqvDnn8o2xX7DfWkrdWhYQMb82Sh3eeTQ4ZvtSby6RMUiiEE\twallet71\n" +
                "14qwC5vH4C8pQBHpCP7UL1n9pCM4GeSGBmjUWXmrbdxjYPKEUzr\twallet72\n" +
                "13djBu4GyQc84ZX8TExsNCDotBQvcmbSRKvxzeg72U64HPhRfQh\twallet73\n" +
                "14GQJBE286b9jc97as3vuVdCER6iRN8nxXhPRKRBXz38kMEKuVN\twallet74\n" +
                "138LvWoRt4nUWibFzwDWaDZqyZT1wfGZix9v8e8DvR3i5Dcnv4Q\twallet75\n" +
                "13xqLwgVivrNmpaEQHF9qsiwgLDXewyzfyMwX2RRrwbmBY2qK4P\twallet76\n" +
                "14NrM9T8cZFe88h3FMeorpkKqfVoknRYLBMesATzhYx6kTpbMR1\twallet77\n" +
                "13tgLS78WXYMd7NTS1a49vXbxGNGZCV2EHK5D8EF2tENLMLePzD\twallet78\n" +
                "13ac3NuBuPmj64N8fa3M6a21EH1BEd4KJwE7JYksFK8iXKkSphx\twallet79\n" +
                "13SggtX2vdmUReAMwW4eWd68bh7UXRwdNzAdSfweae7W55hLpEv\twallet80\n" +
                "132Th6RRq5ZRnnEffMNETZRKMjyDZQVFmHiuEv2citF75kwCgYY\twallet81\n" +
                "13Lo5uyi7cZV5qeXyJgjwiqLFbUr4HEXNjtDDvu53SyPstkhEmc\twallet82\n" +
                "14LpRcLfsrFAPR5XGmwPeHxBdW9Gcas8f2JF7w7jKH7MB9JGuLo\twallet83\n" +
                "13oAWjRPEaZEHgyuNbRjg6174mqACwpxSwKj64cpjUHXWrYrKCL\twallet84\n" +
                "13x1LJtCf5oa4XPYsvFmYkLkqDb5975FYU2DfWMkf7oPhwZrNmc\twallet85\n" +
                "14B2QGa3JqijVN3hztN6vfkMwALUpxMo8k3t9zny84tAUwRVRow\twallet86\n" +
                "13HqcurnY5KZYJFjpFvNjMCTcHD2mAxV3jkof6P7NS9wrpoRPEX\twallet87\n" +
                "13vbCDyHvt8R8wW8whFyQagDn1u8pXfG2BXXbsCGLV4qbWVAJgR\twallet88\n" +
                "13EaS5DbBLXnSrwa3W7YjcD9oT2XkkXGVQU9X1JpwifBFh4W46c\twallet89\n" +
                "14mRyDBiZAapjvucoMpm7y4xouZg2M7Sa9FDPHHD3eapLhzwMVL\twallet90\n" +
                "1496UnNuLxiJEK1KSiwVyxFTtBp6t9XA5LCB8qxeKLo3sdV53t5\twallet91\n" +
                "13A6YMwvXTu86VYTTegEBcHkByd2h2g5uyrURK1D8noeEW99ScL\twallet92\n" +
                "14MmKk77XNYP5AwW3iST65SSQQiesewSvYtBfMWyP7SMvvHNiR5\twallet93\n" +
                "13zmcRjDgafTzGBPg6jMB1y8hAyvbBQf1gEks6ZvK1JtsaCTkKM\twallet94\n" +
                "12y3ebQt6d976wgPfeZuwBK9oYJQydeM3xbJFHAFUbi312Gnxi5\twallet95\n" +
                "14HCvd1swuNoUPP9cUpV2gvJ5cU2wtZFrjjA74LhfmSWenbJcds\twallet96\n" +
                "13CnFSzcqb8Q2dHTCk74mPxok2qUHh4sPXYZdfZUiGKMVeTpP1d\twallet1 \n" +
                "14RueXMUFfyKmzPDkZp3uiGBEFkqGBpnwM7BNSGC9Mhcuh2SLN8\twallet2 \n" +
                "14nRPyCUEr4Mnid7HAwdxWTX3K8qSHiZ8AFqd36pQkz7TEgSzjQ\twallet3 \n" +
                "13cJzRZA33RKYFSLvToVjymTb9mv3Anjaex9styyK6i8gX3ofDJ\twallet4 \n" +
                "144XUzFmDuS9KsJfb6T265R2Kzg5Y5YMhejSQaGkYWQaaxMEEL9\twallet5 \n" +
                "13ydhpddFRyEwd5ipMwShaec56VBKaPsX8C5Xs6yPEn5T17WDpY\twallet6 \n" +
                "14tQM9YrthbH33hupi4t5opXLf17jJKQMVtB524ZBWKKPdBij6P\twallet7 \n" +
                "13mt1PAf4orxrtceWuorNZfsb1RnGdeXK1Uf3wyw21kPhy3YYPi\twallet8 \n" +
                "13tXNDVhR5Jzv6YPEa9m5A84Mw3aQhsxPy1xzP6MuZcLgEjGSbv\twallet9 \n" +
                "149F8c3U9vPRgtDwNWAAEWKxV7Aq2zvpJj2kQqxBdT4ug8RZG7i\twallet10\n" +
                "13ASDCrXVeyorPP9GeHEJVZ876mbQuHJQGKG1Ewq7FufqNXFYJP\twallet11\n" +
                "13kN53pFVtRa2q4eL7CFFcEWDgqMUkCCnrf2SMS8oxTzeQPJEwF\twallet12\n" +
                "13JfpwsAMuDFCVFGqLQmCZEzNVfxQ6vJ3468DDVkCgi543gBjaT\twallet13\n" +
                "13ZTtot5aSZ9JceeejQKy8gZDM87SJRd9vj7MRwKJQKnzwgUUDZ\twallet14\n" +
                "145XpQQQNFMwLWdE34jvKQArpQDdgVvHzW54c8baoURAfiWrYuc\twallet15\n" +
                "12yC97Ze37DkW1uoYficBNdhCHKnq6S7gu6HaaGwTSErZgde8De\twallet16\n" +
                "13Ak6pF9KXGmcWzqwnFJwqgmqRvCe2B64TiGiNc3pEssNx6qMxy\twallet17\n" +
                "14TsVPUUvDbDnBjHNZXcFRHiYcxmLmX4BoaxAtspN3wsFpvgRAe\twallet18\n" +
                "12xaDaFksf424nL74xKwSgAqmwFboopjNvp2kr5gJxwskqPsdRR\twallet19\n" +
                "14ACseSkLB6WiAYSPZQ81tVd74oh6fb2gjYYyc1ixPY6Rgpydzy\twallet20\n" +
                "136seX4koaCCbYU6RXjN5mC1rKw5A4dexJH5B2ZgrpmV3jZKYYz\twallet21\n" +
                "142s3DzAWQNCwZiPVaB83dCJ3GiAcDJy9F2HuEbcSp7NbSoGMXY\twallet22\n" +
                "13W83D19JQnkRD6qzVYNWkt8P2goDcqna7i5uHZntHqSwT6iN36\twallet23\n" +
                "13A6i58Nm3RUKVTH78SvDwR8L9YTAYkL9PxVjrdrX9qzqHYdbSa\twallet24\n" +
                "13SdjVZPV5ZxaiR6BtF6s5HkQ2ymyyFeRFpW2af5PHvpemrHxFb\twallet25\n" +
                "14WsdpRuPZxq1QzpnxJYfFx2MJaR3nFtcDXL5q1R14bACHpD6KS\twallet26\n" +
                "14i9AXBPmSLxLBUzFc7XBMyA26udMK8979M7R28qghxS5We58LW\twallet27\n" +
                "13q3fXrMEMHWuzaXhoEKkCP94Yzfjd8SHY2mchhpUQKSsvVUNPY\twallet28\n" +
                "135WwoWrvfFAup1AxBoaaeZGmuKYySG6pGFZTUqpji7HKtxXVwz\twallet29\n" +
                "13tfQN1KwTDSmymeYYJPv3A8RwmuH1k4CfCHn8zVENMhYrhYZGc\twallet30\n" +
                "14o2z2m5mFwojQ1AojmpBGh1YMPcuhTQLuCBuffAHbNzhnJmiQU\twallet31\n" +
                "14jnQQo3aEyiQk8zgYy6ZdCzmS9daDK21UL13aTHdEWffMbZeb8\twallet32\n" +
                "14XHHuUZz31S2N55J7nRUNFxwqoQTfSgW9ma1RYpZr4ZaXHXJys\twallet33\n" +
                "13eSm6Tk44PwBCY7jk17zSiBnaGKM1qb2QdonCqkQCxgmrdfNpt\twallet34\n" +
                "146qHzjMnXM9V4SixDrB1uPsHfLbZ9d8GE4fYQAwtCRQo4c4VqE\twallet35\n" +
                "13ZUNF4WH47edSadb1wmdpaL1ezJy8vAtopt4R9Z2cKsn2HUgZ1\twallet36\n" +
                "14mZwRPYqbD8NAdP36JsjV9JFS1wtHNHcBdTRTy4u6kdy3ofM1u\twallet37\n" +
                "14hRNpL4kmqh56796upMVfKYhw5dhdB3mVeG5PChYBxf5rVUmfP\twallet38\n" +
                "14fRakZ4HQNi7i485mjquP9jBfciBqhcMRViZDr8oxy63XgHH5Q\twallet39\n" +
                "14CjmWwdepd7ZN6M9TovGhd9AUaVhCqSMUjXU2vKPQFPB86Jxca\twallet40\n" +
                "14qFcZdbhstmL2QwskcmNqhwrxxxbwKf226GMoKX7DwKzfArg91\twallet41\n" +
                "14QPMM1m5d4RtET3z7GWKEKLYRdFaDfYziT1qZv16hYkTevK2Z8\twallet42\n" +
                "14kmuMEhoQpeo3E2ojSxa195MvsYs3unXWktd15X9ypDtCAxNd1\twallet43\n" +
                "13q4fscDwFG3egxaxD5iUxZqBCc5upF9aHUVk6nKALMuqJHbgxu\twallet44\n" +
                "14DHLP4FivkYaTGghkY3rgMbfy4Rw3zjog1edHqJ2k1JJhWbCmZ\twallet45\n" +
                "14hqz3GR5eDZzEakB4eT3VAheD4TzqjM4mCLBWEPnBJ78xPu4Y5\twallet46\n" +
                "13mVCLBejsehzQnLkoLcauj1KzuQQM4gG16ivhLwCNa76BJjbrj\twallet47\n";
        int i = 0;
        new Deploy(startIndex, groupStartIndex).run(groupName, ports[i], deviceTableStr[i], typeIds[i], groupStr[i], walletStr, "20220411214210-84");
    }




    @Test
    public void mohongjun() throws MsgException {
        String groupName = "default";
        Integer startIndex = 3424, groupStartIndex = 100;
        // 山猫：1680 黑豹: 1681
        int[] ports = new int[]{1680};
        Integer[][] typeIds = new Integer[][]
                {
                        {
                                1,
//                                2,
//                                3
                        }
                };
        String[] groupStr = new String[]
                {
                        "85319e07fffffff\t15\n" +
                                "8531a877fffffff\t15\n" +
                                "85411dc7fffffff\t15\n" +
                                "85309c6bfffffff\t15\n" +
                                "8540eedbfffffff\t15\n" +
                                "85411887fffffff\t15\n" +
                                "8540e3a7fffffff\t8\n" +
                                "85411153fffffff\t15\n" +
                                "8540e3affffffff\t15\n" +
                                "853181bbfffffff\t15\n" +
                                "8540c457fffffff\t15\n" +
                                "85159dd7fffffff\t15\n" +
                                "8540e0affffffff\t15\n" +
                                "85400837fffffff\t15\n" +
                                "85411dc7fffffff\t15\n"
                };
        String[] deviceTableStr = new String[]
                {
                                "mhj_zz1\t112YgDRWuF1rhQtsvrb7muE3zms9o1CFfUJmRjBU3obKdh8c1mfx\n" +
                                "mhj_zz1\t112d5wCQWH4D8TdvhKVkUvq4QyhZydWd4VHygCnhYxAdadb5iVuN\n" +
                                "mhj_zz1\t112LiV8seGCuVGK6ynRkKtEWFNgFkv3NzWKr8b2oEegx8ttXFDkG\n" +
                                "mhj_zz1\t11BVqZrffe3bYASZcB53cwiNodW6RybMmPHkmJLsaG2q1CNCMUF\n" +
                                "mhj_zz1\t11ssq2EAXyu9tvkqcm4HBsfGk9uEMdR79bLVjx6Zdmy3DpZeKgd\n" +
                                "mhj_zz1\t112yV9V8k2tFdoZkYUUsLRAYa6Sk7gwhP8AHyhMzRUwGuEBvEKG\n" +
                                "mhj_zz1\t11vY4BQtP8QPB9bTDjr7a5Yi8pt3bN3VU4NX7U6XcECnLWTYf7q\n" +
                                "mhj_zz1\t11uWvgPE2WonJXVXeL4FsJUv1mecnjQnvxPi3iHfqiqeHdREEEJ\n" +
                                "mhj_zz1\t11cWQZyA4dPrSZDV5G4LRrkG1FNAdxteW5gafhGoycCRrHmNvhF\n" +
                                "mhj_zz1\t11iLoeUyRQjVvMzNEAhfL6KysEN4mN2Rzd1wnjriKwNunopacuS\n" +
                                "mhj_zz1\t11JtLFMov9NxSbQCh117ZEnmxoLcj7zvUY7j8EDNiT8egLLUVWN\n" +
                                "mhj_zz1\t11D7Qu54BQ8oVjHsTSc49kCMCh51WQ2n8p6nUSRLa1awXAwsfXJ\n" +
                                "mhj_zz1\t112w6w9W9a6ELgYizYK6cQuMXiWw3CQWjpKE45ykMCuXd17RwvE4\n" +
                                "mhj_zz1\t112g4gKj2HWEoqVt76ka3WSZnjAi2XxuMHNL6iMt6offHbFbBzxX\n" +
                                "mhj_zz1\t11MmMJLFEDBhhwDTovzdnGicBZDwDw4gLmHeE9bZttxRWiuGt99\n" +
                                "mhj_zz1\t1125Jbc2Q3eThzqrWS61z54q7uY86ZBCqZedSRMbRhYUC42PzsVD\n" +
                                "mhj_zz1\t112QeNScS5Kc8Jmmm6upzgDGxHciFAhQHMV6SppsxrQ9XMroaHie\n" +
                                "mhj_zz1\t11PTkiE9GtnhdgKBKrNEwqys8WAn3h93vm6UbGXJcwHRMr8ERwW\n" +
                                "mhj_zz1\t11dJMxbUFsvFEkyXxCnFAvBEaVpK5RfqZd2HEqTp2uotxKcyVpJ\n" +
                                "mhj_zz1\t11rU3itVwmsgj7wcVF5CLL74hKabfSZ6NMjPGz6M3VtmpGYfTLT\n" +
                                "mhj_zz1\t112bpFNmnsH5NdRvtaYiexbq4FwqCKxHGicunHieU9XEk6YFmfnh\n" +
                                "mhj_zz1\t112DMpWkc3faZpVW3gSbSjQHGKrnzexp16mqPAJX8CXPBheCpN8E\n" +
                                "mhj_zz1\t112WeGbUcWXD8HWyQHdWN1m96YsPy6KCU6TkD2hwFSzL6oBs4ppB\n" +
                                "mhj_zz1\t112aQxV3hozowfZQw9CTm9FpuSzJauwyZTaSj3UDpQHru7dqahfV\n" +
                                "mhj_zz1\t112owbwbyX7mtH5TyoisTZitgnbgPN4JuYoanu9GE5Si8Lobjc8P\n" +
                                "mhj_zz1\t1128fTypjdmVJZDofaRwzEc7DPEg51FS8YMf8GxmGU8Czj9qCg1p\n" +
                                "mhj_zz1\t112qSNRiPyE9zDMnkmqqYrhAVdygwS38BqUk9UVHYYkqJxDX5U6o\n" +
                                "mhj_zz1\t11Ein2KrsG2QqbbKCUSorv4FtAeJL9ZD9YYfaq77fn5567nAyzc\n" +
                                "mhj_zz1\t112KzHUQdjhcnLr253ArdK7a9QEwWf6VjrAKf8SpsS9eEgU7GpBx\n" +
                                "mhj_zz1\t11C2iQN57H5vBMBvDK7My35jTkXKCQixAnB7tJvJ6AxoWimX9ST\n" +
                                "mhj_zz1\t1129ghuUvFCYCRDHoqURoDeRzvdb3XtmG124ENmhh4i1BVVaw1u7\n" +
                                "mhj_zz1\t11bpu5bqeowjSiqTq3QRgSU6c17D6GWC3FfVSKVqqmF8ZA4owtL\n" +
                                "mhj_zz1\t11UmqNTPgnfRcv95G4qRBCS96MUxhGNJbFHYsBMsziQL2jt3war\n" +
                                "mhj_zz1\t11E8AnNx1BiUk45zhMU21Cv357JxQfYTVZ7VQzcav2MATENsTuE\n" +
                                "mhj_zz1\t11DAWanZxvzV7XL6sgJYKB17zpjfrshJ7yVJeBEeumkF5hod86R\n" +
                                "mhj_zz1\t11gbcCTdJSkLsX8Uq9zUgzmcD8aRczWjbm4iaA8EKHuQxniEvUX\n" +
                                "mhj_zz1\t112LxPD8qVHfisqgimr58cujvTr3941KSzAomvRX48Y2YjqxrExU\n" +
                                "mhj_zz1\t1182bvcxCAkzkBebmZDt4KBRzHHtiiB5wAyibNG9YrGYK9jPYKE\n" +
                                "mhj_zz1\t11ipSwxbon38FQaGxemw4rHpKXTzEzYCMuFoWYTPBkZv1MTwiJ5\n" +
                                "mhj_zz1\t112ATnwzNoXJr6qQwK9JVRhgVNjhGVi139ut4ztJ3PjqRE3h5wsy\n" +
                                "mhj_zz1\t1127PvJXv1AUYAzZCGZRcNLWj9DeboEeXqMsLf3UEXN1Ybx14CMq\n" +
                                "mhj_zz1\t11n4JtASH4cJaE9XZHLfo5Fz43vvw9uykHXZotCjpByK1csUSZy\n" +
                                "mhj_zz1\t112i47qGaAMJK6g9Rp5LYLKH7JyY2AGXRPo3GBGKJrgfBBBut4e7\n" +
                                "mhj_zz1\t11vyQkUA3ymHoWNRmuhgYBYtmCASgxNfrgC94SiTgHKSLUtBM8L\n" +
                                "mhj_zz1\t112pucopcnV8epWB6RodK7D7oqavHfTN43NvppwJxyrnsjT7cPwZ\n" +
                                "mhj_zz1\t11nQ4SExnz7TqTz5uq4DnULmAGdJRm3NYiNYBgzNMqRWTT5Hxd8\n" +
                                "mhj_zz1\t112E2FdBoyWJmtYMbFM2ekUfBq4qSGMS61bB2TZY4CowvNxCbvQ\n" +
                                "mhj_zz1\t119XemTqSLnjdBuSZc4dCDVfS49y1aJVGUqznmgaBCzZYPJrMTz\n" +
                                "mhj_zz1\t11a7DB3Cr2Ki3hXA5MRzCSa19MHy9YhSKDq7TeNrUwW3Cs5bWhh\n" +
                                "mhj_zz1\t1128w7tAzYmU4LeHNpTHPd6s9RuLWGob7XdiYBzTj4DfEhyYKeHt\n" +
                                "mhj_zz1\t11235JKVPFAfg31zVFzdeazRu5vJHuWgB9SN57qF8R5sEFHU4UEu\n" +
                                "mhj_zz1\t112rPsjPKhKXTcvAtMD4TJFRYmVQVUfesHThThLM3MgKxPekFZ3a\n" +
                                "mhj_zz1\t112HFsaxfXq5tnTKaUjtE6EEDCC6bgvr793rNRGgA16hsLD1knhL\n" +
                                "mhj_zz1\t11GwnUjj5VRo1ikY3o2KKqU7RciKkoJd4H8ZF76s4BrSKb6SHVv\n" +
                                "mhj_zz1\t11UfMiZwQ6YtT447LJvfRAf876ypBRRfruCthiNVPPedZtc4HgY\n" +
                                "mhj_zz1\t11253Bv6y9nWDbafr9NQi97uUr9wYtGC2cPkhNEARRsePXYu5Pxm\n" +
                                "mhj_zz1\t112Sxbmvu6ySVm7vswetbBqF6WhurTVbmDAWS9aqC5F6uP64sKXW\n" +
                                "mhj_zz1\t112kzDQBhEKC9HpgqKQNwFuTKYTdApfR35kXtzcgee6eZHyuy5yv\n" +
                                "mhj_zz1\t11j5sLr6RSwxyZSffqZizhoJJBp2Phh6x6g1ANMo5U2wNsvBubr\n" +
                                "mhj_zz1\t11g5fHGZ2cRvgr17Rom4HfGnVNpZbJh8HajoeZHG4EaD6MyDGQ\n" +
                                "mhj_zz1\t112iPBfuLtqBemocezigqhXkUmfcJyRLo3Ycm7twbSTXvuoXWu53\n" +
                                "mhj_zz1\t11t6nPkVxS8JSyUmsqTDZuLyPdwZskAz2ujQTMf6hyyJCUTTjo8\n" +
                                "mhj_zz1\t11vHdJHuNqTdyULM4iWCJwMhdpzgTW7UNaiVi6jHiSPMSCmXN8D\n" +
                                "mhj_zz1\t11Y2EB4vKcX9F9d41wKPBbHHE7aLpJMoqxX8Ds1Chwf4PXkNLxr\n" +
                                "mhj_zz1\t11veB9MJtbRsGWUJppSdcpyCWV3NhiCsDw2oyGCispBkdg1TVJk\n" +
                                "mhj_zz1\t112BdY6rcMsvypjjV9ZSQ7bizxdcLEyvtqiAjDeJEvsPgVW9nsUD\n" +
                                "mhj_zz1\t11ZzEA9TALAmSbXma5h48EuTngB5sPwajmkAq8zrEWr9p6s28Vu\n" +
                                "mhj_zz1\t11UbWZEaa6w98GxRkTdv82SJjtzHYcHVR9HoC1ki5fMeZyxDuL6\n" +
                                "mhj_zz1\t11wtNA4a47TohATUVftjQNj32Tuf6tU5wQQuzMx387bHq7uY9JX\n" +
                                "mhj_zz1\t11u8ReL7PHGoaHVBGvcZRQjLs3eoSYSHbp9EuRdsApQkbCJ1xtW\n" +
                                "mhj_zz1\t1121gy6uYxQmrGyYgGZ51hMaRkwPa6q2uvkkwjtg9qWeXBCKucoN\n" +
                                "mhj_zz1\t112tfm5kEkE6DV8ks9P4f3y1NR1PduW33w1y5geey8CAzrJwMAkp\n" +
                                "mhj_zz2\t11JvajJPo881sA1dgLYZyFgX2pzpxx3ApkAiY2X2gLJxCuT4aeP\n" +
                                "mhj_zz2\t112jk3Q5ME5Ug2QvUNzZ8ntCCgEEgC9oYiDXzuKvq1xAdikuXKw5\n" +
                                "mhj_zz2\t11kohnrUZzJBz3A8Qr5TfrKHLjuY9ym8rjtuqXRYL1pmVjh2Kb7\n" +
                                "mhj_zz2\t112q2iThqqpLkhmDex2nBp4P7XuypaaNPcSKfD61YVh8AED4AFfm\n" +
                                "mhj_zz2\t11PHHQwh5yvsuSSqUQEe59mFjPYfNvYiwCPEcc4KAJgBCB7SSoV\n" +
                                "mhj_zz2\t115SG9cJtzgbQuRw7EiHtzgqVPAYdFgat48EE9TTJXxEUWPrALy\n" +
                                "mhj_zz2\t11gyDnMfEgFMgKUTGCyF52gQZfmzRFudmwZmjCG5B3qamzrouEs\n" +
                                "mhj_zz2\t1128GvBQv6B8eZJQF2DzfC7uy3HSHJXEZ7XZ3p2k5bvqvSzq12te\n" +
                                "mhj_zz2\t112PXdPT4SisrvcFSZ5LvzWhCzBCYcCRZx9hAWhV7cMiysbjc8rx\n" +
                                "mhj_zz2\t116J3xi4P8TDTZSgS5xRtELcYu55oy2kFP1yufZuxsmRUGqHn9N\n" +
                                "mhj_zz2\t112LWKV9QfFCXnvRsZ31w9uktuqa1VbV9Adc1Cotcu7jzXrXs9m8\n" +
                                "mhj_zz2\t11nVpErxWpjyce2FgbRLKuTF3WvopXSruak5KZzy7XsChEoXrQ9\n" +
                                "mhj_zz2\t11wAtXDqYFvi1EoZ6J5qj49AVjNrh1ZTksJMSyDp2JVmQSnuRUC\n" +
                                "mhj_zz2\t112QjVEyrPf9AbQd7rQLBhGdVpvjhtRzhb5RvTCWqTeT4ZYhcFW6\n" +
                                "mhj_zz2\t1128eqGej4ZiE2vp4yJLQFqTajZmVBDJr1tJXKjBs56DRfjkiAhd\n" +
                                "mhj_zz2\t11p14wvKvHhUDCzNvWAFqGzmByYvWQTDoTT1Nn2YqyaKNURxqid\n" +
                                "mhj_zz2\t112euucb2vSfNUbT3eJXvmdZx2kAHYFesW6ye51whrompkkE1brP\n" +
                                "mhj_zz2\t112225cjWo9AraM6zvVY44pwPVseWjLqKAMd7m81yrW3ZLA1EBbh\n" +
                                "mhj_zz2\t112tTqZJcobNxBaQaPCXb3mevvaSCqFsLvLKQK4d2za4VkXQmUjP\n" +
                                "mhj_zz2\t112c9DsdeAeCiW9NijLhKzPsVNnACEGH7A7AvFUm33disby5XSmk\n" +
                                "mhj_zz2\t11Na3EwQLDG3PjeLvZP9b4YUdiV4SJgFdnq8cvS2sJhvAGuwgX8\n" +
                                "mhj_zz2\t11VMxSA9XVCXth2jUgtQN6HYTs74v8feDZgE2kZG63z1hJ8gaCT\n" +
                                "mhj_zz2\t11GtiNiciHapTb4DYpWeRmbe3yDGJ6yeMQJP1vgJ9qA9C1D2JoG\n" +
                                "mhj_zz2\t11eVZkvzr4ULT8of721nRT7krCkZv2ijkxtbNnsYDBUY4UbwQ9c\n" +
                                "mhj_zz2\t112gz7g8dY45r6sCxd2d7JRk494SgiV2T1WTmAs4RrQ6xPzFLqxS\n" +
                                "mhj_zz2\t112u12P1zDGWA8JxXgo76BbCn9n3UcGtKqhTBsnHf8i328nmwXS\n" +
                                "mhj_zz2\t11SRQQ6RZSa81HTFnSpPbVRHXCTqXsG8GzfQGCM9Pwd1c9ctq56\n" +
                                "mhj_zz2\t112mCS9UKUhSFVE29b6ZDFcGY3sJLzvyBi3qJDgtaeAgkZE5bCP1\n",
                };

        String walletStr = "13h49xhfNq4BnYcU15d3AJzYTYCDbRpVfQ4RCisAbQFEtdfRMVU\twallet1\n" +
                "13yLJUP6jB3MkiVzv4MQhBpoz2Reva8vKRWMvvDa1DTteJfREmK\twallet2\n" +
                "14D8n4kKpCNxswpRSqCQYE7fa7YYc1T1heWLs62V2NNXLBUsRoT\twallet3\n" +
                "14Rg9NGDwt55dTAdWKYaM8w7nmCxiPjWCZoWDBEhi5X5fDD3K8d\twallet4\n" +
                "13vm2UqAAp61NV6yXozYkciVsmGjZGtJXL2253Rai1iGN15t6JK\twallet5\n" +
                "14dmmxRWV3srNrLcMFVfYHpCtRfpGYSaG83CzdhjfU9tgZeBxfJ\twallet6\n" +
                "14t84tGXQqcSieTy1cSx3PiLiccTj1CAUAoEWRmkmzuYjoPaEXn\twallet7\n" +
                "13uwz2JXbUfZqEw11EXBxibRZXTSLhLm96ghEKPsqCBLiRxipqC\twallet8\n" +
                "13cBm85EKqB67G8TADUC9CywFHF6cwWSNA18Hr5ZJrQSwSM8RSz\twallet9\n" +
                "13Lik5RmqDvc2TD1tx3PygnbkDB5xshcn7KiMWE3fTNezGmsv3z\twallet10\n" +
                "13pE7SppCoRJr6zb9ct3VmpPXvyYSyjPmVTpN94vsA8hHBqja7q\twallet11\n" +
                "13ciSdXN1oQQJWJxMRmLv1WtKSQ9KoFcEKytdUv2Xsx1X8HFrCi\twallet12\n" +
                "14iSMzNLZH48j9JFmwcjStxrnrPeMfuY4vQibyLE7EwkRnx15Q2\twallet13\n" +
                "1466cBKKeMotFtBAx4xgcv9oqJTUgjT4C6ywwrFRCasmQnXt5xo\twallet14\n" +
                "14WHS56uvDoXDqkyaKJoaVydMVwiLXbTmfShLTAnfrVVWi9kBWu\twallet15\n" +
                "13jtNWaNABC7y6hpSRoeLHEhY1fqgvkxPemBGRvPUoMbEuRgPQK\twallet16\n" +
                "1312nY9SgUre2SyLBfeJBNMNXrvF2KikescwgGSAGWrNH2c15fn\twallet17\n" +
                "13GPPdrtH9ZUEtemoZRTMR1pZf1Y5H2gDWBUTZQ3Mz7W5Ji3eUC\twallet18\n" +
                "14TJUubmtkreusFkcUzyTU66ypWGZnY4f8T8DtR9PcdqRTd2QJq\twallet19\n" +
                "13dcqQcS4np2Rtyoj1UweQNZLXsqftZgZiX5oULuVhZxkM4RBqr\twallet20\n" +
                "14RkwgpkcAXojVGqCrP84ebYPeHZcVZ923R6w2GH7D6sWJRgaoM\twallet21\n" +
                "14QdwYVquuyyXztWT5r4qQJuGQgzC83Bdc1YhoLVseZQwmVUifX\twallet22\n" +
                "13GviikMfFwbTU7zgRFRgMWbGQNut85rrpr9Nb9cctKiZHScRe1\twallet23\n" +
                "14kdv5HqgTuQWTAJ24jim2tWqNvsAyL8UtdhCTRi8NFQU8vm9oL\twallet24\n" +
                "14kCuZ7HVmMc8QtboxooEN8brko8k2L7CkzRi9nQ5WSyAyragee\twallet25\n" +
                "14p9EMor8PGnCgz9NGjKeXP1PgbPwkHuFFLhNnp3MPRxT4qxbTM\twallet26\n" +
                "13wT814VYrPwQCruu9PfJXy7ijBzUXqcXn7XVbxiiDzocfAsXp3\twallet27\n" +
                "14f6eKDLxpaDNjqyLjxUxSVBcJ87HpxxEypiJEqoSj8jXZQ8ZP3\twallet28\n" +
                "13kfdbrk7AWbBK6yPfCBwg4FrpaFwQfnhrt8EADveCwPnw4JiCv\twallet29\n" +
                "13RqBA77zEBeURVYwTqJ9QLvZGMjGHSGX5PRiFS4UdQPmsZSTCF\twallet30\n" +
                "143KcQ5KsrRUmP4AP5fc42bB3y8zigUExbjTPsESJ17njDPCxFu\twallet31\n" +
                "14Astu4tXNYStiAjfYpawTVfuLnkMnAy9S8thkPUxWhNuUx9xcG\twallet32\n" +
                "13F5PZ4Rp6WQiTRtdqkTW2ZEyKZiXgSkEjFskA7gncvQzHWbmqQ\twallet33\n" +
                "13snefszYSd8zuKtzuRhhSkzPT2ZEffPTzqVHe8yaPY8SPhrk6j\twallet34\n" +
                "13nWDzoGwdUSYM9HpLgd6XvNMVeaEdJKyvZKaJdBEzQZcfMAQ6E\twallet35\n" +
                "14WtQRAkfMsSzESrqZ25thejmoUa4e4hgZxGu7dwtFpo5SjnHoP\twallet36\n" +
                "12wqeHWNTtoyzjGihBZ1KzQkZeNy9Upg1czUjH4eTuXe6nudA2B\twallet37\n" +
                "13faE9hU6tGQ1cLcB8VFcNbkZP8ujg4ksmhqgydeHD4DeXXC5Bs\twallet38\n" +
                "13YfDfw1233BiLBH5Eufy8kQoGbBST9EnXi1jQpQdBYWT8aKYxA\twallet39\n" +
                "13FMBP4W8LRWR1DvgyZRKF6hMuEtdcTBUmx7aNScK7ZDfrzcwqb\twallet40\n" +
                "133iASqQHpVnedpMwPb9RUGw8vJxWUu9Uvd5PT7ttpwwyavnubB\twallet41\n" +
                "13L4io19feJxx2w7x3ophYbbLqtSs1Atf4yNzjHr1jZQW18ndB7\twallet42\n" +
                "14sMyD3ZgqaTeiCrkkkKnonFSRzi4hdg3TNz2pa8MWYWgBqwAWy\twallet43\n" +
                "13d1MwrgTAbDgSgCLGTd2KMdhbqAqqQ6Fb3mwtTuc5wW7gNmaMs\twallet44\n" +
                "135z1bmjhByGpG77ToGqray7d3Agu6Rt9gYnB8Vsj4cdsQ4EB8D\twallet45\n" +
                "138ekczqkzoh7yDdorWxPqXzbpQfWS84U4y5CyhjYntp8qB65pU\twallet46\n" +
                "14i2syV3jccjh8EQhqDUGMavAbFbv3Sxdo5he2Mis4rVQWd2aSA\twallet47\n" +
                "145WxcjmGnfHbW2BcVr5pQStTkVmr9yDmUqc1uccKvf7bXwecyD\twallet48\n" +
                "1475weYE81qe8HVAJLz5tgBFAe9j3cgrKBLBx9A7JAoWBqQgvHs\twallet49\n" +
                "13iVxAz3tD7PRpzPaTRCHwHdRV1pJunStWgm9srD8GuFK54KzKf\twallet50\n" +
                "13dGRUKM6wECvmxYE5xF2VLDT26TyY95opah82nPXTGgfSBdXDb\twallet51\n" +
                "13xKUFGt57WJqJd1g79hrs2s6jHvwP3EYjABmXnNEgzGqtvyPQW\twallet52\n" +
                "14Ud6abxWVuoeYrv5VHWpNLET7mxwLgJLCmfgrbDK4kWASBe9EZ\twallet53\n" +
                "13BgGzBSMu41rQA2NB8jqB7swsYAoV1FMTNPR1p4BoYZgSXTtTP\twallet54\n" +
                "13L61BBbkW3D2peYmJXEGRaqm6tAgD315WtXt1KKPiRpKrcWukJ\twallet55\n" +
                "13R2TP5kK5apaBPvz3BoA1tPEjKMKnurwJ3gK9rCs3pMV3Vsdep\twallet56\n" +
                "13jTsbXEK23HiMvWX9bDtZ7BENBRoKur3oUbz2tEZQZveAZjk1F\twallet57\n" +
                "14C6eXvgzWzDy6Mp8t93PMLJXUmzAxnPEBRiao9PS1GCiNmqcdw\twallet58\n" +
                "13AaseoKrZhCutAyo8sLfdSA79PkAnLEh5PgvQT2ygr2stZ5HW5\twallet59\n" +
                "14qshxmBzUMmgso1eT4e8RT2eRSoKRd4dsGQeybLsywys9EJ6mL\twallet60\n" +
                "13G7G7b7pa22FPK9dmYrS49aWVrciUE5qLCHTyxYzDtTSwDAF3i\twallet61\n" +
                "14VtNx1rTuffmAU5rNC3tjnHwE5NdC1X7BJeJEccKJ3qpH61qjA\twallet62\n" +
                "13489PpimgxyP9q23gw7JjHdXo74FDKK13mPrRhwgXNVnDaNqWC\twallet63\n" +
                "138PMt5CUtD7QCQJMTJxs4KVbMHrCTCqpAnoLHwbqZ4nuKk8pNi\twallet64\n" +
                "14AHpobsfT9DRLffBhDsZz7jXQQbPNY84a7NwPRzaiiNA7GsFnk\twallet65\n" +
                "14pros6EfTD4UmHWR8JWft5s3AvX8xH6SBqYeMNYGTSUw7EzsEz\twallet66\n" +
                "13tv1y4LjggoNY6jptahakWmwUc53zPkv76Qbky6kVKbvGSZK9Z\twallet67\n" +
                "13VkmuG36sHXmUfCa5ziwr6Ww36um52Yw8xAG3mrjvBgHoqWSQt\twallet68\n" +
                "14UYfipQHVfsMowDBcXsA3mCuSzVVmvgnXMccUPNpVJTRL2Hrfc\twallet69\n" +
                "13VBRvERd8r2Z3RKBwmjFjVQCB4xc5vDCp9qyxb3DxFvCy5VVjo\twallet70\n" +
                "13XZqgeih2CHSEVDtUmBWAsnSH2bENjmsyNzLtsmD23UdYaXZVv\twallet71\n" +
                "14FBWvBFTCqS9jRvLJ5BtbDKbLKdKJbxQ8QBkfjae1oavtBvfQJ\twallet72\n" +
                "14AbPDM2L2XtQeXm6QgfhGwxPCnpmjbBYAda4jA9bKFe5nUD8M2\twallet73\n" +
                "13js1MrHxyqtvsPLHNqLKxhGeNoLMPhS2tRhY6zXZmUH7fMMYUj\twallet74\n" +
                "13gpBnmsqihzLVU3JVePtXAXSuCC8twJFKhX3jgN4VGc1bnKGSc\twallet75\n" +
                "12yVrTiUEPQhLep4nu95G63posBrG6zd3WFWr6DQNnkZ76gDhkm\twallet76\n" +
                "14dmZP3KmikDZDvGrnreAoMrEejY97A6kYB4WtkCEQjDT2px6pL\twallet77\n" +
                "13bEp6hTJ3AMyxo7T2UnFdfGNWZmA6k9bchoputdjoinuWrpvKt\twallet78\n" +
                "13svGTK4PVuLynqxh6SyDmkjfZFt1UGNDsg3rHYGGt3LsMaRuf6\twallet79\n" +
                "13g8SQczjBgfMGh635oJ7s7JLvucUz2QykM3jxqsw782AgPvPcf\twallet80\n" +
                "139cz4QKVnNhWdtVE2BGcuQTvSXUEtZ4S7LQvjCwkNFbnreABnJ\twallet81\n" +
                "135QzSkk79wQBKDqe7tjnyDrGXFYBdNnuB6mx6mKAfUFDvJ37HK\twallet82\n" +
                "13FcWYBM6TzRf28zBKhQcYgCqyAuGB27LjUVh2533edWYN3JYN9\twallet83\n" +
                "14UijHYq16qiQEGJ8JHUqgMNvaJ5uVH5xzoAPt71TCE9wqrZABC\twallet84\n" +
                "13ZLuXQX49mekZXiG8TBV8XyucbfveJe35zsZ7VAtRTCoRE3a4k\twallet85\n" +
                "13vDMs8VTw1d5xZdzRkS3CT7ptjNVA1uTjYQnCEyJptcMVEnEKH\twallet86\n" +
                "12z8ZjE3wQyMZj9NWovAGtMKWUhY85dY5mrHLdnTyncBNWJ9Vz3\twallet87\n" +
                "13yufZji77q63u3uqopnAMm9z8c1nnHVskevXBvb2oeX6d1gvRX\twallet88\n" +
                "14UA231f5sHkGKUPmBJ9iqGqZ8hGNSL3zpLudoBRyfNg9SGNXh5\twallet89\n" +
                "13LXBm7opXnJ421WjshUd2ZVNKo7caUCJ1Q6dWWfxhQosydmZN8\twallet90\n" +
                "13oWyEY17JtcNEwJs9ELV4MBE9FPU5oqEbpYSNnPqMVucugzozR\twallet91\n" +
                "13oLhQXnoytE6XbpwhjFgA8mzkZh4YSaBGFQJQWX1iYthH8Rx9z\twallet92\n" +
                "14QvZinQgy8CRDH7oCyrTSRWAuQFjQZekuwbme9vyL66bucYqLv\twallet93\n" +
                "14mxGLdLSEA5MHYaAK7bpeGMVcBc4C5QBZKBUbiTX1Af5DaoKKa\twallet94\n" +
                "13TNDPC7HxcUr1AaQKJQKJw2dzksVLCffjAdfe6KQxNB7vC6wTk\twallet95\n" +
                "13SQmMqVBrPchmtpz1aKmdJ21awhH6LB7YoWRHU7uWFcNLPfMMn\twallet96\n" +
                "13TScXHe9KuiEZ3yPyVBTP1YCP3WqqKe9rrCmPR8qGqzP1Vc9qK\twallet97\n" +
                "14mj5ygwjq7hgQdrs2NNS8RfqyUqaVaHh3HxvR1M9pTSCKUTTeK\twallet98\n" +
                "14WHzfhMvvxgUmRi6ZSEeUt5GEFjeXnfPyWSvLYGQHqG8YMsrxz\twallet99\n" +
                "14JGGk5J39C7ifkEizoMw1iLwz1k7cWLLx1VA6pm2AFz8TyJfXS\twallet100\n" +
                "132obzdZJ6EjCYGnrMi8NSRqWSrmUmkQ5MZhXihLU6kdBNutUyv\twallet101\n" +
                "14CJ1FbTWJNJcJJovRn57NBhVb1tAGWEpnvnPBikY85NQsBQHDN\twallet1\n" +
                "1443Y2SSQd8nG1MMaBXm8veSoufWM9mxJQvM6nLbqF1S88NpYY9\twallet2\n" +
                "14RyifEJvCR9iGN41EofdcGisrv6eVsAZvhdfUvW1L9VaMRhBe4\twallet3\n" +
                "14szw5xeY7XFRPypMjP1VAUVh8WLZJDK9SD7EfUBkCtksr7sPkw\twallet4\n" +
                "14sbtnLrndxoqFKXwQ2ZmABuJdNwYX5aiBZUSJiDr71R7x7UHbn\twallet5\n" +
                "14otUBqLwhi2zp9KokfTk44rcumv9fn7As6x3SUkBamQonpNGfr\twallet6\n" +
                "14pvYyLEseu5TaJG1vtUMuihfuz9fzyTevQgfXKrg4JdbRRJeM6\twallet7\n" +
                "14Te8h3bbsF2jg7tSSyJAskDofeyH3M33iL3FGz3FCAGT2WC56m\twallet8\n" +
                "12xWgvnuP6bWrrCbbrvTcCHDE3nHC3bcvCTF7dBiWpRsJc4pzKp\twallet9\n" +
                "14Y1CfsoCTeQLj6RKbFSpgbnXVUCYFaYUotjnwrf9QKjuGhk4MX\twallet10\n" +
                "14QXsnDSaKgLmzpqFabzFpRmxmJUuXizxYpitsAuCWeMhpr8wdD\twallet11\n" +
                "14Y8fXfLn5ZEytWvmqzoxBYiTkrnLPdiYTCWGCMiu6U6qprm77b\twallet12\n" +
                "14ah5sGTorvKbDu13VWyMWHCCQLFqYbAZBqJo9MQigUTGFv15pA\twallet13\n" +
                "14HWSKXZeyanTgZukyWos2iYED7eVcuytLftXksmJuMoyxU8Z5q\twallet14\n" +
                "14gLPQsrq5QQyTuJSvTsFrama1XLGjiNNDqWCWRJcJjNXq3KJFQ\twallet15\n" +
                "14AidaWqwckQgHd6rw9KWN2FcY9opkdiULVHDhhLLTan3mRLFWF\twallet16\n" +
                "13e6NbZbx8HXPe6sQuHYtxQwD8JwtbvcLKDoVPi7LXsQAzwqHj1\twallet17\n" +
                "14hChw4tu2vpK7fu111jpCVBxDfVSDScfpzYjAGq3UoZuBqdza9\twallet18\n" +
                "13HMDrwDTz5RazhoGVD3iRFkeUsMu1FZ3i9wy4mGiuiE5WWb2pD\twallet19\n" +
                "137qjZV8Jj2F2bGPXzQzvqzNJwmAMyKGVEM4CK6nWCw29cqRorn\twallet20\n" +
                "13LUdgi3dnvxxhdx7VT9cz4Q3xHkQQWZ5cdtszCCq2NxknvSfdF\twallet21\n" +
                "13SpgHQLaPLUG2J9CznrFXHckxGrRzuPrqXWMnKS6BYFivy9oJp\twallet22\n" +
                "13cQAvbVPB3PKsgeygvKYkgPnhYpcDndFdH1r9eDQXKzDotWv5f\twallet23\n" +
                "13KAzXRQeeU9RoFeyfjPXdALB29UYLrbgFKuUgGGS8LDhLPaL2n\twallet24\n" +
                "13TGTPhyahQZzPYopY6SRnotqMCmaiQchPghvqYHtnv5qfsdeUf\twallet25\n" +
                "14Jq31aNJsy8T1zWCDRnHCSZtzMZFtdYPyKyu3hgLZM2X8hN6jk\twallet26\n" +
                "14sGFvKTxqwjPbHRF2bnuS5AL6SVKAhvQHgercmhKemce1N1RiY\twallet27\n" +
                "14iCYbUwG42AjzLo34Qa1627wF74Wm4V8xtVnfTT8yXZ6vQiVB9\twallet28\n" +
                "14kTSopBmJfxPd7v29nk6UFzMdpx6Vc4htNYdhicjFCKxdPEu6H\twallet29\n" +
                "13WU3T2uchyMQVBA2HYV2uqgjK6z1yerHQZXDGPZ5QCMKRVUMEz\twallet30\n" +
                "13mukavZps246s9aGCZzb5HQjTs1eCZwGdEbTDwERQRXJRuVyvh\twallet31\n" +
                "14C69TzAoegYM6HrUAVXfvJhFBEFEuCZu8MnZavzWvqEzs5oUvF\twallet32\n" +
                "13EMUnzafCFbebzvL5AmXQ5g1BR7LtmEN84h67z4YFjUjV3Jcbn\twallet33\n" +
                "134KMqXPDAVvTQd18owxRAvnHfDt3RZoirEKmzvhQoQfk7A1NWX\twallet34\n" +
                "13qeVjW69twj1Q5fcWFnXz8BQkJqcPLhw1wWeSfQwgajDJsusRF\twallet35\n" +
                "12y8ggKysEaqHHcNAXYvX8hPowoqSLWr6pjnv79vVs8ozVx6AZi\twallet36\n" +
                "14LLtKFiRK5xEepbhEqyu8qLoEmS4ePww1fQSF5DSbKcPYVFk6b\twallet37\n" +
                "14XwzAeXzAfwQwLg8XhGHBbaj158afdP51CsRMrrXFA2UrBFgab\twallet38\n" +
                "13WW5NJHjN4DKm3X9MeMU14ud7TA5rKHcmFAWmDs4M5LwuZrwzq\twallet39\n" +
                "142nxVuWg4CfsdqM1NDVNxp2ojdVFZu2ieEMigqdFzXDFGtxgv1\twallet40\n" +
                "146L32xqEMU8QvFGYyJeEnqxkfBAdb51GrTcYQp6U9pnyWeJgEc\twallet41\n" +
                "13w3uGsCKsAmKYadCgEieDh1fB4Pf5qiX1se9CoTN4wsQk3Pqtk\twallet42\n" +
                "13iWwQAro3LxSLtwd3eHAFQCVacyj7LZN4ULY1J4mAyqNkdL6Fe\twallet43\n" +
                "14ep2QGgxwoJBpf1oWtuuYBoHKvh9nhNC6u4UtJ2fiAaHbvoJio\twallet44\n" +
                "13SEQgePH3jvytHJYWE67vqdzfUHysaoA7aaF1Pc76LzwKhGi1p\twallet45\n" +
                "13CT7uvD5dCajK5SukfKNMyNHkA4jYhTpjK7fuNf1MFuUHLtxxL\twallet46\n" +
                "13MfN1mSQy9qh5wsyGTqJ3n1DmLDBwEsXpaJ6RhmNk3BHNVKMub\twallet47\n" +
                "13LdXGKo9xgPf9LJh3bZ7M6hJZ7ACYDvCzwdSSCCRKKKsjut3ob\twallet48\n" +
                "14AnP6JLaK1bttKdt8iPfuMB8fD9B1jbmzztLEUmM1iVExqDy6Q\twallet49\n" +
                "14p8DPk5A6QftesW4nAS7RYKeWafznUboyhxi2FbPnqDwu85aW3\twallet50\n" +
                "13RYj1WN7fa1buhWu5g7mGZUQ9XvDwcTxDZVuifjgB8K7hdrXqS\twallet51\n" +
                "14n4s8gy6VcSynj27Wkp8jZjzuAHGKsGhQA7JMqc3qPkRt29gbV\twallet52\n" +
                "13GjP957mpAQtRCTZqr2jTaQUemNCqELm2yuFuHZGPqUSznJb8p\twallet53\n" +
                "13trKqHWFXyfTiGM9ZrFCX4ZsN1P3wpo2MdxBe7aWCj1LW2UfR7\twallet54\n" +
                "14S8sMm3cHm1NrbTrgsPKjTL1DP34rNv42XuKPQy6kKPgoNRAct\twallet55\n" +
                "13oWgZv7Bcs8xAvKHQfjEaGhY9ZReh1s1FFyuJ8rLRtAzQU1bqe\twallet56\n" +
                "13qwzeLDkwWueBisaBWuABXKYAshqMUgLyXm8cYPUWGSHriFESP\twallet57\n";
        int i = 0;
        new Deploy(startIndex, groupStartIndex).run(groupName, ports[i], deviceTableStr[i], typeIds[i], groupStr[i], walletStr, "20220411212535-100");
    }
}
