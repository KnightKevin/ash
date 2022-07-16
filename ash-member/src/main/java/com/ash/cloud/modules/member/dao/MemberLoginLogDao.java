package com.ash.cloud.modules.member.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.member.entity.MemberLoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface MemberLoginLogDao extends BaseDao<MemberLoginLogEntity> {
	
}