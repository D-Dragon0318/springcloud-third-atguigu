package com.spridra.cloud.service;

import com.spridra.cloud.entities.Order;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:00
 * @Describe:
 * @Version: 1.0
 */

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}
