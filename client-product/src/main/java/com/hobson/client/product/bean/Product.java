package com.hobson.client.product.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品实体
 * @author haibin.tang
 * @create 2020-02-19 10:31 AM
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private Integer price;
    private Integer quantity;
}
