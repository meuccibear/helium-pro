package io.renren.modules.helium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: helium-pro-test
 * @ClassName GeoCoord
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-15 08:33
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoCoord {
    public String cHex;
    public double lat;
    public double lng;

    public static GeoCoord build(String resultHex, com.uber.h3core.util.GeoCoord h3ToGeo) {
        return new GeoCoord(resultHex, h3ToGeo.lat, h3ToGeo.lng);
    }
}
