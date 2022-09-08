package io.renren.run;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.sys.api.HeliumApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: helium-pro-new
 * @ClassName HeliumMapTest
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-15 19:53
 * @Version 1.0
 **/
@Slf4j
@Component
public class Bobcat {
    @Autowired
    HeliumApi heliumApi;

    @Async("taskExecutor")
    public void re(String s, String filePath) throws MsgException {
        String pubkey = "null";
        try {
            JSONObject jsonObject = heliumApi.getMinerJson(s);
            pubkey = JSONUtils.jsGetData(jsonObject, "pubkey").toString();
        } catch (Exception e) {
            e.printStackTrace();
            pubkey = null;
        }
        FileUtils.writeln(filePath, StringUtils.outStr("\t", s, pubkey),
                true, true);
    }
}
