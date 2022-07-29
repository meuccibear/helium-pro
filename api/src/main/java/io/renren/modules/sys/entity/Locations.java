package io.renren.modules.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locations {
    private String location;

    private String longstreet;

    private String shortstreet;

    private String longcity;

    private String shortcity;

    private String longstate;

    private String shortstate;

    private String longcountry;

    private String shortcountry;

    private String searchcity;

    private String cityid;

    private String geometry;
}