package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.dto.G5LogDTO;
import io.renren.modules.business.dto.RadiosDTO;
import io.renren.modules.business.service.BusinessGatewayService;
import io.renren.modules.business.service.BusinessRadioService;
import io.renren.modules.business.service.MongoTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import io.renren.modules.business.entity.BusinessG5Log;
import io.renren.modules.business.dao.BusinessG5LogMapper;
import io.renren.modules.business.service.BusinessG5LogService;

import java.util.*;

@Slf4j
@Service
public class BusinessG5LogServiceImpl implements BusinessG5LogService {

    @Resource
    private BusinessG5LogMapper businessG5LogMapper;

    final
    MongoTemplateService mongoTemplateService;

    final
    BusinessGatewayService gatewayService;

    final
    BusinessRadioService radioService;

    public BusinessG5LogServiceImpl(MongoTemplateService mongoTemplateService, BusinessGatewayService gatewayService, BusinessRadioService radioService) {
        this.mongoTemplateService = mongoTemplateService;
        this.gatewayService = gatewayService;
        this.radioService = radioService;
    }

    @Override
    public int deleteByPrimaryKey(Long g5LogId) {
        return businessG5LogMapper.deleteByPrimaryKey(g5LogId);
    }

    @Override
    public int insert(BusinessG5Log record) {
        return businessG5LogMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessG5Log record) {
        return businessG5LogMapper.insertSelective(record);
    }

    @Override
    public BusinessG5Log selectByPrimaryKey(Long g5LogId) {
        return businessG5LogMapper.selectByPrimaryKey(g5LogId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessG5Log record) {
        return businessG5LogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessG5Log record) {
        return businessG5LogMapper.updateByPrimaryKey(record);
    }

    @Override
    public void log(G5LogDTO g5LogDTO) {
        mongoTemplateService.insert(g5LogDTO);
        if (ObjectUtils.notIsEmpty(g5LogDTO.getGatewayid()) && !"Unkown".equals(g5LogDTO.getGatewayid())) {
            Date now = new Date();
            g5LogDTO.setNow(now);
            gatewayService.insertOrUpdateSelective(g5LogDTO.toBusinessGateway());
            List<BusinessG5Log> g5Logs = new ArrayList<>();
            g5Logs.addAll(g5LogDTO.toBusinessG5Log(now, 1));
            List<String> radioIds = radioService.selectRadioIdByGatewayId(g5LogDTO.getGatewayid());

            if (ObjectUtils.notIsEmpty(g5LogDTO.getRadios())) {
                for (RadiosDTO radio : g5LogDTO.getRadios()) {
                    radioIds.remove(radio.getSid());
//                    radioService.updateStatusByRadioId(radio.getOnair() ? 1 : 0, radio.getSid());
                    radioService.insertOrUpdateSelective(radio.toBusinessRadio(g5LogDTO.getGatewayid()));
                    g5Logs.addAll(radio.toBusinessG5Log(now, 2, 3, 4));
                }
            }

            if (ObjectUtils.notIsEmpty(radioIds) && radioIds.size() > 0) {
                radioService.updateStatusByRadioId(0, BeanUtils.toJavaObject(radioIds, new TypeReference<String[]>() {{
                }}));
            }
            batchInsert(g5Logs);
        } else {
            throw new IllegalArgumentException("gatewayid不能为空～");
        }
    }

    @Override
    public int batchInsert(List<BusinessG5Log> list) {
        return businessG5LogMapper.batchInsert(list);
    }

    @Override
    public R getById(String id, Integer typeId) {

        Date now = new Date();
        R r = new R();
        Map<Integer, String> typeMap = new HashMap<>();
        switch (typeId) {
            case 1:
                typeMap = G5LogDTO.radioType;
                break;
            case 2:
                typeMap = RadiosDTO.radioType;
                break;
        }
        List<BusinessG5Log> g5Logs;

        List<Integer> integers = BeanUtils.toJavaObject(typeMap.keySet().toArray(), new TypeReference<List<Integer>>() {{
        }});
        for (int i = 0; i < integers.size(); i++) {
//            g5Logs = selectAllByIdAndTypeId(id, integers.get(i), now);
            g5Logs = businessG5LogMapper.selectAllByIdAndTypeIdAndCreateTime(id, now, integers.get(i));
            log.info("g5Logs:{}", BeanUtils.toJSON(g5Logs));

            if (i == 0) {
                List<String> dataKeys = new ArrayList<>();
                for (BusinessG5Log g5Log : g5Logs) {
                    dataKeys.add(DateUtils.asStr(7, g5Log.getCreateTime()));
                }
                r.put("dataKey", dataKeys);
            }
            List<Integer> dataVals = new ArrayList<>();
            for (BusinessG5Log g5Log : g5Logs) {
                dataVals.add( g5Log.getStatus() ? 1 : -1);
            }
            r.put(typeMap.get(integers.get(i)), dataVals);
        }
        r.put("dataCol", typeMap.values().toArray());
        return r;
    }


//    List<BusinessG5Log> selectAllByIdAndTypeId(String id, Integer typeId, Date now) {
//
//        List<BusinessG5Log> g5Logs = businessG5LogMapper.selectAllByIdAndTypeIdAndCreateTime(id, now, typeId);
//
//        return g5Logs;
//    }
}



