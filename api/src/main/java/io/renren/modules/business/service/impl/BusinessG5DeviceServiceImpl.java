package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.uber.h3core.H3Core;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.dao.BusinessGatewayMapper;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.business.entity.BusinessRadio;
import io.renren.modules.business.service.BusinessG5DeviceService;
import io.renren.modules.business.service.BusinessRadioService;
import io.renren.modules.domain.dto.G5DeviceDTO;
import io.renren.modules.domain.vo.BusinessRadioVO;
import io.renren.modules.domain.vo.G5DeviceVO;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.Cell;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.sys.api.HeliumApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<BusinessGateway> gateways = gatewayMapper.selectAll();
        List<BusinessRadio> businessRadios = radioService.selectAll();

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
            g5DeviceVOS.add(build);
        }

        PageRRVO pageUtils = PageRRVO.build(g5DeviceDTO, g5DeviceVOS, g5DeviceVOS.size());
        R r = R.ok();
        r.put("page", pageUtils);

        return r;
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


    public void updateG5DeviceInfo() {
        List<BusinessRadio> businessRadios = radioService.selectAll();
        for (BusinessRadio businessRadio : businessRadios) {
            businessRadio.getAlis();

        }
    }

}
