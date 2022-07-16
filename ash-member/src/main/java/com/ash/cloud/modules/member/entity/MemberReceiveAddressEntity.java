package com.ash.cloud.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员收货地址
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member_receive_address")
public class MemberReceiveAddressEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * member_id
     */
	private Long memberId;
    /**
     * 收货人姓名
     */
	private String name;
    /**
     * 电话
     */
	private String phone;
    /**
     * 邮政编码
     */
	private String postCode;
    /**
     * 省份/直辖市
     */
	private String province;
    /**
     * 城市
     */
	private String city;
    /**
     * 区
     */
	private String region;
    /**
     * 详细地址(街道)
     */
	private String detailAddress;
    /**
     * 省市区代码
     */
	private String areacode;
    /**
     * 是否默认
     */
	private Integer defaultStatus;
}