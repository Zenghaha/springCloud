package com.example.controller;

import com.example.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @Autowired
    private LoadBalancerClient balancerClient;

    @GetMapping("/hi")
    public String hello(@RequestParam(required = false,defaultValue = "zhh") String name) {
        return ribbonService.hello(name);
    }

    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance instance =  balancerClient.choose("eureka-client");
        return instance.getHost() + ":" + instance.getPort();
    }
}
