package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void sendMessageByRabbitMq()
	{
		for(int i = 0;i < 3; i++)
		{
			rabbitTemplate.convertAndSend("queue_work","测试Work模型" + i);
		}
	}
}
