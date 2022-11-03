package io.renren.modules.business.service.impl;

import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.business.service.BusinessDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.dao.BusinessLogMapper;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.business.service.BusinessLogService;
import java.util.Date;

@Service
public class BusinessLogServiceImpl implements BusinessLogService {

    @Resource
    private BusinessLogMapper businessLogMapper;

    @Autowired
    BusinessDeviceService businessDeviceService;

    @Override
    public void insertSelective(BusinessLog record) {
        record.setHearttm(new Date());
        BusinessDevice businessDeviceEntity = record.toDBDeviceEntity();
        businessLogMapper.insertSelective(record);
        businessDeviceService.updateByAddress(businessDeviceEntity);
    }

}








