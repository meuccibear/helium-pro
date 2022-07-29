package io.renren.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import io.renren.modules.sys.dao.SourceCorpseMapper;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.SourceCorpseService;

import java.util.List;

@Service
@Slf4j
public class SourceCorpseServiceImpl implements SourceCorpseService {

    @Resource
    private SourceCorpseMapper sourceCorpseMapper;

    @Override
    public int deleteByPrimaryKey(String cityId) {
        return sourceCorpseMapper.deleteByPrimaryKey(cityId);
    }

    @Override
    public int insert(SourceCorpse record) {
        return sourceCorpseMapper.insert(record);
    }

    @Override
    public int insertSelective(SourceCorpse record) {
        return sourceCorpseMapper.insertSelective(record);
    }

    @Override
    public SourceCorpse selectByPrimaryKey(String cityId) {
        return sourceCorpseMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public int updateByPrimaryKeySelective(SourceCorpse record) {
        return sourceCorpseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SourceCorpse record) {
        return sourceCorpseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int inserOrUpdate(SourceCorpse record) {
        SourceCorpse allByCityId = sourceCorpseMapper.findAllByHex(record.getHex());
        log.info(JSON.toJSONString(allByCityId));
        if (ObjectUtils.notIsEmpty(allByCityId)) {
            return sourceCorpseMapper.updateByPrimaryKey(record);
        }
        return insertSelective(record);
    }

    @Override
    public List<String> findHex() {
        return sourceCorpseMapper.findHex();
    }

}


