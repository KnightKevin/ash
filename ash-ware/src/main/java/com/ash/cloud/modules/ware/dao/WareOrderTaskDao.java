package com.ash.cloud.modules.ware.dao;

import com.ash.cloud.modules.ware.entity.WareOrderTaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存工作单
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-22 21:20:44
 */
@Mapper
public interface WareOrderTaskDao extends BaseMapper<WareOrderTaskEntity> {
	
}
