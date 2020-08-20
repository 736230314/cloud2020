package com.aj.springcloud.testdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author Aj
 * @Date 2020/8/20 0020 14:56
 * @Version 1.0
 */

public class Test1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂,并设置连接信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.41.52");
        f.setPort(5672);//可选,5672是默认端口
        f.setUsername("admin");
        f.setPassword("admin");
        f.setVirtualHost("/");

        Connection c = f.newConnection();
        //建立信道
        Channel ch = c.createChannel();

        ch.queueDeclare("helloworld", false,false,false,null);

        /*
         * 发布消息
         * 这里把消息向默认交换机发送.
         * 默认交换机隐含与所有队列绑定,routing key即为队列名称
         *
         * 参数含义:
         * 	-exchange: 交换机名称,空串表示默认交换机"(AMQP default)",不能用 null
         * 	-routingKey: 对于默认交换机,路由键就是目标队列名称
         * 	-props: 其他参数,例如头信息
         * 	-body: 消息内容byte[]数组
         */
        ch.basicPublish("", "helloworld", null, "Hello world!".getBytes());

        System.out.println("消息已发送");
        c.close();
    }
}
