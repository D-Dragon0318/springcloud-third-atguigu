package com.spridra.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.IPayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Map;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-20 09:43
 * @Describe: 网关测试控制嘞
 * @Version: 1.0
 */

@RestController
public class PayGateWayController
{
    @Resource
    IPayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id, @RequestHeader Map<String, String> headers, HttpServletRequest request)
    {
        headers.forEach((key, value) -> System.out.println(key + ": " + value));
        String clientIP = getClientIP(request);
        System.out.println("Client IP: " + clientIP);
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    /**
     * 获取客户端真实IP地址（处理了代理的情况）
     */
    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        } else if (ip.contains(",")) {
            // X-Forwarded-For 可能包含多个IP，第一个为客户端真实IP
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("X-Request-atguigu1")
                    || headName.equalsIgnoreCase("X-Request-atguigu2")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }
        return ResultData.success("getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }
}
