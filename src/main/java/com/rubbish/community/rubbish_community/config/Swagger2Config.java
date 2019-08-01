package com.rubbish.community.rubbish_community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 API 自动生成文档配置
 * API服务地址: http://项目地址/swagger-ui.html
 *
 * @author Leo Wang
 * @version 1.0.0
 * @date 2019/7/25 23:11
 */

@ComponentScan("com.rubbish.community.rubbish_community.controller")
@Configuration
@EnableSwagger2
public class Swagger2Config {


    /**
     * 创建BeanApi
     * apiInfo() 增加API相关信息
     * 通过select()函数,返回一个ApiSelectorBuilder实例,控制哪些接口暴露给Swagger
     * 采用指定扫描的包路径来定义指定要建立API的目录。
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rubbish.community.rubbish_community.controller"))//扫描Api包
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息
     * 访问地址：http://项目实际地址/swagger-ui.html
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RUBBISH COMMUNITY API")
                .description("RUBBISH COMMUNITY API接口文档")//api描述
                //.termsOfServiceUrl("https://www.baidu.com/")//服务地址
                //.contact(new Contact("Leo Wang", "https://www.baidu.com/", "Wangzl@Wangzl.cc"))//联系信息
                .version("v1.0.0")
                .build();
    }

}
