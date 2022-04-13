package io.renren.modules.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.renren.modules.helium.domain.Device;
import lombok.Data;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-24 05:24:38
 */
@Data
@TableName("business_device")
public class BusinessDeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	private String id;
	/**
	 * 一级客户名称
	 */
	private String oneLevelName;
	/**
	 * 二级客户名称
	 */
	private String twoLevelName;
	/**
	 * 英文简写
	 */
	private String en;
	/**
	 * 设备ID
	 */
	private String address;
	/**
	 * 设备磁盘
	 */
	private Object disk;
	/**
	 * 设备名称
	 */
	private String name;
	/**
	 * 内网IP
	 */
	private String publicIp;
	/**
	 * 分组
	 */
	private String groupName;
	/**
	 * 管理机
	 */
	private String manageName;
	/**
	 * 品牌
	 */
	private String pingpai;
	/**
	 * MAC地址
	 */
	private String mac;
	/**
	 * 钱包
	 */
	private String owner;
	/**
	 * 钱包序号
	 */
	private String ownerNo;
	/**
	 * 设备存放地点
	 */
	private String locationAddress;
	/**
	 * 提供运维时间
	 */
	private Date date;
	/**
	 * 备注
	 */
	private String re;
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
	private String loratm;
	/**
	 * 最后的见证【见证别人】
	 */
	private String witnesstm;
	/**
	 * 最后beacontm时间
	 */
	private String beacontm;
	/**
	 * 挑战者地址
	 */
	private String lastwitness;
	/**
	 * 数据导入时间
	 */
	private Date importDataTime;
	/**
	 * 24小时收益
	 */
	private Double total24h;
	/**
	 * 7天收益
	 */
	private Double total7d;
	/**
	 * 30天收益
	 */
	private Double total30d;
	/**
	 * 设备状态
	 */
	private String online;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 街道
	 */
	private String street;
	/**
	 * Hex
	 */
	private String hex;
	/**
	 * 是否进入黑名单 0.正常 1.黑鸡
	 */
	private int depllist;
	/**
	 * 状态 0.正常 1.同步中 2.掉线
	 */
	private Integer status;
	/**
	 * 最后心跳时间
	 */
	private Date hearttm;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 黑名单更新时间
	 */
	private Date depllistTime;
	/**
	 * 检测结果
	 */
	private String remark;

	private Integer errStatus;

	private Double scale;

}
