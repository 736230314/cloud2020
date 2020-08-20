package com.aj.springcloud;

import com.aj.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author Aj
 * @Date 2020/8/15 0015 17:02
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//自定义负载均衡算法,指定那个微服务("CLOUD-PAYMENT-SERVICE"),用那个算法(MySelfRule)
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}





