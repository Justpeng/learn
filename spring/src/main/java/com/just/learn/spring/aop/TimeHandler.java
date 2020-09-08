package com.just.learn.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 11:43
 **/
@Slf4j
public class TimeHandler {
    public void printTime(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();

            System.out.println(method + "方法执行开始时间：" + System.currentTimeMillis());

            try {
                proceedingJoinPoint.proceed();
                System.out.println(method + "方法执行结束时间：" + System.currentTimeMillis());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
