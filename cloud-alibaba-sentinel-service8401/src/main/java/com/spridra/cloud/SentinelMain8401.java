package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-21 17:47
 * @Describe: sentinel主启动类
 * @Version: 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelMain8401
{
    public static void main(String[] args)
    {
        SpringApplication.run(SentinelMain8401.class,args);
    }
}