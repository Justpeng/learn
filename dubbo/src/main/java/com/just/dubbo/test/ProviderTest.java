package com.just.dubbo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-04-26 10:01
 **/
public class ProviderTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo/dubbo.xml"});
        context.start();
        System.in.read(); // 按任意键退出
    }
}
