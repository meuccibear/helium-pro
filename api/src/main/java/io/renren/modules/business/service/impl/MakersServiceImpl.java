package io.renren.modules.business.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import io.renren.modules.business.dao.MakersMapper;
import io.renren.modules.business.entity.Makers;
import io.renren.modules.business.service.MakersService;
@Service
public class MakersServiceImpl implements MakersService{

    @Resource
    private MakersMapper makersMapper;

    @Override
    public int deleteByPrimaryKey(Long makersId) {
        return makersMapper.deleteByPrimaryKey(makersId);
    }

    @Override
    public int insertSelective(Makers record) {
        return makersMapper.insertSelective(record);
    }

    @Override
    public Makers selectByPrimaryKey(Long makersId) {
        return makersMapper.selectByPrimaryKey(makersId);
    }

    @Override
    public int updateByPrimaryKeySelective(Makers record) {
        return makersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Makers record) {
        return makersMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Makers> list) {
        return makersMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Makers> list) {
        return makersMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(Makers record) {
        return makersMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Makers record) {
        return makersMapper.insertOrUpdateSelective(record);
    }

    @Override
    public String selectNameByAddress(String address) {
        return makersMapper.selectNameByAddress(address);
    }

}
