package com.aj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author Aj
 * @Date 2020/8/19 0019 16:35
 * @Version 1.0
 */
@SpringBootApplication
@EnableConfigServer//激活配置中心
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
