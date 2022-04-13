package io.renren.modules.business.controller;

import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.AuthorizedGroupUserDTO;
import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.entity.GroupHotspottyDTO;
import io.renren.modules.business.service.BusinessGroupService;
import io.renren.modules.domain.dto.GroupDTO;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;


/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businessgroup")
public class BusinessGroupController extends AbstractController {
    @Autowired
    private BusinessGroupService businessGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businessgroup:list")
    public R list(@ModelAttribute GroupDTO groupDTO){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(Constant.isNotAdmin(getUserId())){
            groupDTO.setCreateUserId(getUserId());
        }
        PageRRVO page = businessGroupService.getAll(groupDTO);

        return R.ok().put("page", page);
    }



    /**
     * 列表
     */
    /*@RequestMapping("/list")
    @RequiresPermissions("business:businessgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(Constant.isNotAdmin(getUserId())){
            params.put("createUserId", getUserId());
        }
        PageUtils page = businessGroupService.queryPage(params);

        return R.ok().put("page", page);
    }*/


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    @RequiresPermissions("business:businessgroup:info")
    public R info(@PathVariable("groupId") Long groupId){
		BusinessGroupEntity businessGroup = businessGroupService.getById(groupId);

        return R.ok().put("businessGroup", businessGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businessgroup:save")
    public R save(@RequestBody BusinessGroupEntity businessGroup){
        businessGroup.setCreateUserId(getUserId());
		businessGroupService.save(businessGroup);
        return R.ok();
    }

    /**
     * 保存设备到分组
     */
    @RequestMapping("/saveHotspottyToGroup")
    @RequiresPermissions("business:businessgroup:saveHotspottyToGroup")
    public R saveHotspottyToGroup(@RequestBody GroupHotspottyDTO groupHotspottyDTO){
        businessGroupService.saveHotspottyToGroup(groupHotspottyDTO);
        return R.ok();
    }


    /**
     * 选择菜单(添加、修改菜单)
     */
//    @RequestMapping("/authorizedGropUser")
//    @RequiresPermissions("business:businessgroup:authorizedGropUser")
//    public R authorizedGropUser(@RequestBody AuthorizedGroupUserDTO businessGroup){
//        businessGroupService.authorizedGropUser(businessGroup);
//        return R.ok();
//    }

    /**
     * 保存设备到分组
     */
    @RequestMapping("/saveUserGroupToGroup")
    @RequiresPermissions("business:businessgroup:saveUserGroupToGroup")
    public R saveUserGroupToGroup(@RequestBody AuthorizedGroupUserDTO userGroupAssociation){
        businessGroupService.saveUserGroupToGroup(userGroupAssociation);
        return R.ok();
    }

    /**
     * 获取设备信息
     */
    @RequestMapping("/getHotspottyToGroup/{groupId}")
    @RequiresPermissions("business:businessgroup:getHotspottyToGroup")
    public R getHotspottyToGroup(@PathVariable("groupId") Long groupId){
        return R.ok().put("groupHotspottySelect", businessGroupService.getHotspottyToGroup(groupId));
    }


    /**
     * 获取设备信息
     */
    @RequestMapping("/getGroupToUser/{userId}")
    @RequiresPermissions("business:businessgroup:getGroupToUser")
    public R getGroupToUser(@PathVariable("userId") Long userId){
        return R.ok().put("getGroupToUser", businessGroupService.getGroupToUser(userId));
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businessgroup:update")
    public R update(@RequestBody BusinessGroupEntity businessGroup){
		businessGroupService.updateById(businessGroup);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businessgroup:delete")
    public R delete(@RequestBody Long[] groupIds){
		businessGroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }


    /**
     * 选择菜单(添加、修改菜单)
     */
    @GetMapping("/select")
//    @RequiresPermissions("business:businessgroup:select")
    public R select(){
        //查询列表数据
        List<BusinessGroupEntity> groupList = businessGroupService.findAllGroupSelect(getUserId());
        return R.ok().put("groupSelect", groupList);
    }


    /**
     * 选择菜单(添加、修改菜单)
     */
    @GetMapping("/sysUserSelect")
    @RequiresPermissions("business:businessgroup:sysUserSelect")
    public R sysUserSelect(){
        //查询列表数据
        List<OptionBean> userList = businessGroupService.findSysUserByCreateUserId(getUserId());
        return R.ok().put("userSelect", userList);
    }

}
