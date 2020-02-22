package com.hobson.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author haibin.tang
 * @create 2020-02-21 12:17 PM
 **/
@Component
public class SmsService {

    @Autowired
    private SmsSource source;

    public void send() {
        SmsBean smsBean = new SmsBean();
        smsBean.setContent("验证码是: " + (int)(Math.random() * 1000000));
        smsBean.setMobile("187806546467");
        source.output().send(MessageBuilder.withPayload(smsBean).build());
    }
}