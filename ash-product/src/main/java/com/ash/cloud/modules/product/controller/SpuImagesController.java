package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.SpuImagesDTO;
import com.ash.cloud.modules.product.service.SpuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * spu图片
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    @GetMapping("page")
    public Result<PageData<SpuImagesDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SpuImagesDTO> page = spuImagesService.page(params);

        return new Result<PageData<SpuImagesDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SpuImagesDTO> get(@PathVariable("id") Long id){
        SpuImagesDTO data = spuImagesService.get(id);

        return new Result<SpuImagesDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SpuImagesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        spuImagesService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SpuImagesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        spuImagesService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        spuImagesService.delete(ids);

        return new Result();
    }
}