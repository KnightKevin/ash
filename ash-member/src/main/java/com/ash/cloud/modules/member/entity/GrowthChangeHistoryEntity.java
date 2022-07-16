package com.ash.cloud.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 成长值变化历史记录
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_growth_change_history")
public class GrowthChangeHistoryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * member_id
     */
	private Long memberId;
    /**
     * create_time
     */
	private Date createTime;
    /**
     * 改变的值（正负计数）
     */
	private Integer changeCount;
    /**
     * 备注
     */
	private String note;
    /**
     * 积分来源[0-购物，1-管理员修改]
     */
	private Integer sourceType;
}