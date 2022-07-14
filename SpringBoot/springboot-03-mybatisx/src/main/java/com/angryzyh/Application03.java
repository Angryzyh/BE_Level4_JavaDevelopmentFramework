package com.angryzyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.angryzyh.mapper")
public class Application03 {

    public static void main(String[] args) {
        SpringApplication.run(Application03.class, args);
    }

}
