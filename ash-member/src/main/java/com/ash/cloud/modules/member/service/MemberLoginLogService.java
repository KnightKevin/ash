package com.ash.cloud.modules.member.service;

import com.ash.cloud.common.service.CrudService;
import com.ash.cloud.modules.member.dto.MemberLoginLogDTO;
import com.ash.cloud.modules.member.entity.MemberLoginLogEntity;

/**
 * 会员登录记录
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
public interface MemberLoginLogService extends CrudService<MemberLoginLogEntity, MemberLoginLogDTO> {

}