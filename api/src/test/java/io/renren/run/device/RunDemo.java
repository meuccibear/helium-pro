package io.renren.run.device;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.*;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.modules.business.service.BusinessDeviceService;
import io.renren.modules.helium.HexUtils;
import io.renren.modules.helium.domain.deviceConfig.activity.RestBean;
import io.renren.modules.sys.api.HeliumApi;
import io.renren.modules.sys.entity.GlobalDevice;
import io.renren.modules.sys.entity.WholeNetworkDevice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

import io.renren.modules.helium.domain.Device;


/**
 * @program: helium-pro-new
 * @ClassName RunDemo
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-09-20 01:00
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@EnableAsync
public class RunDemo {

    @Resource
    HeliumApi heliumApi;

    @Resource
    BusinessDeviceService businessDeviceService;

    @Test
    public void getNetworkDevice() {
        new NetworkDevice(heliumApi).run("eyJoZWlnaHQiOjE1MzM3MjksImZpbHRlcl9tb2RlcyI6WyJmdWxsIiwibGlnaHQiLCJkYXRhb25seSJdLCJiZWZvcmVfYmxvY2siOjEyMTQ1OTksImJlZm9yZV9hZGRyZXNzIjoiMTFKN0w4Z1hLVk43TlMxOWphcDN0RFFCaHVuTUQ3WmRnOE5wS0RQTlllZ2p1TFptNEh6In0", 21);
    }

    String PATH = "F:\\tmp\\last";


    @Test
    public void getDevice() {
        String path = PATH + "\\%d.txt";
        String outPath = PATH + "\\" + new Date().getTime() + "\\%s";
        List<String> lines;
        Device device;
        String line;
        Map<String, JSONObject> h5Map = new HashMap<>();
        String h5;
        String address;
        JSONObject jsonObject;
        for (int i = 1; i <= 47; i++) {
            try {
                lines = FileUtils.readLines(String.format(path, i));
                for (int i1 = 0; i1 < lines.size(); i1++) {
                    line = lines.get(i1);

                    if (StringUtils.notIsEmpty(line)) {
                        device = BeanUtils.toJavaObject(line, new TypeReference<Device>() {{
                        }});

                        if (StringUtils.notIsEmpty(device.getLocation_hex())) {
                            h5 = HexUtils.h3.h3ToParentAddress(device.getLocation_hex(), 5);
                            if (h5Map.containsKey(h5)) {
                                jsonObject = h5Map.get(h5);

                                if (jsonObject.containsKey(device.getStatus().getOnline())) {
                                    jsonObject.put(device.getStatus().getOnline(), jsonObject.getInteger(device.getStatus().getOnline()) + 1);
                                } else {
                                    jsonObject.put(device.getStatus().getOnline(), 1);
                                }

                                h5Map.put(h5, jsonObject);
                            } else {
                                jsonObject = new JSONObject();
                                jsonObject.put("device", device);
                                if (jsonObject.containsKey(device.getStatus().getOnline())) {
                                    jsonObject.put(device.getStatus().getOnline(), jsonObject.getInteger(device.getStatus().getOnline()) + 1);
                                } else {
                                    jsonObject.put(device.getStatus().getOnline(), 1);
                                }
                                h5Map.put(h5, jsonObject);
                            }

                            if (ObjectUtils.notIsEmpty(device.getGeocode())) {
                                address = StringUtils.outStr("\t", device.getGeocode().getLong_country(), device.getGeocode().getLong_state(), device.getGeocode().getLong_city());
                            } else {
                                address = "\t\t";
                            }

                            FileUtils.writeln(String.format(outPath, "hex.csv"), StringUtils.outStr(",", device.getAddress(), device.getPayer(), device.getOwner(), address, device.getStatus().getOnline(), h5), true, true);
                            FileUtils.writeln(String.format(outPath, "address.txt"), device.getAddress(), true, true);

                        } else {
                            FileUtils.writeln(String.format(outPath, "notHex.txt"), JSON.toJSONString(device), true, true);
                        }
                    }
                }
            } catch (MsgException e) {
                log.error(String.format("%d 读取文件错误~~"), e);
            }
        }

        JSONObject keyJson;
        int offline = 0;
        int online = 0;

        for (Object s : h5Map.keySet().toArray()) {
            keyJson = h5Map.get((String) s);
            online = keyJson.containsKey("online") ? keyJson.getInteger("online") : 0;
            offline = keyJson.containsKey("offline") ? keyJson.getInteger("offline") : 0;
            device = BeanUtils.toJavaObject(keyJson.getJSONObject("device"), new TypeReference<Device>() {{
            }});

            try {
                FileUtils.writeln(String.format(outPath, "h5.txt"), StringUtils.outStr("\t", s, device.getAddress(), device.getGeocode().getLong_country(), device.getGeocode().getLong_state(), device.getGeocode().getLong_city(), online, offline), true, true);
            } catch (MsgException e) {
                log.error("写入数据失败~", e);
            }
        }

    }


    @Test
    public void asd() throws MsgException {
        List<List<String>> lists = BeanUtils.toJavaObject(ObjectUtils.averageAssignPartition(FileUtils.readLines(PATH + "\\1663634602567\\address.txt"), 200), new TypeReference<List<List<String>>>() {{}});

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) {
                businessDeviceService.updateDevicedeBlackListInfo(PATH + "\\", lists, i);
            }
        }
    }


    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void pullDevice() {
        String path = PATH + "\\%d.txt";
        List<String> lines;
        io.renren.run.device.Device device;
        String line;

        for (int i = 1; i <= 47; i++) {
            try {
                lines = FileUtils.readLines(String.format(path, i));
                for (int i1 = 0; i1 < lines.size(); i1++) {
                    line = lines.get(i1);

                    if (StringUtils.notIsEmpty(line)) {
                        device = BeanUtils.toJavaObject(line, new TypeReference<io.renren.run.device.Device>() {{
                        }});

                        mongoTemplate.insert(device);

                    }
                }
            } catch (MsgException e) {
                log.error(String.format("%d 读取文件错误~~"), e);
            }
        }
    }


    @SneakyThrows
    @Test
    public void getCursor() {
        List<String> strings = FileUtils.readLines("F:\\tmp\\last\\cursor.txt");
        String[] arr;
        Cursor cursor;

        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(" ");
            if (arr.length == 2) {
                System.out.println(arr[1]);
                cursor = BeanUtils.mergeObjects(Cursor.class, Base64Utils.baseConvertStr(arr[1]));
                cursor.setId(strings.size() - i);
                cursor.setCursor(arr[1]);
                mongoTemplate.insert(cursor);
            }
        }

        mongoTemplate.query(Cursor.class);

//        catch (MsgException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



    public void mongodb(){
        List<Cursor> data = mongoTemplate.findAll(Cursor.class);

        MultithreadingUtil<Cursor> multithreadingUtil = new MultithreadingUtil<Cursor>(200) {

            List<Cursor> err = new ArrayList<>();

            @Override
            public void execute(Cursor data) {

                RestBean restBean = (RestBean) new CounterUtil() {
                    @Override
                    public boolean check(Object execute) {
                        return execute == null;
                    }

                    @Override
                    public Object execute(Object data) throws MsgException {
                        return heliumApi.getAllDevice((String) data);
                    }
                }.run(data.getCursor());

                if (null == restBean || null == restBean.getData() || restBean.getData().size() == 0) {
                    err.add(data);
                }
                for (Device device : restBean.getData()) {
//                    device.setUpdateTime(new Date());
                    WholeNetworkDevice wholeNetworkDevice = device.toWholeNetworkDevice(data.getCursor());
                    mongoTemplate.insert(wholeNetworkDevice);
                }
            }
        };

        multithreadingUtil.run(data);
    }







}
