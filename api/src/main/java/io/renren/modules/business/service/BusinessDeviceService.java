package io.renren.modules.business.service;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessDevice;
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
public interface BusinessDeviceService {

//    PageUtils queryPage(Map<String, Object> params);

    void insertOrUpdate(BusinessDevice device);

    int updateByAddress(@Param("updated") BusinessDevice updated);

    void insertOrUpdate(List<BusinessDevice> devices);

    List<String> findAll();

    Map<String, Object> findSelect(DeviceDTO deviceDTO);

    R getAll(DeviceDTO deviceDTO);

    String daily(DeviceDTO deviceDTO);

    void importData(MultipartFile file);

    void updateData(Map<String, String> makersDictionary, List<List<String>> lists, int index);

    void getDevice(Map<String, String> makersDictionary,Map<String, String> ownerNo, List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException;

    void addHeliumGlobalDevicev2(List<List<String>> lists, int index, String filePath) throws MsgException;

    void dashboard(List<List<String>> lists, int i, String filePath);

    int deleteByPrimaryKey(Long id);

    int insert(BusinessDevice record);

    int insertSelective(BusinessDevice record);

    BusinessDevice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusinessDevice record);

    int updateByPrimaryKey(BusinessDevice record);

//    int deleteByPrimaryKey(Long id);

//    int insert(BusinessDevice record);
//
//    int insertSelective(BusinessDevice record);
//
//    BusinessDevice selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(BusinessDevice record);
//
//    int updateByPrimaryKey(BusinessDevice record);

//    void addHotspottyGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException;

}












