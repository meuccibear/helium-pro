package io.renren.modules.business.controller;

import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.business.service.BusinessG5LogService;
import io.renren.modules.domain.dto.G5DeviceDTO;
import io.renren.modules.domain.dto.G5StatDTO;
import io.renren.modules.domain.dto.GroupDTO;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-24 05:24:38
 */
@RestController
@RequestMapping("business/businessG5device")
public class BusinessG5DeviceController extends AbstractController {
    @Autowired
    private BusinessG5DeviceService g5DeviceService;

    @Autowired
    BusinessG5LogService businessG5LogService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("business:businessG5device:list")
    public R list(@ModelAttribute G5DeviceDTO g5DeviceDTO) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (Constant.isNotAdmin(getUserId())) {
            g5DeviceDTO.setName(getUser().getNikeName());
        }
        return g5DeviceService.getAll(g5DeviceDTO);
    }


    @RequestMapping("/info")
    @RequiresPermissions("business:businessG5device:info")
    public R info(@ModelAttribute G5StatDTO g5StatDTO){
        return businessG5LogService.getById(g5StatDTO.getId(), g5StatDTO.getTypeId());
    }
}
