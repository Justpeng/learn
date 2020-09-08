package com.just.learn.basic.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-06-04 11:34
 **/
@Slf4j
public class ThreadPool {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
            10
            ,10,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue(200),
            r -> new Thread(r, "notice-pool"),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void runTask(Runnable runnable) {
        try {
            threadPoolExecutor.submit(runnable);
        } catch (Exception e) {
            log.error("3", e);
        }

    }
}
