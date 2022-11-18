package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.modules.product.service.AttrAttrgroupRelationService;
import com.ash.cloud.modules.product.service.AttrService;
import com.ash.cloud.modules.product.vo.AttrGroupWithAttrsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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

import com.ash.cloud.modules.product.dao.AttrGroupDao;
import com.ash.cloud.modules.product.entity.AttrGroupEntity;
import com.ash.cloud.modules.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>()
            );
            return new PageUtils(page);
        } else {
            String key = (String) params.get("key");
            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);

            if (StringUtils.isNotEmpty(key)) {
                wrapper.and(i->{
                    i.eq("attr_group_id", key).or().like("attr_group_name", key);
                });
            }

            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);

            return new PageUtils(page);

        }

    }

    @Override
    public List<AttrGroupWithAttrsVo> listGroupWithAttrsByCatelogId(Long catelogId) {
        // 查出当前分类下的所有分组
        List<AttrGroupEntity> groups = this.baseMapper.selectList(
                new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId)
        );

        List<AttrGroupWithAttrsVo> vos = groups.stream().map(i->{
            AttrGroupWithAttrsVo vo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(i, vo);

            // 查出每个分组下的费属性
            vo.setAttrs(attrService.getRelationAttr(i.getAttrGroupId()));

            return vo;
        }).collect(Collectors.toList());



        return vos;
    }

}