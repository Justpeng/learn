package com.just.lambda.other;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-06-18 16:29
 **/
public class Learn2 {
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
    public void testFilter() {
        List<FlightInfo> flightInfos = getDefaultList();
        List<FlightShortInfo> shortInfos = flightInfos.stream()
                //过滤null
                .filter(Objects::nonNull)
                //过滤非CX航司
                .filter(flightInfo -> "CX".equalsIgnoreCase(flightInfo.getAirline()))
                //映射
                .map(flightInfo ->
                        FlightShortInfo.builder()
                                .flightNo(flightInfo.getFlightNo())
                                .flyTime(flightInfo.getFlyTime()).build())
                //排序-飞行时间
                .sorted(Comparator.comparing(flightInfo -> flightInfo.getFlyTime()))
                //聚合
                .collect(Collectors.toList());
        System.out.println("shortInfo:" + JSONObject.toJSONString(shortInfos));
    }

    @Test
    public void testForeach() {
        List<FlightInfo> flightInfos = getDefaultList();
        flightInfos.stream().forEach(f-> System.out.println(f.getFlightNo()));
    }

    @Test
    public void testFlatMap() {
        List<FlightInfo> firstList = getDefaultList();
        List<FlightInfo> secondList = getDefaultList();
        Stream.of(firstList, secondList).flatMap(f -> f.stream())
                .forEach(f -> System.out.println(f.getFlightNo()));
    }

    /**
     * 获取所有从北京出发的航班的航班号
     */
    @Test
    public void testFlatMap2() {
        List<FlightInfo> firstList = getDefaultList();
        List<FlightInfo> secondList = getDefaultList();
        Map<String, List<FlightInfo>> map = new HashMap<>();
        map.put("first", firstList);
        map.put("second", secondList);
        List<String> flightNos = map.values().stream().flatMap(list -> list.stream())
                .filter(f -> f.getDepCity().equalsIgnoreCase("BJS"))
                .map(f -> f.getFlightNo()).distinct()
                .collect(Collectors.toList());
        System.out.println("flightNos:" + JSONObject.toJSONString(flightNos));
    }

    public void toList() {

    }
}
