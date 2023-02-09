package io.renren.modules.business.service;

import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessGateway;
import io.renren.modules.domain.dto.G5DeviceDTO;

import java.util.List;

public interface BusinessG5DeviceService {
    R getAll(G5DeviceDTO g5DeviceDTO);

    void updateAddress();
    void incomeTask(List<BusinessGateway> gateways);

    void income(BusinessGateway gateway);

}
