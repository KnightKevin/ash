package com.ash.cloud.modules.product.dao;

import com.ash.cloud.modules.product.entity.SpuCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:40
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuCommentEntity> {
	
}
