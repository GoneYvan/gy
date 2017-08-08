package com.gy.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class RabbitMQTest {

    public final static String QUEUE_NAME = "test_queue";
    public final static String userName = "admin"; // producer
    public final static String password = "123456";
    public final static String userName1 = "test"; // consumer
    public final static String password1 = "123";
    public final static String HOST = "127.0.0.1";
    public final static Integer PORT = 5672;

    public static void main( String[] args )
    {
        /**
         * 创建连接连接到RabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        // 设置MabbitMQ所在主机ip或者主机名
        factory.setHost(HOST);
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setPort(PORT);
        // 创建一个连接
        Connection connection = null;
        try {
            connection = factory.newConnection();
            // 创建一个频道
            Channel channel = connection.createChannel();
            // 指定一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送的消息
            String message = "hello world!";
            // 往队列中发出一条消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
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
