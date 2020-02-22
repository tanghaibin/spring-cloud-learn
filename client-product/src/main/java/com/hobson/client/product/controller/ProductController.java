package com.hobson.client.product.controller;

import com.google.common.collect.Lists;
import com.hobson.client.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * 商品服务
 *
 * @author haibin.tang
 * @create 2020-02-19 10:30 AM
 **/
@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("list")
    public ResponseEntity<List<Product>> list() {
        log.info("request product list..");
        return new ResponseEntity<>(createProduct(), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Product> detail(@PathVariable String id) {
        return new ResponseEntity<>(createProduct().stream().filter(e -> Objects.equals(e.getId(), id)).findFirst().orElse(null), HttpStatus.OK);
    }

    private List<Product> createProduct() {
        return Lists.newArrayList(Product.builder().id("P0001").name("法国葡萄酒").price(100000).quantity(89).build(),
                Product.builder().id("P0002").name("82年拉菲").price(150000).quantity(30).build(),
                Product.builder().id("P0003").name("贵州茅台").price(80000).quantity(47).build());
    }
}
