package io.renren.run.device;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.CounterUtil;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.api.HeliumApi;
import lombok.extern.slf4j.Slf4j;
import io.renren.modules.helium.domain.Device;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: helium-pro-new
 * @ClassName NetworkDevice
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-09-20 00:21
 * @Version 1.0
 **/
@Slf4j
public class NetworkDevice {

    HeliumApi heliumApi;

    Date now = new Date();

    int index = 1;

    public NetworkDevice(HeliumApi heliumApi) {
        this.heliumApi = heliumApi;

    }

    public void run(String cursor, int index) {
        this.index = index;
        while (null != cursor) {
            cursor = request(cursor);
        }
    }


    public String request(String cursor) {
        FileUtils.writeln(getFilePath("cursor"), index + " " + cursor, true, true);

        RestBean restBean = (RestBean) new CounterUtil() {
            @Override
            public boolean check(Object execute) {
                return execute == null;
            }

            @Override
            public Object execute(Object data) throws MsgException {
                return heliumApi.getAllDevice((String) data);
            }
        }.run(cursor);

        if (null == restBean || null == restBean.getData() || restBean.getData().size() == 0) {
            FileUtils.writeln(getFilePath("请求失败"), index + " " + cursor, true, true);
            try {
                Thread.sleep(1000 * 60 * 60);
                log.info("休息了 1000 * 60 * 60 毫秒~~");
            } catch (InterruptedException e) {
                log.error("休息错误~~", e);
            }
            return cursor;

        }
        cache(restBean, cursor);
        return restBean.getCursor();
    }

    List<Device> devices = new ArrayList<>();

    String getFilePath(String fileName) {
        return String.format("F:\\tmp\\%d\\%s.txt", now.getTime(), fileName);
    }

    public boolean writeData() {
        for (Device device : devices) {
            try {
                FileUtils.writeln(getFilePath(String.valueOf(index)), JSON.toJSONString(device), true, true);
            } catch (Exception e) {
                log.error("数据写入错误~~", e);
                FileUtils.writeln(getFilePath("error"), index + " " + device.getRequestCursor(), true, true);
                return false;
            }
        }
        return true;
    }

    void cache(RestBean restBean, String requestCursor) {
        for (Device device : restBean.getData()) {
            device.setNextCursor(restBean.getCursor());
            device.setRequestCursor(requestCursor);
            this.devices.add(device);
            if (20000 < devices.size()) {
                if (writeData()) {
                    devices = new ArrayList<>();
                    index++;
                }
            }
        }
        log.info("已经缓存{}", devices.size());
    }

}
