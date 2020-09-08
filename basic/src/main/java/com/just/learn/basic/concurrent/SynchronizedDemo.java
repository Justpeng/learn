package com.just.learn.basic.concurrent;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-04-22 19:05
 **/
public class SynchronizedDemo {
    long count = 1;

    public synchronized long get() {
        return count;
    }

    public synchronized void set() {
        count++;
    }
}

