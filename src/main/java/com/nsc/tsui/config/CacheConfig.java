package com.nsc.tsui.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    //Just keeping it modular, also will configure cache managers here
}
