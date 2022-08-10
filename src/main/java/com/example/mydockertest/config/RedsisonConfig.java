package com.example.mydockertest.config;

import org.redisson.Redisson;
import org.springframework.context.annotation.Bean;

import org.redisson.config.Config;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/4 15:54
 * @Version: v1.0
 */
@Configuration
public class RedsisonConfig {

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        //配置地址、数据库
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
    
}
