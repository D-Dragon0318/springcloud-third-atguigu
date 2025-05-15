package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:17
 * @Describe: 主启动类
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.spridra.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope
public class PayProviderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayProviderMain8001.class, args);
    }
}
