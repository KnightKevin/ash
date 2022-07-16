package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.product.dto.CommentReplayDTO;
import com.ash.cloud.modules.product.service.CommentReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 商品评价回复关系
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@RestController
@RequestMapping("product/commentreplay")
public class CommentReplayController {
    @Autowired
    private CommentReplayService commentReplayService;

    @GetMapping("page")
    public Result<PageData<CommentReplayDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CommentReplayDTO> page = commentReplayService.page(params);

        return new Result<PageData<CommentReplayDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<CommentReplayDTO> get(@PathVariable("id") Long id){
        CommentReplayDTO data = commentReplayService.get(id);

        return new Result<CommentReplayDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody CommentReplayDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        commentReplayService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody CommentReplayDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        commentReplayService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        commentReplayService.delete(ids);

        return new Result();
    }
}