package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5G日志管理
 */
@ApiModel(value = "5G日志管理")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessG5Log implements Serializable {
    /**
     * 5G日志编号
     */
    @ApiModelProperty(value = "5G日志编号")
    private Long g5LogId;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer typeId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}