package io.renren.modules.business.service;

import java.util.List;

/**
 * @program: devops
 * @ClassName MongoTemplateService
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-10-14 10:16
 * @Version 1.0
 **/
public interface MongoTemplateService {

    <T> T insert(T data);

    <T> T insertOrUpdate(T data);

    <T> T save(T data);

    <T> List<T> findList(Class<T> entityClass, Object... conditionS);

    <T> T find(Class<T> entityClass, String primaryKey, Object primaryValue);

    <T> T findById(T data);
}
