package com.ash.cloud.modules.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.product.dao.CategoryDao;
import com.ash.cloud.modules.product.entity.CategoryEntity;
import com.ash.cloud.modules.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

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