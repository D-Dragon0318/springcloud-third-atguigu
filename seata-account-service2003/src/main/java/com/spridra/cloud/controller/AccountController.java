package com.spridra.cloud.controller;

import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:22
 * @Describe:
 * @Version: 1.0
 */

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减账户余额成功！");
    }
}
