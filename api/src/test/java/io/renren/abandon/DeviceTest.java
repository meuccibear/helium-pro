/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.abandon;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.business.service.BusinessDeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceTest {

    @Autowired
    BusinessDeviceService businessDeviceService;

    @Test
    public void asd(){
        //{"address":"11nYuYc88J5vq1eXoch3L4Gafig229B6qdT4gDJEmPXEiEqtSJu","groupname":"成都-程总1","id":"1","onelevelname":"程小燕","publicIp":"172.16.11.10"}
//        BusinessDeviceEntity businessDeviceEntity = new BusinessDeviceEntity();
//        businessDeviceEntity.setAddress("11nYuYc88J5vq1eXoch3L4Gafig229B6qdT4gDJEmPXEiEqtSJu");
//        businessDeviceEntity.setGroupName("成都-程总11");
//        businessDeviceEntity.setId("1");
//        businessDeviceEntity.setOneLevelName("程小燕");
//        businessDeviceEntity.setPublicIp("172.16.11.10");
//        businessDeviceService.insertOrUpdate(businessDeviceEntity);
//        DeviceThread.updateData(businessDeviceService.findAll(), 5);
//
//        try {
//            businessDeviceService.deviceDataRefresh();
//        } catch (MsgException e) {
//            e.printStackTrace();
//        }
    }

}
