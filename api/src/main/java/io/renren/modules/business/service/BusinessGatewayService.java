package io.renren.modules.business.service;

import io.renren.modules.business.entity.BusinessGateway;

import java.util.List;

public interface BusinessGatewayService {


    int deleteByPrimaryKey(String gatewayId);

    int insert(BusinessGateway record);

    int insertSelective(BusinessGateway record);

    BusinessGateway selectByPrimaryKey(String gatewayId);

    int updateByPrimaryKeySelective(BusinessGateway record);

    int updateByPrimaryKey(BusinessGateway record);

    int insertOrUpdate(BusinessGateway record);

    int insertOrUpdateSelective(BusinessGateway record);

    List<BusinessGateway> selectAll();
}





