package io.renren.modules.business.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.dao.BusinessRadioMapper;
import io.renren.modules.business.entity.BusinessRadio;
import io.renren.modules.business.service.BusinessRadioService;

import java.util.List;

@Service
public class BusinessRadioServiceImpl implements BusinessRadioService {

    @Resource
    private BusinessRadioMapper businessRadioMapper;

    @Override
    public int deleteByPrimaryKey(String radioId) {
        return businessRadioMapper.deleteByPrimaryKey(radioId);
    }

    @Override
    public int insert(BusinessRadio record) {
        return businessRadioMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessRadio record) {
        return businessRadioMapper.insertSelective(record);
    }

    @Override
    public BusinessRadio selectByPrimaryKey(String radioId) {
        return businessRadioMapper.selectByPrimaryKey(radioId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessRadio record) {
        return businessRadioMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessRadio record) {
        return businessRadioMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertOrUpdate(BusinessRadio record) {
        return businessRadioMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(BusinessRadio record) {
        return businessRadioMapper.insertOrUpdateSelective(record);
    }

    @Override
    public List<BusinessRadio> selectAll() {
        return businessRadioMapper.selectAll();
    }

    @Override
    public List<BusinessRadio> selectNotAddressGatewRadio() {
        return businessRadioMapper.selectNotAddressGatewRadio();
    }

    @Override
    public List<BusinessRadio> selectAllByGatewayId(String gatewayId) {
        return businessRadioMapper.selectAllByGatewayId(gatewayId);
    }
    @Override
    public List<String> selectRadioIdByGatewayId(String gatewayId) {
        return businessRadioMapper.selectRadioIdByGatewayId(gatewayId);
    }

    @Override
    public int selectRadioIdByGatewayId(Integer updatedStatus, String... ids) {
        return businessRadioMapper.updateStatusByRadioId(updatedStatus, ids);
    }


    @Override
    public int updateAlisByRadioId(String updatedAlis, String radioId) {
        return businessRadioMapper.updateAlisByRadioId(updatedAlis, radioId);
    }

}



