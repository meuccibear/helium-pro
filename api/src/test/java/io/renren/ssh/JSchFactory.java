package io.renren.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import io.renren.ssh.entity.ServerInformation;

/**
 * @program: jsch
 * @ClassName JSchFactory
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-25 14:29
 * @Version 1.0
 **/
public class JSchFactory {

    public static Session buildSession(ServerInformation serverInformation) throws JSchException {
        return buildSession(serverInformation.getUsername(), serverInformation.getHost(), serverInformation.getPort(), serverInformation.getPasswd());
    }

    public static Session buildSession(String username, String host, int port, String passwd) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        // username and password will be given via UserInfo interface.
        session.setUserInfo(new MyUserInfo(passwd));
        return session;
    }

}
