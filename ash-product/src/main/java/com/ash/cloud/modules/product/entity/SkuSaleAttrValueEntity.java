package com.ash.cloud.modules.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * sku销售属性&值
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValueEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;
    /**
     * attr_id
     */
	private Long attrId;
    /**
     * 销售属性名
     */
	private String attrName;
    /**
     * 销售属性值
     */
	private String attrValue;
    /**
     * 顺序
     */
	private Integer attrSort;
}