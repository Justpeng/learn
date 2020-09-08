package com.just.learn.basic.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-06 17:10
 **/
public class DateUtil {
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyy-MM-dd"));
}
