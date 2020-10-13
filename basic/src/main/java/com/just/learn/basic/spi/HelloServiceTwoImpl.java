package com.just.learn.basic.spi;

public class HelloServiceTwoImpl implements HelloService{

    @Override
    public void sayHello() {
        System.out.println("this is HelloServiceTwoImpl");
    }
}
