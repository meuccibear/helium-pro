package io.renren.modules.helium;

import com.alibaba.fastjson.JSONObject;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.GeoCoord;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ExcelUtils;
import io.renren.common.gitUtils.exception.MsgException;
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

    public HexUtils() {}

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

    public void main(String[] args) throws IOException {

        System.out.println(offset("883091364bfffff", "rightLower", 8));


//        h3.h3ToGeo("88309c4adbfffff");

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
//        System.out.println(h3.geoToH3Address(geoCoord.lat, geoCoord.lng, 5));
    }

}
