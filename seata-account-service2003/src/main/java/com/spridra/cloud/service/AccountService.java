package com.spridra.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-22 16:21
 * @Describe:
 * @Version: 1.0
 */

public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
