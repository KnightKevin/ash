package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.SkuFullReductionDTO;
import com.ash.cloud.modules.coupon.service.SkuFullReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 商品满减信息
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/skufullreduction")
public class SkuFullReductionController {
    @Autowired
    private SkuFullReductionService skuFullReductionService;

    @GetMapping("page")
    public Result<PageData<SkuFullReductionDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SkuFullReductionDTO> page = skuFullReductionService.page(params);

        return new Result<PageData<SkuFullReductionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SkuFullReductionDTO> get(@PathVariable("id") Long id){
        SkuFullReductionDTO data = skuFullReductionService.get(id);

        return new Result<SkuFullReductionDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SkuFullReductionDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        skuFullReductionService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SkuFullReductionDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        skuFullReductionService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        skuFullReductionService.delete(ids);

        return new Result();
    }
}