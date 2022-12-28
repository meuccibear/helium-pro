package io.renren.modules.business.dao;
import org.apache.ibatis.annotations.Param;

import io.renren.modules.business.entity.BusinessGateway;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

@Mapper
public interface BusinessGatewayMapper {
    /**
     * delete by primary key
     *
     * @param gatewayId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String gatewayId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BusinessGateway record);

    int insertOrUpdate(BusinessGateway record);

    int insertOrUpdateSelective(BusinessGateway record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BusinessGateway record);

    /**
     * select by primary key
     *
     * @param gatewayId primary key
     * @return object by primary key
     */
    BusinessGateway selectByPrimaryKey(String gatewayId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BusinessGateway record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BusinessGateway record);

    List<BusinessGateway> selectAll();

    List<String> selectGatewayIds();

    int updateAddressByGatewayId(@Param("updatedAddress")String updatedAddress,@Param("gatewayId")String gatewayId);

    int updateAddressAndHexByGatewayId(@Param("updatedAddress")String updatedAddress,@Param("updatedHex")String updatedHex,@Param("gatewayId")String gatewayId);

}