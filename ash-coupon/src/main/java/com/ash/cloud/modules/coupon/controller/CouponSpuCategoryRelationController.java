package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.CouponSpuCategoryRelationDTO;
import com.ash.cloud.modules.coupon.service.CouponSpuCategoryRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 优惠券分类关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    @GetMapping("page")
    public Result<PageData<CouponSpuCategoryRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponSpuCategoryRelationDTO> page = couponSpuCategoryRelationService.page(params);

        return new Result<PageData<CouponSpuCategoryRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<CouponSpuCategoryRelationDTO> get(@PathVariable("id") Long id){
        CouponSpuCategoryRelationDTO data = couponSpuCategoryRelationService.get(id);

        return new Result<CouponSpuCategoryRelationDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody CouponSpuCategoryRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponSpuCategoryRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody CouponSpuCategoryRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponSpuCategoryRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponSpuCategoryRelationService.delete(ids);

        return new Result();
    }
}