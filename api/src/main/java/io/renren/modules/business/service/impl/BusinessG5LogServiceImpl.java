package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.utils.R;
import io.renren.modules.business.dto.G5LogDTO;
import io.renren.modules.business.dto.RadiosDTO;
import io.renren.modules.business.entity.BusinessRadio;
import io.renren.modules.business.service.BusinessGatewayService;
import io.renren.modules.business.service.BusinessRadioService;
import io.renren.modules.business.service.MongoTemplateService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.renren.modules.business.entity.BusinessG5Log;
import io.renren.modules.business.dao.BusinessG5LogMapper;
import io.renren.modules.business.service.BusinessG5LogService;

import java.util.*;

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
        Date now  = new Date();
        if (ObjectUtils.notIsEmpty(g5LogDTO.getGatewayid())) {
            g5LogDTO.setNow(now);
            mongoTemplateService.insert(g5LogDTO);
            gatewayService.insertOrUpdateSelective(g5LogDTO.toBusinessGateway());
            List<BusinessG5Log> g5Logs = new ArrayList<>();
            g5Logs.add(g5LogDTO.toBusinessG5Log());
            List<String> radioIds = radioService.selectRadioIdByGatewayId(g5LogDTO.getGatewayid());

            if (ObjectUtils.notIsEmpty(g5LogDTO.getRadios())) {
                for (RadiosDTO radio : g5LogDTO.getRadios()) {
                    radioIds.remove(radio.getSid());
                    radioService.selectRadioIdByGatewayId(1, radio.getSid());
                    radioService.insertOrUpdateSelective(radio.toBusinessRadio(g5LogDTO.getGatewayid()));
                    g5Logs.addAll(radio.toBusinessG5Log(now, 2, 3));
                }
            }

            if(ObjectUtils.notIsEmpty(radioIds) && radioIds.size() > 0){
                radioService.selectRadioIdByGatewayId(0, BeanUtils.toJavaObject(radioIds, new TypeReference<String[]>(){{}}));
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
        JSONObject jsonObject;
        switch (typeId){
            case 1:
                jsonObject = selectAllByIdAndTypeId(id, 1, now);

                r.put("data1", jsonObject.values().toArray());
                r.put("dataKey", jsonObject.keySet().toArray());
                break;
            case 2:
                jsonObject = selectAllByIdAndTypeId(id, 2, now);
                r.put("data1", jsonObject.values().toArray());
                r.put("dataKey", jsonObject.keySet().toArray());
                jsonObject = selectAllByIdAndTypeId(id, 3, now);
                r.put("data2", jsonObject.values().toArray());

                break;
        }

        return r;
    }


    JSONObject selectAllByIdAndTypeId(String id, Integer typeId, Date now){

        List<BusinessG5Log> g5Logs = businessG5LogMapper.selectAllByIdAndTypeIdAndCreateTime(id,  now, typeId);

        JSONObject jsonObject = new JSONObject();
        List<Integer> a = new ArrayList<>();
        for (BusinessG5Log g5Log : g5Logs) {
            jsonObject.put(DateUtils.asStr(7, g5Log.getCreateTime()), g5Log.getStatus() ? 1 : -1);
        }

        return jsonObject;
    }
}



