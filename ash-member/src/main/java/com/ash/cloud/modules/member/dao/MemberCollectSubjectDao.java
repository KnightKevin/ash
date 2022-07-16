package com.ash.cloud.modules.member.dao;

import com.ash.cloud.common.dao.BaseDao;
import com.ash.cloud.modules.member.entity.MemberCollectSubjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收藏的专题活动
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface MemberCollectSubjectDao extends BaseDao<MemberCollectSubjectEntity> {
	
}