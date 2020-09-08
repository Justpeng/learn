package com.just.learn.basic.proxy.dynamic;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 10:59
 **/
public class PerformanceRecord {
    private String methodName;

    private long beginTime;

    public PerformanceRecord(String methodName) {
        this.methodName = methodName;
        this.beginTime = System.currentTimeMillis();
    }

    public void print() {
        System.out.println("耗时,time:" + (System.currentTimeMillis() - beginTime));
    }
}
