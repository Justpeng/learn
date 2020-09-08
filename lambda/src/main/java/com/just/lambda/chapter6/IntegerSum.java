package com.just.lambda.chapter6;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-16 11:01
 **/
public class IntegerSum {
    private int addIntegers(java.util.List<Integer> integers) {
        return integers.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }


}
