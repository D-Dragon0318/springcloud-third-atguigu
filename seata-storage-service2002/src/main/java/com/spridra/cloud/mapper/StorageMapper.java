package com.spridra.cloud.mapper;

import com.spridra.cloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface StorageMapper extends Mapper<Storage> {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}