package com.ash.cloud.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:40
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

