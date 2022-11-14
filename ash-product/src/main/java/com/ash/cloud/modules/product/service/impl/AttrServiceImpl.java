package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.common.constant.ProductConstant;
import com.ash.cloud.modules.product.dao.AttrAttrgroupRelationDao;
import com.ash.cloud.modules.product.entity.AttrAttrgroupRelationEntity;
import com.ash.cloud.modules.product.entity.AttrGroupEntity;
import com.ash.cloud.modules.product.entity.CategoryEntity;
import com.ash.cloud.modules.product.service.AttrGroupService;
import com.ash.cloud.modules.product.service.CategoryService;
import com.ash.cloud.modules.product.vo.AttrGroupRelationVo;
import com.ash.cloud.modules.product.vo.AttrResponseVo;
import com.ash.cloud.modules.product.vo.AttrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private AttrAttrgroupRelationDao relationDao;


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
                "base".equalsIgnoreCase(attrType)? ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode()
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

        List<AttrResponseVo> voList = records.stream().map(this::convertToVO).collect(Collectors.toList());

        PageUtils pageUtils = new PageUtils(page);

        pageUtils.setList(voList);

        return pageUtils;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr, attrEntity);
        this.save(attrEntity);

        if (attr.getAttrType().equals(ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode())) {
            return;
        }

        AttrAttrgroupRelationEntity relation = new AttrAttrgroupRelationEntity();
        relation.setAttrId(attrEntity.getAttrId());
        relation.setAttrGroupId(attr.getAttrGroupId());
        relationDao.insert(relation);
    }

    @Override
    public AttrResponseVo getInfoById(Long attrId) {
        AttrEntity entity = this.getById(attrId);
        return convertToVO(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAttr(AttrVo attr) {
        AttrEntity entity = new AttrEntity();
        BeanUtils.copyProperties(attr, entity);
        this.updateById(entity);

        if (attr.getAttrType().equals(ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode())) {
            return;
        }

        relationDao.delete(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));

        AttrAttrgroupRelationEntity relation = new AttrAttrgroupRelationEntity();
        relation.setAttrId(attr.getAttrId());
        relation.setAttrGroupId(attr.getAttrGroupId());
        relationDao.insert(relation);
    }

    @Override
    public List<AttrEntity> getRelationAttr(Long attrgroupId) {

        List<AttrAttrgroupRelationEntity> relations = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", attrgroupId));

        List<Long> attrIds = relations.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());

        if (attrIds.size() == 0) {
            return Collections.emptyList();
        }

        List<AttrEntity> list = this.listByIds(attrIds);

        return list;
    }

    @Override
    public void deleteAttrGroupRelation(List<AttrGroupRelationVo> list) {
        List<AttrAttrgroupRelationEntity> entities = list.stream().map(i->{
            AttrAttrgroupRelationEntity entity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(i, entity);
            return entity;
        }).collect(Collectors.toList());
        relationDao.deleteBatchRelation(entities);
    }

    private AttrResponseVo convertToVO(AttrEntity entity) {
        AttrResponseVo vo = new AttrResponseVo();
        BeanUtils.copyProperties(entity, vo);

        // 查询group
        QueryWrapper<AttrAttrgroupRelationEntity> relationWrapper = new QueryWrapper<>();
        AttrAttrgroupRelationEntity relation = relationDao.selectOne(relationWrapper.eq("attr_id", entity.getAttrId()));

        if (entity.getAttrType().equals(ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()) && relation != null) {
            AttrGroupEntity group = attrGroupService.getById(relation.getAttrGroupId());
            vo.setAttrGroupId(relation.getAttrGroupId());
            vo.setGroupName(group.getAttrGroupName());
        }

        CategoryEntity category = categoryService.getById(entity.getCatelogId());
        if (category != null) {
            vo.setCatelogName(category.getName());
        }

        vo.setCatelogPath(categoryService.findCatelogPath(entity.getCatelogId()));

        return vo;
    }
}