package io.renren;

import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.Gateway;
import org.junit.Test;

import java.util.*;

public class Deploy1 {

    String filderPath = "F:\\tmp\\";
    String fileName = "gateway_%s_%s.json";

    @Test
    /**
     * 构建信息
     */
    public void run() throws MsgException {

        //112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq6uuDKf
        String groupStr =
                "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq6uuDKf\t7\n" +
                        "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq7uuDKf\t7\n" +
                        "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq8uuDKf\t7\n" +
                        "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq9uuDKf\t7\n" +
                        "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq10uuDKf\t7\n" +
                        "112GKCgVBVtR7bPnefqDtM6h1vUKkW9e6D3dwUbbMYSDLq11uuDKf\t6\n";

        String deviceTableStr = "192.168.39.3\t112usB44E89M2PRiVhXpHD8GBv1UJ9V5oxqtVPMv4cGzAeervoUD\n" +
                "192.168.39.4\t11PH8vQzwoT3Ju17mUAgmEqJuAkDGN3CLnTsdob3S9rLB8Nmgak\n" +
                "192.168.39.5\t1126iQF5CtLZBp8TdLvYPxpcE56pRGKwHungZhZ853mZVGfjugeb\n" +
                "192.168.39.7\t112rvmvfaPT1VyPDjrS9duE3bpVSaQejSYvfeQLWCBzxoJKPyomT\n" +
                "192.168.39.6\t112nRiVddd95x1EXgaN2qRyeFbYu7aStuDAHsxm2vQRCDTCnFoAW\n" +
                "192.168.39.9\t11iXzUsRQCwW52B1xme28xQzPqBxzbBpYHnLEiSFnhjaFGK5rND\n" +
                "192.168.39.8\t11w2fLJjKjWFrCTHdFVwPpqeETu4JBEPUoUecw2Exz9ZefM28ds\n" +
                "192.168.39.12\t112FeBD11fBzCbd4uAqAF7xxjPG3zPgWp4bEuawjci73Tq54KyjQ\n" +
                "192.168.39.11\t112txShjftTWbjvJ2nqEwg1VpAQvqSb42rseJZSSh5rsFX4G995S\n" +
                "192.168.39.13\t11d3adxHoj4ZYznRVBtpJPCZMCvVxAhYAYTkH1GMVgVS55ixUN3\n" +
                "192.168.39.14\t1121H9YpcopdauU9qhtAAvuKu1EpDuD4rKvABnF4Nbz8YFri8rGQ\n" +
                "192.168.39.15\t11fwNqK8JdwWNd8swQUx2nS3XS4yAkafyT1SnhC7af8uctp7Dvq\n" +
                "192.168.39.16\t112eyXxEWvzg5jJgBacBWh8KTPCweCJW6Z3QytUpyqsZkaCtbVXx\n" +
                "192.168.39.17\t11Q177xBTMYzZ99xphFC48mbT8aNEePAAjnjfMVJzigQy3skh72\n" +
                "192.168.39.22\t112QvfgrpNctpZbM5U6yndaG8Nn8pVSGR9u14XUAUudc7nsBT5f3\n" +
                "192.168.39.18\t11TgSnJKzYNisj9h1EyKrcaxX7gj3J5uFN4J7QFKg7PxVhozNpR\n" +
                "192.168.39.20\t11dv6z3pZ9t9WBin8PkyrAgpQiEznrYiQS1bk6FfmwkzGdgu8tP\n" +
                "192.168.39.21\t112LXkcKVazdBYzwWCzc6snEFMi9u5bT27cUxHrs4An5tDGPezZD\n" +
                "192.168.39.23\t112EYWwAsQt1FfcWDVryisQkoQw8HwMZVJjJBF5fcPdwcYLL6nTo\n" +
                "192.168.39.25\t11ANVJQrCj6WbvLAHv3wK3jBXLJzBdyS3osNv7AhFkKMebWoe2q\n" +
                "192.168.39.24\t112uQkcCGFvpfBywqhAPAdVudWm1sDN7pheY6Bv2EREWWh2kd3oa\n" +
                "192.168.39.26\t11xZhGZujhmDRVvko8A4MyUPzLLEbSwGRtpzfeCurYTmeMMMXsj\n" +
                "192.168.39.30\t112cbjzFCsQiExGFohi4qfQ5n5TUuhmEGpwTJ2yba4ZEoTeguDj9\n" +
                "192.168.39.27\t11EsWoF4BoHrLEybM5wBgzBjr66X5WNToEpxSDJKzteyuYKgRJi\n" +
                "192.168.39.28\t11osRTC2uptpuQ2oVGX7VrMjHP7xB3qvp5oeiVpz3Nuq9kt1CXF\n" +
                "192.168.39.32\t11234hyfYVa7VbeqbRzTBRPtefo3jst2kVEhKaoqMSmJEz3pgYDP\n" +
                "192.168.39.29\t112TVkfkwcxTXcLZrVSRN6RmL5vC4UxAmsP1aLCWFjtZKwb1pMKv\n" +
                "192.168.39.31\t11cQVENdt6KRX7wQrDocuvnFipgSshMEZXzd8V6VF7fdHvMQ43z\n" +
                "192.168.39.37\t112NDaBLbuj8Vbhq3Zpv91ymDzJuYKfWqyBTUwwa7R5hXdvRN2DT\n" +
                "192.168.39.33\t11omGmgkBMm8ed6Bhde1FHE8Sj733qX4nXv8sXVGAGyo9RF6Kqb\n" +
                "192.168.39.34\t11yy5nPo5jFryypxYZvwKFcb7Ht3pigXTsHVjfMYmxoAN7WSnQo\n" +
                "192.168.39.35\t1124mrxJxhvmqjbVEaGnssBYRLN2cMKdNHWMZ1ZT7aRt4TziL1Az\n" +
                "192.168.39.36\t11PuZdNBAFNk2n4GkPq7uqgxxbaY58GLSNbWZYpzLjHKufYj2Y4\n" +
                "192.168.39.38\t11Uvg38EfJaneqXVCFiHifKmjhNA762djXJvyekYjz1EkVvEiHT\n" +
                "192.168.39.39\t11xptvbuiXR16KA7sVnwFTpRQcVn8fv3LhZaMdMehvXJnrPnLLP\n" +
                "192.168.39.41\t11zxccC1w2zwoJS1iNvyHFd7sWbSzs78Zu2b25JJWVL8CuXbi7t\n" +
                "192.168.39.42\t11AKgctc3ktxrEBZJKjmpKmyjzqjDmA85hhM3Wa826EiiAEMB5K\n" +
                "192.168.39.43\t11NqGm6dDrJwpnWchVQp7guRSZqqNc65hWezA8PktNHjgypC4Gu\n" +
                "192.168.39.44\t112g6vued74DWTWmi5pU4s6kVvUJMDnsqdSbpiq9jbNLTZKv1wEG\n" +
                "192.168.39.45\t1148LNpNyNp84rRxwMhiExjePQkHztYBr1g5in3MLBuGJ8iZUfH\n" +
                "192.168.39.46\t11W8maDsGLxoZEuXrQehbLnWdVQ5yLTCCSyo4m7cPD66mESS3yv\n";

        String walletStr = "143E9Ddd9rXughRLo43Ex2DFA4qQBtfqtBHykqH7Tvbg3wSG9pp\told-key1\n" +
                "13Hf57Wt9s4BbecZrpEM4PJt8u5RR5ft885ces4pAwk6zR41NS8\told-key3\n";

        // 山猫：1680 黑豹: 1681
//        structureInfo(groupStr, deviceTableStr, "./data/Hex.txt", 150, 27, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr,"./data/Hexs1.txt", 160, 29, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr, "./data/Hexs_shcz.txt", 416, 55, "shcz", "001616geae", 1680);
        structureInfo(toTableMap(walletStr), groupStr, deviceTableStr, 29, 4, "sz-xz", "0016d6feae", 1680);

    }


    /**
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 16:55
     */
    public void structureInfo(Map<String, String> wallet, String groupStr, String deviceTableStr, int startIndex, int groupStartIndex,
                              String groupName, String gateway_ID, int port) throws MsgException {

        List<List<String>> deviceTable = toTableList(deviceTableStr);

        List<Gateway> gateways = new ArrayList<>();
        String[] vals;
        int ipIndex = 0;
        String logPath = String.format("%s%s-%d-%s%s", filderPath, groupName, deviceTable.size(), DateUtils.asStr(3, new Date()) , ".txt");
        int deviceCount = 0;
        Gateway gateway;
        for (String group : ArrUtils.split("\n", groupStr)) {
            ++groupStartIndex;
            vals = group.split("\t");

            deviceCount += Integer.parseInt(vals[1]);
            for (int i = 0; i < Integer.parseInt(vals[1]); i++) {
                gateway = new Gateway(++startIndex,
                        vals[0],
                        deviceTable.get(ipIndex).get(0),
                        deviceTable.get(ipIndex).get(1),
                        (groupName + groupStartIndex),
                        null,
                        null);
//                        getHotspotsById(deviceTable.get(ipIndex).get(1)));
//                gateway.saveExcelFile(logPath, wallet.get(gateway.getMYDevice().getOwner().replaceAll("\t", "")));
                gateway.saveConfigFile(filderPath, gateway_ID + "000000", port);
                ipIndex++;
            }
        }

        if (deviceTable.size() != deviceCount) {
            System.out.println(StringUtils.outStr("数量不对 ", deviceTable.size() + " " + gateways.size()));
            return;
        }
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


/*
{
    "cname": "szxz2", 分组名称
    "ip": "172.16.1.8",
    "hid": "11w2fLJjKjWFrCTHdFVwPpqeETu4JBEPUoUecw2Exz9ZefM28ds", 设备地址
    "devtype": "pisces", 设备类型
    "gip": "",信号管理服务器内网ip
    "height": "1267173",高度
    "gap": 52,
    "loratm": "1970-01-01 08:00:00", 最后收到lora时间
    "witnesstm": "1970-01-01 08:00:00",最后的见证【见证别人】
    "beacontm": "1970-01-01 08:00:00", 最后beacontm时间
    "lastwitness": "",挑战者地址
    "hearttm": "2022-03-15 17:34:15",最后心跳时间
    "remark": "gap>20,no signal,"检测结果
  },


 */
