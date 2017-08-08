package com.gy.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class CustomerTest {

//    private static String username = "test";
//    private static String password = "123";
    private static String username = RabbitMQTest.userName1;
    private static String password = RabbitMQTest.password1;

    public static void main(String[] argv){
        /* 建立连接 */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitMQTest.HOST);// MQ的IP
        factory.setPort(RabbitMQTest.PORT);// MQ端口
        factory.setUsername(username);// MQ用户名
        factory.setPassword(password);// MQ密码
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();

        /* 声明要连接的队列 */
            channel.queueDeclare(RabbitMQTest.QUEUE_NAME, false, false, false, null);
            System.out.println("wait message：");

        /* 创建消费者对象，用于读取消息 */
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(RabbitMQTest.QUEUE_NAME, true, consumer);

        /* 读取队列，并且阻塞，即在读到消息之前在这里阻塞，直到等到消息，完成消息的阅读后，继续阻塞循环 */
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("received messages'" + message + "'");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
