package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.sys.dao.LocationsMapper;
import io.renren.modules.sys.entity.Locations;
import io.renren.modules.sys.service.LocationsService;
@Service
public class LocationsServiceImpl implements LocationsService{

    @Resource
    private LocationsMapper locationsMapper;

    @Override
    public int deleteByPrimaryKey(String location) {
        return locationsMapper.deleteByPrimaryKey(location);
    }

    @Override
    public int insert(Locations record) {
        return locationsMapper.insert(record);
    }

    @Override
    public int insertSelective(Locations record) {
        return locationsMapper.insertSelective(record);
    }

    @Override
    public Locations selectByPrimaryKey(String location) {
        return locationsMapper.selectByPrimaryKey(location);
    }

    @Override
    public int updateByPrimaryKeySelective(Locations record) {
        return locationsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Locations record) {
        return locationsMapper.updateByPrimaryKey(record);
    }

}
