package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.AttrGroupDTO;
import com.ash.cloud.modules.product.service.AttrGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 属性分组
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @GetMapping("page")
    public Result<PageData<AttrGroupDTO>> page(@RequestParam Map<String, Object> params){
        PageData<AttrGroupDTO> page = attrGroupService.page(params);

        return new Result<PageData<AttrGroupDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<AttrGroupDTO> get(@PathVariable("id") Long id){
        AttrGroupDTO data = attrGroupService.get(id);

        return new Result<AttrGroupDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody AttrGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attrGroupService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody AttrGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        attrGroupService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attrGroupService.delete(ids);

        return new Result();
    }
}