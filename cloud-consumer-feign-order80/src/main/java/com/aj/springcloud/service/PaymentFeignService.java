package com.aj.springcloud.service;

import com.aj.springcloud.entities.CommonResult;
import com.aj.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 10:32
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService
{
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
