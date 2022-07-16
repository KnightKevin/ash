package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.CategoryBrandRelationDTO;
import com.ash.cloud.modules.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 品牌分类关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @GetMapping("page")
    public Result<PageData<CategoryBrandRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CategoryBrandRelationDTO> page = categoryBrandRelationService.page(params);

        return new Result<PageData<CategoryBrandRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<CategoryBrandRelationDTO> get(@PathVariable("id") Long id){
        CategoryBrandRelationDTO data = categoryBrandRelationService.get(id);

        return new Result<CategoryBrandRelationDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody CategoryBrandRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        categoryBrandRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody CategoryBrandRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        categoryBrandRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        categoryBrandRelationService.delete(ids);

        return new Result();
    }
}