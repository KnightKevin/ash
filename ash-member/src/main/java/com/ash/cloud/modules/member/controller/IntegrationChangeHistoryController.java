package com.ash.cloud.modules.member.controller;

import com.ash.cloud.common.constant.Constant;
import com.ash.cloud.common.page.PageData;
import com.ash.cloud.common.utils.Result;
import com.ash.cloud.common.validator.AssertUtils;
import com.ash.cloud.common.validator.ValidatorUtils;
import com.ash.cloud.common.validator.group.AddGroup;
import com.ash.cloud.common.validator.group.DefaultGroup;
import com.ash.cloud.common.validator.group.UpdateGroup;
import com.ash.cloud.modules.member.dto.IntegrationChangeHistoryDTO;
import com.ash.cloud.modules.member.service.IntegrationChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 积分变化历史记录
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    @GetMapping("page")
    public Result<PageData<IntegrationChangeHistoryDTO>> page(@RequestParam Map<String, Object> params){
        PageData<IntegrationChangeHistoryDTO> page = integrationChangeHistoryService.page(params);

        return new Result<PageData<IntegrationChangeHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<IntegrationChangeHistoryDTO> get(@PathVariable("id") Long id){
        IntegrationChangeHistoryDTO data = integrationChangeHistoryService.get(id);

        return new Result<IntegrationChangeHistoryDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody IntegrationChangeHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        integrationChangeHistoryService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody IntegrationChangeHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        integrationChangeHistoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        integrationChangeHistoryService.delete(ids);

        return new Result();
    }
}