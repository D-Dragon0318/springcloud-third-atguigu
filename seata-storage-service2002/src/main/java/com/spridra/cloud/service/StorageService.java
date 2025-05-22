package com.spridra.cloud.service;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:10
 * @Describe:
 * @Version: 1.0
 */

public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
