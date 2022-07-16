package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.SeckillSkuRelationDTO;
import com.ash.cloud.modules.coupon.service.SeckillSkuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 秒杀活动商品关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    @GetMapping("page")
    public Result<PageData<SeckillSkuRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SeckillSkuRelationDTO> page = seckillSkuRelationService.page(params);

        return new Result<PageData<SeckillSkuRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SeckillSkuRelationDTO> get(@PathVariable("id") Long id){
        SeckillSkuRelationDTO data = seckillSkuRelationService.get(id);

        return new Result<SeckillSkuRelationDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SeckillSkuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        seckillSkuRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SeckillSkuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        seckillSkuRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        seckillSkuRelationService.delete(ids);

        return new Result();
    }
}