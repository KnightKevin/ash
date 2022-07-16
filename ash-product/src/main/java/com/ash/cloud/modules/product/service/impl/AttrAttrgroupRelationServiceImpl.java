package com.ash.cloud.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ash.cloud.common.service.impl.CrudServiceImpl;
import com.ash.cloud.modules.product.dao.AttrAttrgroupRelationDao;
import com.ash.cloud.modules.product.dto.AttrAttrgroupRelationDTO;
import com.ash.cloud.modules.product.entity.AttrAttrgroupRelationEntity;
import com.ash.cloud.modules.product.service.AttrAttrgroupRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends CrudServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity, AttrAttrgroupRelationDTO> implements AttrAttrgroupRelationService {

    @Override
    public QueryWrapper<AttrAttrgroupRelationEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<AttrAttrgroupRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}