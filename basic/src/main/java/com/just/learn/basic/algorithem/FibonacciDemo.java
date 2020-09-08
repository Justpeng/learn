package com.just.learn.basic.algorithem;

public class FibonacciDemo {
    public static void main(String[] args) {
        int n = 10;
        for(int i = 1;i <=n;i++) {
            System.out.print(fibonacci(i)+"\t");
        }
    }

    /**
     * 后一个数字=前两个数字相加
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }
}
