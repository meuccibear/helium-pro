package io.renren.business.domin;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLogDTO {
    /**
     * 分组名称
     */
    @ApiModelProperty(value="分组名称")
    private String cname;

    /**
     * ip
     */
    @ApiModelProperty(value="ip")
    private String ip;


    /**
     * 设备类型
     */
    @ApiModelProperty(value="设备类型")
    private String devtype;

    /**
     * 信号管理服务器内网ip
     */
    @ApiModelProperty(value="信号管理服务器内网ip")
    private String gip;

    @ApiModelProperty(value="token")
    private String token;

    @ApiModelProperty(value="address")
    private String hid;

    /**
     * 高度
     */
    @ApiModelProperty(value="高度")
    private String height;

    /**
     * gap
     */
    @ApiModelProperty(value="gap")
    private String gap;

    /**
     * 最后收到lora时间
     */
    @ApiModelProperty(value="最后收到lora时间")
    private Date loratm;

    /**
     * 最后的见证【见证别人】
     */
    @ApiModelProperty(value="最后的见证【见证别人】")
    private String witnesstm;

    /**
     * 最后beacontm时间
     */
    @ApiModelProperty(value="最后beacontm时间")
    private Date beacontm;

    /**
     * 挑战者地址
     */
    @ApiModelProperty(value="挑战者地址")
    private String lastwitness;

    /**
     * 最后心跳时间
     */
    /*@ApiModelProperty(value="最后心跳时间")
    private Date hearttm;*/

    /**
     * 检测结果
     */
    @ApiModelProperty(value="检测结果")
    private String remark;
    /*
     *//**
     * 更新时间
     *//*
    @ApiModelProperty(value="检测结果")
    private Date updateTime;

    *//**
     * 数据导入时间
     *//*
    private Date importDataTime;*/




}

/*
{
	"beacontm": "2022-03-24 14:41:56",
	"cname": "Odd Misty Coyote",
	"devtype": "heltec",
	"gap": "123",
	"gip": "192.168.1.3",
	"height": "123",
	"ip": "192.168.1.1",
	"lastwitness": "12312312",
	"loratm": "2022-03-24 14:41:56",
	"remark": "备注",
	"token": "jiEVJSrMwrVaTXExro8yHSVxE7qABtC5ZiY5gwwBA",
	"witnesstm": "11MApxwkuUjiEVJSrMwrVaTXExro8yHSVxE7qABtC5ZiY5gwwBA",
	"address": "11MApxwkuUjiEVJSrMwrVaTXExro8yHSVxE7qABtC5ZiY5gwwBA"
}
*/
