package com.ash.cloud.modules.coupon.service;

import com.ash.cloud.common.service.CrudService;
import com.ash.cloud.modules.coupon.dto.HomeSubjectDTO;
import com.ash.cloud.modules.coupon.entity.HomeSubjectEntity;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-13
 */
public interface HomeSubjectService extends CrudService<HomeSubjectEntity, HomeSubjectDTO> {

}