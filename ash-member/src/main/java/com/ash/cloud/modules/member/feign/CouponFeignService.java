package com.ash.cloud.modules.member.feign;

import com.ash.cloud.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 须要调用coupon微服务的数据
 *
 * */
@FeignClient("ash-coupon")
public interface CouponFeignService {
    @GetMapping("/coupon/smscoupon/dd")
    Result dd();
}
