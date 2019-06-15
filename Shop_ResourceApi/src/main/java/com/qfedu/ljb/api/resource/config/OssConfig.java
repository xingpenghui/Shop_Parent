package com.qfedu.ljb.api.resource.config;

import com.qfedu.ljb.api.resource.util.OSSUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2019/6/15 17:16
 */
@Configuration
public class OssConfig {
    @Bean
    public OSSUtil createOSS(){
        return new OSSUtil();
    }
}
