package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
@Author: Spridra
@CreateTime: 2025-05-20 09:40
@Describe: 网关启动类
@Version: 1.0
*/

@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
public class GatewayMain9527
{
    public static void main(String[] args)
    {
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
