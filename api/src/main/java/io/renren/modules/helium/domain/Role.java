package io.renren.modules.helium.domain;

import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.modules.helium.HeliumUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName Role
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-31 09:34
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    private String type;
    private long time;
    private String role;
    private long height;
    private String hash;
    private String hotspottyId;
    private String cursorNo;
    private String msg;

    public void setAdditionalparameters(String hotspottyId, String cursorNo) {
        setHotspottyId(hotspottyId);
        setCursorNo(cursorNo);
    }

    static Map<String, String> styleMap = new HashMap<String, String>() {{
        String common = "\t\t\t\t\t\t\t\t%s\n" + StringUtils.outStr("\t|\t", "%s");
        put("gateway", "gateway" + common);
        put("challenger", "challenger" + common);
        put("reward_gateway", "Received Mining Rewards" + common);
        put("challengee", "challengee" + common);
        put("witness", "witness" + common);
    }};


    public void init() {
        String dateStr = DateUtils.asStr(4, new Date(1000 * time));
//        100,000,000
        if (styleMap.containsKey(role)) {
            msg = String.format(styleMap.get(role), dateStr, HeliumUtils.roleTransactions(this));
        } else {
            msg = String.format("%s\t|\t%s", type, role);
        }
    }
}
