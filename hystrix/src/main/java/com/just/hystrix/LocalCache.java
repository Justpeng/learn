package com.just.hystrix;

import java.util.HashMap;
import java.util.Map;

public class LocalCache {
    public static Map<String,String> cityMap=new HashMap<>();

    static {
        cityMap.put("BJS", "北京");
        cityMap.put("SHA", "上海");
    }

    public static String getCityName(String key) {
        return cityMap.get(key);
    }

}
