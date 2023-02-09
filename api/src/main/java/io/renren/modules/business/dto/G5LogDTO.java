package io.renren.modules.business.dto;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.entity.BusinessG5Log;
import io.renren.modules.business.entity.BusinessGateway;
import lombok.Data;
import java.io.Serializable;
import java.util.*;

@Data
public class G5LogDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("cname")
	private String cname;
	@JsonProperty("ip")
	private String ip;
	@JsonProperty("gatewayid")
	private String gatewayid;
	@JsonProperty("miner_name")
	private String minerName;
	@JsonProperty("internel")
	private Boolean internel;
	@JsonProperty("miner_connected")
	private Boolean minerConnected;
	@JsonProperty("miner_version")
	private String minerVersion;
	@JsonProperty("download")
	private Double download;
	@JsonProperty("upload")
	private Double upload;
	@JsonProperty("agw_version")
	private String agwVersion;
	@JsonProperty("radios")
	private List<RadiosDTO> radios;

	private Date now;


	public BusinessGateway toBusinessGateway(){
		BusinessGateway gateway = new BusinessGateway();
		gateway.setGatewayId(gatewayid);

		gateway.setName(minerName);
		gateway.setAlis(cname);
		gateway.setPrivateIp(ip);
		gateway.setInternel(internel);
		gateway.setMinerConnected(minerConnected);
		gateway.setMinerVersion(minerVersion);
		gateway.setDownload(download.doubleValue());
		gateway.setUpload(upload.doubleValue());
		gateway.setAgwVersion(agwVersion);
		gateway.setStatus(internel ? 1: 0);

		return gateway;
//		new BusinessGateway(gatewayid, minerName, cname, ip,  internel, minerConnected,
//				minerVersion, download.doubleValue(), upload.doubleValue(), agwVersion, 1, null, null, "");
	}

	public static Map<Integer, String> radioType = new HashMap<Integer, String>(){{
		put(1, "internel");
	}};

	JSONObject jsonObject = (JSONObject) BeanUtils.toJSON(this);


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
				g5LogList.add( new BusinessG5Log(null, gatewayid, typeId, status, now));
			}
		}

		return g5LogList;
	}

//	public BusinessG5Log toBusinessG5Log(){
//		return new BusinessG5Log(null, gatewayid, 1, internel, now);
//	}
}
