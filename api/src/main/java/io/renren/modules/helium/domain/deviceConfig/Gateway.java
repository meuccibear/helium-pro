package io.renren.modules.helium.domain.deviceConfig;

import com.alibaba.fastjson.JSON;
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

import java.util.Map;

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
    private String owner;
    private String name;

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

    public Gateway(Integer index, String hex, String ip, String address, String grName, GeoCoord geoCoord, String name, String owner) {
        this.hex = hex;
        this.ip = ip;
        this.address = address;
        this.grName = grName;
        this.index = index;
        this.geoCoord = geoCoord;
        this.name = name;
        this.owner = owner;
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
    public void saveExcelFile(String logPath, Map<String, String> ownerMap) throws MsgException {
        String script = "./change_position_core.sh %f %f %s %s";
        FileUtils.writeln(logPath + "script.txt", String.format(script, getGeoCoord().getLat(), getGeoCoord().getLng(), getMYDevice().getAddress(),
                ObjectUtils.notIsEmpty(getMYDevice()) ? ownerMap.get(getMYDevice().getOwner()) : ""), true, true);

        if (ObjectUtils.notIsEmpty(getMYDevice())) {
            FileUtils.writeln(logPath + "exec.txt",
                    StringUtils.outStr("\t",
                            getIndex(),
                            getAddress(),
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


    public void saveExcelFiles(String logPath, Map<String, String> ownerMap) throws MsgException {
        saveExcelFiles(logPath, ownerMap, false);
    }

    public void saveExcelFiles(String logPath, Map<String, String> ownerMap, boolean bug) throws MsgException {

        String ownerName = ownerMap.get(getOwner());
        String script = "./change_position_core.sh %f %f %s %s";
        if (!bug) {
            StringUtils.writeList("\t", logPath);
            StringUtils.writeList("\t", script);
            StringUtils.writeList("\t", JSON.toJSON(getGeoCoord()));
            StringUtils.writeList("\t", getAddress());
            StringUtils.writeList("\t",ownerName);
            FileUtils.writeln(logPath + "script.txt", String.format(script, getGeoCoord().getLat(), getGeoCoord().getLng(), getAddress(),
                    ownerName), true, true);
        }

        FileUtils.writeln(logPath + "exec.txt",
                StringUtils.outStr("\t",
                        getIndex(),
                        getAddress(),
                        getName(),
                        getIp(),
                        ownerName,
                        getGrName(),
                        bug ? "有问题没上的" : ""
                ), true, true);
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
        return saveConfigFile(filderPath, gateway_ID, port, false);
    }

    public String saveConfigFile(String filderPath, String gateway_ID, int port, boolean bug) throws MsgException {

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

        FileUtils.write(String.format(filderPath +"cinfig/"+ (bug ? "bak/" : "") + "gateway_%s_%s.json", getGrName(), getIp().replaceAll("\\.", "_")), json);
        return json;
    }

}
