package com.hobson.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haibin.tang
 * @create 2020-02-21 12:30 PM
 **/
@RestController
@EnableBinding({SmsSource.class, SmsSink.class})
@SpringBootApplication
public class StreamApplication {

    @Autowired
    private SmsService smsService;

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }

    @GetMapping("send/sms")
    public String sendSms() {
        smsService.send();
        return "success";
    }
}
