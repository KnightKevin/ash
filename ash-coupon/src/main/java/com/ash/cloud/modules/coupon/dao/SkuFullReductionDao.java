package com.ash.cloud.modules.coupon.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.coupon.entity.SkuFullReductionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品满减信息
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface SkuFullReductionDao extends BaseDao<SkuFullReductionEntity> {
	
}