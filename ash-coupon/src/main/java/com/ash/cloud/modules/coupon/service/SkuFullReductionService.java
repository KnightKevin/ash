package com.ash.cloud.modules.coupon.service;

import com.ash.cloud.common.to.SkuReductionTo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-20 22:38:36
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveInfo(SkuReductionTo skuReduction);
}

