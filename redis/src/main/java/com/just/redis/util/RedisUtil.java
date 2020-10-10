package com.just.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {
    //默认 localhost:6379
    private static JedisPool jedisPool = new JedisPool();


    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
