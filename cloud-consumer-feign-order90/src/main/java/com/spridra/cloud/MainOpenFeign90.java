package com.spridra.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-15 16:55
 * @Describe: 主启动类
 * @Version: 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients//启用feign客户端,定义服务+绑定接口，以声明式的方法优雅而简单的实现服务调用
public class MainOpenFeign90
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainOpenFeign90.class,args);
    }
}