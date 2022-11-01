package com.ash.cloud.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.modules.product.entity.SpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author Simon
 * @email simon@gmail.com
 * @date 2022-10-12 21:08:40
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

