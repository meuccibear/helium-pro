package io.renren.modules.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.modules.business.entity.BusinessG5Log;
import io.renren.modules.business.entity.BusinessGateway;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
		gateway.setStatus(1);

		return gateway;
//		new BusinessGateway(gatewayid, minerName, cname, ip,  internel, minerConnected,
//				minerVersion, download.doubleValue(), upload.doubleValue(), agwVersion, 1, null, null, "");
	}

	public BusinessG5Log toBusinessG5Log(){
		return new BusinessG5Log(null, gatewayid, 1, internel, now);
	}
}
