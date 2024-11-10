package io.renren.common.github;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;

import java.io.File;

public class CacheUtil {

    String savePath = "./cache/";

    public CacheUtil(String key) {
        savePath = String.format("%s/%s", savePath, key);
        FileUtils.createTxt(savePath);
    }

    public CacheUtil() {
    }

    public String getFilePath(String path) {
        return String.format("%s/%s", savePath, path);
    }

    /**
     * 保存文本
     *
     * @param path
     * @param result
     */
    public void saveResult(String path, String result) {
        try {
            FileUtils.write(getFilePath(path), result);
        } catch (MsgException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 读取文本
     *
     * @param path
     * @return
     */
    public String readResult(String path) {
        File file = new File(getFilePath(path));
        if (file.exists()) {
            return FileUtils.readLine(getFilePath(path));
        } else {
            return null;
        }

    }

}
