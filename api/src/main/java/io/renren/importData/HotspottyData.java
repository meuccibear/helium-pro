package io.renren.importData;

import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.modules.business.entity.BusinessDeviceEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 基础数据类.这里的排序和excel里面的排序一致
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
public class HotspottyData {
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
    private String ownerNo;
    /**
     * 设备存放地点
     */
    private String locationAddress;
    /**
     * 提供运维时间
     */
    private Date date;

    private String link;
    /**
     * 备注
     */
    private String re;

}
