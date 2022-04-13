package io.renren.modules.business.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.utils.R;
import io.renren.importData.HotspottyData;
import io.renren.importData.HotspottyDataListener;
import io.renren.modules.business.dao.Select;
import io.renren.modules.domain.dto.DeviceDTO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
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


@Slf4j
@Service("businessDeviceService")
public class BusinessDeviceServiceImpl extends ServiceImpl<BusinessDeviceDao, BusinessDeviceEntity> implements BusinessDeviceService {

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
    public int updateByAddress(BusinessDeviceEntity updated){
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

    @Override
    public void deviceDataRefresh(Integer startIndex, Integer endIndex) {
        List<String> addresss = baseMapper.findAll();
        updateData(addresss);
    }

    @Override
    @Async("taskExecutor")
    public void updateData(List<String> addresss) {
        Device device = null;
        BusinessDeviceEntity deviceEntity = null;
        String address = null;

        for (int i = 0; i < addresss.size(); i++) {
            address = addresss.get(i);
            System.out.println(String.format("【Size】：%s/%d/%d/%s", addresss.hashCode(), addresss.size(), i, addresss.get(i)));
            if (address.substring(0, 2).equals("11") && ObjectUtils.notIsEmpty(address)) {

                try {
                    device = HeliumUtils.getHotspotsByAddress(address);
                    deviceEntity = device.toDBDeviceEntity();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(ObjectUtils.isEmpty(device) || ObjectUtils.isEmpty(deviceEntity)){
                    deviceEntity = new BusinessDeviceEntity();
                    deviceEntity.setAddress(address);
                    deviceEntity.setErrStatus(1);
                    deviceEntity.setUpdateTime(new Date());
                }else{
                    deviceEntity.setErrStatus(0);
                }
                deviceEntity.setAddress(address);
                try {
                    deviceEntity.setTotal24h(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
                } catch (Exception e) {
                    deviceEntity.setErrStatus(2);
                    log.error("【setTotal24h失败~】"+address, e);
                    e.printStackTrace();
                }
                try {
                    deviceEntity.setDepllist(HeliumUtils.denylist(device.getAddress()) ? 1 : 0);
                } catch (Exception e) {
                    deviceEntity.setErrStatus(3);
                    e.printStackTrace();
                }

                baseMapper.updateByAddress(deviceEntity);
                device = null;
            }
        }
    }

    @SneakyThrows
    @Override
    public void importData(MultipartFile file) {
        baseMapper.clear();
        EasyExcel.read(file.getInputStream(), HotspottyData.class, new HotspottyDataListener(this)).sheet(1).doRead();
    }

}



