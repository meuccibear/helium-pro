/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.abandon;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.service.DynamicDataSourceTestService;
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
public class DataTest {
    @Autowired
    private BusinessDeviceService dynamicDataSourceTestService;


    @Test
    public void test() {
        Long id = 1L;
        dynamicDataSourceTestService.deviceDataRefresh(0, 600);

    }

}
