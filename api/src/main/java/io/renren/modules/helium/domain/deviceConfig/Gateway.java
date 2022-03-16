package io.renren.modules.helium.domain.deviceConfig;

import io.renren.common.gitUtils.ExcelUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.helium.GeoCoord;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
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

    /**
     * internal  output
     */
    private String gwtype = "output";

    public Gateway(Integer index, String hex, String ip, String address, String grName, GeoCoord geoCoord, Device mYDevice) {
        this.hex = hex;
        this.ip = ip;
        this.address = address;
        this.grName = grName;
        this.index = index;
        this.geoCoord = geoCoord;
        this.mYDevice = mYDevice;
    }

    public Gateway(Integer index, String hex, String ip, String address, String grName, GeoCoord geoCoord) {
        this.hex = hex;
        this.ip = ip;
        this.address = address;
        this.grName = grName;
        this.index = index;
        this.geoCoord = geoCoord;
        try {
            this.mYDevice = HeliumUtils.getHotspotsByAddress(address);
        } catch (MsgException e) {
            e.printStackTrace();
        }
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


    /**
     * @throws
     * @title 保存脚本
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 17:03
     */
    public void saveExcelFile(String logPath, String ownerCode) throws MsgException {
        String script = "./change_position_core.sh %f %f %s %s";
        FileUtils.writeln(logPath + "script.txt", String.format(script, getGeoCoord().getLat(), getGeoCoord().getLng(), getMYDevice().getAddress(), ownerCode), true, true);

        if (ObjectUtils.notIsEmpty(getMYDevice())) {
            FileUtils.writeln(logPath + "exec.txt",
                    StringUtils.outStr("\t",
                            getIndex(),
                            getMYDevice().getAddress(),
                            getMYDevice().getName(),
                            getIp(),
                            getMYDevice().getOwner(),
                            getGrName()
                    ), true, true);
        } else {
            FileUtils.writeln(logPath + "exec.txt", StringUtils.outStr("\t",
                    getIndex(),
                    getAddress(),
                    "",
                    getIp(),
                    "",
                    getGrName()), true, true);
        }
    }


    /**
     * @param filderPath 文件地址
     * @param gateway_ID 编号
     * @param port       端口
     * @throws
     * @title 保存配置文件
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/3/15 16:20
     */
    public String saveConfigFile(String filderPath, String gateway_ID, int port) throws MsgException {

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

        FileUtils.write(String.format(filderPath + "gateway_%s_%s.json", getGrName(), getIp().replaceAll("\\.", "_")), json);
        return json;
    }

}
