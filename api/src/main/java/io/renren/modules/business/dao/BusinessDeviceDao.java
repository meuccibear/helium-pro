package io.renren.modules.business.dao;
import java.util.List;

import io.renren.modules.domain.dto.DeviceDTO;
import org.apache.ibatis.annotations.Param;

import io.renren.modules.business.entity.BusinessDeviceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-24 05:24:38
 */
@Mapper
public interface BusinessDeviceDao extends BaseMapper<BusinessDeviceEntity> {

    List<BusinessDeviceEntity> selectAllPaging(@Param("deviceDTO")DeviceDTO deviceDTO);

    List<BusinessDeviceEntity> selectFilterable(@Param("deviceDTO")DeviceDTO deviceDTO);

    Integer selectAllCount(@Param("deviceDTO")DeviceDTO deviceDTO);

    int insertSelective(BusinessDeviceEntity businessDeviceEntity);

    String findAddressByAddress(@Param("address")String address);

    int updateByAddress(@Param("updated")BusinessDeviceEntity updated);

    List<String> findAll();

    List<Select> findSelect(@Param("deviceDTO")DeviceDTO deviceDTO, @Param("typeId") int typeId);

    String findOwnerByAddress(@Param("address")String address);

    void clear();
}
