package com.just.lambda.chapter1;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-07-19 09:38
 **/
public class LambdaDemo {

    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sssss");
            }
        });

        Button button1 = new Button();
        button1.addActionListener(event -> System.out.println("sff"));

        Runnable noArug = () -> System.out.println("ssss");

        ActionListener actionListener = event -> System.out.println("ss");


        Runnable mutil = () -> {
            System.out.println("a");
            System.out.println("b");
        };

        BinaryOperator<Integer> add = (x,y) -> x + y;
        System.out.println(add.apply(1,2));

        String name = getUserName();
        //name = formatName(name);
        Button button2 = new Button();
        button2.addActionListener(event -> System.out.println("hi:" + name));


        Predicate<Integer> alLest5 = x -> x > 5;

        System.out.println(alLest5.test(4));


        ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MM-yyyy")));

        System.out.println(formatter.get().getFormat().format(new Date()));


    }

    private static String getUserName() {
        return "Just";
    }

    private static String formatName(String name) {
        return name + " A";
    }



}
