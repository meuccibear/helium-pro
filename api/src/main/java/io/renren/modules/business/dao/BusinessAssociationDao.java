package io.renren.modules.business.dao;

import io.renren.modules.business.entity.BusinessAssociation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessAssociationDao {
    int deleteByPrimaryKey(Long id);

    int insert(BusinessAssociation record);

    int insertSelective(BusinessAssociation record);

    BusinessAssociation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusinessAssociation record);

    int updateByPrimaryKey(BusinessAssociation record);
}
