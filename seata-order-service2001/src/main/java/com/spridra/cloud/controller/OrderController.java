package com.spridra.cloud.controller;

import com.spridra.cloud.entities.Order;
import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:02
 * @Describe:
 * @Version: 1.0
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}
