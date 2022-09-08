package io.renren.modules.business.dao;

import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.domain.dto.DeviceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BusinessDeviceMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BusinessDevice record);

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
     * @param id primary key
     * @return object by primary key
     */
    BusinessDevice selectByPrimaryKey(Long id);

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

    List<BusinessDevice> selectAllPaging(@Param("deviceDTO") DeviceDTO deviceDTO);

    List<BusinessDevice> selectFilterable(@Param("deviceDTO") DeviceDTO deviceDTO);

    String findAddressByAddress(@Param("address") String address);

    int updateByAddress(@Param("updated")BusinessDevice updated);

    List<String> findAll();

    List<Select> findSelect(@Param("deviceDTO") DeviceDTO deviceDTO, @Param("typeId") int typeId);

    String findOwnerByAddress(@Param("address") String address);

    void clear();
}
