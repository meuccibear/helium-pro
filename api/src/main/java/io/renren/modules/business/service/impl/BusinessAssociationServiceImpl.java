package io.renren.modules.business.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.dao.BusinessAssociationDao;
import io.renren.modules.business.entity.BusinessAssociation;
import io.renren.modules.business.service.BusinessAssociationService;
@Service
public class BusinessAssociationServiceImpl implements BusinessAssociationService{

    @Resource
    private BusinessAssociationDao businessAssociationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return businessAssociationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BusinessAssociation record) {
        return businessAssociationMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessAssociation record) {
        return businessAssociationMapper.insertSelective(record);
    }

    @Override
    public BusinessAssociation selectByPrimaryKey(Long id) {
        return businessAssociationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessAssociation record) {
        return businessAssociationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessAssociation record) {
        return businessAssociationMapper.updateByPrimaryKey(record);
    }

}
