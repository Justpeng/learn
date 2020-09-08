package com.just.learn.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-19 10:26
 **/
public class CountDownLatchTest {

    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>() {});

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Runnable runnable = ()->{
                try {
                    System.out.println("xxx" + finalI);
                    TimeUnit.SECONDS.sleep(10);
                    countDownLatch.countDown();
                    System.out.println("xxx" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            threadPool.execute(runnable);
        }
    }
}
