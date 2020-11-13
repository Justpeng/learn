package com.just.learn.basic.thread;

public class SingleTon {
    private static volatile SingleTon singleTon;

    private SingleTon() {

    }

    public synchronized SingleTon getSingleTon() {
        //是否实例化过
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
