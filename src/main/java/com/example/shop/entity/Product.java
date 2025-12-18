package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.Date;


/*
 * @Description: 商品实体类
 * @Author: Yuc
 * @Date: 2025/12/17
 */
@Data
@TableName("product")
@CrossOrigin
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("product_name")  // 映射数据库中的product_name字段
    private String name;
    @TableField("product_info")  // 映射数据库中的product_info字段
    private String info;
    private BigDecimal price;
    private int sales;
    private int status; // 商品状态，1-上架，0-下架
    private Date createTime;
}
