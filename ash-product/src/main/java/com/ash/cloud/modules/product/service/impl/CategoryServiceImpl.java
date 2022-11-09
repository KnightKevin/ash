package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.modules.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.product.dao.CategoryDao;
import com.ash.cloud.modules.product.entity.CategoryEntity;
import com.ash.cloud.modules.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {

        // 查出所有分类
        List<CategoryEntity> list = baseMapper.selectList(null);

        // 组装成树结构
        List<CategoryEntity> tree = list.stream()
                .filter(i->i.getParentCid()==0)
                .map(i->{
                    i.setChildren(getChildren(i, list));
                    return i;
                })
                .sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort())))
                .collect(Collectors.toList());

        // 每个top生成树


        return tree;
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();

        findParentPath(catelogId, paths);

        Collections.reverse(paths);

        return paths.toArray(new Long[paths.size()]);
    }

    /**
     * 级联更新所有关联的数据
     * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        if (StringUtils.isNotEmpty(category.getName())) {
            categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
        }
    }


    private void findParentPath(Long catelogId, List<Long> paths) {

        paths.add(catelogId);

        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
    }

    /**
     * 获取所有孩子
     * */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(i->i.getParentCid().equals(root.getCatId()))
                .map(i->{
                    i.setChildren(getChildren(i, all));
                    return i;
                })
                .sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort())))
                .collect(Collectors.toList());
    }

}