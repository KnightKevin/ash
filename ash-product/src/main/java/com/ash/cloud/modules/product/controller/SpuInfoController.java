package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.SpuInfoDTO;
import com.ash.cloud.modules.product.service.SpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * spu信息
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/spuinfo")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    @GetMapping("page")
    public Result<PageData<SpuInfoDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SpuInfoDTO> page = spuInfoService.page(params);

        return new Result<PageData<SpuInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SpuInfoDTO> get(@PathVariable("id") Long id){
        SpuInfoDTO data = spuInfoService.get(id);

        return new Result<SpuInfoDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SpuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        spuInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SpuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        spuInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        spuInfoService.delete(ids);

        return new Result();
    }
}