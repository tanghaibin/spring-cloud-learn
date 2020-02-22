package com.hobson.feign.controller;

import com.hobson.feign.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haibin.tang
 * @create 2020-02-19 12:37 PM
 **/
@RestController
@RequestMapping("feign/product")
public class FeignProductController {

    @Autowired
    private ProductFeign productFeign;

    @GetMapping("list")
    public Object list() {
        return productFeign.list();
    }
}
