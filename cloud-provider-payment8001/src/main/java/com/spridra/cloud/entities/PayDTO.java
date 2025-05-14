package com.spridra.cloud.entities;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:23
 * @Describe: PayDTO
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {

    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
