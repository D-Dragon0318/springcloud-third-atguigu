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

    /**
     * 信号量舱壁（SemaphoreBulkhead）原理
     * 当信号量有空闲时，进入系统的请求会直接获取信号量并开始业务处理。
     * 当信号量全被占用时，接下来的请求将会进入阻塞状态，SemaphoreBulkhead提供了一个阻塞计时器，
     * 如果阻塞状态的请求在阻塞计时内无法获取到信号量则系统会拒绝这些请求。
     * 若请求在阻塞计时内获取到了信号量，那将直接获取信号量并执行相应的业务处理。
     */
    @GetMapping(value = "/pay/circuit/testBulkhead/{id}")
    public String testBulkhead(@PathVariable("id") Integer id) {
        if(id == -4) throw new RuntimeException("----bulkhead id 不能-4");

        if(id == 9999)
        {
            try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        return "Hello, bulkhead! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }
}
