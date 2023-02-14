package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.*;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.dao.BusinessGatewayMapper;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.entity.BusinessRadio;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.business.service.BusinessRadioService;
import io.renren.modules.domain.dto.G5DeviceDTO;
import io.renren.modules.domain.vo.BusinessRadioVO;
import io.renren.modules.domain.vo.G5DeviceVO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Cell;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.sys.api.HeliumApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BusinessG5DeviceServiceImpl implements BusinessG5DeviceService {

    @Autowired
    BusinessGatewayMapper gatewayMapper;

    @Autowired
    BusinessRadioService radioService;

    @Autowired
    HeliumApi heliumApi;

    public R getAll(G5DeviceDTO g5DeviceDTO) {
        log.info("{}", g5DeviceDTO);
        List<BusinessGateway> gateways = gatewayMapper.selectAll(g5DeviceDTO);
        List<BusinessRadio> businessRadios = radioService.selectAll(g5DeviceDTO);

        List<G5DeviceVO> g5DeviceVOS = new ArrayList<>();

        for (BusinessGateway gateway : gateways) {
            G5DeviceVO build = BeanUtils.mergeObjects(new TypeReference<G5DeviceVO>() {
            }, gateway);
            build.setId(gateway.getGatewayId());
            build.setTypeId(1);
            List<BusinessRadioVO> children = new ArrayList<>();
            for (BusinessRadio businessRadio : businessRadios) {
                if (businessRadio.getGatewayId().equals(gateway.getGatewayId())) {
                    BusinessRadioVO radioVO = BeanUtils.mergeObjects(new TypeReference<BusinessRadioVO>() {
                    }, businessRadio);
                    radioVO.setId(businessRadio.getRadioId());
                    radioVO.setTypeId(2);
                    children.add(radioVO);
                }
            }

            build.setChildren(children);

            if ((ObjectUtils.notIsEmpty(g5DeviceDTO.getGpsStat()) || ObjectUtils.notIsEmpty(g5DeviceDTO.getSasStat()) || ObjectUtils.notIsEmpty(g5DeviceDTO.getStatus())) && children.size() > 0) {
                g5DeviceVOS.add(build);
            } else if (ObjectUtils.isEmpty(g5DeviceDTO.getGpsStat()) && ObjectUtils.isEmpty(g5DeviceDTO.getSasStat()) && ObjectUtils.isEmpty(g5DeviceDTO.getStatus())) {
                g5DeviceVOS.add(build);
            }
        }

        PageRRVO pageUtils = PageRRVO.build(g5DeviceDTO, g5DeviceVOS, g5DeviceVOS.size());
        R r = R.ok();
        r.putAll(findGatewaySelect(g5DeviceVOS));
        r.put("page", pageUtils);
        return r;
    }

    /**
     * 添加并计数
     *
     * @param oneLevelName
     */
    void putCount(Map<Object, JSONObject> data, Object oneLevelName) {
        oneLevelName = ObjectUtils.notIsEmpty(oneLevelName) ? oneLevelName : "未知";
        JSONObject jsonObject;
        if (data.containsKey(oneLevelName)) {
            jsonObject = data.get(oneLevelName);
            jsonObject.put("num", jsonObject.getInteger("num") + 1);
        } else {
            jsonObject = new JSONObject() {{
                put("num", 1);
            }};
            data.put(oneLevelName, jsonObject);
        }
    }

    private Map<String, Object> findGatewaySelect(List<G5DeviceVO> g5DeviceVOS) {
//        if (ObjectUtils.isEmpty(g5DeviceVOS)) {
//            return new HashMap<>();
//        }
        Map<String, Object> result = new HashMap<>();

        Map<Object, JSONObject> sasStat = new HashMap<>();
        Map<Object, JSONObject> gpsStat = new HashMap<>();
        Map<Object, JSONObject> status = new HashMap<>();
        Map<Object, JSONObject> internel = new HashMap<>();

        for (G5DeviceVO g5DeviceVO : g5DeviceVOS) {
            putCount(internel, g5DeviceVO.getInternel());
//            if(ObjectUtils.notIsEmpty(g5DeviceVO.getChildren())){
            for (BusinessRadioVO child : g5DeviceVO.getChildren()) {
                putCount(sasStat, child.getSasStat());
                putCount(gpsStat, child.getGpsStat());
                putCount(status, child.getStatus());
            }
//            }
        }

        result.put("sasStat", toSelect(sasStat, new HashMap<Object, String>() {{
            put(true, "正常");
            put(false, "不正常");
        }}));
        result.put("gpsStat", toSelect(gpsStat, new HashMap<Object, String>() {{
            put(true, "正常");
            put(false, "不正常");
        }}));
        result.put("status", toSelect(status, new HashMap<Object, String>() {{
            put(1, "正常");
            put(0, "不正常");
        }}));
        result.put("internel", toSelect(internel, new HashMap<Object, String>() {{
            put(true, "正常");
            put(false, "不正常");
        }}));

        return result;
    }

    public List<Select> toSelect(Map<Object, JSONObject> oneLevelName) {
        return toSelect(oneLevelName, null);
    }

    public List<Select> toSelect(Map<Object, JSONObject> oneLevelName, Map<Object, String> aliasM) {

        List<Select> selects = new ArrayList<>();
        for (Object o : oneLevelName.keySet().toArray()) {
            List<Select> son = null;
            if (oneLevelName.get(o).containsKey("son")) {
                Map<Object, JSONObject> data = (Map<Object, JSONObject>) oneLevelName.get(o).get("son");
                son = toSelect(data, aliasM);
            }
            selects.add(new Select(null == o ? "未知" : (null == aliasM ? o : aliasM.get(o)) + " 【" + oneLevelName.get(o).get("num") + "】", o.toString(), son));
        }
        return selects;
    }

    @Override
    public void updateAddress() {
        List<String> gatewayIds = gatewayMapper.selectGatewayIds();

        if (ObjectUtils.isEmpty(gatewayIds)) {
            return;
        }
        List<Device> devices;
        Device device;
        BusinessRadio businessRadio;

        H3Core h3 = null;
        try {
            h3 = H3Core.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String gatewayId : gatewayIds) {
            List<BusinessRadio> businessRadios = radioService.selectAllByGatewayId(gatewayId);
            if (ObjectUtils.isEmpty(businessRadios)) {
                continue;
            }
            businessRadio = businessRadios.get(0);
            devices = heliumApi.getDevices(h3.geoToH3Address(businessRadio.getLat().doubleValue(), businessRadio.getLng().doubleValue(), 8));

            if (ObjectUtils.notIsEmpty(devices)) {
                if (devices.size() == 1) {
                    device = devices.get(0);
                    if (Constant.g5DeviceAddress.containsKey(device.getPayer())) {
                        gatewayMapper.updateAddressAndHexByGatewayId(device.getAddress(), device.getLocation_hex(), gatewayId);
                    }
                } else {
                    for (Device device1 : devices) {
                        if (Constant.g5DeviceAddress.containsKey(device1.getPayer())) {
                            List<Cell> cells = heliumApi.getG5Devices(device1.getAddress());
                            List<String> address = new ArrayList<>();
                            if (ObjectUtils.notIsEmpty(cells)) {
                                log.info("cells.size{} businessRadios.size{}", cells.size(), businessRadios.size());
                                for (Cell cell : cells) {
                                    cell:
                                    for (BusinessRadio radio : businessRadios) {
                                        log.info("radio.for {} {}", cell.getCbsdId(), radio.getRadioId());
                                        if (cell.getCbsdId().indexOf(radio.getRadioId()) > -1) {
                                            radioService.updateAlisByRadioId(cell.getCbsdId(), radio.getRadioId());
                                            if (!address.contains(cell.getCbsdId())) {
                                                address.add(cell.getCbsdId());
                                            }
                                            break cell;
                                        }
                                    }
                                }
                                if (address.size() == businessRadios.size()) {
                                    gatewayMapper.updateAddressAndHexByGatewayId(device1.getAddress(), device1.getLocation_hex(), gatewayId);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }

    }

    @Override
    public void incomeTask(List<BusinessGateway> gateways) {

        for (BusinessGateway gateway : gateways) {

            if (ObjectUtils.notIsEmpty(gateway.getAddress())) {
                BusinessGateway gateway1 = new BusinessGateway();
                gateway1.setGatewayId(gateway.getGatewayId());
                gateway1.setOwner(gateway.getOwner());
                gateway1.setAddress(gateway.getAddress());
                try {
                    income(gateway1);
                } catch (Exception e) {
                    log.error("incomeTask:", e);
                }
                gatewayMapper.updateYesterdayEarningsAndTodayEarningsAndOwnerByAddress(gateway1);
            }
        }

    }


    @Override
    public void income(BusinessGateway gateway) {
        Device device;
        String owner;
//            BusinessGateway gateway1 = new BusinessGateway();
//            gateway1.setGatewayId(gateway.getGatewayId());

        if (ObjectUtils.isEmpty(gateway.getOwner())) {
            device = (Device) new CounterUtil() {
                @Override
                public boolean check(Object execute) {
                    return execute == null;
                }

                @Override
                public Object execute(Object data) {
                    return heliumApi.getHotspotsByAddress((String) data);
                }
            }.run(gateway.getAddress());
            owner = device.getOwner();
            gateway.setOwner(owner);
        } else {
            owner = gateway.getOwner();
        }
        JSONArray data = new JSONArray();
        JSONObject roles = HeliumUtils.roles(owner, false, "rewards_v1,rewards_v2,rewards_v3,subnetwork_rewards_v1", "");
        data.addAll(roles.getJSONArray("data"));
        roles = HeliumUtils.roles(owner, false, "", (String) roles.get("cursor"));
        data.addAll(roles.getJSONArray("data"));
//        JSONArray data = roles.getJSONArray("data");


        if (ObjectUtils.notIsEmpty(data)) {
            JSONArray jsonArray = (JSONArray) JSONUtils.jsGetData(roles, "data");
            List<JSONObject> rmJson = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if(!jsonObject.getString("type").equals("subnetwork_rewards_v1")){
                    rmJson.add(jsonObject);
                    continue;
                }
                log.info("hash:{} time:{}", jsonObject.getString("hash"), DateUtils.asStr(4, new Date(1000 * jsonObject.getLong("time"))));
            }

            for (JSONObject jsonObject : rmJson) {
                jsonArray.remove(jsonObject);
            }

            gateway.setTodayEarnings(getTransactionsAmount(owner, roles, 0));
            gateway.setYesterdayEarnings(getTransactionsAmount(owner, roles, 1));

        }

    }

    //(String) JSONUtils.jsGetData(roles, "data.0.hash")
    BigDecimal getTransactionsAmount(String hotspotsId, JSONObject roles, int index) {
        JSONObject role = (JSONObject) JSONUtils.jsGetData(roles, "data." + index);
        String hash = role.getString("hash");
        LocalDate localDate = LocalDate.now();
        if (index == 1) {
            localDate = localDate.minusDays(1);
        }
        String nowTime = DateUtils.asStr(1, DateUtils.asDate(localDate));
        String time = null;
        if (role.containsKey("time")) {
            time = DateUtils.asStr(1, new Date(1000 * role.getLong("time")));
        }

        log.info("hash:{} {}=={}", hash, nowTime, time);

        if (nowTime.equals(time)) {
            JSONObject json = HeliumUtils.transactions(hotspotsId, hash);
            JSONArray o = (JSONArray) JSONUtils.jsGetData(json, "data.rewards");
            JSONObject jsonObject = null;
            for (int i = 0; i < o.size(); i++) {
                jsonObject = o.getJSONObject(i);
                if (hotspotsId.equals(jsonObject.get("account"))) {
                    break;
                }
            }
            return jsonObject.getBigDecimal("amount").divide(new BigDecimal(100000000), 8, BigDecimal.ROUND_HALF_UP);
        }

        return null;
    }

    public void updateG5DeviceInfo() {
        List<BusinessRadio> businessRadios = radioService.selectAll(new G5DeviceDTO());
        for (BusinessRadio businessRadio : businessRadios) {
            businessRadio.getAlis();

        }
    }

}
