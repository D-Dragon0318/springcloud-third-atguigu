package com.spridra.cloud.service;

import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.entities.PayDTO;

import java.util.List;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:27
 * @Describe: 支付业务服务层
 * @Version: 1.0
 */
public interface IPayService {
    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
