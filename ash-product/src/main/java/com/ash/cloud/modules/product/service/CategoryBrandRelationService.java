package com.ash.cloud.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

