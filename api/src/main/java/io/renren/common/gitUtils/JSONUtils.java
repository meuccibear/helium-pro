package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.JsonObject;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Mr.Lv
 * @Date 2020/8/31 11:10
 */
@Slf4j
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
//    public static JSONArray jsGetData(JSONObject jsonObject, String str) {
//        String[] colNames = str.split("\\.");
//        JSONObject resultData = null;
//        for (int i = 0; i < colNames.length; i++) {
//            if (i + 1 == colNames.length) {
//                if (ObjectUtils.notIsEmpty(resultData)) {
//                    return resultData.getJSONArray(colNames[i]);
//                } else {
//                    return jsonObject.getJSONArray(colNames[i]);
//                }
//            } else {
//                resultData = jsonObject.getJSONObject(colNames[i]);
//            }
//        }
//        return new JSONArray();
//    }

    /**
     * 数组方式获取参数
     * @param data
     * @param keys
     * @return
     */
//    public static Object jsGetData(Object data, String... keys) {
//        return jsGetData(BeanUtils.toJSONObject(data), keys);
//    }
//
//    /**
//     * 数组方式获取参数
//     * @param jsonObject
//     * @param keys
//     * @return
//     */
//    public static Object jsGetData(JSONObject jsonObject, String... keys) {
//        if (null != keys) {
//            String key = "";
//            for (int i = 0; i < keys.length; i++) {
//                key = keys[i];
//                if (i < keys.length) {
//                    return jsonObject.get(key);
//                } else {
//                    jsonObject = jsonObject.getJSONObject(key);
//                }
//            }
//        }
//        return jsonObject;
//    }


    /**
     * js方式获取参数
     *
     * @param jsonObject
     * @param str
     * @return
     * @throws MsgException
     */
    public static Object jsGetData(Object jsonObject, String str) {
        if (!(jsonObject instanceof Map) && ObjectUtils.notIsEmpty(jsonObject)) {
            jsonObject = BeanUtils.toJSONObject(jsonObject);
        }

        String[] colNames = str.split("\\.");
        Object resultData = jsonObject;
        Integer num = 0;
        JSONArray jsonArray;
        for (int i = 0; i < colNames.length; i++) {
            if (ObjectUtils.valueVerification("isInteger", colNames[i])) {
                jsonArray = (JSONArray) resultData;
                try {
                    num = ObjectUtils.toInt(colNames[i]);
                } catch (MsgException e) {
                    num = 0;
                    log.warn("toInt()错误！！！");
                }
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

    public static Object get(JSONObject jsonObject, String key) {
        if (ObjectUtils.isEmpty(jsonObject)) {
            return null;
        }
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

    public static void toCsv(String filePath, Object... datas) {
        if (ObjectUtils.notIsEmpty(datas)) {
            List<String> keys = toCsvTitle(filePath, datas[0]);
            for (Object data : datas) {
                toCsv(filePath, data, keys);
            }
        }
    }

    public static List<String> toCsvTitle(String filePath, Object data) {
        JSONObject jsonObject = BeanUtils.toJSONObject(data);
        List<String> keys = BeanUtils.toJavaObject(jsonObject.keySet().toArray(), new TypeReference<List<String>>() {{
        }});
        log.info("keys:{}", JSONObject.toJSONString(keys));
        FileUtils.writeln(filePath + ".csv", StringUtils.outStr(",", keys.toArray()), true, false);
        return keys;
    }

    public static void toCsv(String filePath, Object data, List<String> keys) {
        List<Object> values = new ArrayList<>();
        JSONObject jsonObject = BeanUtils.toJSONObject(data);
        for (String key : keys) {
            values.add(jsonObject.get(key));
        }

        FileUtils.writeln(filePath + ".csv", StringUtils.outStr(",", values.toArray()), true, true);

    }

    public static void main(String[] args) throws MsgException {
        String json = "{\"end_epoch\":1287370,\"start_epoch\":1287340,\"time\":1648533868,\"type\":\"rewards_v2\",\"rewards\":[{\"amount\":337194,\"type\":\"poc_challengers\",\"gateway\":\"112NiSFKmeSoWwoxu7PQQkXwYJQZVqbQkBshMuBbekfWagp4rgGh\",\"account\":\"1353qQSW2iacyi5yULP3nqGSsZdRoi82Po8ioJer2RAGnM3ufRp\"}],\"hash\":\"2ghJ843e17xfuURveN96RvTytMFUUAxOdsKihkym04U\",\"height\":1287371}";
        toCsv("./asd", BeanUtils.toJSONObject(json));
    }

    public static Map<Object, List<Object>> classify(List list, String keyColName, String valueColName) {
        JSONArray jsonArray = BeanUtils.toJSONArray(list);


        JSONObject jsonObject;
        Object key;
        Object value;

        Map<Object, List<Object>> obgM = new HashMap<>();
        List<Object> businessDevices;
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            key = jsonObject.get(keyColName);
            value = jsonObject.get(valueColName);
            if (obgM.containsKey(key)) {
                businessDevices = obgM.get(key);
                businessDevices.add(value);
            } else {
                businessDevices = new ArrayList<>();
                businessDevices.add(value);
                obgM.put(key, businessDevices);
            }
        }
        return obgM;
    }
}
