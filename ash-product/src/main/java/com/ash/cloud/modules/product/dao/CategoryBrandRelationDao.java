package com.ash.cloud.modules.product.dao;

import com.ash.cloud.modules.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {
	void updateCategory(@Param("catId") Long catId, @Param("name") String name);
}
