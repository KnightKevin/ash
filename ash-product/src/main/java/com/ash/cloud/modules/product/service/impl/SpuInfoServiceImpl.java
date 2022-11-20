package com.ash.cloud.modules.product.service.impl;

import com.ash.cloud.common.to.SpuBoundTo;
import com.ash.cloud.modules.product.entity.*;
import com.ash.cloud.modules.product.feign.CouponFeignService;
import com.ash.cloud.modules.product.service.*;
import com.ash.cloud.modules.product.vo.spu.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ash.cloud.common.utils.PageUtils;
import com.ash.cloud.common.utils.Query;

import com.ash.cloud.modules.product.dao.SpuInfoDao;
import org.springframework.transaction.annotation.Transactional;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Autowired
    private SpuImagesService spuImagesService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private SkuImagesService skuImagesService;

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    private CouponFeignService couponFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSpuInfoVo(SpuSaveVo vo) {
        // spu_info
        SpuInfoEntity spuInfo = new SpuInfoEntity();
        BeanUtils.copyProperties(vo, spuInfo);
        this.save(spuInfo);

        final Long spuId = spuInfo.getId();

        // spu_info_desc
        SpuInfoDescEntity spuInfoDescEntity = new SpuInfoDescEntity();
        spuInfoDescEntity.setSpuId(spuId);
        spuInfoDescEntity.setDecript(String.join(",", vo.getDecript()));
        spuInfoDescService.save(spuInfoDescEntity);

        // spu_info_images
        List<SpuImagesEntity> images = vo.getImages().stream().map(i->{
            SpuImagesEntity spuImagesEntity = new SpuImagesEntity();
            spuImagesEntity.setSpuId(spuId);
            spuImagesEntity.setImgUrl(i);
            return spuImagesEntity;
        }).collect(Collectors.toList());
        spuImagesService.saveBatch(images);

        // product_attr_value
        List<ProductAttrValueEntity> attrValues = vo.getBaseAttrs().stream().map(i->{
            ProductAttrValueEntity productAttrValueEntity = new ProductAttrValueEntity();
            productAttrValueEntity.setAttrId(i.getAttrId());
            productAttrValueEntity.setAttrName(attrService.getById(i.getAttrId()).getAttrName());
            productAttrValueEntity.setAttrValue(i.getAttrValues());
            productAttrValueEntity.setQuickShow(i.getShowDesc());
            productAttrValueEntity.setSpuId(spuId);
            return productAttrValueEntity;
        }).collect(Collectors.toList());
        productAttrValueService.saveBatch(attrValues);

        // 保存spu的积分信息 sms_spu_bounds
        Bounds bounds = vo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuId);
        couponFeignService.saveSpuBounds(spuBoundTo);

        // sku

        // sku_info
        for (Skus i : vo.getSkus()) {

            String defaultImage = "";
            for (Images image : i.getImages()) {
                if (image.getDefaultImg() == 1) {
                    defaultImage = image.getImgUrl();
                }
            }

            SkuInfoEntity skuInfo = new SkuInfoEntity();
            BeanUtils.copyProperties(i, skuInfo);
            skuInfo.setSpuId(spuId);
            skuInfo.setCatalogId(vo.getCatalogId());
            skuInfo.setBrandId(vo.getBrandId());
            skuInfo.setSkuDefaultImg(defaultImage);
            skuInfo.setSaleCount(0L);
            skuInfoService.save(skuInfo);
            Long skuId = skuInfo.getSkuId();

            // 图片信息
            List<SkuImagesEntity> skuImages = i.getImages().stream().map(m->{
                SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                BeanUtils.copyProperties(m, skuImagesEntity);
                skuImagesEntity.setSkuId(skuId);
                return skuImagesEntity;
            }).collect(Collectors.toList());
            skuImagesService.saveBatch(skuImages);

            // 销售属性
            List<SkuSaleAttrValueEntity> skuAttrValues = i.getAttr().stream().map(attr->{
                SkuSaleAttrValueEntity skuSaleAttrValue = new SkuSaleAttrValueEntity();
                BeanUtils.copyProperties(attr, skuSaleAttrValue);
                skuSaleAttrValue.setSkuId(skuId);
                return skuSaleAttrValue;
            }).collect(Collectors.toList());
            skuSaleAttrValueService.saveBatch(skuAttrValues);

        }



    }

}