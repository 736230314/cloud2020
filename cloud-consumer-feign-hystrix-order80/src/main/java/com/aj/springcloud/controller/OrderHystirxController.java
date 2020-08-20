package com.aj.springcloud.controller;

import com.aj.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 15:35
 * @Version 1.0
 */

@RestController
@Slf4j
//定义全局降级处理
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")  Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
  /*
  一对一 特殊降级处理
  @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/


    //没有指定则用defaultFallback
  @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")  Integer id){

        //int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    //降级方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试,或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    //全局降级处理
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息,请稍后再试,o(╥﹏╥)o";
    }
}
