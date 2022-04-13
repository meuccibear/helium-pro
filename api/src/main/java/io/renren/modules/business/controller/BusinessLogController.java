package io.renren.modules.business.controller;

import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.BusinessLogDTO;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessLog;
import io.renren.modules.business.service.BusinessLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: helium-pro-new
 * @ClassName BusinessLogController
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-24 13:59
 * @Version 1.0
 **/
@Api(value = "HotspottyApi", tags = "HotspottyApi")
@RestController
@RequestMapping("business/hotspottyLog")
public class BusinessLogController {

    @Autowired
    BusinessLogService businessLogService;

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody BusinessLogDTO businessLog) {
        businessLogService.insertSelective(BeanUtils.toJavaObject(businessLog, new TypeReference<BusinessLog>(){}));
        return R.ok();
    }

}
