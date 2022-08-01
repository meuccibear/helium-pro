package io.renren.run.ssh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: autossh
 * @ClassName AnsiblePack
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-25 16:02
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnsiblePack {

    private String ip;

    private String status;

    private Integer rc;

    private String result;

    private AnsibleError error;

    public AnsiblePack(String ip, String status) {
        this.ip = ip;
        this.status = status;
    }

    public AnsiblePack(String ip, String status, Integer rc) {
        this.ip = ip;
        this.status = status;
        this.rc = rc;
    }
}
