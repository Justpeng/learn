package com.just.learn.basic.copy.c2;

import java.util.Scanner;

public class U3350p1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int r = num & num - 1;
            System.out.println(r==0?1:0);
            break;
        }
    }
}