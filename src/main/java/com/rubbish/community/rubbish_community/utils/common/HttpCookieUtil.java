package com.rubbish.community.rubbish_community.utils.common;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/30 20:59
 */
@Slf4j
public class HttpCookieUtil {

    public static Cookie getByCookieName(String cookieName){
        Cookie[] cookies =  getRequest().getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void setNewCookie(Cookie cookie){
        assert cookie!=null;
        log.debug("Set-Cookie"+cookie);
        getResponse().addCookie(cookie);
    }

    public static void cleanByCookieName(String cookieName){
        Cookie cookie = getByCookieName(cookieName);
        assert cookie != null;
        cookie.setMaxAge(0);
        log.debug("Clean-Cookie"+cookie);
        setNewCookie(cookie);
    }


    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
}
