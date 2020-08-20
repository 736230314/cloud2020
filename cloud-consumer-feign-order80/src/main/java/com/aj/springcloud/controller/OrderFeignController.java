package com.aj.springcloud.controller;

import com.aj.springcloud.entities.CommonResult;
import com.aj.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 10:38
 * @Version 1.0
 */

@RestController
@Slf4j
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }
}
