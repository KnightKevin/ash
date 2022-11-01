package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.common.constant.ProductConstant;
import com.ash.cloud.modules.product.service.AttrGroupService;
import com.ash.cloud.modules.product.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.product.dao.AttrDao;
import com.ash.cloud.modules.product.entity.AttrEntity;
import com.ash.cloud.modules.product.service.AttrService;
import org.w3c.dom.Attr;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, String attrType, Long catelogId) {

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<AttrEntity>().eq(
                "attr_type",
                "base".equalsIgnoreCase(attrType)? ProductConstant.AttrEnum.ATTR_TYPE_BASE : ProductConstant.AttrEnum.ATTR_TYPE_SALE
        );

        if (catelogId != 0) {
            wrapper.eq("catelog_id", catelogId);
        }

        String key = (String) params.get("key");
        if (StringUtils.isNotEmpty(key)) {
            wrapper.and(i->i.eq("attr_id", key).or().like("attr_name", key));
        }

        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), wrapper);


        List<AttrEntity> records = page.getRecords();

//        records.stream().map(record->{
//
//            categoryService.getById()
//
//        }).collect(Collectors.toList());


        PageUtils pageUtils = new PageUtils(page);

        return pageUtils;
    }
}