///**
// * Copyright (c) 2016-2019 人人开源 All rights reserved.
// * <p>
// * https://www.renren.io
// * <p>
// * 版权所有，侵权必究！
// */
//
//package io.renren.modules.job.task;
//
//import com.alibaba.fastjson.TypeReference;
//import io.renren.common.gitUtils.BeanUtils;
//import io.renren.common.gitUtils.ObjectUtils;
//import io.renren.common.gitUtils.exception.MsgException;
//import io.renren.modules.business.service.BusinessDeviceService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 测试定时任务(演示Demo，可删除)
// * <p>
// * testTask为spring bean的名称
// *
// * @author Mark sunlightcs@gmail.com
// */
//@Component("DeviceTask")
//public class DeviceTask implements ITask {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private BusinessDeviceService businessDeviceService;
//
//    @Override
//    public void run(String params) {
//        logger.debug("HeliumTask定时任务正在执行，参数为：{}", params);
//        businessDeviceService.updateData(BeanUtils.toJavaObject(params, new TypeReference<List<String>>() {{
//        }}));
//    }
//
//}
