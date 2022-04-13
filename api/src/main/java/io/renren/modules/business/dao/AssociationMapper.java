package io.renren.modules.business.dao;

import io.renren.modules.business.entity.GroupHotspottyAssociation;
import java.util.List;

import io.renren.modules.business.entity.UserGroupAssociation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AssociationMapper {

    int goupHotspottyInsert(GroupHotspottyAssociation record);

    int insertSelective(GroupHotspottyAssociation record);

    GroupHotspottyAssociation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupHotspottyAssociation record);

    int updateByPrimaryKey(GroupHotspottyAssociation record);

    int batchGoupHotspottyInsert(@Param("list") List<GroupHotspottyAssociation> list);

    int deleteByGroupId(@Param("groupId")Long groupId);

    int batchUserGroupInsert(@Param("list") List<UserGroupAssociation> list);

    int deleteUserGroupByUserId(@Param("userId")Long userId);

    List<Long> findGroupIdByUserId(@Param("userId")Long userId);

    Long getUserGroupCount(UserGroupAssociation userGroupAssociation);

    Long getGoupHotspottyCount(GroupHotspottyAssociation groupHotspottyAssociation);

}
