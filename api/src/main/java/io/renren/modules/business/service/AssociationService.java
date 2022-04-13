package io.renren.modules.business.service;

import io.renren.modules.business.entity.GroupHotspottyAssociation;
import io.renren.modules.business.entity.UserGroupAssociation;

import java.util.List;

public interface AssociationService {

    int goupHotspottyInsert(Long groupId, Long hotspottyId);

    int batchGoupHotspottyInsert(Long groupId, List<GroupHotspottyAssociation> records);

    int batchUserGoupInsert(Long groupId, List<UserGroupAssociation> records);

    GroupHotspottyAssociation selectByPrimaryKey(Long id);

    List<Long> getGroupToUserId(Long userId);

    Long getUserGroupCount(Long groupId, Long userId);

    Long getGoupHotspottyCount(Long groupId, Long hotspottyId);
}
