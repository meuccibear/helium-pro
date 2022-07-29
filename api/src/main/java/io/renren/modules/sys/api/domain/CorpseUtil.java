package io.renren.modules.sys.api.domain;

import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.LeanData;
import io.renren.modules.sys.entity.GlobalDevice;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.SourceCorpseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: helium-pro-new
 * @ClassName SourceCorpseUtil
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-04-18 19:06
 * @Version 1.0
 **/
@Slf4j
@Component
public class CorpseUtil {

    @Autowired
    SourceCorpseService sourceCorpseService;

    public List<SourceCorpse> checkLeanData(List<LeanData> leanData, int res) {
        Map<String, SourceCorpse> data = new HashMap<>();

        if (ObjectUtils.isEmpty(leanData)) {
            return new ArrayList<>();
        }

        for (LeanData device : leanData) {
            if (ObjectUtils.isEmpty(device)) {
                continue;
            }
            String hex = HexUtils.h3.h3ToParentAddress(device.getL(), res);

            SourceCorpse corpse = data.containsKey(hex) ? data.get(hex) : new SourceCorpse(hex, device.getId());

            if (device.getOnline().equals("online")) {
                corpse.setOnlinecount(corpse.getOnlinecount() + 1);
            } else {
                corpse.setOfflinecount(corpse.getOfflinecount() + 1);
            }
            corpse.setCount(corpse.getCount() + 1);

            if (ObjectUtils.notIsEmpty(device.getRs()) && corpse.getBottomScanle() > device.getRs()) {
                corpse.setBottomScanle(device.getRs());
            }
            sourceCorpseService.inserOrUpdate(corpse);
            data.put(hex, corpse);
        }

        List<SourceCorpse> corpses = BeanUtils.toJavaObject(data.values(), new TypeReference<List<SourceCorpse>>() {{
        }});
        return corpses;
    }

    public List<SourceCorpse> checkDevice(List<Device> devices, int res) {

        Map<String, SourceCorpse> data = new HashMap<>();

        if (ObjectUtils.isEmpty(devices)) {
            return new ArrayList<>();
        }

        for (Device device : devices) {
            if (ObjectUtils.isEmpty(device)) {
                continue;
            }
            String hex = HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), res);

            SourceCorpse corpse = data.containsKey(hex) ? data.get(hex) : new SourceCorpse(hex, device.getAddress(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), device.getGeocode().getCity_id());

            corpse.addDevices(device);
            if (device.getStatus().getOnline().equals("online")) {
                corpse.setOnlinecount(corpse.getOnlinecount() + 1);
            } else {
                corpse.setOfflinecount(corpse.getOfflinecount() + 1);
            }
            corpse.setCount(corpse.getCount() + 1);

            if (ObjectUtils.notIsEmpty(device.getReward_scale()) && corpse.getBottomScanle() > device.getReward_scale()) {
                corpse.setBottomScanle(device.getReward_scale());
            }
            sourceCorpseService.inserOrUpdate(corpse);
            data.put(hex, corpse);
        }

        List<SourceCorpse> corpses = BeanUtils.toJavaObject(data.values(), new TypeReference<List<SourceCorpse>>() {{
        }});
        return corpses;
    }


    public List<SourceCorpse> checkGlobalDevice(List<GlobalDevice> globalDevices, int res) {

        Map<String, SourceCorpse> data = new HashMap<>();

        if (ObjectUtils.isEmpty(globalDevices)) {
            return new ArrayList<>();
        }

        for (GlobalDevice globalDevice : globalDevices) {
            if (ObjectUtils.isEmpty(globalDevice)) {
                continue;
            }
            String hex = HexUtils.h3.h3ToParentAddress(globalDevice.getLocationHex(), res);

            SourceCorpse corpse = data.containsKey(hex) ? data.get(hex) : new SourceCorpse(hex, globalDevice.getAddress(), globalDevice.getLongCountry(), globalDevice.getLongCity(), globalDevice.getCityId());

//            corpse.addDevices(globalDevice);
            if (globalDevice.getOnline().equals("online")) {
                corpse.setOnlinecount(corpse.getOnlinecount() + 1);
            } else {
                corpse.setOfflinecount(corpse.getOfflinecount() + 1);
            }
            corpse.setCount(corpse.getCount() + 1);

            if (ObjectUtils.notIsEmpty(globalDevice.getRewardScale()) && corpse.getBottomScanle() > globalDevice.getRewardScale()) {
                corpse.setBottomScanle(globalDevice.getRewardScale());
            }
            sourceCorpseService.inserOrUpdate(corpse);
            data.put(hex, corpse);
        }

        List<SourceCorpse> corpses = BeanUtils.toJavaObject(data.values(), new TypeReference<List<SourceCorpse>>() {{
        }});
        return corpses;
    }

}
