/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.business.service.MakersService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component("G5DeviceInfoTask")
@Slf4j
public class G5DeviceInfoTask implements ITask {

    @Autowired
    private BusinessG5DeviceService businessG5DeviceService;


    @SneakyThrows
    @Override
    public void run(String params) {
        log.info("G5DeviceInfoTask 定时任务正在执行，参数为：{}", params);
        businessG5DeviceService.updateAddress();
    }

}
