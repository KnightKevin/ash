package com.ash.cloud.modules.coupon.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.coupon.dto.SeckillSkuNoticeDTO;
import com.ash.cloud.modules.coupon.service.SeckillSkuNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 秒杀商品通知订阅
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    @GetMapping("page")
    public Result<PageData<SeckillSkuNoticeDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SeckillSkuNoticeDTO> page = seckillSkuNoticeService.page(params);

        return new Result<PageData<SeckillSkuNoticeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<SeckillSkuNoticeDTO> get(@PathVariable("id") Long id){
        SeckillSkuNoticeDTO data = seckillSkuNoticeService.get(id);

        return new Result<SeckillSkuNoticeDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        seckillSkuNoticeService.delete(ids);

        return new Result();
    }
}