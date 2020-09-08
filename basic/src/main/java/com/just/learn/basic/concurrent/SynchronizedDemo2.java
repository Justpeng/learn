package com.just.learn.basic.concurrent;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-04-22 19:05
 **/
public class SynchronizedDemo2 {
    static long count = 1;

    public synchronized static long get() {
        return count;
    }

    public synchronized static void set() {
        count++;
    }
}

