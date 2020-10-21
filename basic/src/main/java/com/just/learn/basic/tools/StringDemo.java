package com.just.learn.basic.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.regex.Pattern;

public class StringDemo {
    public static Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    public static void main(String[] args) {
//        String[] x = NAME_SEPARATOR.split("ff3,ff3k,3f2,");
//        System.out.println(JSONObject.toJSON(x));
         String[] x = "ff3,ff3k,3f2,".split(",");
        System.out.println(JSONObject.toJSON(x));

    }


}
