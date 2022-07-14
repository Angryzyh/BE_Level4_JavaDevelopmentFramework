package com.angryzyh.springmvc.controller.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class Pet {
    private String name;
    private Double weight;
}
