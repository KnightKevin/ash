package com.ash.cloud.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryBaseAttrPage(Map<String, Object> params, String type, Long catelogId);

}

