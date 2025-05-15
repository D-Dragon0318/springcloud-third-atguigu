package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
@Author: Spridra
@CreateTime: 2025-05-14 16:56
@Describe: 订单模块主启动类
@Version: 1.0
*/

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain9001.class, args);
    }
}
