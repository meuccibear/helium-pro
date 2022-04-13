package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.AuthorizedGroupUserDTO;
import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.entity.GroupHotspottyDTO;
import io.renren.modules.domain.dto.GroupDTO;

import java.util.List;
import java.util.Map;

/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessGroupService extends IService<BusinessGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BusinessGroupEntity> findAllGroupSelect(Long createUserId);

    PageRRVO getAll(GroupDTO groupDTO);

    List<OptionBean> findSysUserByCreateUserId(Long userId);

    void saveHotspottyToGroup(GroupHotspottyDTO groupHotspottyDTO);

    void saveUserGroupToGroup(AuthorizedGroupUserDTO authorizedGroupUserDTO);

    List<List<Object>> getHotspottyToGroup(Long groupId);

    List<Long> getGroupToUser(Long userId);

}

