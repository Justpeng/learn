package com.just.learn.basic.lock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-06 12:25
 **/
public class DeadLock {
    public static void main(String[] args){
        Object lock = new Object();
        Object lock2 = new Object();

        new Thread(new Runnable(){

            @Override
            public void run(){
                synchronized(lock){
                    try{
                        TimeUnit.SECONDS.sleep(5);
                    }catch(InterruptedException e){

                    }
                    synchronized(lock2){

                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock2){
                    try{
                        TimeUnit.SECONDS.sleep(5);
                    }catch(InterruptedException e){

                    }
                    synchronized(lock){

                    }
                }
            }
        }).start();
    }
}
