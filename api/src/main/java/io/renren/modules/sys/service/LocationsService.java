package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.Locations;
public interface LocationsService{


    int deleteByPrimaryKey(String location);

    int insert(Locations record);

    int insertSelective(Locations record);

    Locations selectByPrimaryKey(String location);

    int updateByPrimaryKeySelective(Locations record);

    int updateByPrimaryKey(Locations record);

}
