package io.renren.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.api.domain.CorpseUtil;
import io.renren.modules.sys.entity.SourceCorpse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.sys.dao.GlobalDeviceMapper;
import io.renren.modules.sys.entity.GlobalDevice;
import io.renren.modules.sys.service.GlobalDeviceService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GlobalDeviceServiceImpl implements GlobalDeviceService {

    @Resource
    HeliumApi heliumApi;

    @Autowired
    CorpseUtil corpseUtil;

    @Resource
    private GlobalDeviceMapper globalDeviceMapper;

    @Override
    public int deleteByPrimaryKey(String address) {
        return globalDeviceMapper.deleteByPrimaryKey(address);
    }

    @Override
    public int insert(GlobalDevice record) {
//        log.info(JSON.toJSONString(record));
        return globalDeviceMapper.insert(record);
    }

    @Override
    public int insertSelective(GlobalDevice record) {
        return globalDeviceMapper.insertSelective(record);
    }

    @Override
    public GlobalDevice selectByPrimaryKey(String address) {
        return globalDeviceMapper.selectByPrimaryKey(address);
    }

    @Override
    public int updateByPrimaryKeySelective(GlobalDevice record) {
        return globalDeviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GlobalDevice record) {
        return globalDeviceMapper.updateByPrimaryKey(record);
    }


    @Override
    public void insertOrUpdate(GlobalDevice record) {
        GlobalDevice globalDevice = selectByPrimaryKey(record.getAddress());
        if (ObjectUtils.isEmpty(globalDevice)) {
            record.setCreateTime(new Date());
            insert(record);
        } else {
            record.setUpdateTime(new Date());
            updateByPrimaryKey(record);
        }
    }

    @Override
    public void addHeliumDevice(List<Device> devices, String cursor) {
        if (ObjectUtils.notIsEmpty(devices)) {
            for (Device device : devices) {
                insertOrUpdate(device.toGlobalDevice(cursor));
            }
        }
    }

    @Override
    public List<SourceCorpse> findsourceCorpses5ByLongCountry(String longCountry, String filePath) throws MsgException {
        List<String> hex5s = globalDeviceMapper.selectHex5ByLongCountry(longCountry);
        List<SourceCorpse> sourceCorpses = new ArrayList<>();
        for (String hex5 : hex5s) {
            List<SourceCorpse> sourceCorpses1 = corpseUtil.checkGlobalDevice(globalDeviceMapper.findAllByHex5(hex5), 5);
            sourceCorpses.addAll(sourceCorpses1);
            for (SourceCorpse sourceCorps : sourceCorpses1) {
                FileUtils.writeln(filePath, StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCount(),
                                sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
                                sourceCorps.getCountry(), sourceCorps.getCityId(), sourceCorps.getAddress(),
                                sourceCorps.getBottomScanle(), sourceCorps.getCity(), (sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8))),
                        true, true);
//                log.info(StringUtils.outStr("\t", sourceCorps.getHex(), sourceCorps.getCityId(), sourceCorps.getAddress(),
//                        sourceCorps.getBottomScanle(), sourceCorps.getCount(), sourceCorps.getOfflinecount(), sourceCorps.getOnlinecount(),
//                        sourceCorps.getCountry(), sourceCorps.getCity(), sourceCorps.getOfflinecount() / (sourceCorps.getCount() + 8)));
            }
        }

        return sourceCorpses;
    }

    @Override
    public List<String> selectHex5ByLongCountry(String longCountry) {
        return globalDeviceMapper.selectHex5ByLongCountry(longCountry);
    }


    @Override
    public String addNetHeliumDevice(String cursor) throws MsgException {
        RestBean restBean = heliumApi.getAllDevice(cursor);
        addHeliumDevice(restBean.getData(), cursor);
        return restBean.getCursor();
    }


//    @Override
//    public void addHotspottyDevice(List<LeanData> leanDataList) {
//        if(ObjectUtils.notIsEmpty(leanDataList)){
//            for (LeanData leanData : leanDataList) {
//                insertOrUpdate(leanData.toGlobalDevice());
//            }
//        }
//    }

}


