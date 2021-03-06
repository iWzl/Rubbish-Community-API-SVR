package com.rubbish.community.rubbish_community;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@MapperScan("com.rubbish.community.rubbish_community.dao")
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class RubbishCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubbishCommunityApplication.class, args);
    }

}
