package com.qfedu.ljb.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@Author feri
 *@Date Created in 2019/6/27 09:55
 */
@SpringBootApplication
@EnableSwagger2
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class,args);
    }
}
