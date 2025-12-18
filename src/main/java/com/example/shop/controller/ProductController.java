package com.example.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }

    /*
     * 创建商品接口
     * @param product 商品信息
     * @return 新增结果
     * */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /*
     * 商品列表接口
     * @param pageNum 页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 商品列表
     * */
    @GetMapping
    public Page<Product> getProductList(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return productService.getProductList(pageNum, pageSize);

    }

    /*
     * 所有商品列表接口（含上下架状态）
     * @param pageNum 页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 商品列表
     * */
    @GetMapping("/all")
    public Page<Product> getAllProductList(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return productService.getAllProductList(pageNum, pageSize);
    }

    /*
     * 根据ID获取商品详情
     * @param id 商品ID
     * @return 商品详情
     * */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    /*
     * 更新商品
     * @param id 商品ID
     * @param product 商品信息
     * @return 更新结果
     * */
    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    /*
     * 删除商品
     * @param id 商品ID
     * @return 删除结果
     * */
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    /*
     * 批量删除商品
     * @param ids 商品ID列表
     * @return 删除结果
     * */
    @DeleteMapping
    public boolean deleteProducts(@RequestBody List<Integer> ids) {
        return productService.deleteProducts(ids);
    }

    /*
     * 商品上架
     * @param id 商品ID
     * @return 上架结果
     * */
    @PutMapping("/{id}/on-sale")
    public boolean putOnSale(@PathVariable Integer id) {
        return productService.putOnSale(id);
    }

    /*
     * 商品下架
     * @param id 商品ID
     * @return 下架结果
     * */
    @PutMapping("/{id}/off-sale")
    public boolean takeOffSale(@PathVariable Integer id) {
        return productService.takeOffSale(id);
    }
}
