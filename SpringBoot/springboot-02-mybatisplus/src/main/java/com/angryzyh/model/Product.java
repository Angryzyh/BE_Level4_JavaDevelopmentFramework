package com.angryzyh.model;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private Integer price;
    @Version //指定版本号字段
    private Integer version;
}
