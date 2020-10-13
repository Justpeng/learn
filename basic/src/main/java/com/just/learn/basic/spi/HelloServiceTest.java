package com.just.learn.basic.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class HelloServiceTest {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> iterator = loader.iterator();
        while (iterator.hasNext()) {
            iterator.next().sayHello();
        }

    }
}
