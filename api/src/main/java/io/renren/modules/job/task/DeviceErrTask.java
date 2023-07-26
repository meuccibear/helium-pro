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
import io.renren.modules.business.dao.BusinessGatewayMapper;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.business.service.MakersService;
import io.renren.modules.domain.dto.G5DeviceDTO;
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
@Component("DeviceErrTask")
@Slf4j
public class DeviceErrTask implements ITask {

    @Autowired
    BusinessGatewayMapper gatewayMapper;

    @Autowired
    private BusinessG5DeviceService businessG5DeviceService;

    @Autowired
    private BusinessDeviceService businessDeviceService;

    @Autowired
    MakersService makersService;

    @SneakyThrows
    @Override
    public void run(String params) {
        log.info("MultithreadingDeviceTask定时任务正在执行，参数为：{}", params);
        Map<String, String> makersDictionary = makersService.getMakersDictionary();

        List<List<String>> lists ;
//        = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(businessDeviceService.findErrDevices("depllist"), ObjectUtils.toInt(params, 5)), new TypeReference<List<List<String>>>() {{
//        }});
//        if (ObjectUtils.notIsEmpty(lists)) {
//            for (int i = 0; i < lists.size(); i++) {
//                if (lists.get(i).size() > 0) {
//                    businessDeviceService.updateDevicedeBlackListInfoTask(lists, i);
//                }
//            }
//        }

        lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(businessDeviceService.findErrDevices("online"), ObjectUtils.toInt(params, 5)), new TypeReference<List<List<String>>>() {{
        }});
        if (ObjectUtils.notIsEmpty(lists)) {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > 0) {
                    businessDeviceService.updateDeviceInfoTask(makersDictionary, lists, i);
                }
            }
        }

        lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(businessDeviceService.findErrDevices("total24h"), ObjectUtils.toInt(params, 5)), new TypeReference<List<List<String>>>() {{
        }});
        if (ObjectUtils.notIsEmpty(lists)) {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > 0) {
                    businessDeviceService.updateDeviceProfitInfoTask(lists, i);
                }
            }
        }

        lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(businessDeviceService.findErrDevices("group"), ObjectUtils.toInt(params, 5)), new TypeReference<List<List<String>>>() {{
        }});
        if (ObjectUtils.notIsEmpty(lists)) {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > 0) {
                    businessDeviceService.updateHeartbeatTask(lists, i);
                }
            }
        }

        lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(businessDeviceService.findErrDevices("usesig"), ObjectUtils.toInt(params, 5)), new TypeReference<List<List<String>>>() {{
        }});
        if (ObjectUtils.notIsEmpty(lists)) {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).size() > 0) {
                    businessDeviceService.updateHeartbeatTask(lists, i);
                }
            }
        }

        businessG5DeviceService.incomeTask(gatewayMapper.selectEarnings("todayEarnings"));
        businessG5DeviceService.incomeTask(gatewayMapper.selectEarnings("yesterdayEarnings"));

    }

}
