package com.ash.cloud.modules.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ash.cloud.modules.product.entity.AttrEntity;
import com.ash.cloud.modules.product.service.AttrService;
import com.ash.cloud.modules.product.service.CategoryService;
import com.ash.cloud.modules.product.vo.AttrGroupRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ash.cloud.modules.product.entity.AttrGroupEntity;
import com.ash.cloud.modules.product.service.AttrGroupService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.R;



/**
 * 属性分组
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public R list(
            @RequestParam Map<String, Object> params,
            @PathVariable("catelogId") Long catelogId
            ){
        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        attrGroup.setCatelogPath(categoryService.findCatelogPath(catelogId));
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }


    @GetMapping("/{attrgroupId}/attr/relation")
    public R listRelationAttr(@PathVariable("attrgroupId") Long attrgroupId) {
        List<AttrEntity> list = attrService.getRelationAttr(attrgroupId);

        return R.ok().put("data", list);
    }

    @PostMapping("/attr/relation/delete")
    public R deleteRelationAttr(@RequestBody List<AttrGroupRelationVo> list) {
        attrService.deleteAttrGroupRelation(list);

        return R.ok();
    }

}
