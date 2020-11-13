package com.just.learn.basic.copy.c2;

import java.util.Scanner;

public class U3350p6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num < 0 || num > 1000) {
                System.out.println(0);
                break;
            }
            Integer r = fib(num);
            System.out.println(r);
            if (r < 1000000) {
                System.out.println(r);
                break;
            }
            String v = String.valueOf(r);
            System.out.println(Integer.valueOf(v.substring(v.length()-6)));
            break;
        }
    }

    public static int fib(int n) {
        int[] a=new int[2];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<n+1;i++){
            a[i%2]=(a[0]+a[1])%1000000007;
        }
        return a[n%2];
    }

//    public static int fib(int N) {
//        if (N <= 1) {
//            return N;
//        }
//        return cacheFib(N);
//    }
//
//    public static int cacheFib(int N) {
//        int[] cache = new int[N + 1];
//        cache[1] = 1;
//
//        for (int i = 2; i <= N; i++) {
//            cache[i] = cache[i-1] + cache[i-2];
//        }
//        return cache[N];
//    }
}