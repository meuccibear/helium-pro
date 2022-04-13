package io.renren.modules.helium.domain.deviceConfig.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceBean {

    private Integer key;

    private Integer id;

    private String ip;

    private BigDecimal earningsToday;

    private BigDecimal earningsYesterday;

    private Integer gap;

    private BigDecimal score;

    private String nat;

    private String hostpotId;

    private Integer temp;

    private Integer gain;

    private Integer status = 0;

    RestBean restBean;


    public DeviceBean(String hostpotId, String ip) {
        this.hostpotId = hostpotId;
        this.ip = ip;
    }

    public String toString() {
        return String.format("\n\n%s\t%s", getIp(), getHostpotId());
    }
}
