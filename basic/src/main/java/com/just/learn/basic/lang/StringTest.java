package com.just.learn.basic.lang;

import org.checkerframework.checker.units.qual.C;

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
        if (a == b) { //true 常量池比较
            System.out.println("a == b");
        }

        //Case2
        String a1 = new String("134");
        String a2 = new String("134");
        if (a1 == a2) { //false 两个引用，但内容一样
            System.out.println("a1==a2");
        }
        if (a1.equals(a2)) {//String重写了equals,比较的是内容
            System.out.println("a1.equals(a2)");
        }

        if (22 == 22.0) { //基本类型比较的是值
            System.out.println("22 == 22.0");
        }

        ChildDemo childDemo = new ChildDemo("1", 2);
        ChildDemo childDemo2 = new ChildDemo("1", 3);
        if (childDemo.equals(childDemo2)) { //false 对象equals没有重写的情况下是== 比较的是引用
            System.out.println("childDemo.equals(childDemo2)");
        }

    }
}
