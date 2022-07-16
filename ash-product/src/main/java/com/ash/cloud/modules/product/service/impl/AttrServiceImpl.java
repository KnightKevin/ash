package com.ash.cloud.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ash.cloud.common.service.impl.CrudServiceImpl;
import com.ash.cloud.modules.product.dao.AttrDao;
import com.ash.cloud.modules.product.dto.AttrDTO;
import com.ash.cloud.modules.product.entity.AttrEntity;
import com.ash.cloud.modules.product.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品属性
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Service
public class AttrServiceImpl extends CrudServiceImpl<AttrDao, AttrEntity, AttrDTO> implements AttrService {

    @Override
    public QueryWrapper<AttrEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}