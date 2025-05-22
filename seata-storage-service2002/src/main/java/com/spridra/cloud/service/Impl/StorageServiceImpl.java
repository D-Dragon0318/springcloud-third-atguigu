package com.spridra.cloud.service.Impl;

import com.spridra.cloud.mapper.StorageMapper;
import com.spridra.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:11
 * @Describe:
 * @Version: 1.0
 */

@Service
@Slf4j
public class StorageServiceImpl implements StorageService
{

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
