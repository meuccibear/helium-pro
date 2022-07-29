package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.DataHttp;

public interface DataHttpService {


    int deleteByPrimaryKey(Integer id);

    int insert(DataHttp record);

    int insertSelective(DataHttp record);

    DataHttp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataHttp record);

    int updateByPrimaryKey(DataHttp record);

    DataHttp findAllByAll(DataHttp dataHttp);

    void truncate();

}




