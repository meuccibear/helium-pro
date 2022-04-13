package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import io.renren.common.gitUtils.exception.MsgException;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Mr.Lv
 * @Date 2020/8/31 11:10
 */
public class JSONUtils {

    public static Object toJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return new JsonObject();
        }

        String subStr = json.substring(0, 1);
        switch (subStr) {
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
     *
     * @param jsonObject
     * @param str
     * @return
     */
    public static JSONArray getJSONArray(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");
        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if (ObjectUtils.notIsEmpty(resultData)) {
                    return resultData.getJSONArray(colNames[i]);
                } else {
                    return jsonObject.getJSONArray(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return new JSONArray();
    }

    public static Object getObjectBycol(Object data, String... keys) {
        return getObjectBycol(BeanUtils.toJSON(data), keys);
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

    public static Object get(JSONObject jsonObject, String key) {
        Object value = jsonObject.get(key);
        if (value instanceof JSONObject) {
            return (JSONObject) value;
        } else if (value instanceof Map) {
            return new JSONObject((Map) value);
        } else if (value instanceof JSONArray) {
            return (JSONArray) value;
        } else if (value instanceof List) {
            return new JSONArray((List) value);
        }
        return value;
    }


    public static void getStructure(JSONObject jsonObject, EntityStructure entityStructure) {
//        for (int i = 0; i < jsonObject.size(); i++) {
//            jsonObject.get
//        }
    }

    public static Object getJSONObject(JSONObject jsonObject, String str) throws MsgException {
        String[] colNames = str.split("\\.");
        Object resultData = jsonObject;
        Integer num = 0;
        JSONArray jsonArray;
        for (int i = 0; i < colNames.length; i++) {
            if (ObjectUtils.valueVerification("isInteger", colNames[i])) {
                jsonArray = (JSONArray) resultData;
                num = ObjectUtils.toInt(colNames[i]);
                if (null != jsonArray && num < jsonArray.size()) {
                    resultData = jsonArray.get(num);
                } else {
                    return null;
                }
            } else {
                resultData = get((JSONObject) resultData, colNames[i]);
            }
        }
        return resultData;
    }


    public static void main(String[] args) {
        String json = "{\"end_epoch\":1287370,\"start_epoch\":1287340,\"time\":1648533868,\"type\":\"rewards_v2\",\"rewards\":[{\"amount\":337194,\"type\":\"poc_challengers\",\"gateway\":\"112NiSFKmeSoWwoxu7PQQkXwYJQZVqbQkBshMuBbekfWagp4rgGh\",\"account\":\"1353qQSW2iacyi5yULP3nqGSsZdRoi82Po8ioJer2RAGnM3ufRp\"}],\"hash\":\"2ghJ843e17xfuURveN96RvTytMFUUAxOdsKihkym04U\",\"height\":1287371}";
        System.out.println(getObjectBycol(JSON.parseObject(json), ""));
    }
}
