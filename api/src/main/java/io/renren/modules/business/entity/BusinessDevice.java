package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备信息
 */
@ApiModel(value = "设备信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDevice {
    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Long id;

    /**
     * 一级客户名称
     */
    @ApiModelProperty(value = "一级客户名称")
    private String oneLevelName;

    /**
     * 二级客户名称
     */
    @ApiModelProperty(value = "二级客户名称")
    private String twoLevelName;

    /**
     * 英文简写
     */
    @ApiModelProperty(value = "英文简写")
    private String en;

    /**
     * 管理机
     */
    @ApiModelProperty(value = "管理机")
    private String manageName;

    /**
     * 分组
     */
    @ApiModelProperty(value = "分组")
    private String groupName;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String pingpai;

    /**
     * 内网IP
     */
    @ApiModelProperty(value = "内网IP")
    private String publicIp;

    /**
     * MAC地址
     */
    @ApiModelProperty(value = "MAC地址")
    private String mac;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String name;

    /**
     * 设备地址
     */
    @ApiModelProperty(value = "设备地址")
    private String address;

    /**
     * 设备钱包
     */
    @ApiModelProperty(value = "设备钱包")
    private String owner;

    /**
     * 磁盘大小
     */
    @ApiModelProperty(value = "磁盘大小")
    private Double disk;

    /**
     * 24小时收益
     */
    @ApiModelProperty(value = "24小时收益")
    private Double total24h;

    /**
     * 7天收益
     */
    @ApiModelProperty(value = "7天收益")
    private Double total7d;

    /**
     * 30天收益
     */
    @ApiModelProperty(value = "30天收益")
    private Double total30d;

    /**
     * 设备状态
     */
    @ApiModelProperty(value = "设备状态")
    private String online;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 街道
     */
    @ApiModelProperty(value = "街道")
    private String street;

    /**
     * 黑名单 0.白鸡 1.黑鸡
     */
    @ApiModelProperty(value = "黑名单 0.白鸡 1.黑鸡")
    private Integer depllist;

    /**
     * scale
     */
    @ApiModelProperty(value = "scale")
    private Double scale;

    /**
     * Hex
     */
    @ApiModelProperty(value = "Hex")
    private String hex;

    /**
     * Hex5
     */
    @ApiModelProperty(value = "Hex5")
    private String hex5;

    /**
     * 活动时间
     */
    @ApiModelProperty(value = "活动时间")
    private Date activeTime;

    /**
     * 设备存放地点
     */
    @ApiModelProperty(value = "设备存放地点")
    private String locationAddress;

    /**
     * 提供运维时间
     */
    @ApiModelProperty(value = "提供运维时间")
    private Date date;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String re;

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

    @ApiModelProperty(value = "")
    private Integer grpcfaild;

    /**
     * 最后beacontm时间
     */
    @ApiModelProperty(value = "最后beacontm时间")
    private Date beacontm;

    /**
     * 数据导入时间
     */
    @ApiModelProperty(value = "数据导入时间")
    private Date importDataTime;

    /**
     * 修改状态时间
     */
    @ApiModelProperty(value = "修改状态时间")
    private Integer updateStatusTime;

    /**
     * 最后心跳时间
     */
    @ApiModelProperty(value = "最后心跳时间")
    private Date hearttm;

    /**
     * 状态 0.删除 1.正常
     */
    @ApiModelProperty(value = "状态 0.删除 1.正常 ")
    private Integer status;

    /**
     * 1.正常 2.获取设备信息失败 3.获取收益失败
     */
    @ApiModelProperty(value = "1.正常 2.获取设备信息失败 3.获取收益失败")
    private Integer errStatus;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 检测结果
     */
    @ApiModelProperty(value = "检测结果")
    private String remark;
}