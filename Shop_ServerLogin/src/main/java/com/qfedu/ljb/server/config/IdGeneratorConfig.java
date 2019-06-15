package com.qfedu.ljb.server.config;

import com.qfedu.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/6/14 14:50
 */
@Configuration
public class IdGeneratorConfig {
    @Bean
    public IdGenerator createIG(){
        return new IdGenerator();
    }
}
