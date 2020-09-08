package com.just.learn.basic.jvm;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-21 09:27
 **/
public class SatckError {
    static Long VALUE = 0L;

    public static void add() {
        VALUE++;
        add();
    }

    /**
     * Exception in thread "main" java.lang.StackOverflowError
     * @param args
     */
    public static void main(String[] args) {
        add();
    }
}
