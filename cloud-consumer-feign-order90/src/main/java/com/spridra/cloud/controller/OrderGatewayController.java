package com.spridra.cloud.controller;

import com.spridra.cloud.apis.PayFeignApi;
import com.spridra.cloud.resp.ResultData;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Map;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-20 09:59
 * @Describe: 订单网关消费控制嘞
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderGatewayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData testGateway(@PathVariable("id") Integer id, @RequestHeader Map<String, String> headers)
    {
        headers.forEach((key, value) -> System.out.println(key + ": " + value));
        return payFeignApi.getById(id);
    }
    public String myGatewayFallback(Integer id,Throwable t)
    {
        return "网关拦截，禁止访问/(ㄒoㄒ)/~~";
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData testGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }
    public String myGatewayInfoFallback(Throwable t)
    {
        return "网关拦截，禁止访问/(ㄒoㄒ)/~~";
    }
}
