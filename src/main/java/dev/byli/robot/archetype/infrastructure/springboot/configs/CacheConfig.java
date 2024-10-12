package dev.byli.robot.archetype.infrastructure.springboot.configs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    public static final String EVENTS_CACHE = "events";
    public static final String EXIST_EVENT_CACHE = "existEvent";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(EVENTS_CACHE, EXIST_EVENT_CACHE);
    }

}
