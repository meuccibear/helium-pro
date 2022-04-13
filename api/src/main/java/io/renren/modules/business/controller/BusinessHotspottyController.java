package io.renren.modules.business.controller;

import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.vue.domain.OptionBean;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businesshotspotty")
public class BusinessHotspottyController extends AbstractController {
    @Autowired
    private BusinessHotspottyService businessHotspottyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businesshotspotty:list")
    public R list(@ModelAttribute HotspottyDTO hotspottyDTO){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(Constant.isNotAdmin(getUserId())){
            hotspottyDTO.setCreateUserId(getUserId());
        }
        PageRRVO pageUtils = businessHotspottyService.getAll(hotspottyDTO);
        R r = R.ok();
        r.put("page", pageUtils);
        r.put("onlines", businessHotspottyService.findOnlines(hotspottyDTO));
        return r;
    }

    /**
     * 列表
     */
//    @RequestMapping("/onlines")
//    public R findSelect(){
//        return R.ok().put("onlines", businessHotspottyService.findSelect(getUserId()));
//    }

    /**
     * 信息
     */
    @RequestMapping("/info/{hotspottyId}")
    @RequiresPermissions("business:businesshotspotty:info")
    public R info(@PathVariable("hotspottyId") Long hotspottyId){
		BusinessHotspottyEntity businessHotspotty = businessHotspottyService.getById(hotspottyId);
        return R.ok().put("businessHotspotty", businessHotspotty);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businesshotspotty:save")
    public R save(@RequestBody BusinessHotspottyEntity businessHotspotty){
        businessHotspotty.setCreateTime(new Date());
        businessHotspotty.setCreateUserId(getUserId());

        String[] addresss = businessHotspotty.getAddress().trim().split("\n");
        BusinessHotspottyEntity businessHotspottyDB;
        for (String address : addresss) {
            if (ObjectUtils.notIsEmpty(address)) {
                businessHotspottyDB = BeanUtils.toJavaObject(businessHotspotty, new TypeReference<BusinessHotspottyEntity>(){});
                businessHotspottyDB.setAddress(address);
                businessHotspottyDB.setStatus(-1);
                businessHotspottyService.insertHotspotty(businessHotspottyDB);
            }
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businesshotspotty:update")
    public R update(@RequestBody BusinessHotspottyEntity businessHotspotty){
		businessHotspottyService.updateById(businessHotspotty);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businesshotspotty:delete")
    public R delete(@RequestBody Long[] hotspottyIds){
		businessHotspottyService.removeByIds(Arrays.asList(hotspottyIds));

        return R.ok();
    }


    /**
     * 选择设备
     */
    @GetMapping("/select")
//    @RequiresPermissions("business:businessgroup:select")
    public R select(){
        Long userId = null;
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(Constant.isNotAdmin(getUserId())){
            userId= getUserId();
        }
        //查询列表数据
        List<OptionBean> hotsPottyList = businessHotspottyService.findHotspottyIdAndNameAndOwner(userId);
        return R.ok().put("hotsPottyList", hotsPottyList);
    }

}
