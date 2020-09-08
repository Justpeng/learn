package com.just.learn.basic.lambda.test;

import com.google.common.collect.Lists;
import com.just.learn.basic.lambda.Flight;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-06-04 15:35
 **/
public class FunctionTest {

    @Test
    public void isMu() {
        Flight flight1 = Flight.builder().airline("MU").depAirportCode("PEK").build();
        Flight flight2 = Flight.builder().airline("CZ").depAirportCode("PEK").build();
        Flight flight3 = Flight.builder().airline("MU").depAirportCode("PEK").build();
        List<Flight> flights = Lists.newArrayList(flight1, flight2, flight3);
        flights = flights.stream().filter(flight -> "MU".equalsIgnoreCase(flight.getAirline()))
                .collect(Collectors.toList());
        System.out.println(flights);
    }

    @Test
    public void testIterate() {
        //Stream.iterate(0, a -> a + 2)
        //        .limit(10)
        //        .forEach(System.out::print);
        //Stream.generate(Math::random).limit(10).forEach(System.out::println);
        //
        //
        //IntStream.range(0, 100)
        //        .limit(20)
        //        .mapToDouble(i->i)
        //        .forEach(System.out::println);
        char c = 'A';
        int num =10 ;
        switch (c) {
            case 'B':
                num++;
            case 'A':
                num++;
            case 'Y':
                num++;
                break;
            default:
                num--;

        }
        System.out.println(num);
    }
}
