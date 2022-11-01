package com.ash.cloud.modules.product.dao;

import com.ash.cloud.modules.product.entity.ProductAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu属性值
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
@Mapper
public interface ProductAttrValueDao extends BaseMapper<ProductAttrValueEntity> {
	
}
