package com.just.lambda.chapter6;

import org.junit.Test;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-18 15:31
 **/
public class ArrayExample {

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    @Test
    public void test() {
        double[] x = parallelInitialize(4);
        System.out.println(x[0]);
    }

    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
            .toArray();
    }

}
