package io.renren.modules.business.dao;

import io.renren.modules.business.entity.BusinessLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;
@Mapper
public interface BusinessLogMapper {
    int insertSelective(BusinessLog record);
}
