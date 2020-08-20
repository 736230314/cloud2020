package com.aj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Aj
 * @Date 2020/8/16 0016 18:13
 * @Version 1.0
 *
 * 自定义负载均衡算法
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
