/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.ArrUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HeliumHttpUtils;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HeliumTest {

    @Autowired
    HeliumHttpUtils heliumHttpUtils;

    @SneakyThrows
    @Test
    public void run() {
        System.out.println(JSON.toJSONString(heliumHttpUtils.getCHexsByHex("8565010ffffffff", 5)));
    }

    @Test
    /**
     * @title 显示可用hex
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/12 15:22
     * @throws
     */
    public void showAvailableHex() throws MsgException {
        String groupStr =
                "85319e07fffffff\t15\n" +
                "8531a877fffffff\t15\n" +
                "85411dc7fffffff\t15\n" +
                "85309c6bfffffff\t15\n" +
                "85408a0bfffffff\t15\n" +
                "85411887fffffff\t15\n";
        List<List<String>> groupTable = StringUtils.toTableList(groupStr);
        Map<String, List<GeoCoord>> locations;
        Map<String, List<GeoCoord>> geoMap = new HashMap<>();

        for (List<String> lines : groupTable) {
            locations = heliumHttpUtils.getLocations(lines.get(0), Integer.parseInt(lines.get(1)));
            if (ObjectUtils.notIsEmpty(locations)) {
                geoMap.putAll(locations);
            }
        }
        FileUtils.write("./geoMap.json", JSON.toJSONString(geoMap));

//        geoMap = BeanUtils.toJavaObject(FileUtils.readLine("F:\\Cache\\idea\\github\\helium\\helium-pro-new\\data\\default\\\\location.json"), new TypeReference<Map<String, List<GeoCoord>>>() {
//            });
        showGeoMap(geoMap);
    }


    void showGeoMap(Map<String, List<GeoCoord>> geoMap) {
        List<GeoCoord> value;
        for (Object o : geoMap.keySet().toArray()) {
            value = geoMap.get(o);
            for (GeoCoord geoCoord : value) {
                System.out.println(geoCoord.getLat() + "\t" + geoCoord.getLng() + "\t" + geoCoord.getCHex() + "\t" + o + "\t" + value.size());
            }
            System.out.println();
        }
    }


    @Test
    public void hotspottyInfo() throws MsgException, URISyntaxException {
        List<JSONObject> jsonObjects = ExcelUtils.readFile("./hotspotty.txt");
        JSONObject jsonObject;
        boolean de;
        String filePath = String.format("%s\\%d.txt", "./", System.currentTimeMillis());
        String address;
        String ip;
        Device hotspotsByAddress;
        for (int i = 0; i < jsonObjects.size(); i++) {
            jsonObject = jsonObjects.get(i);
            address = jsonObject.getString("address");
            de = heliumHttpUtils.denylist(address);

            hotspotsByAddress = HeliumUtils.getHotspotsByAddress(address);
            double hotspotsTotal = HeliumUtils.getHotspotsTotal(2, address);
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", ip, address, de, hotspotsByAddress.getStatus().getOnline(), hotspotsByAddress.getStatus().getIp()), true, true);
            FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, hotspotsByAddress.getName(), hotspotsByAddress.getStatus().getOnline(), hotspotsByAddress.getStatus().getIp(), hotspotsByAddress.getGeocode().getLong_country(), hotspotsByAddress.getGeocode().getLong_city(), hotspotsTotal), true, true);
//            FileUtils.writeln(filePath, StringUtils.outStr("\t",  address,  hotspotsByAddress.getGeocode().getLong_street(), hotspotsByAddress.getGeocode().getLong_city()), true, true);
        }
    }

}
