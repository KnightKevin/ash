package com.ash.cloud.modules.ware.dao;

import com.ash.cloud.modules.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-22 21:20:44
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
