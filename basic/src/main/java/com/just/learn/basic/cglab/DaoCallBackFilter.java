package com.just.learn.basic.cglab;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 16:19
 **/
public class DaoCallBackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("insert".equalsIgnoreCase(method.getName())) {
            return 1;
        }
        return 0;
    }
}
