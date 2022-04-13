package io.renren.modules.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户与角色对应关系
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupHotspottyAssociation {
    private Long id;

    /**
    * 用户ID
    */
    private Long groupId;

    /**
    * 设备ID
    */
    private Long hotspottyId;
}
