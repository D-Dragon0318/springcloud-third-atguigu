package com.spridra.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 17:03
 * @Describe: 访问远程http服务（rest）
 * @Version: 1.0
 */

@Configuration
public class RestTemplateConfig
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
