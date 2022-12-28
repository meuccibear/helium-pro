package io.renren.modules.business.service;

import io.renren.common.utils.R;
import io.renren.modules.business.dto.G5LogDTO;
import io.renren.modules.business.entity.BusinessG5Log;import java.util.List;

public interface BusinessG5LogService {


    int deleteByPrimaryKey(Long g5LogId);

    int insert(BusinessG5Log record);

    int insertSelective(BusinessG5Log record);

    BusinessG5Log selectByPrimaryKey(Long g5LogId);

    int updateByPrimaryKeySelective(BusinessG5Log record);

    int updateByPrimaryKey(BusinessG5Log record);

    void log(G5LogDTO g5LogDTO);

    int batchInsert(List<BusinessG5Log> list);

    R getById(String id, Integer typeId);

}



