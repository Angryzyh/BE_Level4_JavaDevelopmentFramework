package com.angryzyh.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sbmp_mybatisplus_product
 */
@TableName(value ="sbmp_mybatisplus_product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}