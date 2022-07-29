package io.renren.modules.job.task;

import io.renren.modules.sys.service.DataHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: helium-pro-new
 * @ClassName TruncateTask
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-05-09 11:38
 * @Version 1.0
 **/
@Component("TruncateTask")
public class TruncateTask implements ITask {

    @Autowired
    DataHttpService dataHttpService;

    @Override
    public void run(String params) {
        dataHttpService.truncate();
    }

}
