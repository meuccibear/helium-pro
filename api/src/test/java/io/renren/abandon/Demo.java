package io.renren.abandon;

import io.renren.common.gitUtils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @program: helium-pro-new
 * @ClassName Demo
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-21 11:20
 * @Version 1.0
 **/
//@Ignore
@Slf4j
public class Demo {
    public static void main(String[] args) {
        String groupStr =
                "";


        System.out.println(groupStr);
    }


    @Test
    public void readExcel(){
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "./demo/info2.xlsm";
        log.info("【fileName】"+ fileName);
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
//        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
//            for (DemoData demoData : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//            }
//        })).sheet("Sheet2").doRead();

        System.out.println(DateUtils.asStr(4, new Date()));

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, HotspottyData.class, new HotspottyDataListener()).sheet(1).doRead();
    }

    public static String getPath() {
        return Demo.class.getResource("/").getPath();
    }
}
