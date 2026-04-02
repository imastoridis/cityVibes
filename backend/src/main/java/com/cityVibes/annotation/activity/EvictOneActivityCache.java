package com.cityVibes.annotation.activity;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to centralize cache eviction logic.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Caching(evict = {
        @CacheEvict(value = "one_activity", key = "#id", condition = "#id != null"),
        @CacheEvict(value = "one_activity", key = "#activityDto.id", condition = "#activityDto != null"),
})
public @interface EvictOneActivityCache {
}
