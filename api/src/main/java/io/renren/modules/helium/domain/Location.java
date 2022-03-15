package io.renren.modules.helium.domain;

import io.renren.modules.helium.GeoCoord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @program: HNTD
 * @ClassName Location
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-23 18:30
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    String hex ;
    String address ;
    List<GeoCoord> geoCoords ;
}
