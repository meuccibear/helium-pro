/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import io.renren.modules.business.dao.BusinessGatewayMapper;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.domain.dto.G5DeviceDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component("G5IncomeTask")
@Slf4j
public class G5IncomeTask implements ITask {

    @Autowired
    private BusinessG5DeviceService businessG5DeviceService;

    @Autowired
    BusinessGatewayMapper gatewayMapper;

    @SneakyThrows
    @Override
    public void run(String params) {
        log.info("G5DeviceInfoTask 定时任务正在执行，参数为：{}", params);
        businessG5DeviceService.incomeTask(gatewayMapper.selectAll(new G5DeviceDTO()));


    }

}
