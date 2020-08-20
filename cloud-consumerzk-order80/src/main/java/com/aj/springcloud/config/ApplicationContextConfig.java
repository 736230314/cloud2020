package com.aj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Aj
 * @Date 2020/8/16 0016 17:23
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig
{
   @Bean
   @LoadBalanced
   public RestTemplate getRestTemplate(){
    return new RestTemplate();
   }
}
