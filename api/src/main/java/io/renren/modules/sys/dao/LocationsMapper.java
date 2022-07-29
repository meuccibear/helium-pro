package io.renren.modules.sys.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import io.renren.modules.sys.entity.Locations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationsMapper {
    int deleteByPrimaryKey(String location);

    int insert(Locations record);

    int insertSelective(Locations record);

    Locations selectByPrimaryKey(String location);

    int updateByPrimaryKeySelective(Locations record);

    int updateByPrimaryKey(Locations record);

    List<String> findLocationByCityid(@Param("cityid")String cityid);

    List<String> findCityidByLongcountry(@Param("countrys")String[] countrys);

}
