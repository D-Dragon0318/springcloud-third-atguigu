package com.spridra.cloud.controller;

import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:14
 * @Describe:
 * @Version: 1.0
 */

@RestController
public class StorageController
{
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
