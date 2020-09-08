package com.just.learn.basic.concurrent.chapter1;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-05-17 17:20
 **/
public class TestCal {
    public  int count = 0;

    public  void add() {
        int id = 0;
        while (id++ < 10000000) {
            count+=1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestCal testCal = new TestCal();
        Thread thread = new Thread(() -> testCal.add());
        Thread thread1 = new Thread(() -> testCal.add());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(testCal.count);
    }


}
