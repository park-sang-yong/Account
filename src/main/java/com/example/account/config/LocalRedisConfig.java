package com.example.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalRedisConfig {
    @Value("${spring.data.redis.port}")
    private int redisPort;
}
