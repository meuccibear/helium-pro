/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import io.renren.common.HeliumHttpUtils;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import io.renren.modules.business.entity.BusinessDevice;
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
@Component("DevicedeBlackListInfoTask")
@Slf4j
public class DevicedeBlackListInfoTask implements ITask {

    @Autowired
    private BusinessDeviceService businessDeviceService;

    @Autowired
    MakersService makersService;

    @SneakyThrows
    @Override
    public void run(String params) {
        log.info("MultithreadingDeviceTask定时任务正在执行，参数为：{}", params);

        HttpResultData httpResultData = new HeliumHttpUtils().send(HttpUtils.Method.GET, "https://raw.githubusercontent.com/helium/denylist/main/denylist.csv");
        List<String> deviceIds = BeanUtils.toJavaObject(httpResultData.getResult().split(",\n"), new TypeReference<List<String>>() {
        });

        List<String> dbDeviceIds = businessDeviceService.findAll();
        List<BusinessDevice> devices = new ArrayList<>();
        BusinessDevice device;
        for (String dbDeviceId : dbDeviceIds) {
            device = new BusinessDevice();
            device.setAddress(dbDeviceId);
            device.setDepllist(deviceIds.contains(dbDeviceId)?1:0);
            devices.add(device);
        }

        businessDeviceService.updateDepllist(devices);

//        if (ObjectUtils.notIsEmpty(lists)) {
//            for (int i = 0; i < lists.size(); i++) {
//                if (lists.get(i).size() > 0) {
//                    businessDeviceService.updateDevicedeBlackListInfoTask(lists, i);
//                }
//            }
//        }
    }

}
