package com.example.account.config;

import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalRedisConfig {
    @Value("${spring.redis.port}")
}
