package com.hobson.client.product.controller;

import com.hobson.client.product.config.BranchConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试分支配置
 *
 * @author haibin.tang
 * @create 2020-02-19 3:36 PM
 **/
@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchConfig branchConfig;

    @GetMapping("current")
    public ResponseEntity<?> current() {
        return new ResponseEntity<>(branchConfig.getBranch(), HttpStatus.OK);
    }
}
