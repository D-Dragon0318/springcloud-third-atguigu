package com.spridra.cloud.controller;

import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.entities.PayDTO;
import com.spridra.cloud.resp.ResultData;
import com.spridra.cloud.resp.ReturnCodeEnum;
import com.spridra.cloud.service.IPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:37
 * @Describe: 支付业务控制层
 * @Version: 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController
{
    @Resource
    IPayService payService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${spridra.info}") String atguiguInfo)
    {
        return "spridraInfo: "+atguiguInfo+"\t"+"port: "+port;
    }


    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值："+i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        if(id < 0) throw new RuntimeException("id不能为负数");
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @RequestMapping(value = "/pay/error",method = RequestMethod.GET)
    public ResultData<Integer> getPayError()
    {
        Integer i = Integer.valueOf(200);
        try
        {
            System.out.println("--------come here");
            int data = 10/0;
        }catch (Exception e){
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return ResultData.success(i);
    }

    @GetMapping(value = "/pay/getAll")
    public ResultData<List<Pay>> getAll(){
        log.info("查询所有记录");
        List<Pay> payList = payService.getAll();
        log.info("查询结果：{}", payList.toString());
        return ResultData.success(payList);
    }

    @GetMapping(value = "/pay/testTimeout")
    public ResultData<String> testTimeout()
    {
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultData.success("测试超时");
    }
}
