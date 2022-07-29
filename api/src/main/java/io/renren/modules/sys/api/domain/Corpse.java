package io.renren.modules.sys.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corpse {
    String hex;

    String address;

    /**
     * 国家
     */
    private String long_country;
    /**
     * 城市
     */
    private String long_city;

    private String cityId;

    int count;

    int offlineCount;

    double bottomScanle = 1;

    int onlineCount;

    public Corpse(String hex, String address, String long_country, String long_city, String cityId) {
        this.hex = hex;
        this.address = address;
        this.long_country = long_country;
        this.long_city = long_city;
        this.cityId = cityId;
    }
}
