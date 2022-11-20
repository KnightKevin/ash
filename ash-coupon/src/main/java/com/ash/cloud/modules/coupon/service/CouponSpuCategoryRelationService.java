package com.ash.cloud.modules.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:36
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

