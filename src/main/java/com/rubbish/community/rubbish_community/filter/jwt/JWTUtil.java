package com.rubbish.community.rubbish_community.filter.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rubbish.community.rubbish_community.utils.common.PropertiesUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Objects;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 20:47
 */
public class JWTUtil {
    private static final long EXPIRE_TIME_PREFIX = Long.parseLong(Objects.requireNonNull(PropertiesUtil.getProperty("token.jwt.expireTime")));
    private static final long EXPIRE_TIME = EXPIRE_TIME_PREFIX * 1000;
    private final static String ISSUER = "oss";

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据token，返回用户ID
     *
     * @author Leo Wang
     * @param token Token
     * @return java.lang.Long
     */
    public static Long getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(Long userId, String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("userId", userId)
                .withClaim("username", username)
                .withIssuer(ISSUER)
                .withExpiresAt(date)
                .sign(algorithm);
    }


    public static String getToken() {
        Subject subject = SecurityUtils.getSubject();
        return subject.getPrincipal().toString();
    }


    public static String getUsername() {
        try {
            DecodedJWT jwt = JWT.decode(getToken());
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    public static Long getUserId() {
        try {
            DecodedJWT jwt = JWT.decode(getToken());
            return jwt.getClaim("userId").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    public static Date getExpiresAt() {
        try {
            DecodedJWT jwt = JWT.decode(getToken());
            return jwt.getExpiresAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
