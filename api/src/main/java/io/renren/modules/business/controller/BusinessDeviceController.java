package io.renren.modules.business.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.fastjson.JSON;
import io.renren.business.domin.RestMessage;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.utils.Constant;
import io.renren.importData.HotspottyData;
import io.renren.importData.HotspottyDataListener;
import io.renren.modules.business.dao.Select;
import io.renren.modules.domain.dto.DeviceDTO;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.sys.controller.AbstractController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-24 05:24:38
 */
@RestController
@RequestMapping("business/businessdevice")
public class BusinessDeviceController extends AbstractController {
    @Autowired
    private BusinessDeviceService businessDeviceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businessdevice:list")
    public R list(@ModelAttribute DeviceDTO deviceDTO){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(Constant.isNotAdmin(getUserId())){
            deviceDTO.setName(getUser().getNikeName());
        }
        return businessDeviceService.getAll(deviceDTO);
    }
    //


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("business:businessdevice:info")
    public R info(@PathVariable("id") String id){
		BusinessDeviceEntity businessDevice = businessDeviceService.getById(id);

        return R.ok().put("businessDevice", businessDevice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businessdevice:save")
    public R save(@RequestBody BusinessDeviceEntity businessDevice){
		businessDeviceService.save(businessDevice);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businessdevice:update")
    public R update(@RequestBody BusinessDeviceEntity businessDevice){
		businessDeviceService.updateById(businessDevice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businessdevice:delete")
    public R delete(@RequestBody String[] ids){
		businessDeviceService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }


    @Order(value = 2)
    @ApiOperation(value = "导入数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "__File")})
    @RequestMapping(value = "/importData", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage importData(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        businessDeviceService.importData(file);

        return new RestMessage();
    }

}
