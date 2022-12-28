package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.business.service.MongoTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @program: devops
 * @ClassName MongoTemplateServiceImpl
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-10-14 10:00
 * @Version 1.0
 **/
@Slf4j
@Component("mongoTemplateService")
public class MongoTemplateServiceImpl implements MongoTemplateService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public <T> T insert(T data) {
        try {
            return mongoTemplate.insert(data);
        } catch (
                DataAccessResourceFailureException e) {
            log.error("请打开 mongodb", e);
        }
        return null;
    }

    @Override
    public <T> T insertOrUpdate(T data) {
        try {
            T byId = findById(data);
            if(ObjectUtils.notIsEmpty(byId)){
                return mongoTemplate.save(data);
            }
            return mongoTemplate.insert(data);
        } catch (
                DataAccessResourceFailureException e) {
            log.error("请打开 mongodb", e);
        }
        return null;
    }

    @Override
    public <T> T save(T data) {
        try {
            return mongoTemplate.save(data);
        } catch (
                DataAccessResourceFailureException e) {
            log.error("请打开 mongodb", e);
        }

        return null;
    }

    @Override
    public <T> List<T> findList(Class<T> entityClass, Object... conditionS) {
        if (ObjectUtils.notIsEmpty(conditionS)) {
            Query query = new Query();
            for (int i = 0; i < conditionS.length; i++) {
                if (i % 2 == 1) {
                    query.addCriteria(Criteria.where((String) conditionS[i - 1]).is(conditionS[i]).orOperator());
                }
            }
            return mongoTemplate.find(query, entityClass);

        }
        return null;
    }


    public <T> T findOne(Class<T> entityClass, Object... conditionS) {
        if (ObjectUtils.notIsEmpty(conditionS)) {
            Query query = new Query();
            for (int i = 0; i < conditionS.length; i++) {
                if (i % 2 == 1) {
                    query.addCriteria(Criteria.where((String) conditionS[i - 1]).is(conditionS[i]));
                }
            }
            return mongoTemplate.findOne(query, entityClass);

        }
        return null;
    }

    @Override
    public <T> T find(Class<T> entityClass, String primaryKey, Object primaryValue) {
        if (ObjectUtils.notIsEmpty(primaryKey)) {
            return findOne(entityClass, new Object[]{primaryKey, primaryValue});
        }
        return null;
    }


    @Override
    public <T> T findById(T data) {
        if (ObjectUtils.notIsEmpty(data)) {
            String primaryKey = "_id";
            JSONObject jsonObject = JSONUtils.toJSONObject(data);
            if (ObjectUtils.notIsEmpty(jsonObject) && jsonObject.containsKey("_id")) {
                Query query = new Query().addCriteria(Criteria.where(primaryKey).is(jsonObject.get(primaryKey)));
                return (T) mongoTemplate.findOne(query, data.getClass());

            }
        }
        return null;
    }
}
