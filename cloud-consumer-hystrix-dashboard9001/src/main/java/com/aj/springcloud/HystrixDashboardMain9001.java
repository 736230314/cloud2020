package com.aj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author Aj
 * @Date 2020/8/17 0017 20:02
 * @Version 1.0
 */

@SpringBootApplication
@EnableHystrixDashboard//开启豪猪仪表盘
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
