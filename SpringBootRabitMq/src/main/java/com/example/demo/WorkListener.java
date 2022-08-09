package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class WorkListener {
    @RabbitListener(queues = "queue_work")
    public void ReceiveMessage(String msg)
    {
        System.out.println("msg = " +msg);
        //System.out.println(channel);
        //System.out.println(message);
    }

    @RabbitListener(queues = "queue_fanout1")
    public void ReceiveMessageFromQueue1(String msg)
    {
        System.out.println("队列一接收的消息："+msg);
    }

    @RabbitListener(queues = "queue_fanout2")
    public void ReceiveMessageFromQueue2(String msg)
    {
        System.out.println("队列二接收的消息："+msg);
    }

    @RabbitListener(queues = "queue_topic1")
    public void ReceiveMessageFromTopic1(String msg)
    {
        System.out.println("队列一接收的消息："+msg);
    }

    @RabbitListener(queues = "queue_topic2")
    public void ReceiveMessageFromTopic2(String msg)
    {
        System.out.println("队列二接收的消息："+msg);
    }
}
