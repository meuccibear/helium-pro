package io.renren.run;

import com.jcraft.jsch.Session;
import io.renren.common.utils.SSHLinuxUtils;
import org.junit.Test;

import static io.renren.common.gitUtils.http.HttpUtilsx.userName;

/**
 * @program: helium-pro-new
 * @ClassName SSH
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-20 17:24
 * @Version 1.0
 **/

public class SSH {

    @Test
    public void run() throws Exception {

        String host = "183.194.69.182";
        Integer port = 22;
        String userName = "root";
        String password = "Zp19491225";
        Session session =SSHLinuxUtils.createSession(host ,port ,userName ,password);
        try {
            SSHLinuxUtils.exeCommand(session, "cd / && ps" );
        } catch (Exception e){
            if(session != null){
                session.disconnect();
            }
        }
    }

}
