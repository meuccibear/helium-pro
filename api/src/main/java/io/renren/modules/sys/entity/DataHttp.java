package io.renren.modules.sys.entity;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataHttp {
    private Integer id;

    private String method;

    private String url;

    private String entityparameter;

    private String headers;

    private Integer status;

    private String respone;

    private Date createTime;

    public DataHttp(String method, String url, Object entityparameter, Object headers, Integer status, String respone) {
        this.method = method;
        this.url = url;
        if (ObjectUtils.notIsEmpty(entityparameter)) {
            this.entityparameter = JSON.toJSONString(entityparameter);
        }
        if (ObjectUtils.notIsEmpty(headers)) {
            this.headers = JSON.toJSONString(headers);
        }
        this.status = status;
        this.respone = respone;
    }

    public DataHttp(String method, String url, Object entityparameter, Object headers, Integer status) {
        this.method = method;
        this.url = url;
        if (ObjectUtils.notIsEmpty(entityparameter)) {
            this.entityparameter = JSON.toJSONString(entityparameter);
        }
        if (ObjectUtils.notIsEmpty(headers)) {
            this.headers = JSON.toJSONString(headers);
        }
        this.status = status;
    }
}
