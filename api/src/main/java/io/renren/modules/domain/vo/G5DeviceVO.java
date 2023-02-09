package io.renren.modules.domain.vo;

import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.entity.BusinessRadio;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data

public class G5DeviceVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    private Integer typeId;
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

    private String address;

    /**
     * 今天收益
     */
    @ApiModelProperty(value = "今天收益")
    private BigDecimal todayEarnings;

    /**
     * 昨天收益
     */
    @ApiModelProperty(value = "昨天收益")
    private BigDecimal yesterdayEarnings;

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

    private Boolean hasChildren = false;
    private List<BusinessRadioVO> children;

}
