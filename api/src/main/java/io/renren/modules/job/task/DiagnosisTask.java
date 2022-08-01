/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.common.gitUtils.http.HttpUtilsx;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.BusinessLogService;
import io.renren.modules.sys.service.WebsiteApiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component("DiagnosisTask")
@Slf4j
public class DiagnosisTask implements ITask {

    @Autowired
    BusinessLogService businessLogService;

    @Autowired
    WebsiteApiService websiteApiService;

    @Autowired
    private BusinessDeviceService businessDeviceService;

    @Override
    public void run(String params) {
        log.debug("DiagnosisTask定时任务正在执行，参数为：{}", params);

        try {
            HttpResultData httpResultData = websiteApiService.send(HttpUtils.Method.GET, params, null, null);
//            HttpResultData httpResultData = HttpUtilsx.get(params);
            Object o = JSONUtils.toJson(httpResultData.getResult());
            log.info(o.getClass().toString());

            if (o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) o;
                List<String> addresss = businessDeviceService.findAll();
                BusinessLog businessLog = new BusinessLog();
                for (String address : addresss) {
                    try {
                        businessLog = BeanUtils.toJavaObject(jsonObject.get(address), new TypeReference<BusinessLog>() {{
                        }});
                        businessLogService.insertSelective(businessLog);
                    } catch (Exception e) {
                        log.debug("DiagnosisTask JSON {}{}", JSON.toJSONString(businessLog), e.toString());
                    }
                }
            } else if (o instanceof JSONArray) {
//                List<BusinessLog> businessLogs = BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<List<BusinessLog>>() {{}});
                List<BusinessLog> businessLogs = BeanUtils.toJavaObject(o, new TypeReference<List<BusinessLog>>() {{}});
                for (BusinessLog businessLog : businessLogs) {
                    try {
                        businessLogService.insertSelective(businessLog);
                    } catch (Exception e) {
                        log.debug("DiagnosisTask Array {}{}", JSON.toJSONString(businessLog), e.toString());
                    }
                }
            }

        } catch (MsgException e) {
            e.printStackTrace();
        }

    }

}
