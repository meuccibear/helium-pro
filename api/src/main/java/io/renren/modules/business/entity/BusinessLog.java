package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "business_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLog {
    @ApiModelProperty(value = "")
    private String hid;

    /**
     * ip
     */
    @ApiModelProperty(value = "ip")
    private String ip;

    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private String devtype;

    /**
     * 信号管理服务器内网ip
     */
    @ApiModelProperty(value = "信号管理服务器内网ip")
    private String gip;

    /**
     * 最后收到lora时间
     */
    @ApiModelProperty(value = "最后收到lora时间")
    private Date loratm;

    /**
     * 最后的见证【见证别人】
     */
    @ApiModelProperty(value = "最后的见证【见证别人】")
    private Date witnesstm;

    /**
     * 磁盘大小
     */
    @ApiModelProperty(value = "磁盘大小")
    private Double disk;

    /**
     * muxtm
     */
    @ApiModelProperty(value = "muxtm")
    private Date muxtm;

    /**
     * miner版本
     */
    @ApiModelProperty(value = "miner版本")
    private String minerver;

    /**
     * miner状态
     */
    @ApiModelProperty(value = "miner状态")
    private String minerstat;

    /**
     * hntman版本
     */
    @ApiModelProperty(value = "hntman版本")
    private String ver;

    /**
     * 最后beacontm时间
     */
    @ApiModelProperty(value = "最后beacontm时间")
    private Date beacontm;

    /**
     * 最后心跳时间
     */
    @ApiModelProperty(value = "最后心跳时间")
    private Date hearttm;

    /**
     * 检测结果
     */
    @ApiModelProperty(value = "检测结果")
    private String remark;

    @ApiModelProperty(value = "")
    private Integer grpcfaild;

    public BusinessDevice toDBDeviceEntity() {
        BusinessDevice businessDeviceEntity = new BusinessDevice();
//        setAddress(getHid());
        businessDeviceEntity.setAddress(getHid());
        businessDeviceEntity.setDisk(getDisk());
        businessDeviceEntity.setRemark(getRemark());
        businessDeviceEntity.setIp(getIp());
        businessDeviceEntity.setDevtype(getDevtype());
//        businessDeviceEntity.setCname(getCname());
//        businessDeviceEntity.setGip(getGip());
//        businessDeviceEntity.setHeight(getHeight());
//        businessDeviceEntity.setGap(getGap());
//        businessDeviceEntity.setLastwitness(getLastwitness());
//        businessDeviceEntity.setLoratm(DateUtils.asStr(4, getLoratm()));
//        businessDeviceEntity.setBeacontm(DateUtils.asStr(4, getBeacontm()));

        businessDeviceEntity.setLoratm(getLoratm());
        businessDeviceEntity.setBeacontm(getBeacontm());
        businessDeviceEntity.setWitnesstm(getWitnesstm());
        businessDeviceEntity.setHearttm(getHearttm());
        businessDeviceEntity.setMuxtm(getMuxtm());
        businessDeviceEntity.setMinerstat(getMinerstat());
        businessDeviceEntity.setMinerver(getMinerver());
        businessDeviceEntity.setVer(getVer());
        businessDeviceEntity.setGrpcfaild(getGrpcfaild());

        return businessDeviceEntity;
    }
}