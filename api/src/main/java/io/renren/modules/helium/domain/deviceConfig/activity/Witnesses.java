/**
 * Copyright 2021 bejson.com
 */
package io.renren.modules.helium.domain.deviceConfig.activity;

import io.renren.common.gitUtils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Auto-generated: 2021-11-17 10:40:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Witnesses {

    private Object timestamp;
    private Double snr;
    private int signal;
    private String packet_hash;
    private String owner;
    private String location_hex;
    private String location;
    private boolean is_valid;
    //  见证者
    private String gateway;
    private double frequency;
    private String datarate;
    private int channel;


    public String toString() {
        String format = "\t\t\t\t\t%s\t\t%s\t\t%s\n";

        if (timestamp instanceof Long) {
            long time = (long) timestamp;
            long seconds = time / 1_000_000_000;
            int nanos = (int) (time % 1_000_000_000);
            LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(seconds, nanos, ZoneOffset.ofHoursMinutes(0, 0));
            timestamp = localDateTime;
            return String.format(format, is_valid(), DateUtils.asStr(localDateTime), getSnr());
        } else if (timestamp instanceof LocalDateTime) {
            return String.format(format, is_valid(), DateUtils.asStr((LocalDateTime) timestamp), getSnr());
        } else {
            return "Error:转化出错";
        }
    }
}
