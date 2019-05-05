package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现
public class DeptProvider_App8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_App8003.class,args);
    }
}
