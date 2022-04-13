/**
 * Copyright 2021 bejson.com
 */
package io.renren.modules.helium.domain.deviceConfig.activity;

import com.alibaba.fastjson.JSON;
import io.renren.modules.helium.domain.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auto-generated: 2021-11-17 10:40:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class RestBean {

    private List<Role> data;

    private String cursor;

//    public String toString() {
//        StringBuffer result = new StringBuffer();
//        Map<String, String> map = new HashMap<>();
//
//        result.append("\n\n总数：" + getData().size() + "\n");
//        for (LeanData datum : getData()) {
//            switch (datum.getType()) {
//                case "poc_receipts_v1":
//                    result.append("\t Witnessed Beacon\n");
//                    result.append(datum.toString());
//                    break;
//                default:
//                    result.append("\t " + datum.getType() + "\n");
//                    break;
//            }
//            map.put(datum.getType(), "");
//        }
//        System.out.println(JSON.toJSONString(map));
//        return result.toString();
//    }
}
