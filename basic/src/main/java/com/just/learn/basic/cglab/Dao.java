package com.just.learn.basic.cglab;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 15:52
 **/
public class Dao {

    public Dao() {
        update();
    }

    public void insert() {
        System.out.println("Proxy insert");
    }

    public void update() {
        System.out.println("Proxy update");
    }
}
