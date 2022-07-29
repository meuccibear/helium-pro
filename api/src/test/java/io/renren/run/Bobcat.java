package io.renren.run;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uber.h3core.H3Core;
import io.renren.Hex;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.map.NumMap;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.helium.*;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.helium.domain.Result;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
