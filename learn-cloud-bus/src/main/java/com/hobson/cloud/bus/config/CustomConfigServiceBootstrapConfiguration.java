package com.hobson.cloud.bus.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 为了覆盖ConfigServicePropertySourceLocator bean
 * 原因：org.springframework.cloud.config.client.ConfigServicePropertySourceLocator#locate(org.springframework.core.env.Environment) 这个方法的restTemplate如果没有值则是用的
 * org.springframework.http.client.SimpleClientHttpRequestFactory这个类来构建请求的 会出现 Connection reset; nested exception is java.net.SocketException: Connection reset 这个异常
 * 所以要替换掉默认创建的ConfigServicePropertySourceLocator这个bean，改为人为创建并且把OkHttp工具替换进去
 * 并且需要在resources下建立META-INF/spring.factories 这个文件，这个文件是用来声明启动类的，可以覆盖掉springboot内部自动扫描创建的bean
 *
 * 谨记: 遇到问题查官方文档
 * @author haibin.tang
 * @create 2020-02-20 1:37 PM
 **/
@Configuration
public class CustomConfigServiceBootstrapConfiguration {

    @Bean
    @ConditionalOnMissingBean(ConfigServicePropertySourceLocator.class)
    @ConditionalOnProperty(value = "spring.cloud.config.enabled", matchIfMissing = true)
    public ConfigServicePropertySourceLocator configServicePropertySourceLocator(ConfigClientProperties clientProperties) {
        ConfigServicePropertySourceLocator configServicePropertySourceLocator =  new ConfigServicePropertySourceLocator(clientProperties);
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setReadTimeout(100000);
        factory.setConnectTimeout(100000);
        configServicePropertySourceLocator.setRestTemplate(new RestTemplate(factory));
        return configServicePropertySourceLocator;
    }
}