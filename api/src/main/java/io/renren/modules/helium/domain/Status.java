package io.renren.modules.helium.domain;

import io.renren.common.gitUtils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private Object listen_addrs;
    private long height;

    public Object getIp(){
        if (listen_addrs instanceof List) {
            List<String> listenAddrList = (List<String>) listen_addrs;
            String listenAddrs = null;
            if(null != listenAddrList){
                for (int i1 = listenAddrList.size() - 1; i1 >= 0; i1--) {
                    String addr = (String) listenAddrList.get(i1);
                    if (addr.indexOf("ip4") > 0) {
                        listenAddrs = addr;
                    }
                }
            }
            setListen_addrs(listenAddrs);
        }
        return getListen_addrs();
    }


    public LocalDateTime getTimestamp() {
        if (timestamp instanceof String) {
            setTimestamp(DateUtils.asLocalDateTime(DateUtils.toDate((String) timestamp)));
        }
        return (LocalDateTime) timestamp;
    }
}
