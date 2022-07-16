package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.CouponSpuRelationDTO;
import com.ash.cloud.modules.coupon.service.CouponSpuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 优惠券与产品关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    @GetMapping("page")
    public Result<PageData<CouponSpuRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponSpuRelationDTO> page = couponSpuRelationService.page(params);

        return new Result<PageData<CouponSpuRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<CouponSpuRelationDTO> get(@PathVariable("id") Long id){
        CouponSpuRelationDTO data = couponSpuRelationService.get(id);

        return new Result<CouponSpuRelationDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody CouponSpuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponSpuRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody CouponSpuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponSpuRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponSpuRelationService.delete(ids);

        return new Result();
    }
}