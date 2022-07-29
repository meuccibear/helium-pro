package io.renren.modules.business.entity;

import java.util.Date;

import io.renren.common.gitUtils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLog {

    //    {
    //    "hid": "1125o7FRU7QpamH6VQn9bDsj2oXb4aMn6q1xUPT9KE1B3ad8QpxL",
    //    "devtype": "eda",
    //    "ip": "192.168.1.135",
    //    "disk": "5.11",
    //    "loratm": 1658981699.5076168,
    //    "witnesstm": 0,
    //    "beacontm": 1658920477.7158105,
    //    "muxtm": 0,
    //    "minerver": "unkown",
    //    "minerstat": "unkown",
    //    "ver": "1.7",
    //    "hearttm": 1658981718.9539683,
    //    "remark": ""
    //  }
    /**
     * 分组名称
     */
    private String cname;

    /**
     * ip
     */
    private String ip;

    /**
     * 设备类型
     */
    private String devtype;

    /**
     * 信号管理服务器内网ip
     */
    private String gip;

    /**
     * 高度
     */
    private String height;

    /**
     * gap
     */
    private Integer gap;

    /**
     * 最后收到lora时间
     */
    private Date loratm;

    /**
     * 最后的见证【见证别人】
     */
    private String witnesstm;

    /**
     * 最后beacontm时间
     */
    private Date beacontm;

    /**
     * 挑战者地址
     */
    private String lastwitness;

    /**
     * 最后心跳时间
     */
    private Date hearttm;

    /**
     * 检测结果
     */
    private String remark;

    private String token;

    /**
     * 设备地址
     */
    private String address;

    private Object disk;

    private String hid;

    public BusinessDeviceEntity toDBDeviceEntity() {
        BusinessDeviceEntity businessDeviceEntity = new BusinessDeviceEntity();
        setAddress(getHid());
        businessDeviceEntity.setAddress(getAddress());
        businessDeviceEntity.setDisk(getDisk());
        businessDeviceEntity.setRemark(getRemark());
        businessDeviceEntity.setCname(getCname());
        businessDeviceEntity.setIp(getIp());
        businessDeviceEntity.setDevtype(getDevtype());
        businessDeviceEntity.setGip(getGip());
        businessDeviceEntity.setHeight(getHeight());
        businessDeviceEntity.setGap(getGap());
        businessDeviceEntity.setLoratm(DateUtils.asStr(4,getLoratm()));
        businessDeviceEntity.setBeacontm(DateUtils.asStr(4,getBeacontm()));
        businessDeviceEntity.setWitnesstm(getWitnesstm());
        businessDeviceEntity.setLastwitness(getLastwitness());
        businessDeviceEntity.setHearttm(getHearttm());
        return businessDeviceEntity;
    }
}
