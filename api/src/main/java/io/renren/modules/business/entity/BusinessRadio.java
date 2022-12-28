package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * radio管理
 */
@ApiModel(value = "radio管理")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRadio implements Serializable {
    /**
     * radio编号
     */
    @ApiModelProperty(value = "radio编号")
    private String radioId;

    /**
     * gateway编号
     */
    @ApiModelProperty(value = "gateway编号")
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

    @ApiModelProperty(value = "")
    private String model;

    /**
     * gps状态
     */
    @ApiModelProperty(value = "gps状态")
    private Boolean gpsStat;

    @ApiModelProperty(value = "")
    private BigDecimal lng;

    @ApiModelProperty(value = "")
    private BigDecimal lat;

    @ApiModelProperty(value = "")
    private Boolean sasStat;

    @ApiModelProperty(value = "")
    private Boolean coreStat;

    @ApiModelProperty(value = "")
    private Boolean onair;

    /**
     * cell版本
     */
    @ApiModelProperty(value = "cell版本")
    private String cellVersion;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

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
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer status;

    private static final long serialVersionUID = 1L;
}