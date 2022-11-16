package com.ash.cloud.modules.member.dao;

import com.ash.cloud.modules.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-11-16 21:55:49
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
