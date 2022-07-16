package com.ash.cloud.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员收藏的专题活动
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member_collect_subject")
public class MemberCollectSubjectEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * subject_id
     */
	private Long subjectId;
    /**
     * subject_name
     */
	private String subjectName;
    /**
     * subject_img
     */
	private String subjectImg;
    /**
     * 活动url
     */
	private String subjectUrll;
}