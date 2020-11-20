package com.just.learn.basic.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceProxy implements InvocationHandler {

    private Object subject;

    public OrderServiceProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        System.out.println("执行业务开始");
        method.invoke(subject, args);
        System.out.println("执行业务结束");
        System.out.println("代理开始结束");
        return null;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy(orderService);
        OrderService subject = (OrderService) Proxy.newProxyInstance(
                orderService.getClass().getClassLoader(), orderService.getClass().getInterfaces(), orderServiceProxy);
        subject.createOrder("a");
    }
}
