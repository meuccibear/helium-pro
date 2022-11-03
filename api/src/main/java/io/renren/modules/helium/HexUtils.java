package io.renren.modules.helium;

import com.uber.h3core.H3Core;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.List;

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

    static {
        try {
            h3 = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取附近的同级别方块
     * @param hex
     * @param res
     * @return
     */
    public static List<String> getNearbyHex(String hex, Integer res) {
        List<String> strings = h3.kRing(null == res ? hex : h3.h3ToParentAddress(hex, res), 1);
        return strings;
    }

    public static void main(String[] args) throws IOException {
//        String hex5 = h3.h3ToParentAddress("8c180cc000001ff", 5);
//        System.out.println(hex5);
//        System.out.println(h3.h3ToCenterChild(hex5,12));
//
//        h3Core.h3ToCenterChild("85180cdbfffffff", 8);
//        {"lat":-0.002408089057290397,"lng":-6.898403577189072E-4}
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

//        String aa ="88408e2ed3fffff\n" +
//                "88408e25a1fffff\n" +
//                "88408e25e1fffff\n" +
//                "88408e2c47fffff\n" +
//                "88408e2595fffff\n" +
//                "88408e2f59fffff\n" +
//                "88408e2e2dfffff\n" +
//                "88408e2d59fffff";
//
//        for (String s : aa.split("\n")) {;
//            System.out.println(h3.h3ToParentAddress(s, 5));
//        }


//        41.992454492393556	13.916168336356302	881e81531bfffff	false

    }

}
