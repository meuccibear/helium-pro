package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Mr.Lv
 * @Date 2020/8/31 11:10
 */
public class JSONUtils {

    public static Object toJson(String json)  {
        if(StringUtils.isEmpty(json)){
            return new JsonObject();
        }

        String subStr = json.substring(0, 1);
        switch (subStr){
            case "[":
                return JSONArray.parseArray(json);
            case "{":
                return JSONObject.parseObject(json);
            default:
                return new JsonObject();
        }

    }




    /**
     * 获取 集合
     * @param jsonObject
     * @param str
     * @return
     */
    public static JSONArray getJSONArray(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");
        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if(ObjectUtils.notIsEmpty(resultData)){
                    return resultData.getJSONArray(colNames[i]);
                }else{
                    return jsonObject.getJSONArray(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return new JSONArray();
    }



    public static Object getObjectBycol(JSONObject jsonObject, String... keys) {
        if (null != keys) {
            String key = "";
            for (int i = 0; i < keys.length; i++) {
                key = keys[i];
                if (i < keys.length) {
                    return jsonObject.get(key);
                } else {
                    jsonObject = jsonObject.getJSONObject(key);
                }
            }
        }
        return jsonObject;
    }


    public static JSONObject getJSONObject(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");

        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            resultData = jsonObject.getJSONObject(colNames[i]);
        }
        return resultData;
    }

}
