package com.ash.cloud.modules.member.dao;

import com.ash.cloud.modules.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-16 21:55:49
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
