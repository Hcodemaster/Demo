package com.example.demo.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @GetMapping("/rabbit")
    public void SendMessage()
    {
        for(int i = 0;i < 3; i++)
        {
            //Message message = new Message(("测试Work模型" + i).getBytes());
            rabbitTemplate.convertAndSend("queue_work","测试Work模型" + i);
        }
    }
    @GetMapping("/broad")
    public void sendMessageForBroad()
    {
        for(int i = 0;i < 5 ; i++)
        {
            //rabbitTemplate.convertAndSend("exchange_fanout","","测试Work模型" + i);
            Message message = new Message(("测试发布订阅模型" + i).getBytes());
            rabbitTemplate.sendAndReceive("exchange_fanout","",message);
        }
    }

    @GetMapping("/topic")
    public void sendMessageForTopic()
    {
        for(int i = 0 ;i < 10 ; i++)
        {
            if(i % 2 == 0)
                rabbitTemplate.convertAndSend("topicExchange","topic.huang","测试Topic模型" + i);
            else
                rabbitTemplate.convertAndSend("topicExchange","topic.huang.zhi","测试Topic模型" + i);
        }
    }
}
