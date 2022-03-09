package io.renren.modules.business.controller;

import io.renren.common.gitUtils.PageRRVO;
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
//    @RequestMapping("/list")
//    @RequiresPermissions("business:businesshotspotty:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = businessHotspottyService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businesshotspotty:list")
    public R list(@ModelAttribute HotspottyDTO hotspottyDTO){
        PageRRVO pageUtils = businessHotspottyService.getAll(hotspottyDTO);
        return R.ok().put("page", pageUtils);
    }


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
		businessHotspottyService.save(businessHotspotty);
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

}
