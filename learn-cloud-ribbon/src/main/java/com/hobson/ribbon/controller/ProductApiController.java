package com.hobson.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 对商品服务api进行负载均衡
 * @author haibin.tang
 * @create 2020-02-19 10:53 AM
 **/
@RestController
@RequestMapping("api/product")
public class ProductApiController {

    /**
     * 此RestTemplate已经开启了负载均衡
     * 会自动从所访问的服务进行负载均衡
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("list")
    public Object list() {
        return restTemplate.getForEntity("http://client-product/product/list", List.class, Map.class);
    }
}
