package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.domain.dto.DeviceDTO;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Async;
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

    void importData(MultipartFile file);

    void updateData(List<List<String>> lists, int index);

//    void updateData1(List<List<String>> lists, int index, String filePath);

    void getDevice(Map<String, String> ownerNo, List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevicev2(List<List<String>> lists, int index, String filePath) throws MsgException;

    void dashboard(List<List<String>> lists, int i, String filePath);

//    void addHotspottyGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException;

}




