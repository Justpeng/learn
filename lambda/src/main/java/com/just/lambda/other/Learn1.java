package com.just.lambda.other;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-05-24 16:34
 **/
@Slf4j
public class Learn1 {

    /**
     * 构建默认航班数据集合
     * @return
     */
    private List<FlightInfo> getDefaultList() {
        FlightInfo flightInfo1 = FlightInfo.builder().depCity("SHA").arrCity("HKG").airline("MU").flightNo("MU1234").flyTime(200).share(true).build();
        FlightInfo flightInfo2 = FlightInfo.builder().depCity("BJS").arrCity("LAX").airline("CZ").flightNo("CZ1111").flyTime(300).share(true).build();
        FlightInfo flightInfo3 = FlightInfo.builder().depCity("SHA").arrCity("BKK").airline("CX").flightNo("CX2122").flyTime(400).share(false).build();
        FlightInfo flightInfo4 = FlightInfo.builder().depCity("BJS").arrCity("BKK").airline("CX").flightNo("CX1222").flyTime(500).share(false).build();
        List<FlightInfo> flightInfos = Lists.newArrayList(flightInfo1, flightInfo2, flightInfo3, flightInfo4);
        return flightInfos;
    }

    @Test
    public void test1() {
        FlightInfo f = new FlightInfo();
        f.setShare(false);
        Predicate<FlightInfo> stringPredicate = e -> e.getShare();
        System.out.println(stringPredicate.test(f));
    }

    @Test
    public void test2() {
        List<FlightInfo> flightInfos = new ArrayList<>();
        flightInfos.forEach(f -> System.out.println(f.getShare()));
        flightInfos.stream().map(f -> f.getFlyTime());
    }

    @Test
    public void testJoin1() {
        List<String> list = Lists.newArrayList("MU", "CZ", "CX");
        Stream.of(list);
        System.out.println("Str:" + list.stream().collect(Collectors.joining("-")));
    }

    @Test
    public void testJoin() {
        //模拟航班集合
        List<FlightInfo> flightInfos = getDefaultList();
        //获取所有航司信息集合
        List<String> airlines = flightInfos.stream().map(f -> f.getAirline()).distinct().collect(Collectors.toList());
        System.out.println("airlines:" + airlines);
        //获取航航司信息
        String joiningStr = airlines.stream().collect(Collectors.joining());
        System.out.println("airline-joining:" + joiningStr);
        //"-" 拼接
        String delimiter = airlines.stream().collect(Collectors.joining("-"));
        System.out.println("airline-delimiter:" + delimiter);
        //"#" 拼接，首"[",尾"]"
        String preDelimiter = airlines.stream().collect(Collectors.joining("#", "[", "]"));
        System.out.println("airline-prefix:" + preDelimiter);
    }

    @Test
    public void testGroup() {
        //模拟航班集合
        FlightInfo flightInfo1 = FlightInfo.builder().airline("MU").flightNo("MU1234").build();
        FlightInfo flightInfo2= FlightInfo.builder().airline("CZ").flightNo("CZ1111").build();
        FlightInfo flightInfo3 = FlightInfo.builder().airline("CX").flightNo("CX2122").build();
        FlightInfo flightInfo4 = FlightInfo.builder().airline("CX").flightNo("CX1222").build();
        List<FlightInfo> flightInfos = Lists.newArrayList(flightInfo1, flightInfo2, flightInfo3, flightInfo4);
        //根据航司分组
        Map<String, List<FlightInfo>> map = flightInfos.stream()
                .collect(Collectors.groupingBy(flight -> flight.getAirline()));
        System.out.println("map:" + JSONObject.toJSONString(map));
    }

    @Test
    public void testPartition() {
        //模拟航班集合
        FlightInfo flightInfo1 = FlightInfo.builder().share(true).flightNo("MU1234").build();
        FlightInfo flightInfo2= FlightInfo.builder().share(true).flightNo("CZ1111").build();
        FlightInfo flightInfo3 = FlightInfo.builder().share(false).flightNo("CX2122").build();
        FlightInfo flightInfo4 = FlightInfo.builder().share(false).flightNo("CX1222").build();
        List<FlightInfo> flightInfos = Lists.newArrayList(flightInfo1, flightInfo2, flightInfo3, flightInfo4);
        //区分是否共享
        Map<Boolean, List<FlightInfo>> map = flightInfos.stream()
                .collect(Collectors.partitioningBy(flight -> flight.getShare()));
        System.out.println("map:" + JSONObject.toJSONString(map));
    }


    @Test
    public void testReduce() {
        //模拟航班集合
        List<FlightInfo> flightInfos = getDefaultList();
        //使用reduce对飞行时间求和
        int sumTime = flightInfos.stream().map(f -> f.getFlyTime()).reduce(0, Integer::sum);
        int sumTime2 = flightInfos.stream().map(f -> f.getFlyTime()).reduce(0, (a, b) -> a + b);
        System.out.println("sumTime:" + sumTime);
        System.out.println("sumTime2:" + sumTime2);

    }









    @Test
    public void toList() {
        //获取数据
        List<FlightInfo> flightInfos = getDefaultList();
        //toList,获取所有航司
        List<String> airlines = flightInfos.stream().map(flightInfo -> flightInfo.getAirline()).collect(Collectors.toList());
        Set<String> airlines2 = flightInfos.stream().map(flightInfo -> flightInfo.getAirline()).collect(Collectors.toSet());
        System.out.println("airlines:" + JSONObject.toJSONString(airlines));
        System.out.println("airlines2:" + JSONObject.toJSONString(airlines2));
        //distinct & toList 获取非重复航司
        List<String> noneDistinct = flightInfos.stream().map(flightInfo -> flightInfo.getAirline()).distinct().collect(Collectors.toList());
        System.out.println("none distinct airlines:" + JSONObject.toJSONString(noneDistinct));

    }

    @Test
    public void minBy() {
        List<FlightInfo> flightInfos = getDefaultList();
        //minBy 获取飞行时间最短的航班
        Optional<FlightInfo> flight = flightInfos.stream()
                .collect(Collectors.minBy(
                        Comparator.comparing(
                                flightInfo -> flightInfo.getFlyTime())));
        System.out.println("flightInfo:" + JSONObject.toJSONString(flight.get()));
    }

    @Test
    public void sum() {
        List<FlightInfo> flightInfos = getDefaultList();
        //sum 获取飞行时间总和
        Integer sumTime = flightInfos.stream()
                .map(flightInfo -> flightInfo.getFlyTime())
                .collect(Collectors.summingInt(time -> (int) time)).intValue();
        System.out.println("sumTime:" + sumTime);
        //or
        Integer sumTime2 = flightInfos.stream()
                .mapToInt(flightInfo -> flightInfo.getFlyTime())
                .sum();
        System.out.println("sumTime2:" + sumTime2);
    }

    @Test
    public void avg() {
        List<FlightInfo> flightInfos = getDefaultList();
        //avg 获取平均时间
        Double avgTime = flightInfos.stream().mapToInt(FlightInfo::getFlyTime).average().getAsDouble();
        System.out.println("avgTime:" + avgTime);

        Double avgTime2 = flightInfos.stream().map(flightInfo -> flightInfo.getFlyTime())
                .collect(Collectors.averagingDouble(time -> time)).doubleValue();
        System.out.println("avgTime2:" + avgTime2);
    }

    public void lambda() {
        Runnable taskBefore8 = new Runnable() {
            @Override
            public void run() {
                System.out.println("11");
            }
        };
        Runnable task = () -> System.out.println("11");
        Runnable task2 = () -> {

        };

        Lists.newArrayList(false, true).stream().filter(Objects::nonNull);
        IntStream.of(1, 2, 3).filter(x -> x > 0);
        LongStream.of(1L, 2L, 3L).filter(x -> x > 0);

        Stream.of(1, 2, 3).forEach(x -> System.out.println(x));

        Stream.of("I", "Am", "Stream").map(f -> f.getBytes());

        Supplier<FlightInfo> supplier = FlightInfo::new;
        Supplier<List<String>> strings = ArrayList::new;

        Comparator<People> peopleComparator = Comparator.comparing(People::getAge);
        peopleComparator.compare(new People(),new People());
        //逆序
        Comparator<People> peopleComparator2= Comparator.comparing(People::getAge).reversed();
        peopleComparator.compare(new People(),new People());

        Comparator<People> peopleComparator3= Comparator.comparing(People::getName).thenComparing(People::getAge);
        peopleComparator.compare(new People(),new People());


        Lists.newArrayList(new People(), new People(), new People()).stream()
                .filter(p -> p.getName().equalsIgnoreCase("just"))
                .filter(p -> p.getAge() > 10)
                .collect(Collectors.toSet());

        Lists.newArrayList(new People(), new People(), new People())
                .stream()
                .filter((p->p.getAge()>10));


        Predicate<People> peoplePredicate = Objects::nonNull;
        Lists.newArrayList(new People(), new People(), new People())
                .stream()
                .filter((peoplePredicate).and(people -> people.getAge() > 20).and(people -> people.getAddr().equalsIgnoreCase("beijing")));



    }

    @Getter
    @Setter
    class People {
        private String name;
        private String addr;
        private int age;
    }






}
