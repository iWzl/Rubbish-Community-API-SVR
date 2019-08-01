package com.rubbish.community.rubbish_community.filter.shiro;

import com.rubbish.community.rubbish_community.filter.jwt.JWTUtil;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 21:24
 */
public class ShiroCacheHelper {
    @Autowired
    private RedisShiroCacheManager redisShiroCacheManager;

    public void clearCurrentAuthenticationCache() {
        Cache<Object, Object> cache = redisShiroCacheManager.getCache(AuthRealm.class + ".authenticationCache");
        cache.remove(JWTUtil.getToken());
    }
}
