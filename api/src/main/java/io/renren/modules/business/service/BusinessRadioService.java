package io.renren.modules.business.service;

import io.renren.modules.business.entity.BusinessRadio;
import io.renren.modules.domain.dto.G5DeviceDTO;

import java.util.List;

public interface BusinessRadioService {

    int deleteByPrimaryKey(String radioId);

    int insert(BusinessRadio record);

    int insertSelective(BusinessRadio record);

    BusinessRadio selectByPrimaryKey(String radioId);

    int updateByPrimaryKeySelective(BusinessRadio record);

    int updateByPrimaryKey(BusinessRadio record);

    int insertOrUpdate(BusinessRadio record);

    int insertOrUpdateSelective(BusinessRadio record);

    List<BusinessRadio> selectAll(G5DeviceDTO g5DeviceDTO);


    List<BusinessRadio> selectNotAddressGatewRadio();

    List<BusinessRadio> selectAllByGatewayId(String gatewayId);

    List<String> selectRadioIdByGatewayId(String gatewayId);

    int updateStatusByRadioId(Integer updatedStatus, String... ids);

    int updateAlisByRadioId(String updatedAlis, String radioId);
}



