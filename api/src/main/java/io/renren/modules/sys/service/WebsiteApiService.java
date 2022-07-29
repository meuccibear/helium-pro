package io.renren.modules.sys.service;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.modules.sys.entity.WebsiteApi;
public interface WebsiteApiService  {

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteApi record);

    int insertSelective(WebsiteApi record);

    WebsiteApi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebsiteApi record);

    int updateByPrimaryKey(WebsiteApi record);


    HttpResultData sendV(String apiKey, Object... data) throws MsgException;


    HttpResultData sendKV(String apiKey, Object data) throws MsgException;


}
