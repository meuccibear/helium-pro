package io.renren.ssh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: jsch
 * @ClassName ServerInformation
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-25 14:32
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerInformation {

    private String username = "root";

    private String host = "117.185.91.78";

    private String passwd = "Zp19491225";

    private Integer port = 22;

}
