package io.renren.modules.business.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import io.renren.business.domin.RestMessage;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.utils.Constant;
import io.renren.modules.domain.dto.DeviceDTO;
import io.renren.modules.sys.controller.AbstractController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
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
    public R list(@ModelAttribute DeviceDTO deviceDTO) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (Constant.isNotAdmin(getUserId())) {
            deviceDTO.setName(getUser().getNikeName());
        }
        return businessDeviceService.getAll(deviceDTO);
    }

    /**
     * 日报
     */
//    @RequestMapping("/daily")
//    @RequiresPermissions("business:businessdevice:daily")
//    public void daily(@ModelAttribute DeviceDTO deviceDTO){
//        //如果不是超级管理员，则只查询自己创建的角色列表
//        if(Constant.isNotAdmin(getUserId())){
//            deviceDTO.setName(getUser().getNikeName());
//        }
//        deviceDTO.setModeType(1);
//        businessDeviceService.daily(deviceDTO);
//    }


    @ApiOperation(value = "下载日报", position = 1)
    @RequestMapping(value = "/downloadDaily", produces = "application/octet-stream")
//    @CrossOrigin
    @RequiresPermissions("business:businessdevice:downloadDaily")
    public void downloadDaily(HttpServletRequest request, HttpServletResponse response) {
        DeviceDTO deviceDTO = new DeviceDTO();
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (Constant.isNotAdmin(getUserId())) {
            deviceDTO.setName(getUser().getNikeName());
        }
        deviceDTO.setModeType(1);

        download("日报_" + DateUtils.asStr(3, new Date()), businessDeviceService.daily(deviceDTO), response);
    }

    private void download(String name, String content, HttpServletResponse response) {
        String fileName = name + ".txt";
        try {
            response.setContentType("text/plain;charset=UTF-8;");
//            response.addHeader("Content-Disposition", "attachment;FileName=" + fileName);
            ByteArrayOutputStream by = new ByteArrayOutputStream();
            by.write(content.getBytes());
            by.writeTo(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
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
