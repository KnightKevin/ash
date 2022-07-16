package com.ash.cloud.modules.member.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.member.dto.MemberLevelDTO;
import com.ash.cloud.modules.member.service.MemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员等级
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    @GetMapping("page")
    public Result<PageData<MemberLevelDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberLevelDTO> page = memberLevelService.page(params);

        return new Result<PageData<MemberLevelDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<MemberLevelDTO> get(@PathVariable("id") Long id){
        MemberLevelDTO data = memberLevelService.get(id);

        return new Result<MemberLevelDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody MemberLevelDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberLevelService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody MemberLevelDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberLevelService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberLevelService.delete(ids);

        return new Result();
    }
}