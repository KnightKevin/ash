package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.SkuInfoDTO;
import com.ash.cloud.modules.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * sku信息
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("page")
    public Result<PageData<SkuInfoDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SkuInfoDTO> page = skuInfoService.page(params);

        return new Result<PageData<SkuInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SkuInfoDTO> get(@PathVariable("id") Long id){
        SkuInfoDTO data = skuInfoService.get(id);

        return new Result<SkuInfoDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SkuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        skuInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SkuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        skuInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        skuInfoService.delete(ids);

        return new Result();
    }
}