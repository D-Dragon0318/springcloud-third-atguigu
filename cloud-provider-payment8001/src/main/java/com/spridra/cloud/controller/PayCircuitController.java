package com.spridra.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-16 15:14
 * @Describe: 计数滑动窗口熔断
 * @Version: 1.0
 */

@RestController
public class PayCircuitController {
    private static final Logger log = LoggerFactory.getLogger(PayCircuitController.class);

    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/pay/circuit/testCircuitNumber/{id}")
    public String testCircuitNumber(@PathVariable("id") Integer id) {
        if(id < 0) throw new RuntimeException("id 不能为负数");
        if(id == 999){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("testCircuitNumber,id = " +id);
        return "Hello, circuit! inputId:  " + " \t " + IdUtil.simpleUUID();
    }
}
