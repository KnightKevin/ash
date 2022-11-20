package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.modules.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:36
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
