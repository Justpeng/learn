package com.just.learn.basic.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 18:15
 **/
@Slf4j
public class EchoServer {
    public static void main(String[] args)  {
        ServerSocket ss  = null;
        PrintWriter pw;
        BufferedReader br;
        try {
            ss = new ServerSocket(1111);
        } catch (Exception e) {
            log.error("serverSocket error", e);
        }
        Socket incoming;
        while (true) {
            try {
                incoming = ss.accept();
                pw = new PrintWriter(incoming.getOutputStream(), true);
                //先将字节流转换为字符流，之后将字符流放入缓存之中
                br = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                //提示
                pw.println("Hello!");
                pw.println("Enter BYE to exit");
                pw.flush();
                while (true) {
                    //用户输入时，才返回数据
                    String str = br.readLine();
                    if (str == null) {
                        break;
                    }else {
                        pw.println("Echo:" + str);
                        pw.flush();
                        //退出命令
                        if ("BYE".equalsIgnoreCase(str.trim())) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
//        pw.close();
//        br.close();
//        incoming.close();
//        ss.close();

    }
}
