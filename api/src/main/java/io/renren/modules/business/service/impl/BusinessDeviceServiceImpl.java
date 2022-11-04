package io.renren.modules.business.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.HeliumHttpUtils;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.utils.R;
import io.renren.importData.HotspottyData;
import io.renren.importData.HotspottyDataListener;
import io.renren.modules.business.dao.BusinessDeviceMapper;
import io.renren.modules.business.dao.Select;
import io.renren.modules.domain.dto.DeviceDTO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.api.domain.CorpseUtil;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import io.renren.modules.business.entity.BusinessDevice;
import io.renren.modules.business.service.BusinessDeviceService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Slf4j
@Service("businessDeviceService")
public class BusinessDeviceServiceImpl implements BusinessDeviceService {

    @Resource
    BusinessDeviceMapper businessDeviceMapper;

    @Autowired
    HeliumApi heliumApi;

    @Autowired
    CorpseUtil corpseUtil;

    @Autowired
    GlobalDeviceService globalDeviceService;

    @Override
    public Map<String, Object> findSelect(DeviceDTO deviceDTO) {
        Map<String, Object> selectMap = new HashMap<>();
        selectMap.put("onlines", businessDeviceMapper.findSelect(deviceDTO, 1));
        selectMap.put("depllist", businessDeviceMapper.findSelect(deviceDTO, 2));
        return selectMap;
    }

    @Override
    public R getAll(DeviceDTO deviceDTO) {
        List<BusinessDevice> businessDeviceEntities = businessDeviceMapper.selectAllPaging(deviceDTO);
        List<BusinessDevice> deviceEntities = businessDeviceMapper.selectFilterable(deviceDTO);

        PageRRVO pageUtils = PageRRVO.build(deviceDTO, businessDeviceEntities, deviceEntities.size());
        R r = R.ok();
        r.put("page", pageUtils);
        r.putAll(findSelect(deviceEntities));
        return r;
    }

    @Override
    public String daily(DeviceDTO deviceDTO) {
        List<BusinessDevice> businessDeviceEntities = businessDeviceMapper.selectAllPaging(deviceDTO);
        StringBuffer result = new StringBuffer();
        for (BusinessDevice businessDeviceEntity : businessDeviceEntities) {
            result.append(StringUtils.outStr("\t", businessDeviceEntity.getOneLevelName(), businessDeviceEntity.getTwoLevelName(), businessDeviceEntity.getManageName(), businessDeviceEntity.getAddress(), businessDeviceEntity.getPublicIp(), businessDeviceEntity.getIp(), businessDeviceEntity.getRemark())).append("\n");
        }
        JSONObject returnResult = new JSONObject();
        if (ObjectUtils.isEmpty(result.toString())) {
            returnResult.put("msg", "暂时没有有问题的设备~");
            returnResult.put("existence", false);
        } else {
            returnResult.put("context", result.toString());
            returnResult.put("existence", true);
        }

        return returnResult.toJSONString();
    }

    private Map<String, Object> findSelect(List<BusinessDevice> businessDeviceEntities) {
        Map<String, Object> result = new HashMap<>();

        //一级客户名称
        Map<String, JSONObject> oneLevelName = new HashMap<>();
        //二级客户名称
        Map<String, JSONObject> twoLevelName = new HashMap<>();
        Map<String, JSONObject> manageName = new HashMap<>();
        Map<String, JSONObject> groupName = new HashMap<>();
        Map<String, JSONObject> online = new HashMap<>();
        Map<String, JSONObject> depllist = new HashMap<>();
        Map<String, JSONObject> location = new HashMap<>();
        Map<String, JSONObject> country = new HashMap<>();
        Map<String, JSONObject> city = new HashMap<>();

        for (BusinessDevice businessDeviceEntity : businessDeviceEntities) {

            putCount(oneLevelName, businessDeviceEntity.getOneLevelName());
            putCount(twoLevelName, businessDeviceEntity.getTwoLevelName());
            putCount(manageName, businessDeviceEntity.getManageName());
            putCount(groupName, businessDeviceEntity.getGroupName());
            putCount(online, businessDeviceEntity.getOnline());
            putCount(depllist, String.valueOf(businessDeviceEntity.getDepllist()));
            putCount(country, businessDeviceEntity.getCountry());
            putCount(city, businessDeviceEntity.getCity());
//            putCount(groupName, businessDeviceEntity.getGroupName());
        }

        result.put("onlines", toSelect(online));
        result.put("depllists", toSelect(depllist, new HashMap<Object, String>() {{
            put("0", "不存在");
            put("1", "存在");
        }}));
        result.put("oneLevelNames", toSelect(oneLevelName));
        result.put("twoLevelNames", toSelect(twoLevelName));
        result.put("manageNames", toSelect(manageName));
        result.put("groupNames", toSelect(groupName));
        result.put("locations", toSelect(location));
        result.put("countrys", toSelect(country));
        result.put("citys", toSelect(city));
        return result;
    }


    /**
     * 添加并计数
     *
     * @param oneLevelName
     */
    void putCount(Map<String, JSONObject> data, String oneLevelName) {
//        Integer num = data.get(levelName);
        oneLevelName = ObjectUtils.notIsEmpty(oneLevelName) ? oneLevelName : "未知";
        JSONObject jsonObject;
        if (data.containsKey(oneLevelName)) {
            jsonObject = data.get(oneLevelName);
            jsonObject.put("num", jsonObject.getInteger("num") + 1);
        } else {
            jsonObject = new JSONObject();
            jsonObject.put("num", 1);
            data.put(oneLevelName, jsonObject);
        }
    }


    public List<Select> toSelect(Map<String, JSONObject> oneLevelName) {
        return toSelect(oneLevelName, null);
    }

    public List<Select> toSelect(Map<String, JSONObject> oneLevelName, Map<Object, String> aliasM) {

        List<Select> selects = new ArrayList<>();
        for (Object o : oneLevelName.keySet().toArray()) {
            List<Select> son = null;
            if (oneLevelName.get(o).containsKey("son")) {
                Map<String, JSONObject> data = (Map<String, JSONObject>) oneLevelName.get(o).get("son");
                son = toSelect(data, aliasM);
            }
            selects.add(new Select(null == o ? "未知" : (null == aliasM ? o : aliasM.get(o)) + " 【" + oneLevelName.get(o).get("num") + "】", (String) o, son));
        }
        return selects;
    }

    @Override
    public void insertOrUpdate(BusinessDevice device) {
        if (StringUtils.isEmpty(device.getAddress())) {
            return;
        }
        device.setStatus(1);
        String address = businessDeviceMapper.findAddressByAddress(device.getAddress());
        if (StringUtils.notIsEmpty(address)) {
            device.setUpdateTime(new Date());
            businessDeviceMapper.updateByAddress(device);
        } else {
            device.setImportDataTime(new Date());
            businessDeviceMapper.insertSelective(device);
        }
    }

    @Override
    public int updateByAddress(BusinessDevice updated) {
        return businessDeviceMapper.updateByAddress(updated);
    }

    @Override
    public void insertOrUpdate(List<BusinessDevice> devices) {
        for (BusinessDevice device : devices) {
            insertOrUpdate(device);
        }
    }

    @Override
    public List<String> findAll() {
        return businessDeviceMapper.findAll();
    }

    @Override
    public List<String> findErrDevices(String showCol) {
        return businessDeviceMapper.selectAddressByDepllistAndOnlineAndTotal24h(showCol);
    }

    @Override
    public void updateDepllist(List<BusinessDevice> devices) {
        Map<Object, List<Object>> obgM = JSONUtils.classify(devices, "depllist", "address");

        for (Object o : obgM.keySet().toArray()) {
            businessDeviceMapper.updateDepllistByAddress(ObjectUtils.notIsEmpty(o) ? (Integer) o : null, BeanUtils.toJavaObject(obgM.get(o), new TypeReference<List<String>>() {
            }));
        }
    }

    @Override
    public void updateTotal24h(List<BusinessDevice> devices) {
        Map<Object, List<Object>> obgM = JSONUtils.classify(devices, "total24h", "address");

        for (Object o : obgM.keySet().toArray()) {
            businessDeviceMapper.updateTotal24hByAddress((BigDecimal) o, BeanUtils.toJavaObject(obgM.get(o), new TypeReference<List<String>>() {
            }));
        }
    }

    @SneakyThrows
    @Override
    public void importData(MultipartFile file) {
        businessDeviceMapper.clear();
        EasyExcel.read(file.getInputStream(), HotspottyData.class, new HotspottyDataListener(this)).sheet(1).doRead();
    }

    @Override
    @Async("updateDeviceInfoTask")
    public void updateDeviceInfoTask(Map<String, String> makersDictionary, List<List<String>> lists, int index) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        Device device = null;
        BusinessDevice deviceEntity = null;
        String address = null;

        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
            if (ObjectUtils.notIsEmpty(address)) {

                device = (Device) new CounterUtil() {
                    @Override
                    public boolean check(Object execute) {
                        return execute == null;
                    }

                    @Override
                    public Object execute(Object data) throws Exception {
                        return heliumApi.getHotspotsByAddress((String) data);
                    }
                }.run(address);
                deviceEntity = new BusinessDevice();
                deviceEntity.setAddress(address);
                if (ObjectUtils.notIsEmpty(device)) {
                    deviceEntity.setName(device.getName().replaceAll("-", " "));
                    deviceEntity.setOnline(device.getStatus().getOnline());
                    deviceEntity.setCountry(device.getGeocode().getLong_country());
                    deviceEntity.setCity(StringUtils.outStr(" ", device.getGeocode().getLong_city(), device.getGeocode().getLong_state()));
                    deviceEntity.setStreet(device.getGeocode().getLong_street());
                    deviceEntity.setHex(device.getLocation_hex());
                    deviceEntity.setOwner(device.getOwner());
                    deviceEntity.setScale(device.getReward_scale());
                    deviceEntity.setPingpai(makersDictionary.get(device.getPayer()));
                } else {
                    deviceEntity.setOnline("404");
                }

                log.info("【updateByAddress】{}", JSON.toJSONString(deviceEntity));
                businessDeviceMapper.updateByAddress(deviceEntity);
            }
        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

    @Override
    @Async("updateDeviceProfitInfoTask")
    public void updateDeviceProfitInfoTask(List<List<String>> lists, int index) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        List<BusinessDevice> devices = new ArrayList<>();

        BusinessDevice deviceEntity;
        String address;
        Double hotspotsTotal;
        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
            if (ObjectUtils.notIsEmpty(address)) {
                hotspotsTotal = (Double) new CounterUtil() {
                    @Override
                    public boolean check(Object execute) {
                        return execute == null;
                    }

                    @Override
                    public Object execute(Object data) throws Exception {
                        return heliumApi.getHotspotsTotal(2, (String) data);
                    }
                }.run(address);

                deviceEntity = new BusinessDevice();
                deviceEntity.setAddress(address);

                if (ObjectUtils.notIsEmpty(hotspotsTotal)) {
                    deviceEntity.setTotal24h(hotspotsTotal);
                } else {
                    deviceEntity.setTotal24h(null);
                }

                devices.add(deviceEntity);
            }
        }

        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));
        updateTotal24h(devices);

    }

    @Override
    @Async("updateDevicedeBlackListInfoTask")
    public void updateDevicedeBlackListInfoTask(List<List<String>> lists, int index) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        BusinessDevice device;
        String address = null;

        List<BusinessDevice> devices = new ArrayList<>();

        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
            if (ObjectUtils.notIsEmpty(address)) {
                device = new BusinessDevice();
                device.setAddress(address);
                Boolean denylistB = (Boolean) new CounterUtil() {
                    @Override
                    public boolean check(Object execute) {
                        return execute == null;
                    }

                    @Override
                    public Object execute(Object data) throws Exception {
                        return heliumApi.denylist((String) data);
                    }
                }.run(address);
                device.setDepllist(ObjectUtils.notIsEmpty(denylistB) ? (denylistB ? 1 : 0) : null);
                devices.add(device);
            }
        }
        updateDepllist(devices);
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{} {}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now), JSON.toJSONString(devices));

    }

    @Override
    @Async("taskExecutor")
    public void updateDevicedeBlackListInfo(String filePath, List<List<String>> lists, int index) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String address = null;

        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
            if (ObjectUtils.notIsEmpty(address)) {
                Boolean denylistB = (Boolean) new CounterUtil() {
                    @Override
                    public boolean check(Object execute) {
                        return execute == null;
                    }

                    @Override
                    public Object execute(Object data) throws MsgException {
                        return heliumApi.denylist((String) data);
                    }
                }.run(address);

                if (ObjectUtils.notIsEmpty(denylistB)) {
                    FileUtils.writeln(filePath + "denylist.csv", StringUtils.outStr(",", address, denylistB), true, true);
                } else {
                    FileUtils.writeln(filePath + "err", StringUtils.outStr(",", address, denylistB), true, true);
                }
            }
        }

        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));
    }


    @Override
    @Async("taskExecutor")
    public void getDevice(Map<String, String> makersDictionary, Map<String, String> ownerNo, List<List<String>> lists, int index, String filePath) throws MsgException {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String address = null;
        boolean de = false;
        double hotspotsTotal = 0;
        JSONObject cl;
        String clJson = "";
        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
//            FileUtils.writeln(filePath, HeliumUtils.dashboard(cityid), true, i != 0);
            Device device = null;
            try {
                device = heliumApi.getHotspotsByAddress(address);
                log.info("device {}", device);
                de = heliumApi.denylist(address);
                hotspotsTotal = HeliumUtils.getHotspotsTotal(2, address);
                cl = new HeliumHttpUtils().client(address);

                clJson = "";
                if (ObjectUtils.notIsEmpty(cl)) {
                    clJson = StringUtils.outStr("\t", JSONUtils.jsGetData(cl, "client.usesig"), JSONUtils.jsGetData(cl, "client.group"));
                } else {
                    clJson = StringUtils.outStr("\t", "", "");
                }

                if (ObjectUtils.notIsEmpty(ownerNo)) {
                    // 对应钱包序号
                    FileUtils.writeln(filePath, StringUtils.outStr("\t", address, makersDictionary.get(device.getPayer()), de, clJson, device.getName().replaceAll("-", " "), device.getOwner(), ownerNo.get(device.getOwner()), device.getStatus().getOnline(), device.getStatus().getIp(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), hotspotsTotal, device.getLat(), device.getLng(), device.getLocation_hex(), ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""), true, true);
                } else {
//                    System.out.println(device.getPayer());
//                    log.info("device:{}", device);
                    // 基础
                    FileUtils.writeln(filePath, StringUtils.outStr("\t",
                                    address,
                                    makersDictionary.get(device.getPayer()),
                                    de,
                                    clJson,
                                    device.getName().replaceAll("-", " "),
                                    device.getOwner(), device.getStatus().getOnline(),
                                    device.getStatus().getIp(), device.getGeocode().getLong_country(),
                                    device.getGeocode().getLong_city(), hotspotsTotal,
                                    device.getLat(), device.getLng(), device.getLocation_hex(),
                                    ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""),
                            true, true);

                }
                //  FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, device.getName().replaceAll("-", " "), device.getOwner(), device.getStatus().getOnline(), device.getStatus().getIp(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), hotspotsTotal, device.getLat(), device.getLng(), device.getLocation_hex(), ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""), true, true);

//                FileUtils.writeln(filePath, StringUtils.outStr(",", address, device.getLat(), device.getLng()), true, true);
            } catch (Exception e) {
                log.error("没有找到设备 " + address, e);
                FileUtils.writeln(filePath, address + "\t找不到设备", true, true);
            }

        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

    @SneakyThrows
    @Async("taskExecutor")
    public void addHeliumGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String cityid = null;

        for (int i = 0; i < addresss.size(); i++) {
            cityid = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d条信息 查询参数：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
            globalDeviceService.addHeliumDevice(heliumApi.getHotspotsByCities(cityid), null);
        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}条信息 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

    @SneakyThrows
    @Async("taskExecutor")
    public void addHeliumGlobalDevicev2(List<List<String>> lists, int index, String filePath) throws MsgException {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String cursor = null;

        for (int i = 0; i < addresss.size(); i++) {
            cursor = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d条信息 查询参数：%s", addresss.hashCode(), index, addresss.size(), i, cursor));
            RestBean restBean = heliumApi.getAllDevice(cursor);
            if (ObjectUtils.isEmpty(AllCus.keys)) {
                AllCus.keys = JSONUtils.toCsvTitle(filePath, restBean.getData().get(0).toGlobalDevice(cursor));
            }
            for (Device datum : restBean.getData()) {
                JSONUtils.toCsv(filePath, datum.toGlobalDevice(cursor), AllCus.keys);
            }
            globalDeviceService.addNetHeliumDevice(cursor);
        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}条信息 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

    @SneakyThrows
    @Async("taskExecutor")
    public void dashboard(List<List<String>> lists, int index, String filePath) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        String address = null;

        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
//            FileUtils.writeln(filePath, HeliumUtils.dashboard(cityid), true, i != 0);

            try {

                FileUtils.writeln(filePath, HeliumUtils.dashboard(address), true, true);
            } catch (MsgException e) {
                log.error("没有找到设备 " + address, e);
            }

        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

//    @Override
//    public int deleteByPrimaryKey(Long id) {
//        return businessDeviceMapper.deleteByPrimaryKey(id);
//    }

    @Override
    public int insert(BusinessDevice record) {
        return businessDeviceMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessDevice record) {
        return businessDeviceMapper.insertSelective(record);
    }

//    @Override
//    public BusinessDevice selectByPrimaryKey(Long id) {
//        return businessDeviceMapper.selectByPrimaryKey(id);
//    }

    @Override
    public int updateByPrimaryKeySelective(BusinessDevice record) {
        return businessDeviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessDevice record) {
        return businessDeviceMapper.updateByPrimaryKey(record);
    }

}











