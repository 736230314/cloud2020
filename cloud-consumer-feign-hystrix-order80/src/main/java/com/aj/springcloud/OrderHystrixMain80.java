package com.aj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 15:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients//激活fegin
@EnableHystrix//激活豪猪
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
