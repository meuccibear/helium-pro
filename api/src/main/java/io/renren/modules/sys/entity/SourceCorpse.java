package io.renren.modules.sys.entity;

import io.renren.modules.helium.domain.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceCorpse {
    private String hex;

    private String cityId;

    private String address;

    private Double bottomScanle;

    private Integer count = 0 ;

    private Integer offlinecount = 0;

    private Integer onlinecount = 0;

    private String country;

    private String city;

    List<Device> devices = new ArrayList<>();

    public void addDevices(Device device){
        devices.add(device);
    }

    public SourceCorpse(String hex, String address, String country, String city, String cityId) {
        this.hex = hex;
        this.address = address;
        this.country = country;
        this.city = city;
        this.cityId = cityId;
        bottomScanle = Double.valueOf(1);
        count = 0;
        offlinecount = 0;
        onlinecount = 0;
    }

    public SourceCorpse(String hex, String id) {
        this.hex = hex;
        this.address = address;
        bottomScanle = Double.valueOf(1);
        count = 0;
        offlinecount = 0;
        onlinecount = 0;
    }
}
