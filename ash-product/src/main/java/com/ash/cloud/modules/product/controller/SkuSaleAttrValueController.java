package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.SkuSaleAttrValueDTO;
import com.ash.cloud.modules.product.service.SkuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * sku销售属性&值
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/skusaleattrvalue")
public class SkuSaleAttrValueController {
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @GetMapping("page")
    public Result<PageData<SkuSaleAttrValueDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SkuSaleAttrValueDTO> page = skuSaleAttrValueService.page(params);

        return new Result<PageData<SkuSaleAttrValueDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SkuSaleAttrValueDTO> get(@PathVariable("id") Long id){
        SkuSaleAttrValueDTO data = skuSaleAttrValueService.get(id);

        return new Result<SkuSaleAttrValueDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SkuSaleAttrValueDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        skuSaleAttrValueService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SkuSaleAttrValueDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        skuSaleAttrValueService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        skuSaleAttrValueService.delete(ids);

        return new Result();
    }
}