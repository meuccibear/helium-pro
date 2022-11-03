package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.DataHttp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataHttpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataHttp record);

    int insertSelective(DataHttp record);

    DataHttp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataHttp record);

    int updateByPrimaryKey(DataHttp record);

    DataHttp findAllByAll(DataHttp dataHttp);

    DataHttp updateSelective(DataHttp dataHttp);

}
