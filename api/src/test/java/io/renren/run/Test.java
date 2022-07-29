package io.renren.run;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;

import java.util.List;

/**
 * @program: helium-pro-new
 * @ClassName Test
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-28 13:48
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws MsgException {
        List<Device> walletByAddress = HeliumUtils.getHotspotsByWalletId("13g98n81gKjt38BpuUQTMv8JtDbh6gjrdBkBYMJXsZc1YWWESz8");
        for (Device device : walletByAddress) {
            System.out.println(device.getAddress());
        }
    }
}
