package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.modules.coupon.entity.SkuLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品阶梯价格
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:35
 */
@Mapper
public interface SkuLadderDao extends BaseMapper<SkuLadderEntity> {
	
}
