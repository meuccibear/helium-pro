package io.renren.abandon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtilsx;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.NumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.helium.domain.deviceConfig.Gateway;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
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

        int startIndex = 2907;
        int groupStartIndex = 31;

//        String groupName = "sh-cz";
//        String groupName = "cd-lz";
//        String groupName = "hn-cz";
        String groupName = "cd_lwf_s8_";

        // 山猫：1680 黑豹: 1681
        int port = 1680;
//        int port = 1681;

        int[] typeIds = {1, 2, 3};
//        int[] typeIds = {1};
//        int[] typeIds = {2};
//        int[] typeIds = {3};
//        int[] typeIds = {2, 3};

        String groupStr =
                "853199b3fffffff\t10\n" +
                        "8531b147fffffff\t10";

        String walletStr = "";

        String deviceTableStr =
                "192.168.11.22\t11229DnKMqVnR5H6Yu5JYwYR6KKuyjL3Fg7Yfnh1EEYkpfcmzC3A\n" +
                        "192.168.11.45\t11qeLpVdPMZMAQjJ2D1s5he9sVqXK71qyMy4BngVXi4zy9PTsE\n" +
                        "192.168.11.46\t115gYZW8kNCo9bDnDSq1XKdinNSMoWM63jsMC6sFdLd5fQD7NZa\n" +
                        "192.168.11.47\t112E3j1vmvHfwgu5vab4RPUdAVL9VycxFwTFgDX3jDCtqskYijxz\n" +
                        "192.168.11.48\t11qUPas6Q56999rniLPn64k7KwUUyFAV8zbuNEW16ZCNfZqpVBt\n" +
                        "192.168.11.49\t112kPMZkYi5AqjtFgfkBbbMpCJ4MUv2MHM5mGctFeSeMWYSxLd57\n" +
                        "192.168.11.50\t11YoUUDqpaqM7Y9H15aNZioXCQwAbzRi8oBzACGXhGq8S7YyB9w\n" +
                        "192.168.11.51\t11VqAtHUfvHhhmPPj79Psr8MmykYtdgVXeVMoxTkKMyZeLfGrKh\n" +
                        "192.168.11.52\t114RMN1hz6CrD4gg3wwTGnbVmvvyeagN84EzuCsshxCbaa8PpRu\n" +
                        "192.168.11.53\t112bUGCfDfai6bqybR3QwFzpGKC9Z2ELoKtE6Sfa7DTLSPNg5BnG\n" +
                        "192.168.11.54\t11Ljj9pNKqiCraEim9myC18S1uwhwjfGwE76kU48gJw42oZJ9vh\n" +
                        "192.168.11.55\t1126bAbaWByK934EmTtXPCwLHDQpsdRiXDaiwVvjq7WhdXPj4GxD\n";

        path += String.format("%s/%s-%d/", groupName, DateUtils.asStr(6, new Date()), deviceTableStr.split("\n").length);
//        path += String.format("%s/2022032217-57/", groupName);
        System.out.println(path);
        String locationPath = String.format("%s/location.json", path);
        String devicePath = String.format("%s/device.txt", path);
        String denylistPath = String.format("%s/denylist.txt", path);
        for (int typeId : typeIds) {
            switch (typeId) {
                case 1:
                    System.out.println("groupStr: " + groupStr);
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
                    this.startIndex = startIndex;
                    this.groupStartIndex = groupStartIndex;
                    structureInfo(toTableMap(walletStr), groupStr, geoMap, deviceTable, groupName, "001c16eeae", port);
                    break;
            }
        }
    }

    public Deploy(Integer startIndex, Integer groupStartIndex) {
        this.startIndex = startIndex;
        this.groupStartIndex = groupStartIndex;
    }

    public void run(String groupName,
                    Integer port,
                    String deviceTableStr,
                    Integer[] typeIds,
                    String groupStr,
                    String walletStr,String pathL) throws MsgException {

        path += ObjectUtils.isEmpty(pathL) ? String.format("%s/%s-%d/", groupName, DateUtils.asStr(3, new Date()), deviceTableStr.split("\n").length) : groupName+"/"+pathL+"/";
//        path += String.format("%s/2022032217-57/", groupName);
        System.out.println(path);
        String locationPath = String.format("%s/location.json", path);
        String devicePath = String.format("%s/device.txt", path);
        String denylistPath = String.format("%s/denylist.txt", path);
        for (int typeId : typeIds) {
            switch (typeId) {
                case 1:
                    System.out.println("groupStr: " + groupStr);
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
                        System.out.println(JSON.toJSONString(device));
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
                    System.out.println(devicePath);
                    List<JSONObject> deviceTable = ExcelUtils.readFile(devicePath);

                    Map<String, List<GeoCoord>> geoMap = BeanUtils.toJavaObject(FileUtils.readLine(locationPath), new TypeReference<Map<String, List<GeoCoord>>>() {
                    });
                    structureInfo(toTableMap(walletStr), groupStr, geoMap, deviceTable, groupName, "001c16eeae", port);
                    break;
            }
        }
    }


    Integer startIndex;
    Integer groupStartIndex;

    /**
     * @throws
     * @title
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/18 22:03
     */
    public void structureInfo(Map<String, String> wallet,
                              String groupStr,
                              Map<String, List<GeoCoord>> geoMap,
                              List<JSONObject> deviceTable,
                              String groupName, String gateway_ID, Integer port) throws MsgException {


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
        System.out.println(ipIndex + "    " + groupStartIndex);
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


//    public List<Location> structureInfos(String groupStr) throws MsgException {
//        List<List<String>> groupTable = toTableList(groupStr);
//        List<Location> locations = new ArrayList<>();
//        for (List<String> lines : groupTable) {
//            locations.add(HeliumUtils.getLocation(lines.get(0), Integer.parseInt(lines.get(1))));
//        }
//        FileUtils.write("" + System.currentTimeMillis() + ".txt", JSON.toJSONString(locations));
//        return locations;
//    }

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
        log.info("【id】 ", id);
        HttpResultData httpResultData = HttpUtilsx.get(String.format("https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com/v1/hotspots/%s", id));
        Result result = BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<Result>() {
        });
        return BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
    }


    public static void main(String[] args) throws MsgException {
        System.out.println("[] " + JSON.toJSONString(HeliumUtils.getLocations("85180cd7fffffff", 10)));
        ;
    }
}
