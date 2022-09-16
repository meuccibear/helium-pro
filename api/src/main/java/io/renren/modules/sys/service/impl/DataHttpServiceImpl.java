package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.sys.dao.DataHttpMapper;
import io.renren.modules.sys.entity.DataHttp;
import io.renren.modules.sys.service.DataHttpService;

import java.util.Date;

@Service
public class DataHttpServiceImpl implements DataHttpService {

    @Resource
    private DataHttpMapper dataHttpMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dataHttpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DataHttp record) {
        record.setCreateTime(new Date());
        return dataHttpMapper.insert(record);
    }

    @Override
    public int insertSelective(DataHttp record) {
        return dataHttpMapper.insertSelective(record);
    }

    @Override
    public DataHttp selectByPrimaryKey(Integer id) {
        return dataHttpMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DataHttp record) {
        return dataHttpMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DataHttp record) {
        return dataHttpMapper.updateByPrimaryKey(record);
    }

    @Override
    public DataHttp findAllByAll(DataHttp dataHttp) {
        return dataHttpMapper.findAllByAll(dataHttp);
    }

}




