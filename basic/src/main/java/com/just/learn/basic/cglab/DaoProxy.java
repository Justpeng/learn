package com.just.learn.basic.cglab;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 15:53
 **/
public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before daoProxy");
        methodProxy.invokeSuper(o, objects);
        System.out.println("after daoProxy");
        return o;
    }
}
