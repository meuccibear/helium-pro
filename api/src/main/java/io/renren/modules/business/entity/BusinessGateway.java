package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * gateway管理
 */
@ApiModel(value = "gateway管理")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessGateway implements Serializable {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String gatewayId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    private String alis;

    /**
     * 内网IP
     */
    @ApiModelProperty(value = "内网IP")
    private String privateIp;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 坐标
     */
    @ApiModelProperty(value = "坐标")
    private String hex;

    /**
     * 网络是否通畅
     */
    @ApiModelProperty(value = "网络是否通畅")
    private Boolean internel;

    /**
     * miner是否连接
     */
    @ApiModelProperty(value = "miner是否连接")
    private Boolean minerConnected;

    /**
     * miner版本
     */
    @ApiModelProperty(value = "miner版本")
    private String minerVersion;

    /**
     * 下载速度
     */
    @ApiModelProperty(value = "下载速度")
    private Double download;

    /**
     * 上传速度
     */
    @ApiModelProperty(value = "上传速度")
    private Double upload;

    /**
     * agw版本
     */
    @ApiModelProperty(value = "agw版本")
    private String agwVersion;

    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;
}