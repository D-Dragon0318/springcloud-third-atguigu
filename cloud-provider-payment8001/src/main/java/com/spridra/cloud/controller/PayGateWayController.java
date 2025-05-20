package com.spridra.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.IPayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }
}
