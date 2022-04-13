package io.renren;

import lombok.Data;

@Data
public class DeviceInfo {
    /**
     * 分组名称
     */
    public String cname;

    public String ip;
    /**
     *设备地址
     */
    public String hid;
    /**
     * 设备类型
     */
    public String devtype;
    /**
     * 信号管理服务器内网ip
     */
    public String gip;
    /**
     * 高度
     */
    public String height;
    /**
     * 同步高度差距
     */
    public String gap;
    /**
     * 最后收到lora时间
     */
    public String loratm;
    /**
     * 最后的见证【见证别人】
     */
    public String witnesstm;
    /**
     * 最后beacontm时间
     */
    public String beacontm;
    /**
     * 挑战者地址
     */
    public String lastwitness;
    /**
     * 最后心跳时间
     */
    public String hearttm;
    /**
     * 检测结果
     */
    public String remark;
}
 /*
 {
   "cname": "szxz2", 分组名称
    "ip": "172.16.1.8",
    "hid": "11w2fLJjKjWFrCTHdFVwPpqeETu4JBEPUoUecw2Exz9ZefM28ds", 设备地址
    "devtype": "pisces", 设备类型
    "gip": "",信号管理服务器内网ip
    "height": "1267173",高度
    "gap": 52,
    "loratm": "1970-01-01 08:00:00", 最后收到lora时间
    "witnesstm": "1970-01-01 08:00:00",最后的见证【见证别人】
    "beacontm": "1970-01-01 08:00:00", 最后beacontm时间
    "lastwitness": "",挑战者地址
    "hearttm": "2022-03-15 17:34:15",最后心跳时间
    "remark": "gap>20,no signal,"检测结果
  }

  */
