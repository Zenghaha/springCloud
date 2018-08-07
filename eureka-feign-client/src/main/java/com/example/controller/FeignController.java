package com.example.controller;

import com.example.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    HiService hiService;

    @GetMapping("/testFeign")
    public String sayHi(@RequestParam(required = false,defaultValue = "zhh") String name) {
        return hiService.sayHi(name);
    }
}
