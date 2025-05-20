package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-20 16:22
 * @Describe: nacos消费者接口
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain83.class, args);
    }
}
