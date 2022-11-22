package com.ash.cloud.modules.ware.dao;

import com.ash.cloud.modules.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-22 21:20:44
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
