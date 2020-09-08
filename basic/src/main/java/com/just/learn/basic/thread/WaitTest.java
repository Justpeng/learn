package com.just.learn.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-20 10:07
 **/
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        //object.wait();
        synchronized (object) {
            System.out.println(Thread.holdsLock(object));
            TimeUnit.SECONDS.sleep(29);
            object.wait();
        }
        System.out.println(Thread.holdsLock(object));

        Thread tread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
