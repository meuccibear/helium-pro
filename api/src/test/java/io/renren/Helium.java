package io.renren;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumHttpUtils;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.sys.api.HeliumApi;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName HeliumMapTest
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-15 19:53
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Helium {
    @Autowired
    HeliumApi heliumApi;


    @Autowired
    HeliumHttpUtils heliumHttpUtils;

//    @SneakyThrows
//    @Test
//    public void asd(){
//        System.out.println(JSON.toJSONString(new HeliumHttpUtils().getLocations("85419e4bfffffff", 15)));
//    }

    @Test
    public void hotspottyInfo() throws MsgException, URISyntaxException {
        List<JSONObject> jsonObjects = ExcelUtils.readFile("../data/hotspotty.txt");
        JSONObject jsonObject;
        boolean de;
//        String filePath = String.format("%s\\%d.txt", "../data/result/", System.currentTimeMillis());
        String filePath = String.format("%s\\hotspottyInfo_%d", "../data/result/", System.currentTimeMillis());
        String address;
        String ip;
        String str = "old-key1\t14WbEvba7SjLS7Ja6jMiT8UbK9MuTpSdMUeZ338wBw2Mzfy67vg\n" +
                "old-key2\t13wSARncwNdUmVkxb9Ev5Qb5fsE9Ck8wMqBSpdAJNnzd88b2DUW\n" +
                "old-key3\t138GmWgcwTrSfayHttecNKDBsdpo4ANk7nGM5k9ky4Abrm6TBB4\n" +
                "old-key4\t13fVJasHmmpNawVXSh11TaxEpme98YwTb5gZkSRgvkwHwSgWtWE\n" +
                "old-key5\t13kCnzCtuiXjhyj7R9rnfT1qcmuEJw6LHhtqPxY1VV2WGztR3M6\n" +
                "old-key6\t14Jr4kXVs56ab5Wjt9UZ4i68yi8grfgzZy39dHtns46EUgjWhjg\n" +
                "old-key7\t149pxVHEVMT93HU2BV7GsxHUtmHaLdkfJcba2pzFqFozZuDHgHt\n" +
                "old-key8\t13ezoGTEc4qW19TJrjfakaUBxjrisCULWo1XLbKAXDpYXtj8czF\n" +
                "old-key9\t141eesnERRnuY5Y5HKnUn27vJKzA4ssVSUDZCNUYgGGPx8Gp7QB\n" +
                "old-key10\t148y1tgRrcHE1833wSgcogBHoTLxVbPFvJaPPHwhNXt76cSbjCo";
        Map<String, String> ownerNo = formatOwnerNo(str);
        Device hotspotsByAddress;
        for (int i = 0; i < jsonObjects.size(); i++) {
            jsonObject = jsonObjects.get(i);
            address = jsonObject.getString("address");
            hotspotsByAddress = heliumApi.getHotspotsByAddress(address);
            if (ObjectUtils.isEmpty(hotspotsByAddress)) {
                log.info("【获取设备信息失败！】{}", address);
                continue;
            }
            de = heliumApi.denylist(address);
            double hotspotsTotal = HeliumUtils.getHotspotsTotal(2, address);
            FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, hotspotsByAddress.getName().replaceAll("-", " "), hotspotsByAddress.getOwner(), hotspotsByAddress.getStatus().getOnline(), hotspotsByAddress.getStatus().getIp(), hotspotsByAddress.getGeocode().getLong_country(), hotspotsByAddress.getGeocode().getLong_city(), hotspotsTotal), true, true);
            //自定义
//            FileUtils.writeln(filePath, StringUtils.outStr("\t", hotspotsByAddress.getAddress(), ownerNo.containsKey(hotspotsByAddress.getOwner()) ? ownerNo.get(hotspotsByAddress.getOwner()) : hotspotsByAddress.getOwner(), de), true, true);
//            FileUtils.writeln(filePath, StringUtils.outStr(",", hotspotsByAddress.getAddress(), hotspotsByAddress.getLat(), hotspotsByAddress.getLng()), true, true);
        }
    }


    /**
     * @throws
     * @title 钱包格式化
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/4/22 15:43
     */
    public Map<String, String> formatOwnerNo(String str) {
        Map<String, String> map = new HashMap<>();

        for (String s : str.split("\n")) {
            String[] split = s.split("\t");
            map.put(split[1], split[0]);
        }
        return map;
    }


    @Test
    public void group() {
        int a = 10, b = 8;
        for (int i = 1; i <= a; i++) {
            for (int i1 = 0; i1 < b; i1++) {
                System.out.println("分组" + i);
            }
        }
    }
}
