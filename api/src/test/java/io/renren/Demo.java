package io.renren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: helium-pro-new
 * @ClassName Demo
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-07-30 21:14
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket socket = server.accept();

                InputStreamReader in = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String content;
                System.out.println(1);

                //while ((content = br.readLine()) != null && content != ""){ //用content != ""或者不判断content是否为空，会导致阻塞
                while ((content = br.readLine()) != null && !"".equals(content)) {
                    System.out.println(content);
                }
                System.out.println(2);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type:text/html;charset=utf-8");
                String body = "hello,nio1";
                printWriter.println("Content-Length:" + body.getBytes().length);
                printWriter.println();
                printWriter.println(body);
                printWriter.close();
                socket.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
