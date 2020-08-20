package com.aj.springcloud.service.impl;

import com.aj.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Aj
 * @Date 2020/8/20 0020 16:30
 * @Version 1.0
 */
@EnableBinding(Source.class)//定义消息推送管道
public class MessageProviderImpl implements IMessageProvider
{
    @Resource
   private MessageChannel output;  //消息发送通道



    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial: "+serial);
        return null;
    }
}
