package io.renren.modules.business.service;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.domain.dto.DeviceDTO;
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
public interface BusinessDeviceService {

//    PageUtils queryPage(Map<String, Object> params);

    void insertOrUpdate(BusinessDevice device);

    int updateByAddress(@Param("updated") BusinessDevice updated);

    void insertOrUpdate(List<BusinessDevice> devices);

    List<String> findAll();

    List<String> findErrDevices(String showCol);

    Map<String, Object> findSelect(DeviceDTO deviceDTO);

    R getAll(DeviceDTO deviceDTO);

    String daily(DeviceDTO deviceDTO);

    void updateDepllist(List<BusinessDevice> devices);

    void updateTotal24h(List<BusinessDevice> devices);

    void importData(MultipartFile file);

    void updateDeviceInfoTask(Map<String, String> makersDictionary, List<List<String>> lists, int index);

    void updateDeviceProfitInfoTask( List<List<String>> lists, int index);

    void updateDevicedeBlackListInfoTask(List<List<String>> lists, int index);

    void updateDevicedeBlackListInfo(String filePath, List<List<String>> lists, int index);

    void getDevice(Map<String, String> makersDictionary, Map<String, String> ownerNo, List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevicev2(List<List<String>> lists, int index, String filePath) throws MsgException;

    void dashboard(List<List<String>> lists, int i, String filePath);

    int insert(BusinessDevice record);

    int insertSelective(BusinessDevice record);

    int updateByPrimaryKeySelective(BusinessDevice record);

    int updateByPrimaryKey(BusinessDevice record);

}












