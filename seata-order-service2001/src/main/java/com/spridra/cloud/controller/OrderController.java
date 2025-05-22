package com.spridra.cloud.controller;

import com.spridra.cloud.entities.Order;
import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    // @GetMapping("/order/create")
    @PostMapping("/order/create")
    // public ResultData create(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId, @RequestParam("count") Integer count,@RequestParam("money") Long money) {
    public ResultData create(@RequestBody Order order) {
        // Order order = new Order();
        // order.setUserId(userId);
        // order.setProductId(productId);
        // order.setCount(count);
        // order.setMoney(money);
        System.out.println(order);
        orderService.create(order);
        return ResultData.success(order);
    }
}
