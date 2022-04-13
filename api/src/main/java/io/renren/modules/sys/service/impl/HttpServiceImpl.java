package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.sys.entity.Http;
import io.renren.modules.sys.dao.HttpMapper;
import io.renren.modules.sys.service.HttpService;

import java.util.List;

@Service
public class HttpServiceImpl implements HttpService {

    @Resource
    private HttpMapper httpMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return httpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Http record) {
        return httpMapper.insert(record);
    }

    @Override
    public int insertSelective(Http record) {
        return httpMapper.insertSelective(record);
    }

    @Override
    public Http selectByPrimaryKey(Integer id) {
        return httpMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Http record) {
        return httpMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Http record) {
        return httpMapper.updateByPrimaryKey(record);
    }

    @Override
    public Http findByAll(Http http){
        return httpMapper.findByAll(http);
    }

}


