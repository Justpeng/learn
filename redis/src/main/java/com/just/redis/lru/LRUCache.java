package com.just.redis.lru;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:内存淘汰策略
 * @author: pengLi
 * @create: 2020-10-23 19:21
 **/
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int CACHE_SIZE;

    public LRUCache(int size) {
        super((int) ( size / 0.75 + 1),0.75f,true);
        CACHE_SIZE = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
