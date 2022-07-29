package io.renren.modules.sys.service;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.helium.domain.Device;
import io.renren.modules.sys.entity.GlobalDevice;
import io.renren.modules.sys.entity.SourceCorpse;

import java.util.List;

public interface GlobalDeviceService {

    int deleteByPrimaryKey(String address);

    int insert(GlobalDevice record);

    int insertSelective(GlobalDevice record);

    GlobalDevice selectByPrimaryKey(String address);

    int updateByPrimaryKeySelective(GlobalDevice record);

    int updateByPrimaryKey(GlobalDevice record);

    void insertOrUpdate(GlobalDevice record);

    void addHeliumDevice(List<Device> devices,String cursor);

    List<SourceCorpse> findsourceCorpses5ByLongCountry(String longCountry, String filePath) throws MsgException;

    List<String> selectHex5ByLongCountry(String longCountry);

    String addNetHeliumDevice(String cursor) throws MsgException;

//    void addHotspottyDevice(List<LeanData> devices);

}


