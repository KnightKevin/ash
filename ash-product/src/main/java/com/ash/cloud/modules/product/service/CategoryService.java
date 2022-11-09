package com.ash.cloud.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:40
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    /**
     * 找到catelogId的完整路径
     * [父，子，孙]
     * */
    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

