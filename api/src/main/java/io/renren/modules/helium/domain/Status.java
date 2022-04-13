package io.renren.modules.helium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: HNTD
 * @ClassName Status
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-01-27 17:16
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Object timestamp;
    private String online;
    private List<String> listen_addrs;
    private long height;

    public String getIp(){
        String listenAddrs = null;
        if(null != listen_addrs){
            for (int i1 = listen_addrs.size() - 1; i1 >= 0; i1--) {
                String addr = (String) listen_addrs.get(i1);
                if (addr.indexOf("ip4") > 0) {
                    listenAddrs = addr;
                }
            }
        }

        return listenAddrs;
    }
}
