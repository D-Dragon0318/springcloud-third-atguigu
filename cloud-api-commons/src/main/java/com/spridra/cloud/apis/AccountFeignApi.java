package com.spridra.cloud.apis;

import com.spridra.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:24
 * @Describe:
 * @Version: 1.0
 */

@FeignClient(value = "seata-account-service")
public interface AccountFeignApi
{
    //扣减账户余额
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
