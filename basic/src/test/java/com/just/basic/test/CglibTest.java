package com.just.basic.test;

import com.just.learn.basic.cglab.Dao;
import com.just.learn.basic.cglab.DaoAnotherProxy;
import com.just.learn.basic.cglab.DaoCallBackFilter;
import com.just.learn.basic.cglab.DaoProxy;
import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 15:59
 **/
public class CglibTest {
    @Test
    public void testCglib() {
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (Dao) enhancer.create();
        dao.insert();
        dao.update();
    }

    /**
     * 意思是CallbackFilter的accept方法返回的数值表示的是顺序，顺序和setCallbacks里面Proxy的顺序是一致的。再解释清楚一点，Callback数组中有三个callback，
     * 方法名为"insert"的方法返回的顺序为0，即使用Callback数组中的0位callback，即DaoProxy
     * 方法名不为"insert"的方法返回的顺序为1，即使用Callback数组中的1位callback，即DaoAnotherProxy
     * 默认 NoOp.INSTANCE
     */
    @Test
    public void testCglib2() {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy anotherProxy = new DaoAnotherProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy,anotherProxy,NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoCallBackFilter());
        //构造函数中的方法
        enhancer.setInterceptDuringConstruction(false);
        Dao dao = (Dao) enhancer.create();
        dao.insert();
        dao.update();
    }
}
