package io.renren.abandon;

import io.renren.common.gitUtils.exception.MsgException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: helium-pro-new
 * @ClassName 生成配置文件
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-25 20:12
 * @Version 1.0
 **/
public class Deploy3 {

    @Test
    public void run() throws MsgException {

        String[] groupStr = new String[]
                {
                        "8540a1affffffff\t11&8540a1affffff22\t11\n" + "85409463fffffff\t11\n",
                        "8530b02ffffffff\t7\n" + "8530b077fffffff\t7"
                };

        String[] deviceTableStr = new String[]
            {
                "192.168.88.88\t112gYVKQccx2nH2e2DPucDYmLaexYuaQCnrKZYYPtrc2pmhdM31o\n" ,
                "192.168.39.13\t112QuKKq96MX8FuTfzx99R62d9f3bz1rGLGbcBULM7T5WqJ6izTu\n" +
                "192.168.39.14\t11V8V7xSiNfUAq12txPY4dVKyCVoCT7BrQnmKj36ZF1xiWMXort\n"
            };


        List<GroupInfo> groupInfoList = new ArrayList<>();

        String[] inGroupStr;
        String[] lineData;
        for (int i = 0; i < groupStr.length; i++) {
            inGroupStr = groupStr[i].split("&");
            for (int i1 = 0; i1 < inGroupStr.length; i1++) {
                lineData = inGroupStr[i1].split("\t");

//                groupInfoList.add(new GroupInfo(lineData[0], null, null, null, null));
            }
        }
//        for (String s : groupStr) {
//            for (String s1 : s.split("&")) {
//                groupInfoList
//                System.out.println(s1);
//            }
//        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    class GroupInfo {
        String hex;
        String address;
        int groupIndex;
        int index;
        String groupName;
    }

}
