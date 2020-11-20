package com.just.learn.basic.dynamic.cglb;

import com.just.learn.basic.dynamic.OrderService;
import com.just.learn.basic.dynamic.OrderServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class OrderMethodProxy implements MethodInterceptor {
    Object subject;

    public OrderMethodProxy(Object subject) {
        this.subject = subject;
    }

    public Object createEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(subject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始");
        System.out.println("业务代码开始");
        //invokeSupper
        Object subject = methodProxy.invokeSuper(o, objects);

        System.out.println("业务代码结束");
        System.out.println("cglib动态代理结束");
        return subject;
    }

    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderMethodProxy orderMethodProxy = new OrderMethodProxy(orderService);
        OrderService subject = (OrderService) orderMethodProxy.createEnhancer();
        subject.createOrder("sss");
    }
}
