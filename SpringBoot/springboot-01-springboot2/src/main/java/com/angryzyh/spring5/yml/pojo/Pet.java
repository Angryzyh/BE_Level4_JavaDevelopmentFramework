package com.angryzyh.spring5.yml.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pet")
@Data
public class Pet {
    private String name;
    private Double weight;
}
