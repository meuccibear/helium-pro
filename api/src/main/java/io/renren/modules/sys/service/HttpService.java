package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.Http;

public interface HttpService {


    int deleteByPrimaryKey(Integer id);

    int insert(Http record);

    int insertSelective(Http record);

    Http selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Http record);

    int updateByPrimaryKey(Http record);

    Http findByAll(Http http);
}


