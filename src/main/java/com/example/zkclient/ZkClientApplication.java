package com.example.zkclient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootApplication
public class ZkClientApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZkClientApplication.class, args);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostConstruct
    public void init() {
        List<ServiceInstance> list = discoveryClient.getInstances("application");
        System.out.println(list);
    }


}
