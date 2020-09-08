package com.just.learn.basic.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-18 11:12
 **/
public class PerformanceHandler implements InvocationHandler {

    /**
     * 代理对象的真实对象
     */
    private final Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(proxy.getClass().getName() + "." + method.getName());
        Object object = method.invoke(target, args);
        PerformanceMonitor.end();
        return object;
    }
}
