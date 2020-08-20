package com.aj.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aj.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @Author Aj
 * @Date 2020/8/20 0020 16:35
 * @Version 1.0
 */
@RestController
public class SendMessageController
{
    @Resource
    private IMessageProvider messageProvider;


    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
       return messageProvider.send();
    }


}
