package com.example.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {

    //远程调用失败会重试
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1),5);
    }
}
