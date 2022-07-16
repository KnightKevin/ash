package com.ash.cloud.modules.product.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.product.entity.SkuImagesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku图片
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Mapper
public interface SkuImagesDao extends BaseDao<SkuImagesEntity> {
	
}