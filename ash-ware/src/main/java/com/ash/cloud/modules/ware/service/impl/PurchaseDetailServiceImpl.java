package com.ash.cloud.modules.ware.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.ware.dao.PurchaseDetailDao;
import com.ash.cloud.modules.ware.entity.PurchaseDetailEntity;
import com.ash.cloud.modules.ware.service.PurchaseDetailService;


@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailDao, PurchaseDetailEntity> implements PurchaseDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // key:
        //asfdadf
        //status:
        //0
        //wareId:
        //1610262156602867700

        QueryWrapper<PurchaseDetailEntity> queryWrapper = new QueryWrapper<PurchaseDetailEntity>();
        String key = (String) params.get("key");
        if (StringUtils.isNotEmpty(key)) {
            queryWrapper.and(w-> w.eq("id", key).or().eq("sku_id", key));
        }

        String status = (String) params.get("status");
        if (StringUtils.isNotEmpty(key)) {
            queryWrapper.eq("status", status);
        }

        String wareId = (String) params.get("wareId");
        if (StringUtils.isNotEmpty(key)) {
            queryWrapper.eq("ware_id", wareId);
        }

        IPage<PurchaseDetailEntity> page = this.page(
                new Query<PurchaseDetailEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}