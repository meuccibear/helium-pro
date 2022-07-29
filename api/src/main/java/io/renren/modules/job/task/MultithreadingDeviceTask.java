/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import lombok.SneakyThrows;
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
@Component("MultithreadingDeviceTask")
public class MultithreadingDeviceTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BusinessDeviceService businessDeviceService;

//    @Autowired
//    private HeliumHttpUtils heliumHttpUtils;

    @SneakyThrows
    @Override
    public void run(String params) {
        logger.info("MultithreadingDeviceTask定时任务正在执行，参数为：{}", params);

        List<List<String>> lists = ObjectUtils.averageAssign(businessDeviceService.findAll(), ObjectUtils.toInt(params, 5));
        for (int i = 0; i < lists.size(); i++) {
            businessDeviceService.updateData(lists, i);
        }
//        StringUtils.writeList("-", lists.get(0).hashCode());
//        businessDeviceService.updateData(lists.get(0));
    }

}
