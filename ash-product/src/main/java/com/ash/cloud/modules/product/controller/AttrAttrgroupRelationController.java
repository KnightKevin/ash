package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.AttrAttrgroupRelationDTO;
import com.ash.cloud.modules.product.service.AttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 属性&属性分组关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @GetMapping("page")
    public Result<PageData<AttrAttrgroupRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<AttrAttrgroupRelationDTO> page = attrAttrgroupRelationService.page(params);

        return new Result<PageData<AttrAttrgroupRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<AttrAttrgroupRelationDTO> get(@PathVariable("id") Long id){
        AttrAttrgroupRelationDTO data = attrAttrgroupRelationService.get(id);

        return new Result<AttrAttrgroupRelationDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody AttrAttrgroupRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody AttrAttrgroupRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attrAttrgroupRelationService.delete(ids);

        return new Result();
    }
}