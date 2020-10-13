package com.just.learn.basic.spi;

public class HelloServiceOneImpl implements HelloService{

    @Override
    public void sayHello() {
        System.out.println("this is HelloServiceOneImpl");
    }
}
