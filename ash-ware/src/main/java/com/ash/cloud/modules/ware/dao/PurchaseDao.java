package com.ash.cloud.modules.ware.dao;

import com.ash.cloud.modules.ware.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-22 21:20:44
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
