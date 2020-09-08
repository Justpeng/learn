package com.just.netty.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-07 15:53
 **/
@Slf4j
public class CoreTest {

    public void timeServerTest() {
        try {
            new TimeServer().bind(8700);
        } catch (InterruptedException e) {
            log.error("服务启动异常",e);
        }
    }



    public void timeClientTest() {
        try {
            new TimeClient().connect(8700,"127.0.0.1");
        } catch (InterruptedException e) {
            log.error("服务启动异常",e);
        }
    }




    public void echoServerTest() {

        new EchoServer().bind(8700);

    }



    public void echoClientTest() {
        try {
            new EchoClient().connect(8700,"127.0.0.1");
        } catch (InterruptedException e) {
            log.error("服务启动异常",e);
        }
    }
}
