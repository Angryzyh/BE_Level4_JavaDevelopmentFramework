package com.angryzyh.model;

import com.angryzyh.model.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 
 * @TableName sbmp_mybatisplus_user
 */
@TableName(value ="sbmp_mybatisplus_user")
@Data
@Component
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private SexEnum sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    //逻辑删除
    //         设置默认值为false 0   被删除后为：true 1
    @TableLogic(value = "false" , delval = "true")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}