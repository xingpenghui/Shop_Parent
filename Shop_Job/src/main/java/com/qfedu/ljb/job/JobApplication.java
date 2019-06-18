package com.qfedu.ljb.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@Author feri
 *@Date Created in 2019/6/18 14:17
 */
@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})//取消Spring的Quartz自动注入
@EnableScheduling //启用Spring Task
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class,args);
    }
}
