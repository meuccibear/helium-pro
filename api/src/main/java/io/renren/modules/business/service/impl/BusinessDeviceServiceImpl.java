package io.renren.modules.business.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.utils.R;
import io.renren.importData.HotspottyData;
import io.renren.importData.HotspottyDataListener;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.service.MakersService;
import io.renren.modules.domain.dto.DeviceDTO;
import io.renren.modules.helium.HeliumHttpUtils;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.api.domain.CorpseUtil;
import io.renren.modules.sys.entity.SourceCorpse;
import io.renren.modules.sys.service.GlobalDeviceService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessDeviceDao;
import io.renren.modules.business.entity.BusinessDeviceEntity;
import io.renren.modules.business.service.BusinessDeviceService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Slf4j
@Service("businessDeviceService")
public class BusinessDeviceServiceImpl extends ServiceImpl<BusinessDeviceDao, BusinessDeviceEntity> implements BusinessDeviceService {

    @Resource
    HeliumApi heliumApi;

    @Autowired
    CorpseUtil corpseUtil;

    @Autowired
    GlobalDeviceService globalDeviceService;

    @Autowired
    HeliumHttpUtils heliumHttpUtils;

    @Resource
    MakersService makersService;


    @Override
    public Map<String, Object> findSelect(DeviceDTO deviceDTO) {
        Map<String, Object> selectMap = new HashMap<>();
        selectMap.put("onlines", baseMapper.findSelect(deviceDTO, 1));
        selectMap.put("depllist", baseMapper.findSelect(deviceDTO, 2));
        return selectMap;
    }

    @Override
    public R getAll(DeviceDTO deviceDTO) {
        List<BusinessDeviceEntity> businessDeviceEntities = baseMapper.selectAllPaging(deviceDTO);
        List<BusinessDeviceEntity> deviceEntities = baseMapper.selectFilterable(deviceDTO);

        PageRRVO pageUtils = PageRRVO.build(deviceDTO, businessDeviceEntities, deviceEntities.size());
        R r = R.ok();
        r.put("page", pageUtils);
        r.putAll(findSelect(deviceEntities));
        return r;
    }

    private Map<String, Object> findSelect(List<BusinessDeviceEntity> businessDeviceEntities) {
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

        for (BusinessDeviceEntity businessDeviceEntity : businessDeviceEntities) {

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


    void putCount(Map<String, JSONObject> data, String oneLevelName, String twoLevelName) {
        oneLevelName = ObjectUtils.notIsEmpty(oneLevelName) ? oneLevelName : "未知";
        twoLevelName = ObjectUtils.notIsEmpty(twoLevelName) ? twoLevelName : "未知";

        putCount(data, oneLevelName);
        JSONObject jsonObject = data.get(oneLevelName);
        if (jsonObject.containsKey("son")) {
            Map<String, JSONObject> sonData = (Map<String, JSONObject>) jsonObject.get("son");
            putCount(sonData, twoLevelName);
        } else {
            Map<String, JSONObject> sonData = new HashMap<>();
            putCount(sonData, twoLevelName);
            jsonObject.put("son", sonData);
        }
    }

    /**
     * 添加并计数
     *
     * @param oneLevelName
     * @param levelName
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
    public PageUtils queryPage(Map<String, Object> params) {
        String oneLevelName = (String) params.get("one_level_name");
        String twoLevelName = (String) params.get("two_level_name");
        String key = (String) params.get("key");
        IPage<BusinessDeviceEntity> page = this.page(
                new Query<BusinessDeviceEntity>().getPage(params),
                new QueryWrapper<BusinessDeviceEntity>()
                        .and(wrapper -> wrapper.eq(ObjectUtils.notIsEmpty(oneLevelName), "one_level_name", oneLevelName)
                                .or(ObjectUtils.notIsEmpty(twoLevelName), wrapper1 -> wrapper1.eq("two_level_name", twoLevelName))
                        )
                        .and(ObjectUtils.notIsEmpty(key), wrapper -> wrapper.eq("one_level_name", key)
                                .or(wrapper1 -> wrapper1.eq("two_level_name", key))
                        )
        );

        return new PageUtils(page);
    }


    @Override
    public void insertOrUpdate(BusinessDeviceEntity device) {
        if (StringUtils.isEmpty(device.getAddress())) {
            return;
        }
        device.setStatus(1);
        String address = baseMapper.findAddressByAddress(device.getAddress());
        if (StringUtils.notIsEmpty(address)) {
            device.setUpdateTime(new Date());
            baseMapper.updateByAddress(device);
        } else {
            device.setImportDataTime(new Date());
            baseMapper.insertSelective(device);
        }
    }

    @Override
    public int updateByAddress(BusinessDeviceEntity updated) {
        return baseMapper.updateByAddress(updated);
    }


    @Override
    public void insertOrUpdate(List<BusinessDeviceEntity> devices) {
        for (BusinessDeviceEntity device : devices) {
            insertOrUpdate(device);
        }
    }

    @Override
    public List<String> findAll() {
        return baseMapper.findAll();
    }


    @SneakyThrows
    @Override
    public void importData(MultipartFile file) {
        baseMapper.clear();
        EasyExcel.read(file.getInputStream(), HotspottyData.class, new HotspottyDataListener(this)).sheet(1).doRead();
    }


    @Override
    @Async("taskExecutor")
    public void updateData(List<List<String>> lists, int index) {
        List<String> addresss = lists.get(index);
        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));

        LocalDateTime now = LocalDateTime.now();
        Device device = null;
        BusinessDeviceEntity deviceEntity = null;
        String address = null;
        BusinessDeviceEntity businessDeviceEntity;
        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
//            if (address.substring(0, 2).equals("11") && ObjectUtils.notIsEmpty(address)) {
            if (ObjectUtils.notIsEmpty(address)) {
                try {
                    device = heliumApi.getHotspotsByAddress(address);
                    if (ObjectUtils.notIsEmpty(device)) {
                        businessDeviceEntity = new BusinessDeviceEntity();
                        businessDeviceEntity.setAddress(device.getAddress());
                        businessDeviceEntity.setName(device.getName().replaceAll("-", " "));
                        businessDeviceEntity.setOnline(device.getStatus().getOnline());
                        businessDeviceEntity.setCountry(device.getGeocode().getLong_country());

                        businessDeviceEntity.setCity(StringUtils.outStr(" ", device.getGeocode().getLong_city(), device.getGeocode().getLong_state()));
                        businessDeviceEntity.setStreet(device.getGeocode().getLong_street());
                        businessDeviceEntity.setHex(device.getLocation_hex());
                        businessDeviceEntity.setTotal24h(device.getTotal());
                        businessDeviceEntity.setOwner(device.getOwner());
                        businessDeviceEntity.setUpdateTime(new Date());
                        businessDeviceEntity.setDepllist(device.getDepllist());
                        businessDeviceEntity.setScale(device.getReward_scale());
                        businessDeviceEntity.setPingpai(makersService.selectNameByAddress(device.getPayer()));
                        deviceEntity.setErrStatus(0);
                    } else {
                        deviceEntity = new BusinessDeviceEntity();
                        deviceEntity.setAddress(address);
                        deviceEntity.setErrStatus(1);
                        deviceEntity.setUpdateTime(new Date());
                    }
                } catch (Exception e) {
                    log.error("【getHotspotsByAddress失败~】" + address, e);
                }

                try {
                    deviceEntity.setTotal24h(heliumApi.getHotspotsTotal(2, address));
                } catch (Exception e) {
                    deviceEntity.setErrStatus(2);
                    log.error("【setTotal24h失败~】" + address, e);
                }
                try {
                    Boolean denylistB = heliumApi.denylist(address);
                    if (ObjectUtils.notIsEmpty(denylistB)) {
                        deviceEntity.setDepllist(denylistB ? 1 : 0);
                    }
                } catch (Exception e) {
                    log.error("【setDepllist失败~】" + address, e);
                    deviceEntity.setErrStatus(3);
                }

                log.info("【updateByAddress】{}", JSON.toJSONString(deviceEntity));
                baseMapper.updateByAddress(deviceEntity);
                device = null;
            }
        }
        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));

    }

//    @Override
//    @Async("taskExecutor")
//    public void updateData1(List<List<String>> lists, int index, String filePath) {
//        List<String> addresss = lists.get(index);
//        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));
//
//        LocalDateTime now = LocalDateTime.now();
//        String cityid = null;
//
//        for (int i = 0; i < addresss.size(); i++) {
//            cityid = addresss.get(i);
//            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d个设备信息 设备地址：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
//
//            try {
//                List<Device> devices = heliumApi.getHotspotsByCities(cityid);
//                List<SourceCorpse> sourceCorpses = corpseUtil.checkDevice(devices, 5);
//                for (SourceCorpse sourceCorps : sourceCorpses) {
//                    FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                                    sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                                    sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)),
//                            true, true);
//                }
//            } catch (MsgException | URISyntaxException e) {
//                log.error("[findCorpseS]", e);
//            }
//        }
//        log.info("任务结束：hash值：{} 线程序号：{} 查询{}台设备 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));
//
//    }


    @Override
    @Async("taskExecutor")
    public void getDevice(Map<String, String> ownerNo, List<List<String>> lists, int index, String filePath) throws MsgException {
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
                de = heliumApi.denylist(address);
                hotspotsTotal = HeliumUtils.getHotspotsTotal(2, address);
                cl = heliumHttpUtils.client(address);

                clJson = "";
                if (ObjectUtils.notIsEmpty(cl)) {
                    clJson = StringUtils.outStr("\t", JSONUtils.jsGetData(cl, "client.usesig"), JSONUtils.jsGetData(cl, "client.cname"));
                } else {
                    clJson = StringUtils.outStr("\t", "", "");
                }

                if (ObjectUtils.notIsEmpty(ownerNo)) {
                    // 对应钱包序号
                    FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, clJson, device.getName().replaceAll("-", " "), device.getOwner(), ownerNo.get(device.getOwner()), device.getStatus().getOnline(), device.getStatus().getIp(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), hotspotsTotal, device.getLat(), device.getLng(), device.getLocation_hex(), ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""), true, true);
                } else {
                    // 基础
                    FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, clJson, device.getName().replaceAll("-", " "), device.getOwner(), device.getStatus().getOnline(), device.getStatus().getIp(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), hotspotsTotal, device.getLat(), device.getLng(), device.getLocation_hex(), ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""), true, true);
                }
                //  FileUtils.writeln(filePath, StringUtils.outStr("\t", address, de, device.getName().replaceAll("-", " "), device.getOwner(), device.getStatus().getOnline(), device.getStatus().getIp(), device.getGeocode().getLong_country(), device.getGeocode().getLong_city(), hotspotsTotal, device.getLat(), device.getLng(), device.getLocation_hex(), ObjectUtils.notIsEmpty(device.getLocation_hex()) ? HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5) : ""), true, true);

//                FileUtils.writeln(filePath, StringUtils.outStr(",", address, device.getLat(), device.getLng()), true, true);
            } catch (MsgException e) {
                log.error("没有找到设备 " + address, e);
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

//    @SneakyThrows
//    @Async("taskExecutor")
//    public void addHotspottyGlobalDevice(List<List<String>> lists, int index, String filePath) throws MsgException {
////        getCHexsByHex(hex, 5)
//        List<String> addresss = lists.get(index);
//        log.info(String.format("开始执行任务：hash值：%s 线程序号：%d任务量：%d", addresss.hashCode(), index, addresss.size()));
//
//        LocalDateTime now = LocalDateTime.now();
//        String cityid = null;
//
//        for (int i = 0; i < addresss.size(); i++) {
//            cityid = addresss.get(i);
//            log.info(String.format("hash值：%s 线程序号：%d任务量：%d 开始查询第%d条信息 查询参数：%s", addresss.hashCode(), index, addresss.size(), i, addresss.get(i)));
//
//            List<LeanData> leanDataL = HeliumUtils.getCHexsByHex(cityid, 5);
//            globalDeviceService.addHotspottyDevice(heliumApi.getHotspotsByCities(cityid));
//        }
//        log.info("任务结束：hash值：{} 线程序号：{} 查询{}条信息 所消耗的时间{}", addresss.hashCode(), index, addresss.size(), DateUtils.calculationTimeConsuming(now));
//
//    }

}



