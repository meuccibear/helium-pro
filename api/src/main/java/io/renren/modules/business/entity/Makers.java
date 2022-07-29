package io.renren.modules.business.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="getResultVToJSONArray")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Makers {
    @ApiModelProperty(value="")
    private Long makersId;

    @ApiModelProperty(value="")
    private String address;

    @ApiModelProperty(value="")
    private String name;
}
