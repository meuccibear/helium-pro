package io.renren.modules.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteApi {
    private Integer id;

    private String key;

    private String name;

    /**
    * 1：网站 2：接口域名 3：接口地址
    */
    private Integer type;

    /**
    * 1：Get 2：POST
    */
    private Integer method;

    private String url;

    private Integer parentId;

    private String fullLink;

    private String parameter;

    private String headers;
}