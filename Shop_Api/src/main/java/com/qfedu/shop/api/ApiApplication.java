package com.qfedu.shop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *@Author feri
 *@Date Created in 2019/6/11 15:29
 */
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApiApplication.class);
    }
}