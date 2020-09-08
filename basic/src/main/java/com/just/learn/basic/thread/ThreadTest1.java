package com.just.learn.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-19 09:53
 **/
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("xxxxx");
            }
        });

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("yyyyy");
            }
        });
        //同步
        thread.run();
        thread1.run();
        //异步
        //thread.start();
        //thread1.start();
        for (int j = 0; j < 100; j++) {
            System.out.println("mmmmmm");
        }
    }
}
