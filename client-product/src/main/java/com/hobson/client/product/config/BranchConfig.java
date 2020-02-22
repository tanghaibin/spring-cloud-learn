package com.hobson.client.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 分支配置 从config上拉取值
 *
 * @author haibin.tang
 * @create 2020-02-19 3:33 PM
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "current")
public class BranchConfig {
    private String branch;
}
