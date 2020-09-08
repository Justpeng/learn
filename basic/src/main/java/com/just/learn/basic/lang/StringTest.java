package com.just.learn.basic.lang;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-15 09:50
 **/
public class StringTest {
    public static void main(String[] args) throws InterruptedException {
        //Case1
        String a = "123";
        String b = "123";
        System.out.println(a == b);

        //Case2
        String a1 = new String("134");
        String a2 = new String("134");
        System.out.println(a1==a2);


        String ori = "111";
        ori += "222";
        ori += "333";
        System.out.println(ori);

        StringBuilder stringBuilder = new StringBuilder("111");
        stringBuilder.append("222");
        stringBuilder.append("333");
        System.out.println(stringBuilder.toString());
        while (true) {
            TimeUnit.SECONDS.sleep(10);
            System.out.println(111);
        }
    }
}
