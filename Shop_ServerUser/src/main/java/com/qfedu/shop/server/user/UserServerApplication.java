package com.qfedu.shop.server.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *@Author feri
 *@Date Created in 2019/6/11 15:27
 */
@SpringBootApplication
public class UserServerApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UserServerApplication.class);
    }
}
