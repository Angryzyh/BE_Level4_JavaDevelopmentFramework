package com.angryzyh.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data //lombok
@Component //自动装配
@TableName("sbmp_mybatisplus_user") //映射数据库表明
public class User {
    //指定主键属性映射字段名
    //自增策略 MP默认雪花算法+UUID
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    //指定实体属性与数据库字段的映射
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    //逻辑删除
    //         设置默认值为false 0   被删除后为：true 1
    @TableLogic(value = "false" , delval = "true")
    private boolean isDelete;
}
