package io.renren.modules.sys.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import io.renren.modules.sys.entity.Http;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HttpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Http record);

    int insertSelective(Http record);

    Http selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Http record);

    int updateByPrimaryKey(Http record);

    Http findByAll(Http http);

}
