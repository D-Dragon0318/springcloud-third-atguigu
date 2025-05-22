package com.spridra.cloud.mapper;

import com.spridra.cloud.entities.Account;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {
    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}