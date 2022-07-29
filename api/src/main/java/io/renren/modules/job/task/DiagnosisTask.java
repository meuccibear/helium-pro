/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtilsx;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.business.service.BusinessLogService;
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

    @Override
    public void run(String params) {
        log.debug("DiagnosisTask定时任务正在执行，参数为：{}", params);

        try {
            HttpResultData httpResultData = HttpUtilsx.get(params);
            List<BusinessLog> businessLogs = BeanUtils.toJavaObject(httpResultData.getResult(), new TypeReference<List<BusinessLog>>(){{}});
            for (BusinessLog businessLog : businessLogs) {
                try{
                    if(ObjectUtils.notIsEmpty(businessLog.getDisk())){
                        businessLog.setDisk(Double.valueOf((String) businessLog.getDisk()));
                    }
                    businessLogService.insertSelective(businessLog);
                }catch (Exception e){
                    log.debug("DiagnosisTask{}{}", JSON.toJSONString(businessLog), e.toString());
                }
            }
        } catch (MsgException e) {
            e.printStackTrace();
        }

    }

}
