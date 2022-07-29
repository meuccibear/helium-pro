/**
 * Copyright 2021 bejson.com
 */
package io.renren.modules.helium.domain.deviceConfig.activity;

import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Auto-generated: 2021-11-17 10:40:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String type;
    private LocalDateTime time;
    private String secret;
    private String request_block_hash;
    private List<Path> path;
    private String onion_key_hash;
    private long height;
    private String hash;
    private int fee;
    private String challenger_owner;
    private double challenger_lon;
    private String challenger_location;
    private double challenger_lat;
    //    挑战者
    private String challenger;

    public String toString() {

        StringBuffer result = new StringBuffer();
        result.append("\t\t[LeanData]\n");
        result.append("\t\ttype:" + type + "\n");
        System.out.println(time);
        result.append("\t\t时间:" + DateUtils.asStr(time) + "\n");
        result.append("\t\t\t[path]\n");
        if (ObjectUtils.notIsEmpty(getPath())) {
            for (Path path1 : path) {
                result.append("\t\t\t" + getChallenger() + " ---> " + path1.getChallengee() + "\n");
                if (path1.type()) {
                    result.append(path1.toString());
                }
            }
        }
//        result.append("\n\n\n\t\t\t" + JSONObject.toJSONString(this) + "\n\n\n\n");

//        String.formatKV("%s --> %s\n", DateUtils.asStr(getTime()), JSON.toJSONString(this))
        return result.toString();
    }

}
