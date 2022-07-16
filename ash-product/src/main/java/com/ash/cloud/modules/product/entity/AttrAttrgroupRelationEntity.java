package com.ash.cloud.modules.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 属性&属性分组关联
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
	private Long attrId;
    /**
     * 属性分组id
     */
	private Long attrGroupId;
    /**
     * 属性组内排序
     */
	private Integer attrSort;
}