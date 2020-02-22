package com.hobson.cloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 短信消息发送端
 *
 * @author haibin.tang
 * @create 2020-02-21 12:13 PM
 **/
public interface SmsSource {

    @Output("SMS_OUTPUT")
    MessageChannel output();
}
