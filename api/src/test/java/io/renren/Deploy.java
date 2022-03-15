package io.renren;

import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.business.domin.device.Device;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Location;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.Gateway;
import org.junit.Test;
import java.util.*;

public class Deploy {
    @Test
    /**
     * 构建信息
     */
    public void run() throws MsgException {

        String groupStr =
                "1128MbMnLoAXwQqabS3khGTQw3HZFqXZukkTbD1c66zYRrx2G3Sx\t4\n" +
                "112L6Bcz3Tq539m8HXaFxwm1MrMvJHJZUCsZ8GuFLarHs4wADfgm\t2\n";

        String deviceTableStr = "192.168.10.1\t11VgUAzboXENyoUJ8LM62KkSXk3y6rqoz84vvRywENTJVbWKkRa\n" +
                "192.168.10.2\t112FSPoyE2UWakSyT2ooupbmbLfmUPPXu8SnpmopE2Jzjc3G8mKV\n" +
                "192.168.10.3\t11txx4Q2rJvf9akm4Xrdm5bo7QjnW1bbrhcZmYJXkHrjyTqF9uR\n" +
                "192.168.10.4\t11k3uoT1S2twK1FUu14XkCuBkyDQeunCu5v6jeZ6zMzyE9cKFqz\n" +
                "192.168.10.5\t11Mh6U4sdH1z6y7hGxgenFArKvLuaNNq8J6i69wRCYfVKp8Tp9q\n" +
                "192.168.10.50\t1127zpFNFrrRNTaEXYE1YtTaK5ddVGEsLv2sKkR9ACMYoiKHMMYB";

        String walletStr = "13QzfEmw4RLkeq4CbaToLQZx79SCzVfhUxZdthvRK8bRf1uqczG\told-key1\n" +
                "14PS9bm18fiDBSNUtcH4tVQ1UM6WoRwpU9xSzWhNiimiQh3dw16\told-key2\n" +
                "136SEJqundQgqo6ecP8ueu4jBCwn4vmCawXryWkjvqqHkwvaLm6\told-key3\n";

        // 山猫：1680 黑豹: 1681
//        structureInfo(groupStr, deviceTableStr, "./data/Hex.txt", 150, 27, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr,"./data/Hexs1.txt", 160, 29, "hncz", "001616deae", 1680);
//        structureInfo(groupStr, deviceTableStr, "./data/Hexs_shcz.txt", 416, 55, "shcz", "001616geae", 1680);
        structureInfo(toTableMap(walletStr), groupStr, deviceTableStr,  0, 0, "boge4", "0016b6feae", 1680);

    }

    String filderPath = "F:\\Cache\\ideaProject\\HNTD\\api\\gateway\\";
    String fileName = "gateway_%s_%s.json";
    String logPath = filderPath + "%s-%d-" + DateUtils.asStr(3, new Date()) + ".txt";

    /**
     * @param groupStr
     * @param deviceTableStr
     * @param hexPath
     * @param startIndex
     * @param groupStartIndex
     * @param groupName
     * @param gateway_ID
     * @param port
     * @throws MsgException
     */
    public void structureInfo(Map<String, String> wallet, String groupStr, String deviceTableStr, int startIndex, int groupStartIndex,
                              String groupName, String gateway_ID, int port) throws MsgException {


        List<List<String>> deviceTable = toTableList(deviceTableStr);

        List<Gateway> gateways = new ArrayList<>();
        String[] vals;
        int ipIndex = 0;
        logPath = String.format(logPath, groupName, deviceTable.size());

        Location location;
        for (String group : ArrUtils.split("\n", groupStr)) {
            ++groupStartIndex;
            vals = group.split("\t");
            location = HeliumUtils.getLocation(vals[0], Integer.parseInt(vals[1]));

            for (int i = 0; i < Integer.parseInt(vals[1]); i++) {
                gateways.add(new Gateway(++startIndex,
                        vals[0],
                        deviceTable.get(ipIndex).get(0),
                        deviceTable.get(ipIndex).get(1),
                        (groupName + groupStartIndex),
                        location.getGeoCoords().get(i),
                        getHotspotsById(deviceTable.get(ipIndex).get(1))));
//                    gateways.add(new Gateway(++startIndex,
//                            vals[0],
//                            deviceTable.get(ipIndex).get(0),
//                            "",
//                            (groupName + groupStartIndex),
//                            getRandomDevice(completedRewardsBean),
//                            null));
                ipIndex++;
            }
        }

        if (deviceTable.size() != gateways.size()) {
            System.out.println(StringUtils.outStr("数量不对 ", deviceTable.size() + " " + gateways.size()));
            return;
        }
        String script = "./change_position_core.sh \t\t %s %s";
        for (Gateway gateway : gateways) {
            if (ObjectUtils.notIsEmpty(gateway.getMYDevice())) {
                FileUtils.writeln(logPath, StringUtils.outStr("\t", gateway.getIndex(), gateway.getMYDevice().getAddress(), gateway.getMYDevice().getName(), gateway.getIp(), gateway.getMYDevice().getOwner(),
                        gateway.getGrName(), gateway.getHex(), gateway.getGeoCoord().getLat(), gateway.getGeoCoord().getLng(), String.format(script, gateway.getMYDevice().getAddress(), wallet.get(gateway.getMYDevice().getOwner().replaceAll("\t","")))), true, true);
            } else {
                FileUtils.writeln(logPath, StringUtils.outStr("\t", gateway.getIndex(), gateway.getAddress(), "", gateway.getIp(), "",
                        gateway.getGrName(), gateway.getHex()), true, true);
            }
            FileUtils.write(String.format(filderPath + fileName, gateway.getGrName(), gateway.getIp().replaceAll("\\.", "_")),
                    gateway.out(gateway_ID + "000000", port));
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
