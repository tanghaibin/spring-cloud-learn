package com.hobson.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 短信消息接收端
 * @author haibin.tang
 * @create 2020-02-21 12:10 PM
 **/
public interface SmsSink {

    String INPUT = "SMS_INPUT";

    @Input(SmsSink.INPUT)
    SubscribableChannel input();

}
