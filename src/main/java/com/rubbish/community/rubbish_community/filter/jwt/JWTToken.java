package com.rubbish.community.rubbish_community.filter.jwt;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 20:46
 */
public class JWTToken extends UsernamePasswordToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
