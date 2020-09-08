package com.just.learn.spring.test;

import com.just.learn.spring.aop.DaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 11:55
 **/
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring.xml"}) //加载配置文件
public class TestAop {

    @Autowired
    DaoImpl daoImpl;

    @Test
    public void test() {

        daoImpl.insert();
    }
}
