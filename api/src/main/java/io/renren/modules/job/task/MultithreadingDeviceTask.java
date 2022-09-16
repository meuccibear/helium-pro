/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import com.google.common.collect.Lists;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.MakersService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component("MultithreadingDeviceTask")
@Slf4j
public class MultithreadingDeviceTask implements ITask {

    @Autowired
    private BusinessDeviceService businessDeviceService;

    @Autowired
    MakersService makersService;

    @SneakyThrows
    @Override
    public void run(String params) {
        log.info("MultithreadingDeviceTask定时任务正在执行，参数为：{}", params);
        Map<String, String> makersDictionary = makersService.getMakersDictionary();

        Lists.partition(new ArrayList<>(), 200);
        List<List<String>> lists = ObjectUtils.averageAssignPartition(businessDeviceService.findAll(), ObjectUtils.toInt(params, 5));
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).size() > 0){
                businessDeviceService.updateData(makersDictionary, lists, i);
            }
        }
    }

}
