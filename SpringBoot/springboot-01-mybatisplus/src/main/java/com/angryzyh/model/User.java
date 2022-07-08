package com.angryzyh.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
