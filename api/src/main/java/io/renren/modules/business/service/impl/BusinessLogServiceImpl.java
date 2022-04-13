package io.renren.modules.business.service.impl;

import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.business.service.BusinessDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import io.renren.modules.business.dao.BusinessLogMapper;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.business.service.BusinessLogService;

@Service
public class BusinessLogServiceImpl implements BusinessLogService {

    @Resource
    private BusinessLogMapper businessLogMapper;

    @Autowired
    BusinessDeviceService businessDeviceService ;

    @Override
    public int insertSelective(BusinessLog record) {
        record.setHearttm(new Date());
        BusinessDeviceEntity businessDeviceEntity = record.toDBDeviceEntity();

        int i = businessLogMapper.insertSelective(record);
        businessDeviceService.updateByAddress(businessDeviceEntity);
        return i;
    }

}





