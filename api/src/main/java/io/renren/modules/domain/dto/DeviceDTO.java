package io.renren.modules.domain.dto;

import io.renren.common.gitUtils.PageRRDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: helium-pro
 * @ClassName HotspottyDTO
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-09 10:42
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO extends PageRRDTO {

    String owner;

    String online;

    String depllist;

    String name;

    String key;

    String oneLevelName;

    String twoLevelName;

    String manageName;

    String groupName;

    String country;

    String city;

    /**
     * @title
     * @description 1.日报
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/8/1 17:21
     * @throws
     */
    Integer modeType;

}
