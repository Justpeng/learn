package com.just.lambda.chapter6;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-16 10:36
 **/
public class DickRolls {

    private static final int N = 1000000;


    @GenerateMicroBenchmark
    public Map<Integer, Double> serialDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side,
                        Collectors.summingDouble(n -> fraction)));
    }

    @Test
    public void test() {
        System.out.println(serialDiceRolls());
    }

    @Test
    public void test2() {
        System.out.println(parallelDiceRolls());
    }
    public Map<Integer,Double> parallelDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side,
                        Collectors.summingDouble(n -> fraction)));
    }


    private static IntFunction<Integer> twoDiceThrows() {
        return i ->{
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            int first = threadLocalRandom.nextInt(1, 7);
            int end = threadLocalRandom.nextInt(1, 7);
            return first + end;
        };
    }
}
