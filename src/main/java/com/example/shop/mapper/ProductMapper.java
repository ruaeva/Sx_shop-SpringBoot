package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/*
 * @Description: 商品Mapper
 * @Author: Yuc
 * @Date: 2025/12/17
*/
@Mapper
public interface ProductMapper extends
        BaseMapper<Product> {
}
