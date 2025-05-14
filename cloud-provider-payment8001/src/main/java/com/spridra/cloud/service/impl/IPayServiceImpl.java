package com.spridra.cloud.service.impl;

import com.spridra.cloud.entities.Pay;
import com.spridra.cloud.mapper.PayMapper;
import com.spridra.cloud.service.IPayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Spridra
 * @CreateTime: 2025-05-14 14:31
 * @Describe: 业务实现类
 * @Version: 1.0
 */
@Service
public class IPayServiceImpl implements IPayService {
    @Resource
    PayMapper payMapper;
    @Override
    public int add(Pay pay){
        return payMapper.insertSelective(pay);
    }
    @Override
    public int delete(Integer id){
        return payMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int update(Pay pay){
        return payMapper.updateByPrimaryKeySelective(pay);
    }
    @Override
    public Pay getById(Integer id){
        return payMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Pay> getAll(){
        return payMapper.selectAll();
    }
}
