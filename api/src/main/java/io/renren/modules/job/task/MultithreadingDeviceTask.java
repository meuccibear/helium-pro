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
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
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
public class MultithreadingDeviceTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BusinessDeviceService businessDeviceService;

    @SneakyThrows
    @Override
    public void run(String params) {
        logger.debug("MultithreadingDeviceTask定时任务正在执行，参数为：{}", params);

        List<List<String>> lists = ObjectUtils.averageAssign(businessDeviceService.findAll(), ObjectUtils.toInt(params, 5));
        for (int i = 0; i < lists.size(); i++) {
            StringUtils.writeList("-", lists.get(i).hashCode());
//            try {
//                Object target = SpringContextUtils.getBean("DeviceTask");
//                Method method = target.getClass().getDeclaredMethod("run", String.class);
//                method.invoke(target, JSON.toJSONString(lists.get(i)));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
            businessDeviceService.updateData(lists.get(i));
        }
    }


}
