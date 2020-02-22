package com.hobson.cloud.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haibin.tang
 * @create 2020-02-21 5:10 PM
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class BusApplication {

    @Value("${current.branch}")
    private String branch;

    public static void main(String[] args) {
        SpringApplication.run(BusApplication.class, args);
    }

    @GetMapping("branch")
    public String branch() {
        return branch;
    }
}
