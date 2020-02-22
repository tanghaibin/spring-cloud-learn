package com.hobson.cloud.stream;

import lombok.Data;
import lombok.ToString;

/**
 * @author haibin.tang
 * @create 2020-02-21 12:19 PM
 **/
@ToString
@Data
public class SmsBean {
    private String mobile;
    private String content;
}
