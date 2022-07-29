package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.GlobalDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface GlobalDeviceMapper {
    int deleteByPrimaryKey(String address);

    int insert(GlobalDevice record);

    int insertSelective(GlobalDevice record);

    GlobalDevice selectByPrimaryKey(String address);

    int updateByPrimaryKeySelective(GlobalDevice record);

    int updateByPrimaryKey(GlobalDevice record);

    List<String> selectHex5ByLongCountry(@Param("longCountry") String longCountry);

    List<GlobalDevice> findAllByHex5(@Param("hex5") String hex5);
}
