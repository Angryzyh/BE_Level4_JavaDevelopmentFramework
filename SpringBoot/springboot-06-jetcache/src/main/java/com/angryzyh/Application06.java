package com.angryzyh;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation //jetcache 开启缓存
@EnableMethodCache(basePackages = "com.angryzyh") //jetcache开启方法缓存
public class Application06 {
    public static void main(String[] args) {
        SpringApplication.run(Application06.class, args);
    }
}
