package com.spridra.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 09:46
 * @Describe: 服务层
 * @Version: 1.0
 */

@Service
public class FlowLimitService
{
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
