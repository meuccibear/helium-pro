package io.renren.modules.sys.dao;

import java.util.List;

import io.renren.modules.sys.entity.SourceCorpse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SourceCorpseMapper {
    int deleteByPrimaryKey(String hex);

    int insert(SourceCorpse record);

    int insertSelective(SourceCorpse record);

    SourceCorpse selectByPrimaryKey(String hex);

    int updateByPrimaryKeySelective(SourceCorpse record);

    int updateByPrimaryKey(SourceCorpse record);

    SourceCorpse findAllByHex(@Param("hex") String hex);

    List<String> findHex();
}
