package com.spridra.cloud.apis;

import com.spridra.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:23
 * @Describe:
 * @Version: 1.0
 */

@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi
{
    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
