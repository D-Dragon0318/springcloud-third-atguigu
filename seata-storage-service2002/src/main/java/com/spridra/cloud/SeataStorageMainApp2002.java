package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:09
 * @Describe:
 * @Version: 1.0
 */

@SpringBootApplication
@MapperScan("com.spridra.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
public class SeataStorageMainApp2002
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageMainApp2002.class,args);
    }
}
