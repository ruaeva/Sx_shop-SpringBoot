package com.example.shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shop.entity.Product;
import com.example.shop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    /*
     * 分页查询上架商品列表
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 分页商品数据
     */
    public Page<Product> getProductList(int pageNum, int pageSize) {
        QueryWrapper<Product> wrapper = new QueryWrapper<Product>()
                .eq("status", 1)
                .orderByDesc("sales"); // 按销量排序

        return productMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    /*
     * 查询所有商品列表（包括上架和下架）
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return 分页商品数据
     * */
    public Page<Product> getAllProductList(int pageNum, int pageSize) {
        QueryWrapper<Product> wrapper = new QueryWrapper<Product>()
                .orderByDesc("sales"); // 按销量排序

        return productMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    }

    /*
     * 根据ID获取商品详情
     * @param id 商品ID
     * @return 商品详情
     * */
    public Product getProductById(Integer id) {
        return productMapper.selectById(id);
    }

    /*
     * 新增商品
     * @param product 商品信息
     * @return 新增结果
     * */
    public boolean createProduct(Product product) {
        // 如果没有设置状态，默认为上架状态
        if (product.getStatus() == 0) {
            product.setStatus(1);
        }
        // 设置创建时间
        product.setCreateTime(new java.util.Date());
        return productMapper.insert(product) > 0;
    }

    /*
     * 更新商品
     * @param product 商品信息
     * @return 更新结果
     * */
    public boolean updateProduct(Product product) {
        return productMapper.updateById(product) > 0;
    }

    /*
     * 删除商品
     * @param id 商品ID
     * @return 删除结果
     * */
    public boolean deleteProduct(Integer id) {
        return productMapper.deleteById(id) > 0;
    }

    /*
     * 批量删除商品
     * @param ids 商品ID列表
     * @return 删除结果
     * */
    public boolean deleteProducts(List<Integer> ids) {
        return productMapper.deleteBatchIds(ids) > 0;
    }

    /*
     * 上架商品
     * @param id 商品ID
     * @return 上架结果
     * */
    public boolean putOnSale(Integer id) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(1);
        return productMapper.updateById(product) > 0;
    }

    /*
     * 下架商品
     * @param id 商品ID
     * @return 下架结果
     * */
    public boolean takeOffSale(Integer id) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(0);
        return productMapper.updateById(product) > 0;
    }
}
