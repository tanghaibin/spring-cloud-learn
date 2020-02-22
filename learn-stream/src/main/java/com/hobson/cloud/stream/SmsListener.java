package com.hobson.cloud.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 短信监听器
 *
 * @author haibin.tang
 * @create 2020-02-21 12:24 PM
 **/
@Slf4j
@Component
public class SmsListener {

    @StreamListener(SmsSink.INPUT)
    public void listener(Message<SmsBean> smsBeanMessage) {
        log.info("接收到短信消息 -->> {}", smsBeanMessage);
    }
}
