package com.just.learn.basic.concurrent;

import org.junit.Test;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-04-22 19:05
 **/
public class SynchronizedTest {
    @Test
    public void test() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.set();
        synchronizedDemo.get();
    }

    @Test
    public void test2() {
        synchronized (SynchronizedDemo.class){
            System.out.println("xxx");
        }
    }

}

