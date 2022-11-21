package com.ash.cloud.modules.coupon.service.impl;

import com.ash.cloud.common.to.SkuReductionTo;
import com.ash.cloud.modules.coupon.entity.MemberPriceEntity;
import com.ash.cloud.modules.coupon.entity.SkuLadderEntity;
import com.ash.cloud.modules.coupon.service.MemberPriceService;
import com.ash.cloud.modules.coupon.service.SkuLadderService;
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

import com.ash.cloud.modules.coupon.dao.SkuFullReductionDao;
import com.ash.cloud.modules.coupon.entity.SkuFullReductionEntity;
import com.ash.cloud.modules.coupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    SkuLadderService skuLadderService;

    @Autowired
    MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveInfo(SkuReductionTo skuReduction) {
        // 保存阶梯价格
        SkuLadderEntity skuLadder = new SkuLadderEntity();
        skuLadder.setSkuId(skuReduction.getSkuId());
        skuLadder.setFullCount(skuReduction.getFullCount());
        skuLadder.setDiscount(skuReduction.getDiscount());
        skuLadder.setAddOther(skuReduction.getCountStatus());
        skuLadderService.save(skuLadder);

        // 保存满减信息
        SkuFullReductionEntity skuFullReduction = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReduction, skuFullReduction);
        this.save(skuFullReduction);

        // 会员价格
        List<MemberPriceEntity> memberPrices = skuReduction.getMemberPrice().stream().map(i->{
            MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
            memberPriceEntity.setSkuId(skuReduction.getSkuId());
            memberPriceEntity.setMemberPrice(i.getPrice());
            memberPriceEntity.setMemberLevelName(i.getName());
            memberPriceEntity.setMemberLevelId(i.getId());
            memberPriceEntity.setAddOther(1);
            return memberPriceEntity;
        }).collect(Collectors.toList());
        memberPriceService.saveBatch(memberPrices);
    }

}