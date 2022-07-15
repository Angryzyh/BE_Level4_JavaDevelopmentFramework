package com.angryzyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //第一步开启定时任务注解
public class Application08 {

    public static void main(String[] args) {
        SpringApplication.run(Application08.class, args);
    }

}
