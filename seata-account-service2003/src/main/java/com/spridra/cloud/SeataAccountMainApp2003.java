package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:19
 * @Describe:
 * @Version: 1.0
 */

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.spridra.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
public class SeataAccountMainApp2003
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataAccountMainApp2003.class,args);
    }
}
