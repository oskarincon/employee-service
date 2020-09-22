/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bogota.test.employee.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

/**
 *
 * @author oscarivanrincontenjo
 */
@Configuration
public class RedisConfig {
        @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap.put("cache1", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(20)));  
            configurationMap.put("cache2", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2)));     
            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
