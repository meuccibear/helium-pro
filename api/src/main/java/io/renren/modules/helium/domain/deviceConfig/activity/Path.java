/**
 * Copyright 2021 bejson.com
 */
package io.renren.modules.helium.domain.deviceConfig.activity;

import io.renren.common.gitUtils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Auto-generated: 2021-11-17 10:40:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Path {

    // 见证人
    private List<Witnesses> witnesses;
    // 被挑战者
    private Receipt receipt;
    private Geocode geocode;
    private String challengee_owner;
    private double challengee_lon;
    private String challengee_location_hex;
    private String challengee_location;
    private double challengee_lat;
    // 被挑战者
    private String challengee;


    //    private boolean is_valid = false;
    private Integer validNum;


    public Integer getValidNum() {
        init();
        return validNum;
    }

    public void init() {
        if (ObjectUtils.isEmpty(witnesses)) {
            validNum = 0;
        } else {
            if (ObjectUtils.isEmpty(validNum)) {
                validNum = 0;
                for (Witnesses witnesses1 : witnesses) {
                    if (witnesses1.is_valid()) {
                        validNum++;
                    }
                }
            }
        }


    }


    public boolean type() {
        return ObjectUtils.notIsEmpty(getWitnesses());
    }

    public String toString() {

        init();
        StringBuffer result = new StringBuffer();
        result.append("\t\t\t\t[witnesses]\n");
        result.append(String.format("\t\t\t\t\t总共:%s个\t状态:%s\t失效数量:%s", getWitnesses().size(), validNum > 0 ? "失效" : "生效", getValidNum().toString() + "\n\n"));
        result.append("\t\t\t\t\tis_valid\t\t时间\t\t\t\t\t\tSNR\n");
        for (Witnesses witnesses1 : witnesses) {
            result.append(witnesses1.toString());
        }
        return result.toString();
    }
}
