package io.renren.modules.helium.domain.deviceConfig;

import io.renren.business.domin.device.Device;
import io.renren.common.gitUtils.ExcelUtils;
import io.renren.modules.helium.GeoCoord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {
    private Integer index;
    private String hex;
    private String ip;
    private String address;
    private String grName;
    private GeoCoord geoCoord;
    private Device mYDevice;
//    private String gatewayID;

    /**
     * internal  output
     */
    private String gwtype = "output";

//    private Gateway_conf gateway_conf;

    public Gateway(Integer index, String hex, String ip, String address, String grName, GeoCoord geoCoord, Device mYDevice) {
        this.hex = hex;
        this.ip = ip;
        this.address = address;
        this.grName = grName;
        this.index = index;
        this.geoCoord = geoCoord;
        this.mYDevice = mYDevice;
//        this.gatewayID = gatewayID;
    }


    public String out(String gateway_ID, int port) {




        String json = "{\n" +
                "  \"gateway_conf\": {\n" +
                "    \"gateway_ID\": \"" + ExcelUtils.toTempStr(gateway_ID, String.valueOf(index)) + "\",\n" +
                "    \"group_hash\": \"" + grName + "af" + "\",\n" +
                "    \"gwtype\": \"" + getGwtype() + "\",\n" +
                "    \"serv_port_down\": " + port + ",\n" +
                "    \"serv_port_up\": " + port + ",\n" +
                "    \"server_address\": \"" + getIp() + "\"\n" +
                "  }\n" +
                "}\n";
        return json;
    }

    public static String build(String gateway_ID, String grName, String ip, int port) {
        Gateway_conf gateway_conf = new Gateway_conf();
        gateway_conf.setGateway_ID(gateway_ID);
        gateway_conf.setGroup_hash(grName);
        gateway_conf.setGwtype("output");
        gateway_conf.setServer_address(ip);
        gateway_conf.setServ_port_up(port);
        gateway_conf.setServ_port_down(port);
//        Gateway gatewayConf = new Gateway();
//        gatewayConf.setGateway_conf(gateway_conf);

        String json = "{\n" +
                "  \"gateway_conf\": {\n" +
                "    \"gateway_ID\": \"" + gateway_conf.getGateway_ID() + "\",\n" +
                "    \"group_hash\": \"" + gateway_conf.getGroup_hash() + "\",\n" +
                "    \"gwtype\": \"output\",\n" +
                "    \"serv_port_down\": " + gateway_conf.getServ_port_down() + ",\n" +
                "    \"serv_port_up\": " + gateway_conf.getServ_port_up() + ",\n" +
                "    \"server_address\": \"" + gateway_conf.getServer_address() + "\"\n" +
                "  }\n" +
                "}\n";
        return json;
    }
}
