package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.modules.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.product.dao.BrandDao;
import com.ash.cloud.modules.product.entity.BrandEntity;
import com.ash.cloud.modules.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(key)) {
            queryWrapper.eq("brand_id", key).or().like("name", key);
        }


        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        // 更新相关冗余表
        if (StringUtils.isNotEmpty(brand.getName())) {
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());
        }

    }
}