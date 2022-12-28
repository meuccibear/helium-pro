package io.renren.modules.business.service;

import io.renren.common.utils.R;
import io.renren.modules.domain.dto.G5DeviceDTO;

public interface BusinessG5DeviceService {
    R getAll(G5DeviceDTO g5DeviceDTO);

    void updateAddress();

}
