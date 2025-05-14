package com.spridra.cloud.controller;

import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.entities.PayDTO;
import com.spridra.cloud.service.IPayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:37
 * @Describe: 支付业务控制层
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PayController {
    @Resource IPayService payService;
    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值："+i;
    }
    @DeleteMapping(value = "/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }
    @PutMapping(value = "/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "成功修改记录，返回值："+i;
    }
    @GetMapping(value = "/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }//全部查询getall作为家庭作业

    @GetMapping(value = "/pay/getAll")
    public List<Pay> getAll(){
        log.info("查询所有记录");
        List<Pay> payList = payService.getAll();
        log.info("查询结果：{}", payList.toString());
        return payList;
    }
}
