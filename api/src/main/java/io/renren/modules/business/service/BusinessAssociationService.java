package io.renren.modules.business.service;

import io.renren.modules.business.entity.BusinessAssociation;
public interface BusinessAssociationService{

    public static String GROUP = "business_group";

    int deleteByPrimaryKey(Long id);

    int insert(BusinessAssociation record);

    int insertSelective(BusinessAssociation record);

    BusinessAssociation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusinessAssociation record);

    int updateByPrimaryKey(BusinessAssociation record);

}
