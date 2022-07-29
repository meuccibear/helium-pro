package io.renren.modules.helium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ExcelUtils;
import io.renren.common.gitUtils.exception.MsgException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: HNTD
 * @ClassName HexUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-23 18:31
 * @Version 1.0
 **/
@Slf4j
public class HexUtils {
    public static H3Core h3;
    public static Map<String, GeoCoord> hex8Offset = new HashMap<>();

    static {
        try {
            h3 = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //               883091acadfffff               883091aca1fffff
        //883091add3fffff               883091aca5fffff               883091aca7fffff
        //               883091ad99fffff               883091ad9bfffff
        String cententHexAddr = "883091aca5fffff";
        GeoCoord left = getDistanceGeoCoord("883091add3fffff", cententHexAddr);
        GeoCoord leftTop = getDistanceGeoCoord("883091acadfffff", cententHexAddr);
        GeoCoord leftLower = getDistanceGeoCoord("883091ad99fffff", cententHexAddr);
        GeoCoord right = getDistanceGeoCoord("883091aca7fffff", cententHexAddr);
        GeoCoord rightTop = getDistanceGeoCoord("883091aca1fffff", cententHexAddr);
        GeoCoord rightLower = getDistanceGeoCoord("883091ad9bfffff", cententHexAddr);
        hex8Offset.put("left", left);
        hex8Offset.put("leftLower", leftLower);
        hex8Offset.put("leftTop", leftTop);
        hex8Offset.put("right", right);
        hex8Offset.put("rightTop", rightTop);
        hex8Offset.put("rightLower", rightLower);
    }

    Map<String, CompletedRewardsBean> hexMap = new HashMap<>();

    public HexUtils() {
    }

    public HexUtils(String path) {
        importHexsFile(path);
    }


    public CompletedRewardsBean getHex(String hex) {
        return hexMap.get(hex);
    }

    /**
     * 获取Hex
     *
     * @param path
     * @return
     * @throws MsgException
     */
    public void importHexsFile(String path) {
        List<JSONObject> jsonArray = null;
        try {
            jsonArray = ExcelUtils.readFile(path);
        } catch (MsgException e) {
            System.out.println(e.getMessage());
        }
        for (JSONObject jsonObject : jsonArray) {
            System.out.println((String) jsonObject.get("hex"));
            CompletedRewardsBean completedRewardsBean = BeanUtils.mergeObjects(CompletedRewardsBean.class, jsonObject.get("json"));
            completedRewardsBean.setHex((String) jsonObject.get("hex"));
            hexMap.put((String) jsonObject.get("hex"), completedRewardsBean);
        }
    }

    /**
     * 经纬差距
     *
     * @param h3Address1
     * @param h3Address2
     * @return
     */
    public static GeoCoord getDistanceGeoCoord(String h3Address1, String h3Address2) {
        // 中心
        GeoCoord cenGeoCoord = h3.h3ToGeo(h3Address1);
        // 右边
        GeoCoord rightGeoCoord = h3.h3ToGeo(h3Address2);

        double lat = cenGeoCoord.lat - rightGeoCoord.lat;
        double lng = cenGeoCoord.lng - rightGeoCoord.lng;

        return new GeoCoord(lat, lng);
    }


    public static String offset(String h3address, String opt, int res) {
        GeoCoord cenGeoCoord = h3.h3ToGeo(h3address);
        GeoCoord optOffset = hex8Offset.get(opt);
        GeoCoord geoCoord = new GeoCoord(cenGeoCoord.lat + optOffset.lat, cenGeoCoord.lng + optOffset.lng);
        return h3.geoToH3Address(geoCoord.lat, geoCoord.lng, res);
    }

    public static List<String> getNearbyHex(String hex, Integer res) {
//        int res = h3.h3GetResolution(address);
//        if(res < 0 || res > 8){
//            throw new IllegalArgumentException(String.format("resolution %d is out of range (must be 0 < res < 8)", res));
//        }
//        log.info(null == res ? hex : h3.h3ToParentAddress(hex, res));
        List<String> strings = h3.kRing(null == res ? hex : h3.h3ToParentAddress(hex, res), 1);
        return strings;
    }


    public static void main(String[] args) throws IOException {
//        String hex5 = h3.h3ToParentAddress("8c180cc000001ff", 5);
//        System.out.println(hex5);
//        System.out.println(h3.h3ToCenterChild(hex5,12));

//        System.out.println(offset("883091364bfffff", "rightLower", 8));
//
//        h3Core.h3ToCenterChild("85180cdbfffffff", 8);
//        {"lat":-0.002408089057290397,"lng":-6.898403577189072E-4}
//        System.out.println(JSON.toJSONString(getDistanceGeoCoord( "8c180cd8c9fffff","8c180cd8c8e35ff")));
//        System.out.println(JSON.toJSONString(h3.h3ToGeo("88309c4b5dfffff")));
//        System.out.println(JSON.toJSONString(h3.geoToH3Address(30.6735023718096, 117.48017871304, 8)));
//        System.out.println(JSON.toJSONString(h3.h3ToGeo("88318b72b5fffff")));

//        H3Core h3 = H3Core.newInstance();
//
//        // 中心
//        GeoCoord cenGeoCoord = h3.h3ToGeo("85408a17fffffff");
//        // 右边
//        GeoCoord rightGeoCoord = h3.h3ToGeo("85408a13fffffff");
//
//        double lat = cenGeoCoord.lat - rightGeoCoord.lat;
//        double lng = cenGeoCoord.lng - rightGeoCoord.lng;
//        // 中心 - 右边
//        System.out.println(cenGeoCoord.lat - rightGeoCoord.lat);
//        System.out.println(cenGeoCoord.lng - rightGeoCoord.lng);
//        GeoCoord geoCoord = new GeoCoord(cenGeoCoord.lat + lat, cenGeoCoord.lng + lng);
//
        //51.568910 -9.170066
//        System.out.println(h3.geoToH3Address(51.568910, -9.170066, 12));
//        39.035612 116.722636
//        for (GeoCoord geoCoord : h3.getH3UnidirectionalEdgeBoundary("85408a13fffffff")) {
//            System.out.println(JSON.toJSONString(h3.geoToH3Address(geoCoord.lat, geoCoord.lng, 8)));
//        }
//        h3.getH3UnidirectionalEdgeBoundary()


        //周围的方块 顺序是从9点钟方向逆时针转
//        List<String> strings = h3.kRing("88309bb897fffff", 1);
//        System.out.println(JSON.toJSONString(strings));
//
//        for (String string : strings) {
//            GeoCoord geoCoord = h3.h3ToGeo(string);
//            System.out.println(geoCoord.lat + "\t" + geoCoord.lng+ "\t" +string);
//        }
//        //[["kRing中心"],[""...]]
//        List<List<String>> lists = h3.kRings("881e21b115fffff", 1);
//        System.out.println(JSON.toJSONString(lists));
//
//        System.out.println(h3.h3GetResolution("881e21b115fffff"));

        String aa ="8840b24505fffff\n" +
                "8840b24517fffff\n" +
                "8840b24503fffff\n" +
                "8840b24e65fffff\n" +
                "8840b24e05fffff\n" +
                "8840b24e41fffff\n" +
                "8840b24aabfffff\n" +
                "8840b24abdfffff\n" +
                "8840b24aebfffff\n" +
                "8840b241c3fffff\n" +
                "8840b241abfffff\n" +
                "8840b241e1fffff\n" +
                "8840b2408dfffff\n" +
                "8840b240c3fffff\n" +
                "8840b240adfffff\n" +
                "8840b211bdfffff\n";

        for (String s : aa.split("\n")) {
            System.out.println(h3.h3ToParentAddress(s, 6));
        }

    }

}
