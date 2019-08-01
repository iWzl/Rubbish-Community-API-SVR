package com.rubbish.community.rubbish_community.filter.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 21:18
 */
public class RedisShiroCacheManager implements CacheManager {
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }
}
