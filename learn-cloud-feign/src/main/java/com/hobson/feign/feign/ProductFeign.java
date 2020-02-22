package com.hobson.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author haibin.tang
 * @create 2020-02-19 12:38 PM
 **/
@FeignClient("client-product")
public interface ProductFeign {

    @GetMapping("product/list")
    List<Map<String, Object>> list();
}
