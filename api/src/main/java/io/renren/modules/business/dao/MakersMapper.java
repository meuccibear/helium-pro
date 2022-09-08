package io.renren.modules.business.dao;
import io.renren.modules.business.dao.SelectAddressAndNameResult;

import io.renren.modules.business.entity.Makers;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MakersMapper {
    /**
     * delete by primary key
     * @param makersId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long makersId);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Makers record);

    /**
     * select by primary key
     * @param makersId primary key
     * @return object by primary key
     */
    Makers selectByPrimaryKey(Long makersId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Makers record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Makers record);

    int updateBatch(List<Makers> list);

    int batchInsert(@Param("list") List<Makers> list);

    int insertOrUpdate(Makers record);

    int insertOrUpdateSelective(Makers record);

    String selectNameByAddress(@Param("address")String address);

    List<Makers> selectAll();

}
