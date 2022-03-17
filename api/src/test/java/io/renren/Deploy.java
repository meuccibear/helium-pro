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
    String logPath ;
//    = filderPath + "%s-%d-" + DateUtils.asStr(3, new Date());


    @Test
    /**
     * 构建信息
     */
    public void run() throws MsgException {

        int startIndex = 1666;
        int groupStartIndex = 143;
//        String groupName = "sh-cz";
        String groupName = "hn-cz";
        // 山猫：1680 黑豹: 1681
        int port = 1680;
//        int port = 1681;

        int typeId = 1;

        String groupStr =
                "85400827fffffff\t9\n" +
                        "85319993fffffff\t9\n" +
                        "85319e17fffffff\t9\n" +
                        "8530b393fffffff\t9\n" +
                        "8530b58bfffffff\t9\n" +
                        "851f14d3fffffff\t9\n" +
                        "851f0613fffffff\t9\n" +
                        "851f061bfffffff\t9\n" +
                        "8540315bfffffff\t9\n" +
                        "854019affffffff\t9\n" +
                        "854019affffffff\t9\n" +
                        "8540e317fffffff\t9\n" +
                        "8540e313fffffff\t9\n";
        String walletStr = "13xxLEFC6akyb6GJ14fbormA9iRQzW513HyGdYLpmjTa3nzLrMB\told-key1\n" +
                "13ihVVasjxeRtL2ikNbtPn9oBGQBMkHhTgCrykDvoemKBD3g6Nt\told-key2\n" +
                "13yNZeuVE4nvWHnDo6ku3qcQDi8WFQFpfToXp36ayp5xwKfpX3M\told-key3\n" +
                "14SSvzQ8HeF3hZpPXzb99q4izVS2XdfYQoifL8devFvZaCYsNda\told-key4\n" +
                "13nfj352LTaCjX3XoVYmuU88DPwVDhvBQSQvkp1JbMbpjiNKyjL\told-key5\n";

        String deviceTableStr =
                "192.168.11.1\t112LhuMx3a5h4VU5ppKDZmHiyHDDMRoLPqAg6XiqmVxMqEDz7Ka3\n" +
                        "192.168.11.2\t11uqYZGHgmcrwxzyToWqkoma182VA4kP8YamageziS4PZj8uhzR\n" +
                        "192.168.11.3\t11iQDPxVFHVvaYCa4LUcRo3dUadn8RxhwdQSo8StpS9X3Zt1Azm\n" +
                        "192.168.11.4\t112BAa3SEYwu8JMkeQ4KwtJ1GDBNwBMiymxyipo2xQcsdqWfcoFx\n" +
                        "192.168.11.5\t119JtYAtDUFWMwLGhKyD2NXhcrurSuaqFaGud535PpEmvXgsAxL\n" +
                        "192.168.11.6\t11qNWFfgaWzMvM6BU8yKiAgTN1sXJZkzbvhhnZdoEdTZPy9ae8J\n" +
                        "192.168.11.7\t112LvJiyyuJ3NtyHufeCf9Y8f3JnYqQTC9Gxo4Eez8vFfXEQumJ9\n" +
                        "192.168.11.8\t1125fpMLY4Z97E1YbvKGnV1HunfJnKsVutwq8BDzD8Z9GWWgbtYn\n" +
                        "192.168.11.9\t112vhSBeS17iWspDQGSaUmLU2CAAmWJcrYCr6w7b4iywtyTUwQcE\n" +
                        "192.168.11.10\t112cAAmYxKs88DWaz5evcdEgEsekajqiUxvubGrKH26ZPMRvmkZ\n" +
                        "192.168.11.11\t112C1tSv1knNBouT4jR766LQ71sdsBG6QbtsESVMHPvzJLWCeKZQ\n" +
                        "192.168.11.12\t112sBgZWU8AYXXN6TETPDrcZ1L2zA3eYrjVJJrnmoD5gqd5ifQXW\n" +
                        "192.168.11.13\t11ncCCuHUxVApCSRApb21tttx6GenCpcTecF6H7pmcPJXYyMAKJ\n" +
                        "192.168.11.14\t11sqHGqoFQqQaAm4yPcnUXTWyxUJqnYQWfrDYttmeHP3VH4QGo8\n" +
                        "192.168.11.16\t11r3ZbxkbhLiBgZiZ9VzRxXHBuNyZMTaD7C5V1gTS5dqo7uTdrQ\n" +
                        "192.168.11.17\t112q1tqNnL4vjnVFaBj6x4VyQekoZ1yWZxJFpFZrXzBSQtTfiQbM\n" +
                        "192.168.11.18\t112pCaatV6Log2UZUHMtwoWGeFtPvQpr371hbxVyih4VWJbMeLYP\n" +
                        "192.168.11.19\t11NfPfxUG2QQvnu8w8FWVMspNEGqb7gABW234MZiUu9CPrYEnFa\n" +
                        "192.168.11.20\t112GtrZkZXRLpoPyg6S664fbz8zEoC3qdSvjtuiTey2tcMtcXS7Z\n" +
                        "192.168.11.21\t11zWGWf5TEkVVLP5MgNWe1koP7CUohCr1paRWEYUXckV1QAGWLb\n" +
                        "192.168.11.22\t112kgWvEQKRispTkn34YjBpHCE8Cx4sKenMouP5GktQsQKd6rhAY\n" +
                        "192.168.11.23\t112nyhLMhsXVMdSNNZCaE8mjwV8UiMqsuQUjTcRMfwE7yyGMUxQ3\n" +
                        "192.168.11.24\t11YUbBCbpbhrZc71bgUv4tCG3yCRkiY1m9NJ75p9pho9kEA7ih9\n" +
                        "192.168.11.25\t11232uVRFjormEYTpXMJNqZeSi8j8D9QFJQpe8GhcjakGAFoGkio\n";

        path += String.format("%s-%d/", groupName, deviceTableStr.split("\n").length);
        String locationPath = String.format("%s/location.json", path);
        String devicePath = String.format("%s/device.txt", path);
        logPath = path + "%s-%d-" + DateUtils.asStr(3, new Date());
        switch (typeId) {
            case 1:
                saveLocation(locationPath, groupStr);
                break;
            case 2:
                List<JSONObject> jsonArray = ExcelUtils.readTxt("ip\taddress\n" + deviceTableStr);
                Device device;
                FileUtils.writeln(devicePath, "ip\taddress\tname\towner", true, true);

                for (JSONObject jsonO : jsonArray) {
                    device = getHotspotsById((String) jsonO.get("address"));
                    FileUtils.writeln(devicePath, StringUtils.outStr("\t", (String) jsonO.get("ip"), device.getAddress(), device.getName(), device.getOwner()), true, true);
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

                    gateway.saveConfigFile(path, gateway_ID + "000000", port);
                } else {
                    gateway = new Gateway(++startIndex,
                            row.get(0),
                            " ",
                            deviceTable.get(ipIndex).getString("address"),
                            (groupName + groupStartIndex),
                            geoMap.get(row.get(0)).get(i),
                            deviceTable.get(ipIndex).getString("name"),
                            deviceTable.get(ipIndex).getString("owner")
                    );

                    gateway.saveExcelFiles(path, wallet);

                    gateway.saveConfigFile(path, gateway_ID + "000000", port);
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
