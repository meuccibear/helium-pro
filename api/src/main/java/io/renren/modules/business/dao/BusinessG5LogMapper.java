package io.renren.modules.business.dao;
import java.util.Date;

import io.renren.modules.business.entity.BusinessG5Log;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BusinessG5LogMapper {
    /**
     * delete by primary key
     *
     * @param g5LogId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long g5LogId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(BusinessG5Log record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(BusinessG5Log record);

    /**
     * select by primary key
     *
     * @param g5LogId primary key
     * @return object by primary key
     */
    BusinessG5Log selectByPrimaryKey(Long g5LogId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BusinessG5Log record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BusinessG5Log record);

    int batchInsert(@Param("list") List<BusinessG5Log> list);


    List<BusinessG5Log> selectAllByIdAndTypeId(@Param("id")String id,@Param("typeIds")Integer... typeIds);


    List<BusinessG5Log> selectAllByIdAndTypeIdAndCreateTime(@Param("id")String id,@Param("createTime")Date createTime,@Param("typeIds")Integer... typeIds);

}