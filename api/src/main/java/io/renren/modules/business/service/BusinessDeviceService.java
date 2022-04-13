package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.domain.dto.DeviceDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-24 05:24:38
 */
public interface BusinessDeviceService extends IService<BusinessDeviceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insertOrUpdate(BusinessDeviceEntity device);

    int updateByAddress(@Param("updated") BusinessDeviceEntity updated);

    void insertOrUpdate(List<BusinessDeviceEntity> devices);

    List<String> findAll();

    Map<String, Object> findSelect(DeviceDTO deviceDTO);

    R getAll(DeviceDTO deviceDTO);

    void deviceDataRefresh(Integer startIndex, Integer endIndex);

    void updateData(List<String> addresss);

    void importData(MultipartFile file);

}




