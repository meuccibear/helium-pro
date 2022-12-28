package io.renren.modules.business.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.dao.BusinessGatewayMapper;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.service.BusinessGatewayService;

import java.util.List;

@Service
public class BusinessGatewayServiceImpl implements BusinessGatewayService {

    @Resource
    private BusinessGatewayMapper businessGatewayMapper;

    @Override
    public int deleteByPrimaryKey(String gatewayId) {
        return businessGatewayMapper.deleteByPrimaryKey(gatewayId);
    }

    @Override
    public int insert(BusinessGateway record) {
        return businessGatewayMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessGateway record) {
        return businessGatewayMapper.insertSelective(record);
    }

    @Override
    public BusinessGateway selectByPrimaryKey(String gatewayId) {
        return businessGatewayMapper.selectByPrimaryKey(gatewayId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessGateway record) {
        return businessGatewayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessGateway record) {
        return businessGatewayMapper.updateByPrimaryKey(record);
    }


    @Override
    public int insertOrUpdate(BusinessGateway record) {
        return businessGatewayMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(BusinessGateway record) {
        return businessGatewayMapper.insertOrUpdateSelective(record);
    }

    @Override
    public List<BusinessGateway> selectAll() {
        return businessGatewayMapper.selectAll();
    }
}





