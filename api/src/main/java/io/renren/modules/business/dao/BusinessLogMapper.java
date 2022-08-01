package io.renren.modules.business.dao;

import io.renren.modules.business.entity.BusinessLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessLogMapper {
    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BusinessLog record);
}