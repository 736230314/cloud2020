package com.aj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 17:39
 * @Version 1.0
 *
 * 统一异常处理,集中熔断
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_TimeOut',o(╥﹏╥)o";
    }
}
