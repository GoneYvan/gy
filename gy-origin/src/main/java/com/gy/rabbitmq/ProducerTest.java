package com.gy.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class ProducerTest {

    private static Integer total = 2;
    private static String username = RabbitMQTest.userName;
    private static String password = RabbitMQTest.password;

    public static void main( String[] args )
    {
        ConnectionFactory factory = new ConnectionFactory();
        // 设置MabbitMQ所在主机ip或者主机名
        factory.setHost(RabbitMQTest.HOST);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setPort(RabbitMQTest.PORT);
        // 创建一个连接
        Connection connection = null;
        try {
            connection = factory.newConnection();
            // 创建一个频道
            Channel channel = connection.createChannel();
            // 指定一个队列
            channel.queueDeclare(RabbitMQTest.QUEUE_NAME, false, false, false, null);
            // 发送的消息
            for (int i = 0; i < total; i++) {
                String message = "i am " + username + " , the message sort " + (i+1);
                // 往队列中发出一条消息
                channel.basicPublish("", RabbitMQTest.QUEUE_NAME, null, message.getBytes());
                System.out.println(" [" + username + "] Sent '" + message + "'");
            }
            // 关闭频道和连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
