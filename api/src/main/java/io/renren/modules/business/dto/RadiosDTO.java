package io.renren.modules.business.dto;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.entity.BusinessG5Log;
import io.renren.modules.business.entity.BusinessRadio;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.*;

@NoArgsConstructor
@Data
public class RadiosDTO {
    @JsonProperty("sid")
    private String sid;
    @JsonProperty("model")
    private String model;
    @JsonProperty("gps_stat")
    private Boolean gpsStat;
    @JsonProperty("lng")
    private String lng;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("sas_stat")
    private String sasStat;
    @JsonProperty("core_stat")
    private Boolean coreStat;
    @JsonProperty("onair")
    private Boolean onair;
    @JsonProperty("cell_version")
    private String cellVersion;

    public BusinessRadio toBusinessRadio(String gatewayid){
        return new BusinessRadio(sid, gatewayid, null, null, model,
                gpsStat, new BigDecimal(lng), new BigDecimal(lat), "SUCCESS".equals(sasStat),
                coreStat, onair, cellVersion, "",null, null, getOnair() ? 1 : 0);
    }

    JSONObject jsonObject = (JSONObject) BeanUtils.toJSON(this);

    public static Map<Integer, String> radioType = new HashMap<Integer, String>(){{
        put(2, "gpsStat");
        put(3, "sasStat");
        put(4, "onair");
    }};


    public List<BusinessG5Log> toBusinessG5Log(Date now , Integer... typeIds){
        List<BusinessG5Log> g5LogList = new ArrayList<>();

        if(ObjectUtils.isEmpty(typeIds)){
            return g5LogList;
        }

        for (Integer typeId : typeIds) {
            if(ObjectUtils.isEmpty(jsonObject)){
                jsonObject = (JSONObject) BeanUtils.toJSON(this);
            }

            String valueColName = radioType.get(typeId);
            if(ObjectUtils.notIsEmpty(valueColName)){
                JSONObject jsonObject = (JSONObject) BeanUtils.toJSON(this);
                Object o = jsonObject.get(valueColName);
                Boolean status = false;
                if(o instanceof Boolean){
                    status = (Boolean) o;
                }else if(o instanceof String){
                    status =  "SUCCESS".equals(o);
                } else {
                    continue;
                }
                g5LogList.add( new BusinessG5Log(null, sid, typeId, status, now));
            }
        }

        return g5LogList;
    }
}
