package io.renren;

import com.alibaba.fastjson.JSON;
import com.uber.h3core.H3Core;
import com.uber.h3core.LengthUnit;
import com.uber.h3core.util.GeoCoord;
import io.renren.modules.helium.HexUtils;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: helium-pro-new
 * @ClassName Hex
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-05-25 00:15
 * @Version 1.0
 **/
public class Hex {
    public static H3Core H3C;

    static {
        try {
            H3C = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取方块等级
     *
     * @param hex
     * @return
     */
    public static int getResolution(String hex) {
        return H3C.h3GetResolution(hex);
    }

    /**
     * 获取小[year]圈的子级的中心方框
     *
     * @param hex
     * @param resolution 缩小圈数
     * @return
     */
    public static String getSonCenHex(String hex, int resolution) {
        return H3C.h3ToCenterChild(hex, getResolution(hex) + resolution);
    }

    /**
     * 获取附近[circle]圈的同级
     *
     * @param hex
     * @param circle
     * @return
     */
    public static List<String> kRing(String hex, int circle) {
        return H3C.kRing(hex, circle);
    }

    /**
     * 获取比坐标低1级的坐标
     *
     * @param hex
     * @return
     */
    public static List<String> getSonHexs(String hex) {
        return kRing(getSonCenHex(hex, 1), 1);
    }

    public static List<String> getSonHexs(String hex, int res) {
        int second = res - getResolution(hex);
        List<String> oldHexs = getSonHexs(hex);
        List<String> hexs;

        for (int i = 1; i < second; i++) {
            hexs = new ArrayList<>();
            for (String oldHex : oldHexs) {
                hexs.addAll(getSonHexs(oldHex));
            }
            oldHexs = hexs;
        }

        return oldHexs;
    }


    public static String h3ToParentAddress(String h3Address, int res) {
        return H3C.h3ToParentAddress(h3Address, res);
    }


    public static GeoCoord h3ToGeo(String resultHex) {
        return H3C.h3ToGeo(resultHex);
    }


    @SneakyThrows
    public static void main(String[] args) {
        // 计算中间有多少方块
//        System.out.println(H3C.h3Distance("85289aabfffffff", "85289bdbfffffff"));
//
        GeoCoord geoCoord = H3C.h3ToGeo("85289aabfffffff");
        System.out.println(JSON.toJSONString(geoCoord));
//        System.out.println(H3C.geoToH3Address(geoCoord.lat, geoCoord.lng, 5));
        System.out.println(H3C.geoToH3Address(47.11649809,  1.506263612, 8));

//        System.out.println(H3C.pointDist(H3C.h3ToGeo("85289aabfffffff"), H3C.h3ToGeo("85289aaffffffff"), LengthUnit.km));

//        StringBuffer sb = new StringBuffer();
//        String sfo = "'%s'";
//        for (String sonHex : getSonHexs("851949a7fffffff", 8)) {
//            if (sb.length() == 0) {
//                sb.append(String.format(sfo, sonHex));
//            } else {
//                sb.append(String.format("," + sfo, sonHex));
//            }
//        }
//
//        System.out.println(String.format("hex in (%s)", sb.toString()));

//        dis();
    }

    /**
     * 方块之间距离
     */
    public static void dis() {
        String str = "8544e297fffffff\n" +
                "8544e287fffffff\n" +
                "8526aa6bfffffff\n" +
                "8526aa6ffffffff\n" +
                "85446c17fffffff\n" +
                "8526c83bfffffff\n" +
                "8529124ffffffff\n" +
                "8529a1b7fffffff";

        for (String s : str.split("\n")) {
//            System.out.println(s);
            for (String s1 : str.split("\n")) {
                if (!s.equals(s1)) {
                    System.out.println(s + "\t" + H3C.pointDist(H3C.h3ToGeo(s), H3C.h3ToGeo(s1), LengthUnit.km) + "\t" + s1);
                }
            }
        }
    }


    public void h5() {
        String str = "882aa86ac7fffff\n" +
                "882aa8622bfffff\n" +
                "88266d305bfffff\n" +
                "882aa86009fffff\n" +
                "882aa86043fffff\n" +
                "882aa86223fffff\n" +
                "88446c8dbbfffff\n" +
                "8826aa6b03fffff\n" +
                "882aa86027fffff\n" +
                "882aa86045fffff\n" +
                "88266d32a5fffff\n" +
                "88266d3209fffff\n" +
                "882aa86309fffff\n" +
                "88446c0425fffff\n" +
                "88446c15e1fffff\n" +
                "88266d326bfffff\n" +
                "8826aa68d3fffff\n" +
                "882aa86acbfffff\n" +
                "882aa86351fffff\n" +
                "882aa86357fffff\n" +
                "88446c02c3fffff\n" +
                "8826aa68e1fffff\n" +
                "8826aa6b01fffff\n" +
                "8826aa6b53fffff\n" +
                "88446c0639fffff\n" +
                "882aa861cdfffff\n" +
                "88266d3643fffff\n" +
                "88266d3609fffff\n" +
                "88446c1537fffff\n" +
                "88446c153bfffff\n" +
                "88446c052bfffff\n" +
                "88446c1663fffff\n" +
                "88446c042bfffff\n" +
                "88266d32b1fffff\n" +
                "88266d3059fffff\n" +
                "88266d3207fffff\n" +
                "8826aa69bbfffff\n" +
                "8844e2875bfffff\n" +
                "88266d304bfffff\n" +
                "88266d323dfffff\n" +
                "88266d3205fffff\n" +
                "88446c14ddfffff\n" +
                "88446c1535fffff\n" +
                "8826aa6d39fffff\n" +
                "8826aa6a2dfffff\n" +
                "8829124dd5fffff\n" +
                "8844e2866bfffff\n" +
                "8844e28755fffff\n" +
                "8826aa6b29fffff\n" +
                "8826aa6dedfffff\n" +
                "8844e2946bfffff\n" +
                "8844e29465fffff\n" +
                "8844e28641fffff\n" +
                "8844e2860dfffff\n" +
                "8844e29429fffff\n" +
                "8826aa6d45fffff\n" +
                "8844e294a3fffff\n" +
                "8844e28625fffff\n" +
                "8844e29441fffff\n" +
                "8826aa683bfffff\n" +
                "8829a1b669fffff\n" +
                "8829a1b663fffff\n" +
                "8829a1b62dfffff\n" +
                "8829a1b757fffff\n" +
                "8829124dd9fffff\n" +
                "8829124dc3fffff\n" +
                "8829124cedfffff\n" +
                "8829124dcdfffff\n" +
                "8829124d19fffff\n" +
                "8829124c25fffff\n" +
                "8829124c29fffff\n" +
                "8844e28667fffff\n" +
                "8826c83a4bfffff";

        for (String s : str.split("\n")) {
            System.out.println(s + "\t" + HexUtils.h3.h3ToParentAddress(s, 5));
        }
    }
}
