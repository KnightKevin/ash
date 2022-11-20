package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.modules.coupon.entity.SeckillSkuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动商品关联
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:35
 */
@Mapper
public interface SeckillSkuRelationDao extends BaseMapper<SeckillSkuRelationEntity> {
	
}
