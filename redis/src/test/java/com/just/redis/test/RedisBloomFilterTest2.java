package com.just.redis.test;

import com.just.redis.RedisBloomFilter2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

public class RedisBloomFilterTest2 {
    private static final int NUM_APPROX_ELEMENTS = 3000;
    private static final double FPP = 0.03;
    private static final int DAY_SEC = 60 * 60 * 24;
    private static JedisPool jedisPool;
    private static RedisBloomFilter2 redisBloomFilter;

    @BeforeClass
    public static void beforeClass() throws Exception {
        jedisPool = new JedisPool();
        redisBloomFilter = new RedisBloomFilter2(NUM_APPROX_ELEMENTS, FPP, jedisPool);
        System.out.println("numHashFunctions: " + redisBloomFilter.getNumHashFunctions());
        System.out.println("bitmapLength: " + redisBloomFilter.getBitmapLength());
    }

    @AfterClass
    public static void afterClass() throws Exception {
        jedisPool.close();
    }

    @Test
    public void testInsert() throws Exception {
        redisBloomFilter.insert("topic_read:8839540:20190609", "76930242", DAY_SEC);
        redisBloomFilter.insert("topic_read:8839540:20190609", "76930243", DAY_SEC);
        redisBloomFilter.insert("topic_read:8839540:20190609", "76930244", DAY_SEC);
        redisBloomFilter.insert("topic_read:8839540:20190609", "76930245", DAY_SEC);
        redisBloomFilter.insert("topic_read:8839540:20190609", "76930246", DAY_SEC);
    }

    @Test
    public void testMayExist() throws Exception {
        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930242"));
        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930244"));
        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930246"));
        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930248"));
    }
}
