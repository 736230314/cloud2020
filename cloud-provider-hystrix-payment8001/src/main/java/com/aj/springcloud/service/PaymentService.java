package com.aj.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.nio.ch.DefaultSelectorProvider;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 11:34
 * @Version 1.0
 */
@Service
public class PaymentService
{
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id)
    {
       return "线程池:    "+Thread.currentThread().getName()+"   PaymentInfo_OK,id:    "+id+"\t" +"O(∩_∩)O哈哈~";
    }

    /**
     * fallbackMethod指定发生异常后 用那个方法作为兜底
     * commandProperties =@HystrixProperty 超过多少时间就会降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimOut(Integer id)
    {
        //int timeNumber = 5;
      //  int age = 10/0;
        //MILLISECONDS暂停毫秒
       try {
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:    "+Thread.currentThread().getName()+"   PaymentInfo_TimeOut,id:    "+id+"\t" +"O(∩_∩)O哈哈~"+"耗时(秒):  ";


    }
    //兜底的方法
    public String paymentInfo_TimOutHandler(Integer id)
    {
        return "线程池:    "+Thread.currentThread().getName()+"   8001系统繁忙或出错,请稍后再试,id:    "+id+"\t" +"o(╥﹏╥)o";
    }

    /*
    * 服务熔断
    *
    *
    * */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数,意思就是在多少次内达到多少失败率就熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        //类似于UUID.randomUUID().toString()  糊涂工具包
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    //兜底的方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
