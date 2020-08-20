package com.aj.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Author Aj
 * @Date 2020/8/17 0017 10:59
 * @Version 1.0
 */
@Configuration
public class FeginConfig {
    @Bean
    Logger.Level feginLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
