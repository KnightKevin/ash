package com.ash.cloud.modules.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ash.cloud.common.service.impl.CrudServiceImpl;
import com.ash.cloud.modules.coupon.dao.SeckillSkuNoticeDao;
import com.ash.cloud.modules.coupon.dto.SeckillSkuNoticeDTO;
import com.ash.cloud.modules.coupon.entity.SeckillSkuNoticeEntity;
import com.ash.cloud.modules.coupon.service.SeckillSkuNoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class SeckillSkuNoticeServiceImpl extends CrudServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity, SeckillSkuNoticeDTO> implements SeckillSkuNoticeService {

    @Override
    public QueryWrapper<SeckillSkuNoticeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SeckillSkuNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}