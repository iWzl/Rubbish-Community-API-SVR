package com.rubbish.community.rubbish_community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 20:40
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins(DEFAULT_ORIGINS)
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders(DEFAULT_ALLOWED_HEADERS)
//                .allowCredentials(true)
//                .maxAge(3600);
    }
}
