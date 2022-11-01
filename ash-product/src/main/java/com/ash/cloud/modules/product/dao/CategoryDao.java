package com.ash.cloud.modules.product.dao;

import com.ash.cloud.modules.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:40
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
