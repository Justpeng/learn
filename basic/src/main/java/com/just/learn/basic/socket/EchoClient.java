package com.just.learn.basic.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 18:37
 **/
@Slf4j
public class EchoClient {

    public static void main(String[] ar) throws  Exception {
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("localhost", 1111);
            pw = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            log.error("client端异常", e);
        }
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            pw.println(userInput);
            System.out.println(bufferedReader.readLine());
        }
        pw.close();
        bufferedReader.close();
        socket.close();
    }
}
