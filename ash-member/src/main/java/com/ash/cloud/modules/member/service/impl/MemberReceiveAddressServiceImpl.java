package com.ash.cloud.modules.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ash.cloud.common.service.impl.CrudServiceImpl;
import com.ash.cloud.modules.member.dao.MemberReceiveAddressDao;
import com.ash.cloud.modules.member.dto.MemberReceiveAddressDTO;
import com.ash.cloud.modules.member.entity.MemberReceiveAddressEntity;
import com.ash.cloud.modules.member.service.MemberReceiveAddressService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class MemberReceiveAddressServiceImpl extends CrudServiceImpl<MemberReceiveAddressDao, MemberReceiveAddressEntity, MemberReceiveAddressDTO> implements MemberReceiveAddressService {

    @Override
    public QueryWrapper<MemberReceiveAddressEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MemberReceiveAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}