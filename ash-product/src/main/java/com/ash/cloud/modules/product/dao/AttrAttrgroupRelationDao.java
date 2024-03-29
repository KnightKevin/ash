package com.ash.cloud.modules.product.dao;

import com.ash.cloud.modules.product.entity.AttrAttrgroupRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性&属性分组关联
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    void deleteBatchRelation(@Param("entities") List<AttrAttrgroupRelationEntity> entities);

    void insertBatch(@Param("entities") List<AttrAttrgroupRelationEntity> entities);
}
