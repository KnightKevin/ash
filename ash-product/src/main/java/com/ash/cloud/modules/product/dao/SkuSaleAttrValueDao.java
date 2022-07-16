package com.ash.cloud.modules.product.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.product.entity.SkuSaleAttrValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku销售属性&值
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseDao<SkuSaleAttrValueEntity> {
	
}