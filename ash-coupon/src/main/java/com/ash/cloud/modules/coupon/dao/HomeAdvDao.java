package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.coupon.entity.HomeAdvEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页轮播广告
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface HomeAdvDao extends BaseDao<HomeAdvEntity> {
	
}