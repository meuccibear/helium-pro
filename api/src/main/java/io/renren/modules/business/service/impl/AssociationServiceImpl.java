package io.renren.modules.business.service.impl;

import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.entity.GroupHotspottyAssociation;
import io.renren.modules.business.entity.UserGroupAssociation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.dao.AssociationMapper;
import io.renren.modules.business.service.AssociationService;
import java.util.List;

@Service
public class AssociationServiceImpl implements AssociationService {

    @Resource
    private AssociationMapper associationMapper;


    @Override
    public int goupHotspottyInsert(Long groupId, Long hotspottyId) {
        GroupHotspottyAssociation records = new GroupHotspottyAssociation();
        records.setGroupId(groupId);
        records.setHotspottyId(hotspottyId);

        if (associationMapper.getGoupHotspottyCount(records) == 0) {
            return associationMapper.goupHotspottyInsert(records);
        }
        return 0;
    }

    @Override
    public int batchGoupHotspottyInsert(Long groupId, List<GroupHotspottyAssociation> records) {
        associationMapper.deleteByGroupId(groupId);
        if (ObjectUtils.notIsEmpty(records)) {
            return associationMapper.batchGoupHotspottyInsert(records);
        }
        return 0;
    }

    @Override
    public int batchUserGoupInsert(Long userId, List<UserGroupAssociation> records) {
        associationMapper.deleteUserGroupByUserId(userId);
        if (ObjectUtils.notIsEmpty(records)) {
            return associationMapper.batchUserGroupInsert(records);
        }
        return 0;
    }

    @Override
    public GroupHotspottyAssociation selectByPrimaryKey(Long id) {
        return associationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Long> getGroupToUserId(Long userId) {
        return associationMapper.findGroupIdByUserId(userId);
    }


    @Override
    public Long getUserGroupCount(Long groupId, Long userId) {
        return associationMapper.getUserGroupCount(new UserGroupAssociation(null, groupId, userId));
    }

    @Override
    public Long getGoupHotspottyCount(Long groupId, Long hotspottyId) {
        return associationMapper.getGoupHotspottyCount(new GroupHotspottyAssociation(null, groupId, hotspottyId));
    }

}
