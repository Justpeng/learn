package com.just.learn.basic.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 11:04
 **/
public class OrderServiceImplDynamic implements OrderService {

    @Override
    public void addOrder() {
        try {
            System.out.println("新增模拟订单");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addByJDKProxy() {
        addOrder();
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImplDynamic();
        PerformanceHandler performanceHandler = new PerformanceHandler(new OrderServiceImplDynamic());
        OrderService proxy = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(), orderService.getClass().getInterfaces(), performanceHandler);
        proxy.addByJDKProxy();
    }
}
