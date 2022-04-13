package io.renren.abandon;

import io.renren.common.gitUtils.exception.MsgException;
import org.junit.Test;

/**
 * @program: helium-pro-new
 * @ClassName 生成配置文件
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-25 20:12
 * @Version 1.0
 **/
public class DeployProS {

    @Test
    public void run() throws MsgException {
        String groupName = "hncyb_hs_";
        Integer startIndex = 3424, groupStartIndex = 100;
        // 山猫：1680 黑豹: 1681
        int ports = 1680;
        Integer[] typeIds = new Integer[]{1, 2, 3};
        String groupStr =  "85301237fffffff\t14\n" + "8530a157fffffff\t14\n";
        String deviceTableStr =
                "192.168.10.8\t11aor4aBj8AxYXmtqgJkWBrKpB2xRCLwb8Kt8tmBoVnh339wpzd\n" +
                        "192.168.10.10\t1122MEU6SirAXirCzTTMDaE8pMXrH5kZk7CDzPhjCH5RGtsvcWYR\n" +
                        "192.168.10.11\t112MJPxDUvqQPRUgNy2SReb2qcM8eXmpUR8VstwotJAH5LTaKZJB\n" +
                        "192.168.10.24\t11SoPKK2QGahw1SL4F54RSVmWLk4XqFFSG2dPjeBE8xyzRG4BfQ\n" +
                        "192.168.10.29\t115G2RnS4epWNeJqwVNnZUAC5wZwsS9smmxw6MptcYk1r9hfGd3\n" +
                        "192.168.10.47\t112AZp88cmjr5MpmYSUWaxPMMG6Qymd5UgxhQTyGJiL8WCvDUWU3\n";

        String walletStr = "14pZy2ACtkJK3YT3ktC7EW57NeD56gKx5zAmg4X9jgJDNgxWMh8\told-key1\n" +
                "14r9um6TBWk3RGNv1d2hyFSY52tBuwBEHwVaB883P5k6M5EHjnP\told-key2\n" +
                "137v4eysWB6VUS2Dvwu6sGpg5YHHtzXP7LvZEnWMucvanuYEH26\told-key3\n" +
                "13v8F4Tq8dBXgDxCG9mY6ndioTPbpj4Qhg3MEUpyFvyWJZftRx1\told-key4\n" +
                "14KZFQ3KC6JMUrLfgBB9Vy9pQyyoNriwKWSZBMdB7GsPoy1AvM5\told-key5\n" +
                "14asR8BjCKUnywkz5EbbwLXcZM7Df6ePSTgDTREFFtbb8N23YVY\told-key6\n" +
                "13zxtGin7zJZVysHAyhibihHGDVSnNbSDEAEdWWwHxo4Uzxyf6i\told-key7\n";

        new DeployPro(startIndex, groupStartIndex).
                run(groupName, ports, deviceTableStr, typeIds, groupStr, walletStr);
    }
}
