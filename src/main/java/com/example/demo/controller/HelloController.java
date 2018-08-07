package com.example.demo.controller;

import com.example.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {

    @Autowired
    ConfigBean configBean;

    @GetMapping("/hello")
    public String Hello() {
        return "HelloWorld" + configBean.getName() + "-" + configBean.getAge() + "-" + configBean.getNumber();
    }

    @GetMapping("/testRest")
    public String testRest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com/",String.class);
    }
}
