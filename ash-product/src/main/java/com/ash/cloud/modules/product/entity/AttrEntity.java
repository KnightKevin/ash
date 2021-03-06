package com.ash.cloud.modules.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商品属性
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_attr")
public class AttrEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
	private Long attrId;
    /**
     * 属性名
     */
	private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
	private Integer searchType;
    /**
     * 值类型[0-为单个值，1-可以选择多个值]
     */
	private Integer valueType;
    /**
     * 属性图标
     */
	private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
	private String valueSelect;
    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
	private Integer attrType;
    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
	private Long enable;
    /**
     * 所属分类
     */
	private Long catelogId;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
	private Integer showDesc;
}