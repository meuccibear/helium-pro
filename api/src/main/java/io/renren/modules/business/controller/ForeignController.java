package io.renren.modules.business.controller;

import io.renren.common.utils.R;
import io.renren.modules.business.dto.G5LogDTO;
import io.renren.modules.business.service.BusinessG5LogService;
import io.renren.modules.sys.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("business/foreignController")
public class ForeignController extends AbstractController {

    @Autowired
    BusinessG5LogService g5LogService;

    @PostMapping("/log")
    public R log(@RequestBody G5LogDTO g5LogDTO) {
        g5LogService.log(g5LogDTO);
        return R.ok();
    }

}
