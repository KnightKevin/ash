package com.ash.cloud.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员登录记录
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member_login_log")
public class MemberLoginLogEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * member_id
     */
	private Long memberId;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * ip
     */
	private String ip;
    /**
     * city
     */
	private String city;
    /**
     * 登录类型[1-web，2-app]
     */
	private Integer loginType;
}