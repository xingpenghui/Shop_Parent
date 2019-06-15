package com.qfedu.ljb.api.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@Author feri
 *@Date Created in 2019/6/15 15:58
 */
@SpringBootApplication
@EnableSwagger2
public class ResourceApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ResourceApplication.class);
    }
}
