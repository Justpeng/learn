package com.just.learn.basic.proxy.dynamic;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 10:58
 **/
public class PerformanceMonitor {

    private static ThreadLocal<PerformanceRecord> recordThreadLocal = new ThreadLocal<>();


    public static void begin(String method) {
        PerformanceRecord record = new PerformanceRecord(method);
        System.out.println("监控新增订单");
        recordThreadLocal.set(record);
    }

    public static void end() {
        System.out.println("监控结束");
        recordThreadLocal.get().print();
    }
}
