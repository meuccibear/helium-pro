/*
 * Copyright (C) 2017 Zhejiang BYCDAO Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.bycdao.com.
 * Developer Web Site: http://open.bycdao.com.
 */

package io.renren.modules.business.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.renren.business.domin.RestMessage;
import io.renren.business.domin.UploadModel;
import io.renren.common.gitUtils.CSVUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/09/04 21:19
 */
@Api(value = "文件上传", tags = "文件上传")
@Controller
@RequestMapping("/api/upload")
public class UploadController {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    static Map<String, Integer> colIndex = null;
    static List<String> cols = new ArrayList<String>() {{
        add("key");
        add("id");
        add("ip");
        add("hostpotId");
        add("earningsToday");
        add("earningsYesterday");
        add("gap");
        add("score");
        add("nat");
        add("temp");
        add("gain");
    }};

    private List<Map> upload(HttpServletRequest request, MultipartFile[] files) {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File realFile = new File(realPath);
        if (!realFile.exists()) {
            realFile.mkdirs();
        }
        List<Map> uploadFiles = CollectionUtil.newArrayList();
        System.out.println("进入图片上传接口:" + files.length + "张");
        for (MultipartFile file : files) {
            File targetFile = new File(realFile, file.getOriginalFilename());
            FileOutputStream fileOutputStream = null;
            InputStream ins = null;
            try {
                fileOutputStream = new FileOutputStream(targetFile);
                int i = -1;
                byte[] bytes = new byte[1024 * 1024];
                ins = file.getInputStream();
                while ((i = ins.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, i);
                }
            } catch (IOException e) {
            } finally {
                closeQuilty(ins);
                closeQuilty(fileOutputStream);
            }
            Map fileInfo = new HashMap();
            fileInfo.put("id", UUID.randomUUID().toString());
            fileInfo.put("url", targetFile.getPath());
            fileInfo.put("original_name", targetFile.getName());
            uploadFiles.add(fileInfo);
        }
        return uploadFiles;
    }


    @Order(value = 3)
    @ApiOperation(value = "多文件MultipartFile上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file[]", value = "文件流对象,接收数组格式", required = true, dataType = "MultipartFile", allowMultiple = true),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial(@RequestParam(value = "file[]", required = true) MultipartFile[] files, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<Map> uploadFiles = upload(request, files);
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    @Order(value = 2)
    @ApiOperation(value = "单文件File上传22")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "__file"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial22", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial22(@RequestParam(value = "file", required = true) MultipartFile file, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<MultipartFile> a = CollectionUtil.newArrayList();
        a.add(file);
        List<Map> uploadFiles = upload(request, a.toArray(new MultipartFile[]{}));
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    @Order(value = 2)
    @ApiOperation(value = "单文件File上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "__File"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial2", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial2(@RequestParam(value = "file", required = true) MultipartFile file, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<MultipartFile> a = CollectionUtil.newArrayList();
        a.add(file);
        List<Map> uploadFiles = upload(request, a.toArray(new MultipartFile[]{}));
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    /**
     * 读取设备部信息
     *
     * @param inputStream 文件流
     * @return
     * @throws MsgException
     */
    public void getDevicesData(InputStream inputStream) throws MsgException {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<List<String>> table = CSVUtils.readCSV(reader, 15);

        logger.info(JSON.toJSONString(table));
        initColIndex(table.get(0));
        JSONObject jsonObject;
//        DeviceBean deviceBean;
        List<String> strings = null;

        String key;
        Integer index;
        for (int i = 1; i < table.size(); i++) {
            strings = table.get(i);
            logger.info(JSON.toJSONString(strings));
            jsonObject = new JSONObject();
            for (int j = 0; j < cols.size(); j++) {
                key = cols.get(j);
                index = getColIndex(key);
                if (ObjectUtils.notIsEmpty(index)) {
                    String data = strings.get(index);
                    System.out.println("==="+key + "\t" + data);
                    switch (key) {
                        case "temp":
                            String result = "";
                            for (char c : data.toCharArray()) {
                                int charIndex = (int)c;
                                if(charIndex >= 48 && charIndex <= 57 || charIndex == 46){
                                    result +=c ;
                                }
                            }
//                            data = data.replaceAll(" °C", "");
                            data = result;
                            break;
                        case "gap":
                            data = data.replaceAll("-", "");
                            break;
                    }
                    System.out.println(key + "\t" + data);
                    jsonObject.put(key, data);
                } else {
                    System.out.println("没找到:\t" + key + " "+ index);

                }
            }
//            info("实体类JSON:\t" + jsonObject.toJSONString());
//            deviceBean = BeanUtils.mergeObjects(DeviceBean.class, jsonObject);
//            deviceBeans.add(deviceBean);
        }
//        return deviceBeans;
    }

    public Integer getColIndex(String key) {
//        info(JSON.toJSONString(colIndex)+" 找 " + key);

        if (ObjectUtils.isEmpty(colIndex)) {
            return null;
        }

        Integer result = colIndex.get(key);
        if(ObjectUtils.isEmpty(result)){
            result = colIndex.get(key.toLowerCase());
        }
        return result;
    }

    public void initColIndex(List<String> tableCols) {
//        info("列名:\t" + JSON.toJSONString(tableCols));

        colIndex = new HashMap<>();
        String key;
        Integer index ;
        for (int i = 0; i < tableCols.size(); i++) {
            key = tableCols.get(i).toLowerCase();
            colIndex.put(key, i);
        }

        colIndex.put("earningsToday", 6);
        colIndex.put("earningsYesterday", 12);
//        colIndex.put("hostpotId", 4);
//        info("列名：下标:\t" + JSON.toJSONString(colIndex) + "\n\n");

    }

    @Order(value = 2)
    @ApiOperation(value = "单文件File上传-noArg")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", paramType = "form", required = true, dataType = "__File"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial4", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial3(@RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        /*List<MultipartFile> a=Lists.newArrayList();
        a.add(file);
        List<Map> uploadFiles= upload(request,a.toArray(new MultipartFile[]{}));
        RestMessage rm=new RestMessage();
        rm.setData(uploadFiles);
        return rm;*/
        return null;
    }

    @Order(value = 2)
    @ApiOperation(value = "多文件File上传")
    @ApiImplicitParams({@ApiImplicitParam(name = "file[]", value = "文件流对象,接收数组格式", required = true, dataType = "__File", allowMultiple = true),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial1", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial1(@RequestParam(value = "file[]", required = true) MultipartFile[] files, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        List<Map> uploadFiles = upload(request, files);
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }

    private void closeQuilty(InputStream ins) {
        if (ins != null) {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void closeQuilty(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
