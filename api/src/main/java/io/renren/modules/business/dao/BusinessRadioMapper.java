package io.renren.modules.business.dao;
import io.renren.modules.domain.dto.G5DeviceDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import io.renren.modules.business.entity.BusinessRadio;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessRadioMapper {
    /**
     * delete by primary key
     *
     * @param radioId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String radioId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BusinessRadio record);

    int insertOrUpdate(BusinessRadio record);

    int insertOrUpdateSelective(BusinessRadio record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BusinessRadio record);

    /**
     * select by primary key
     *
     * @param radioId primary key
     * @return object by primary key
     */
    BusinessRadio selectByPrimaryKey(String radioId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BusinessRadio record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BusinessRadio record);

    List<BusinessRadio> selectAll(@Param("g5DeviceDTO") G5DeviceDTO g5DeviceDTO);

    List<BusinessRadio> selectNotAddressGatewRadio();


    List<BusinessRadio> selectAllByGatewayId(@Param("gatewayId")String gatewayId);


    List<String> selectRadioIdByGatewayId(@Param("gatewayId")String gatewayId);


    int updateStatusByRadioId(@Param("updatedStatus")Integer updatedStatus,@Param("radioIds")String... radioIds);

    int updateAlisByRadioId(@Param("updatedAlis")String updatedAlis,@Param("radioId")String radioId);

}