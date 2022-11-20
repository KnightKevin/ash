package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.modules.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:36
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
