package com.ash.cloud.modules.member.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.member.dto.MemberCollectSubjectDTO;
import com.ash.cloud.modules.member.service.MemberCollectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员收藏的专题活动
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    @GetMapping("page")
    public Result<PageData<MemberCollectSubjectDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberCollectSubjectDTO> page = memberCollectSubjectService.page(params);

        return new Result<PageData<MemberCollectSubjectDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<MemberCollectSubjectDTO> get(@PathVariable("id") Long id){
        MemberCollectSubjectDTO data = memberCollectSubjectService.get(id);

        return new Result<MemberCollectSubjectDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody MemberCollectSubjectDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberCollectSubjectService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody MemberCollectSubjectDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberCollectSubjectService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberCollectSubjectService.delete(ids);

        return new Result();
    }
}