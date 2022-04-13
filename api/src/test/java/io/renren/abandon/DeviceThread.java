package io.renren.abandon;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import java.util.List;

public class DeviceThread implements Runnable {

    //不要使用 @Autowired
    BusinessDeviceService businessDeviceService;

    List<String> addresss;

    @Override
    public void run() {
        businessDeviceService.updateData(addresss);
        System.out.println("【addresss】" + JSON.toJSONString(addresss));

    }

    public DeviceThread(List<String> addresss) {
        businessDeviceService = GetBeanUtil.getApplicationContext().getBean(BusinessDeviceService.class);
        System.out.println(ObjectUtils.isEmpty(businessDeviceService));
        this.addresss = addresss;
    }

}
