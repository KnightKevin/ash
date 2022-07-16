package com.ash.cloud.modules.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ash.cloud.common.service.impl.CrudServiceImpl;
import com.ash.cloud.modules.coupon.dao.SpuBoundsDao;
import com.ash.cloud.modules.coupon.dto.SpuBoundsDTO;
import com.ash.cloud.modules.coupon.entity.SpuBoundsEntity;
import com.ash.cloud.modules.coupon.service.SpuBoundsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class SpuBoundsServiceImpl extends CrudServiceImpl<SpuBoundsDao, SpuBoundsEntity, SpuBoundsDTO> implements SpuBoundsService {

    @Override
    public QueryWrapper<SpuBoundsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SpuBoundsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}