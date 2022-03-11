package io.renren.modules.business.controller;

import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessAnagementMachineEntity;
import io.renren.modules.business.service.BusinessAnagementMachineService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 管理机
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businessanagementmachine")
public class BusinessAnagementMachineController extends AbstractController {
    @Autowired
    private BusinessAnagementMachineService businessAnagementMachineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businessanagementmachine:list")
    public R list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }

        PageUtils page = businessAnagementMachineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mmId}")
    @RequiresPermissions("business:businessanagementmachine:info")
    public R info(@PathVariable("mmId") Long mmId){
		BusinessAnagementMachineEntity businessAnagementMachine = businessAnagementMachineService.getById(mmId);

        return R.ok().put("businessAnagementMachine", businessAnagementMachine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businessanagementmachine:save")
    public R save(@RequestBody BusinessAnagementMachineEntity businessAnagementMachine){
        businessAnagementMachine.setCreateUserId(getUserId());
		businessAnagementMachineService.save(businessAnagementMachine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businessanagementmachine:update")
    public R update(@RequestBody BusinessAnagementMachineEntity businessAnagementMachine){
		businessAnagementMachineService.updateById(businessAnagementMachine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businessanagementmachine:delete")
    public R delete(@RequestBody Long[] mmIds){
		businessAnagementMachineService.removeByIds(Arrays.asList(mmIds));

        return R.ok();
    }

}
