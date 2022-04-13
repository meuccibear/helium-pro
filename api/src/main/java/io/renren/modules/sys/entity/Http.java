package io.renren.modules.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Http {
    private Integer id;

    private String url;

    private String data;

    private String respone;

    private Integer status;

    private String method;
}