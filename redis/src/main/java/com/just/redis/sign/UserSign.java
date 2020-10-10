package com.just.redis.sign;

import com.just.learn.basic.date.DateUtil;
import com.just.redis.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.text.ParseException;

/**
 * 用户签到场景 bitmap
 */
public class UserSign {

    private static final String PREFIX = "checkin_";

    public static void main(String[] args) throws ParseException {
        Long uid = 3L;
        String key = PREFIX + DateUtil.getNowDateStr();
        //指定日期签到
        String date = "20201010";
        doSign(uid, date);

        Integer singCount = getUserSignCount(uid);
        System.out.println("连续签到次数" + singCount);

        //某日签到用户数
        Long total = getTotalTodaySign(date);
        System.out.println("签到人数" + total);
    }

    public static Long getTotalTodaySign(String date) {
        String key = PREFIX + date;
        Jedis jedis = RedisUtil.getJedis();
        return jedis.bitcount(key);
    }

    /**
     * 获取连续签到次数
     * @param uid
     * @return
     */
    public static int getUserSignCount(Long uid) {
        Jedis jedis = RedisUtil.getJedis();
        String key = PREFIX + uid;
        Integer index = DateUtil.getTodayInYear();
        int n =0;
        for (int i = index; i >= 0; i--) {
            Boolean sign = jedis.getbit(key, i);
            if (sign == false) {
                break;
            }
            n++;
        }
        return n;
    }

    public static void doSign(Long uid, String date) throws ParseException {
        String key = PREFIX + date;
        Jedis jedis = RedisUtil.getJedis();
        Boolean sign = jedis.getbit(key, uid);
        if (sign) {
            System.out.println("已签到" + date);
            return;
        } else {
            System.out.println("进行签到" + date);
            jedis.setbit(key, uid, "1");
            jedis.setbit(PREFIX + uid, DateUtil.getDateInYear(date), "1");
        }
    }
}
