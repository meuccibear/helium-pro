package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessGroupDao;
import io.renren.modules.business.entity.*;
import io.renren.modules.business.service.AssociationService;
import io.renren.modules.business.service.BusinessGroupService;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.domain.dto.GroupDTO;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("businessGroupService")
public class BusinessGroupServiceImpl extends ServiceImpl<BusinessGroupDao, BusinessGroupEntity> implements BusinessGroupService {

    @Autowired
    AssociationService associationService;

    @Autowired
    BusinessHotspottyService businessHotspottyService;

    @Autowired
    SysUserService sysUserService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Long createUserId = (Long) params.get("createUserId");

        IPage<BusinessGroupEntity> page = this.page(
                new Query<BusinessGroupEntity>().getPage(params),
                new QueryWrapper<BusinessGroupEntity>().eq(createUserId != null, "create_user_id", createUserId)
        );

        return new PageUtils(page);
    }

    @Override
    public List<BusinessGroupEntity> findAllGroupSelect(Long createUserId){
        return baseMapper.findAllByCreateUserId(createUserId);
    }

    @Override
    public PageRRVO getAll(GroupDTO groupDTO) {
        return PageRRVO.build(groupDTO, baseMapper.findAllByCreateUserId(groupDTO), baseMapper.findAllByCreateUserIdCount(groupDTO));
    }




    @Override
    public List<OptionBean> findSysUserByCreateUserId(Long userId){
        List<SysUserEntity> sysUserEntities = sysUserService.findAllByCreateUserId(userId);
//        sysUserEntities
        List<OptionBean> optionBeans = new ArrayList<>();
        for (SysUserEntity sysUserEntity : sysUserEntities) {
            optionBeans.add(new OptionBean(sysUserEntity.getUserId(), sysUserEntity.getUsername()));
        }
        return optionBeans;
    }

    @Override
    public void saveHotspottyToGroup(GroupHotspottyDTO groupHotspottyDTO) {
        GroupHotspottyAssociation groupHotspottyAssociation = new GroupHotspottyAssociation();
        groupHotspottyAssociation.setGroupId(groupHotspottyDTO.getGroupId());

        List<GroupHotspottyAssociation> groupHotspottyAssociations = new ArrayList<>();
        for (List<Object> hotsPottyId : groupHotspottyDTO.getHotsPottyIds()) {
            System.out.println(JSON.toJSONString(hotsPottyId));
            groupHotspottyAssociations.add(new GroupHotspottyAssociation(null, groupHotspottyDTO.getGroupId(), Long.valueOf(hotsPottyId.get(1).toString())));
        }
        associationService.batchGoupHotspottyInsert(groupHotspottyDTO.getGroupId(), groupHotspottyAssociations);
    }


    @Override
    public void saveUserGroupToGroup(AuthorizedGroupUserDTO groupHotspottyDTO) {
        UserGroupAssociation userGroupAssociation = new UserGroupAssociation();
        userGroupAssociation.setUserId(groupHotspottyDTO.getUserId());

        List<UserGroupAssociation> groupHotspottyAssociations = new ArrayList<>();
        for (Long hotsPottyId : groupHotspottyDTO.getGroupIds()) {
            groupHotspottyAssociations.add(new UserGroupAssociation(null, Long.valueOf(hotsPottyId.toString()), groupHotspottyDTO.getUserId()));
        }

        associationService.batchUserGoupInsert(groupHotspottyDTO.getUserId(), groupHotspottyAssociations);
    }

    @Override
    public List<List<Object>> getHotspottyToGroup(Long groupId) {
        List<HotspottyEntity> hotspottyToGroup = businessHotspottyService.getHotspottyToGroup(groupId);
        List<List<Object>> groupHotspottySelect = new ArrayList<>();
        List<Object> cols ;
        for (HotspottyEntity hotspottyEntity : hotspottyToGroup) {
            cols = new ArrayList<>();
            cols.add(hotspottyEntity.getOwner());
            cols.add(hotspottyEntity.getHotspottyId());
            groupHotspottySelect.add(cols);
        }
        return groupHotspottySelect;
    }

    @Override
    public List<Long> getGroupToUser(Long userId) {
        return associationService.getGroupToUserId(userId);
    }

}
