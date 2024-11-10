package io.renren.common.gitUtils.http;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.JSONUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    protected static final Log logger = LogFactory.getLog(FileUtils.class);
    static boolean exceptionThrow = false;


    public static void write(String filePath, String context) throws MsgException {
        createTxt(filePath);
        try {
            org.apache.commons.io.FileUtils.write(getFile(filePath), context, "UTF-8", false);
        } catch (IOException e) {
            throw new MsgException(e.getMessage());
        }
    }

    public static void writeln(String filePath, String context, boolean notExistCreateFile, boolean append) {
        createTxt(filePath);
        write(filePath, context + "\n", notExistCreateFile, append);
    }

    public static void write(String filePath, String context, boolean notExistCreateFile, boolean append) {
        try {
            org.apache.commons.io.FileUtils.write(getFile(filePath), context, "UTF-8", append);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static JSONObject readJSONO(String filePath) throws MsgException {
        return JSONUtils.toJSONObject(readLine(filePath));
    }

    /**
     * 读取文本
     *
     * @param filePath 文件路径
     * @return
     */
    public static String readLine(String filePath) {
        List<String> strings = readLines(filePath);
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            sb.append(string);
        }
        if (ObjectUtils.notIsEmpty(sb.toString())) {
            return sb.toString();
        }
        return "";
    }

    public static List<String> readLines(String filePath) {
        List<String> strings = null;
        try {
            strings = org.apache.commons.io.FileUtils.readLines(getFile(filePath), "UTF-8");
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
//        logger.info("strings:\t" + JSON.toJSONString(strings));
//        logger.info("strings:\t" + strings.size());
        return strings;
    }

    static boolean isFile(String filePath) {
        return indexOfNum(filePath, ".") >= 1;
    }

    public static Integer indexOfNum(String originStr, String targetStr) {
        int res = 0;

        int i = originStr.indexOf(targetStr);

        while (i != -1) {
            i = originStr.indexOf(targetStr, i + 1);
            res++;
        }
        return res;

    }

    /**
     * 获取文件
     * @param filePath 文件路径
     * @return 文件
     */
    public static File getFile(String filePath) {
        return getFile(filePath, true);
    }

    /**
     * 获取文件
     *
     * @param filePath           文件 路径
     * @param notExistCreateFile 不存在创建文件
     * @return 文件
     */
    public static File getFile(String filePath, boolean notExistCreateFile) {
        File file = new File(filePath);
//        System.out.println(file.getPath());
//        System.out.println(file.getParentFile().getParentFile().getParentFile());
        if (file.exists()) {
            return file;
        } else {
            exceptionPromptThrown("文件不存在");
        }

        // 新建文件
        if (notExistCreateFile) {
            if (isFile(filePath)) {
                try {
                    if (!file.createNewFile()) {
                        throw new IllegalArgumentException("创建文件失败！");
                    }
                } catch (IOException e) {
                    throw new IllegalArgumentException("IO异常~ " + e.getMessage());
                }
            } else {
                if (!file.mkdir()) {
                    throw new IllegalArgumentException("创建文件失败！");
                }
            }
        }
        return file;
    }


    public static void exceptionPromptThrown(String msg) {
        if (exceptionThrow) {
            throw new IllegalArgumentException(msg);
        } else {
            logger.info(msg);
        }
    }


    public static void createTxt(String path) {
        if(new File(path).exists()) {
            return;
        }
        path = path.replaceAll("\\\\", "/");
        String[] files = path.split("/");
        String createFilder = "";
        for (int i = 0; i < files.length; i++) {

            if (i == (files.length - 1)) {
                new File(createFilder).mkdirs();
                try {
                    System.out.println("\t" + createFilder + files[i]);
                    new File(createFilder += files[i]).createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                createFilder += files[i] + "/";
            }
            System.out.println(createFilder);
        }
    }

//    public static void main(String[] args) {
//        createTxt("../data\\asdasd/asd");
//    }

}
