package com.qkh.gulimall.member.feign;

import com.qkh.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qkh
 * @create 2023-08-29 10:59
 */
@FeignClient("gulimall-coupon")
@Service
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
