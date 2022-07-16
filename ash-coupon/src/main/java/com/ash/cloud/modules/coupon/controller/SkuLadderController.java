package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.SkuLadderDTO;
import com.ash.cloud.modules.coupon.service.SkuLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 商品阶梯价格
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    @GetMapping("page")
    public Result<PageData<SkuLadderDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SkuLadderDTO> page = skuLadderService.page(params);

        return new Result<PageData<SkuLadderDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SkuLadderDTO> get(@PathVariable("id") Long id){
        SkuLadderDTO data = skuLadderService.get(id);

        return new Result<SkuLadderDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SkuLadderDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        skuLadderService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SkuLadderDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        skuLadderService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        skuLadderService.delete(ids);

        return new Result();
    }
}