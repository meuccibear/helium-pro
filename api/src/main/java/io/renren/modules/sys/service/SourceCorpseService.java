package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.SourceCorpse;

import java.util.List;

public interface SourceCorpseService {

    int deleteByPrimaryKey(String cityId);

    int insert(SourceCorpse record);

    int insertSelective(SourceCorpse record);

    SourceCorpse selectByPrimaryKey(String cityId);

    int updateByPrimaryKeySelective(SourceCorpse record);

    int updateByPrimaryKey(SourceCorpse record);

    int inserOrUpdate(SourceCorpse record);

    List<String> findHex();


}


