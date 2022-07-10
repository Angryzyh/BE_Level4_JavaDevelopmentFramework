package com.angryzyh.model;

import com.angryzyh.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import org.springframework.stereotype.Component;

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
    private Long id;

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