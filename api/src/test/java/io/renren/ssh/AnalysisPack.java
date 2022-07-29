package io.renren.ssh;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.ssh.entity.AnsibleError;
import io.renren.ssh.entity.AnsiblePack;
import lombok.SneakyThrows;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: autossh
 * @ClassName AnalysisPack
 * @description: 解析包
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-25 16:04
 * @Version 1.0
 **/
public class AnalysisPack {

    // 查找ansible关键符号
    static String ansibleStartStr = " | ";
    static String ansibleStartRegex = ansibleStartStr.replaceAll("\\|", "\\\\|");

    /**
     * @throws
     * @title 解析ansible数据
     * @description
     * @author Mr.Lv lvzhuozhuang@foxmail.com
     * @updateTime 2022/7/25 17:24
     */
    @SneakyThrows
    public static List<AnsiblePack> ansible(String data) {
        String[] lines = data.split("\n");

        List<AnsiblePack> ansiblePacks = new ArrayList<>();
        AnsiblePack ansiblePack = null;
        String result = "";

        for (String line : lines) {
            // 查找ansible关键符号
            int i = line.indexOf(ansibleStartStr);
            if (-1 != i) {
                if (null != ansiblePack) {
                    if (ObjectUtils.notIsEmpty(ansiblePack.getRc())) {
                        ansiblePack.setResult(result);
                    } else {
                        ansiblePack.setError(BeanUtils.toJavaObject(result, new TypeReference<AnsibleError>() {{
                        }}));
                    }

                    ansiblePacks.add(ansiblePack);
                }
                String[] cols = line.split(ansibleStartRegex);
                result = "";
                switch (cols.length) {
                    case 2:
                        ansiblePack = new AnsiblePack(cols[0], cols[1].replaceAll("! => \\{", ""));
                        result += "{";
                        break;
                    case 3:
                        ansiblePack = new AnsiblePack(cols[0], cols[1], ObjectUtils.toInt(cols[2].replaceAll("rc=| >>", "")));
                        break;
                }
            } else {
                result += line;
            }
        }

        return ansiblePacks;
    }

    public void classification(List<AnsiblePack> ansiblePacks) {
        List<AnsiblePack> errAnsiblePacks = new ArrayList<>();
        List<AnsiblePack> okAnsiblePacks = new ArrayList<>();

        for (AnsiblePack ansiblePack : ansiblePacks) {
            switch (ansiblePack.getRc()) {
                case 0:
                    okAnsiblePacks.add(ansiblePack);
                    break;
                default:
                    errAnsiblePacks.add(ansiblePack);
                    break;
            }
        }

        Map<String, List<AnsiblePack>> result = new HashMap<>();

    }


    public static void main(String[] args) {
        String result = "192.168.1.11 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\ne6129bc90616   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.4 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n19da8abf9ce1   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.127 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\na96ec1c113ec   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.184 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS       PORTS                                                                                      NAMES\n979e037f164c   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   5 days ago   Up 4 hours   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.0.55 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED       STATUS       PORTS     NAMES\ndb7e8ebbbb06   quay.io/team-helium/miner:miner-arm64_2022.06.09.0_GA   \"/opt/miner/bin/mine…\"   6 weeks ago   Up 3 hours             miner\n192.168.1.89 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n8c5172796fac   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.155 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS        PORTS                                                                                      NAMES\nd2ab8dfb3e98   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   6 days ago   Up 43 hours   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.108 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n4386e561e7fa   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.195 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\nad38408d289b   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.140 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\nc984cb857305   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.144 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n883bcf7686f2   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.160 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n9455aa81ab8a   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.164 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n6bc09f4a523f   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   5 days ago   Up 5 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.42 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n8890ae474ac0   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.186 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n8d3a53f74b1c   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.95 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n60068c82792d   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.55 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\ne6425c89eb16   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.130 | UNREACHABLE! => {\n    \"changed\": false,\n    \"msg\": \"Failed to connect to the host via ssh: ssh: connect to host 192.168.1.130 port 22: No route to host\",\n    \"unreachable\": true\n}\n192.168.1.153 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\ne79aeca8ad54   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.156 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n7c3035444c3a   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.176 | CHANGED | rc=0 >>\nCONTAINER ID   IMAGE                                                   COMMAND                  CREATED      STATUS      PORTS                                                                                      NAMES\n9f72da42e75b   quay.io/team-helium/miner:miner-arm64_2022.07.14.0_GA   \"/bin/sh /opt/miner/…\"   3 days ago   Up 3 days   0.0.0.0:1680->1680/udp, :::1680->1680/udp, 0.0.0.0:44158->44158/tcp, :::44158->44158/tcp   miner\n192.168.1.196 | UNREACHABLE! => {\n    \"changed\": false,\n    \"msg\": \"Failed to connect to the host via ssh: ssh: connect to host 192.168.1.196 port 22: No route to host\",\n    \"unreachable\": true\n}\n192.168.1.191 | UNREACHABLE! => {\n    \"changed\": false,\n    \"msg\": \"Failed to connect to the host via ssh: ssh: connect to host 192.168.1.191 port 22: No route to host\",\n    \"unreachable\": true\n}\n192.168.1.172 | UNREACHABLE! => {\n    \"changed\": false,\n    \"msg\": \"Failed to connect to the host via ssh: ssh: connect to host 192.168.1.172 port 22: No route to host\",\n    \"unreachable\": true\n}\n";

        List<AnsiblePack> ansiblePacks = AnalysisPack.ansible(result.toString());

        for (AnsiblePack ansiblePack : ansiblePacks) {
            System.out.println(JSONObject.toJSONString(ansiblePack));
        }

    }
}
