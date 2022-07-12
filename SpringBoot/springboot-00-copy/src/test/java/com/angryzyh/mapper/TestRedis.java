package com.angryzyh.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class TestRedis {

    @Test
    public void test(@Autowired StringRedisTemplate stringRedisTemplate) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String k1 = ops.get("k1");
        System.out.println("k1 = " + k1);
    }
}
