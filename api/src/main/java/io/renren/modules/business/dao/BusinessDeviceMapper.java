package io.renren.modules.business.dao;

import io.renren.modules.business.entity.BusinessDevice;

import java.math.BigDecimal;
import java.util.List;

import io.renren.modules.domain.dto.DeviceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BusinessDeviceMapper {
    /**
     * delete by primary key
     *
     * @param address primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String address);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BusinessDevice record);

    int insertOrUpdate(BusinessDevice record);

    int insertOrUpdateSelective(BusinessDevice record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BusinessDevice record);

    /**
     * select by primary key
     *
     * @param address primary key
     * @return object by primary key
     */
    BusinessDevice selectByPrimaryKey(String address);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BusinessDevice record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BusinessDevice record);

    int updateBatch(List<BusinessDevice> list);

    int updateBatchSelective(@Param("list") List<BusinessDevice> list);

    int batchInsert(@Param("list") List<BusinessDevice> list);

    List<BusinessDevice> selectAllPaging(@Param("deviceDTO") DeviceDTO deviceDTO);

    List<BusinessDevice> selectFilterable(@Param("deviceDTO") DeviceDTO deviceDTO);

    String findAddressByAddress(@Param("address") String address);

    int updateByAddress(@Param("updated") BusinessDevice updated);

    List<String> findAll();

    List<Select> findSelect(@Param("deviceDTO") DeviceDTO deviceDTO, @Param("typeId") int typeId);

    String findOwnerByAddress(@Param("address") String address);

    void clear();

    List<BusinessDevice> selectAll();

    int updateHex5ByAddress(@Param("updatedHex5") String updatedHex5, @Param("addresss") List<String> addresss);

    List<BusinessDevice> selectAllByHex5(@Param("hex5s") List<String> hex5s);

    List<String> selectAddressByDepllistAndOnlineAndTotal24h(@Param("showCol") String showCol);

    int updateDepllistByAddress(@Param("updatedDepllist") Integer updatedDepllist, @Param("addresss") List<String> addresss);

    int updateTotal24hByAddress(@Param("updatedTotal24h") BigDecimal updatedTotal24h, @Param("addresss") List<String> addresss);

}
