package io.renren.modules.business.service;

import java.util.List;
import java.util.Map;

import io.renren.modules.business.entity.Makers;
public interface MakersService{

    int deleteByPrimaryKey(Long makersId);

    int insertSelective(Makers record);

    Makers selectByPrimaryKey(Long makersId);

    int updateByPrimaryKeySelective(Makers record);

    int updateByPrimaryKey(Makers record);

    int updateBatch(List<Makers> list);

    int batchInsert(List<Makers> list);

    int insertOrUpdate(Makers record);

    int insertOrUpdateSelective(Makers record);

    String selectNameByAddress(String address);

    Map<String, String> getMakersDictionary();
}
