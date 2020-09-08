package com.just.lambda.chapter6.answers;


import java.util.stream.IntStream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-19 09:10
 **/
public class Exercise {
    public static int sequentialSumOfSquare(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }

    public static int multiplyThrough(java.util.List<Integer> list) {
        return 5 * list.stream().parallel()
                .reduce(1, (acc, x) -> x * acc);
    }



}
