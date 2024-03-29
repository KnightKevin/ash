package com.ash.cloud.modules.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.ash.cloud.modules.product.vo.AttrResponseVo;
import com.ash.cloud.modules.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ash.cloud.modules.product.entity.AttrEntity;
import com.ash.cloud.modules.product.service.AttrService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.R;



/**
 * 商品属性
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:41
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 查询规格参数信息
     */
    @RequestMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(
            @RequestParam Map<String, Object> params,
            @PathVariable("attrType") String attrType,
            @PathVariable("catelogId") Long catelogId
    ){
        PageUtils page = attrService.queryBaseAttrPage(params, attrType, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        AttrResponseVo vo = attrService.getInfoById(attrId);

        return R.ok().put("attr", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
