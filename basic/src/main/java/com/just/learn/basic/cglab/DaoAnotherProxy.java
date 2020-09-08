package com.just.learn.basic.cglab;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 16:16
 **/
public class DaoAnotherProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("another,start:" + System.currentTimeMillis());
        methodProxy.invokeSuper(o, objects);
        System.out.println("another,end:" + System.currentTimeMillis());
        return o;
    }
}
