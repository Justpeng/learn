package com.just.learn.basic.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-05-06 17:10
 **/
public class DateUtil {
    private static final ThreadLocal<DateFormat> Y_M_D = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyy-MM-dd"));

    private static final ThreadLocal<DateFormat> YMD = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyyMMdd"));

    public static String getNowDateStr() {
        return YMD.get().format(new Date());
    }

    public static int getTodayInYear() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDaysInYear(calendar.get(Calendar.YEAR), calendar.get(Calendar.MARCH), calendar.get(Calendar.DATE));
    }


    public static int getDateInYear(String dateStr) throws ParseException {
        Date date = YMD.get().parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDaysInYear(calendar.get(Calendar.YEAR), calendar.get(Calendar.MARCH), calendar.get(Calendar.DATE));
    }

    /**
     * get days in this year
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int getDaysInYear(int year, int month, int day) {
        /*平年二月28天*/
        final int DAYS_28 = 28;
        /*闰年二月29天*/
        final int DAYS_29 = 29;
        /*除了31天的月份,4、6、9、11其他均为30天*/
        final int DAYS_30 = 30;
        /*1、3、5、7、8、10、12月份31天*/
        final int DAYS_31 = 31;

        int totalDays = 0;

        switch (month) {
            // 12 月份加的是11月份的天数，依次类推
            case 12:
                totalDays += DAYS_30;
            case 11:
                totalDays += DAYS_31;
            case 10:
                totalDays += DAYS_30;
            case 9:
                totalDays += DAYS_31;
            case 8:
                totalDays += DAYS_31;
            case 7:
                totalDays += DAYS_30;
            case 6:
                totalDays += DAYS_31;
            case 5:
                totalDays += DAYS_30;
            case 4:
                totalDays += DAYS_31;
            case 3:
                // 判断是否是闰年
                if (((year / 4 == 0) && (year / 100 != 0)) || (year / 400 == 0)) {
                    totalDays += DAYS_29;
                } else {
                    totalDays += DAYS_28;
                }
            case 2:
                totalDays += DAYS_31;
            case 1: // 如果是1月份就加上输入的天数
                totalDays += day;
        }
        return totalDays;
    }
}
