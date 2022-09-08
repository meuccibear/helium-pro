package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: DemoJava
 * @description:
 * @author: Zhuozhuang.Lv
 * @create: 2020-01-06 16:20
 */
@Slf4j
public class StringUtils<resultMap> {

    public static Boolean isEmpty(Object value) {
        return !notIsEmpty(value);
    }

    public static Boolean notIsEmpty(Object value) {
        if (value == null) {
            return false;
        } else if (value instanceof String) {
//            System.out.println("String");
            return ((String) value).length() > 0;
        } else if (value instanceof Integer) {
//            System.out.println("Integer");
            return (Integer) value > 0;
        }
        return true;
    }

    public static String substringSup(String str, String beginStr, String endStr) {
        beginStr = StringUtils.clearSpace(beginStr);
        endStr = StringUtils.clearSpace(endStr);
        return substringx(str, beginStr, endStr);

    }

    public static String substringx(String str, String beginStr, String endStr) {
        int beginIndex = str.indexOf(beginStr);
        if (beginIndex > -1) {
            String lastStr = str.substring(beginIndex + beginStr.length() - beginStr.length(), str.length());
//            System.out.println(lastStr);
            int lastIndex = lastStr.indexOf(endStr);
            if (StringUtils.notIsEmpty(lastIndex) && lastIndex > -1) {
                return lastStr.substring(0, lastIndex + endStr.length()).toString().replaceAll(" ", "");
            } else {
                return "";
            }
        }
        return "";
    }

    /**
     * @throws
     * @title 截取字符串高级版
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/7/25 16:33
     */
    public static String substring(String str, String beginStr, String endStr) {
        Integer beginIndex;
        String lastStr = null;
        if (beginStr != null) {
            beginIndex = str.indexOf(beginStr);

            if (beginIndex > -1) {
                lastStr = str.substring(beginIndex + beginStr.length(), str.length());
            }
        } else {
            lastStr = str;
        }

        if (null != lastStr && null != endStr) {
            int lastIndex = lastStr.indexOf(endStr);
            if (StringUtils.notIsEmpty(lastIndex) && lastIndex > -1) {
                return lastStr.substring(0, lastIndex).toString().replaceAll(" ", "");
            } else {
                return "";
            }
        }

        return "";
    }

    public static String getString(String res, String regex) {
        regex = StringUtils.clearSpace(regex);

        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern = Pattern.compile(regex);
        // 定义一个matcher用来做匹配
        Matcher matcher = pattern.matcher(res);
        // 如果找到了
        if (matcher.find()) {
            // 打印出结果
            return matcher.group(1);
        }

        return "";
    }

    public static String clearSpace(String str) {
        return str.replaceAll(" ", "");
    }

    public static boolean indexOf(String str, String indexOfStr) {
        int index = str.indexOf(".html");
        return index >= 0;
    }

    public static String toUrl(Object obj) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        Iterator<String> iterator = jsonObject.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = (String) jsonObject.get(key);
            if (StringUtils.notIsEmpty(value)) {
                stringBuilder.append(String.format("%s=%s", key, value)).append("; ");
            }
        }
        return stringBuilder.toString();
    }

    public static String outStr(String str, Object... clos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object clo : clos) {
//            if (ObjectUtils.notIsEmpty(clo)) {
                stringBuffer.append(clo);
//            }
            stringBuffer.append(str);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }


    public static void writeList(String str, Object... clos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object clo : clos) {
            stringBuffer.append(str);
            stringBuffer.append(clo);
        }
        System.out.println(stringBuffer.substring(1, stringBuffer.length()));
    }


    /**
     * @param tempStr
     * @param str
     * @return
     */
    public static String toTempStr(String tempStr, String str) {
        int num = tempStr.length() - str.length();
        return tempStr.substring(0, num) + str;
    }


    /**
     * @param groupStr
     * @return
     */
    public static List<List<String>> toTableList(String groupStr) {
        String[] vals;
        List<List<String>> table = new ArrayList<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
//            StringUtils.writeList(" ", vals);
            table.add(BeanUtils.toJavaObject(vals, new TypeReference<List<String>>() {
            }));
        }
        return table;
    }


    /**
     * @param groupStr
     * @return
     */
    public static Map<String, String> toTableMap(String groupStr) {
        String[] vals;
        Map<String, String> resultMap = new HashMap<>();
        for (String group : ArrUtils.split("\n", groupStr)) {
            vals = group.split("\t");
            if (ObjectUtils.notIsEmpty(vals)) {
                resultMap.put(vals[0], vals[1]);
            }
        }
        return resultMap;
    }

    /**
     * 省略中间字符串
     *
     * @param str 字符串
     * @return 省略的字符串
     * @eg omitMiddle(" 112oAt69WMJnMbipmESZeQ88sZSzRWi8t3AiDecdSuXnzkyBrfoh ") ==》 112oAt...yBrfoh
     */
    public static String omitMiddle(int showNum, String str) {
        return String.format("%s...%s", str.substring(0, showNum), str.substring(str.length() - showNum));
    }


    public static String formatKV(String str, Object data) {
        if (ObjectUtils.isEmpty(str) || ObjectUtils.isEmpty(data)) {
            return null;
        }
        JSONObject jsonObject = BeanUtils.toJSONObject(data);
        for (Object o : jsonObject.keySet().toArray()) {
            str = str.replaceAll(String.format("\\$\\{%s}", o), String.valueOf(jsonObject.get(o)));
        }
        return str;
    }

    public static String formatV(String str, Object... datas) {
        if (ObjectUtils.isEmpty(str) || ObjectUtils.isEmpty(datas)) {
            return str;
        }
        for (Object data : datas) {
            str = str.replace(substringx(str, "$", "}"), String.valueOf(data));
        }
        return str;
    }

    public static String formatV(String str, Map<String, Object> datas) {
        if (ObjectUtils.isEmpty(str) || ObjectUtils.isEmpty(datas)) {
            return str;
        }
        String name = "";
//        for (Object data : datas) {
        name = substringx(str, "${", "}");
        str = str.replace(name, String.valueOf(datas.get(substring(str, "${", "}"))));
//        }
        return str;
    }

    public static void main(String[] args) {
//        System.out.println(substringx("ap:12)", "ap:", ")"));
//        Map<String,Object> jsonObject = new HashMap<>();
//        jsonObject.put("name", "cursora");
//        System.out.println(formatV("我是${name}", jsonObject));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cursor", "cursora");
        System.out.println(formatKV("{ \"cursor\": \"${cursor}\" }", jsonObject.toJSONString()));


//        System.out.println(substringx("我是${name}", "$", "}"));

    }

}
