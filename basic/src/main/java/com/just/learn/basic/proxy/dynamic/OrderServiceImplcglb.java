package com.just.learn.basic.proxy.dynamic;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 11:04
 **/
public class OrderServiceImplcglb implements OrderService {

    @Override
    public void addOrder() {
        PerformanceMonitor.begin("addOrder");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }

    @Override
    public void addByJDKProxy() {

    }


    public static void main(String[] args) {
        PerformanceProxy performanceProxy = new PerformanceProxy();
        OrderServiceImplcglb orderServiceImplcglb = (OrderServiceImplcglb) performanceProxy.getProxy(OrderServiceImplcglb.class);
        orderServiceImplcglb.addOrder();
    }
}
