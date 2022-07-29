package io.renren.modules.sys.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import io.renren.modules.sys.entity.WebsiteApi;

@Mapper
public interface WebsiteApiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteApi record);

    int insertSelective(WebsiteApi record);

    WebsiteApi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebsiteApi record);

    int updateByPrimaryKey(WebsiteApi record);

    List<WebsiteApi> findAllByType(@Param("type")Integer type);

}
