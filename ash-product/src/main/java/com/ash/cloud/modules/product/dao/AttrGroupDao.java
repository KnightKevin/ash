package com.ash.cloud.modules.product.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.product.entity.AttrGroupEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 属性分组
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Mapper
public interface AttrGroupDao extends BaseDao<AttrGroupEntity> {
	
}