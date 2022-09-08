/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.BusinessLogDTO;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.modules.business.dao.BusinessDeviceDao;
import io.renren.modules.business.entity.BusinessDevice;
//import io.renren.common.HeliumHttpUtils;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {
    //    @Resource
//    private WebsiteApiMapper websiteApiMapper;
    @Resource
    HeliumApi heliumApi;
    @Resource
    BusinessDeviceDao businessDeviceDao;

//    @Autowired
//    HeliumHttpUtils heliumHttpUtils;

    @Autowired
    GlobalDeviceService globalDeviceService;

    @SneakyThrows
    @Test
    public void test() {
//        DBApi.setWebsiteApiMap(websiteApiMapper.findAllByType(3));
//        log.info(JSON.toJSONString(DBApi.sendV("getHotspotsByCities", "eXVuY2hlbmcgc2hpc2hhbnhpIHNoZW5nY2hpbmE")));

//        log.info(JSON.toJSONString(heliumApi.getHotspotsTotal(0, "112NKYCGFnhMutzB6vE8s4QNLnESvAjDo3WebWRUHakoivPuiqn6")));
//        log.info(JSON.toJSONString(heliumApi.denylist("112NKYCGFnhMutzB6vE8s4QNLnESvAjDo3WebWRUHakoivPuiqn6")));


//        Device hotspotsByAddress = heliumApi.getHotspotsByAddress("112BQSyDQSdmj6pHzXdsrbEjE2kyMT6NN5i7kYxoMfAVRKAqavgc");
//        BusinessDevice businessDeviceEntity = hotspotsByAddress.toDBDeviceEntity();
//        log.info(JSON.toJSONString(businessDeviceEntity));
//        businessDeviceDao.updateByAddress(businessDeviceEntity);

        BusinessLog businessLog = BeanUtils.toJavaObject("{\"loratm\": \"2022-08-05 11:43:06\"}", new TypeReference<BusinessLog>() {{
        }});
        System.out.println(DateUtils.asStr(4,businessLog.getLoratm()));

    }

    @SneakyThrows
    @Test
    public void test1() {
        String cursor = "";
        while (null != cursor) {
            cursor = globalDeviceService.addNetHeliumDevice(cursor);
            System.out.println(cursor);
        }
    }

    @Test
    public void asd() throws MsgException {

        BusinessLogDTO businessLogDTO = BeanUtils.toJavaObject("{\"loratm\":1659435301.8079479}", new TypeReference<BusinessLogDTO>() {{
        }});

        System.out.println(BeanUtils.toJSONObject(businessLogDTO));
//        Map<String, String> parameter = new HashMap<>();
//        parameter.put("address", "${address}");
//        parameter.put("min_time", "-30 day");
//        parameter.put("max_time", DateUtils.asStr(LocalDateTime.now(ZoneOffset.UTC), "UTC"));
//        parameter.put("bucket", "day");
//        System.out.println(JSON.toJSONString(parameter));
//        HttpResultData post = heliumHttpUtils.post();
//        System.out.println(JSON.toJSONString(post.getResult()));
    }

}
