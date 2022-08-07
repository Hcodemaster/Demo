package com.example.demo;

import com.example.demo.Interface.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	ProducerService producerService;

	@Test
	void sendMessage()
	{
		producerService.sendMessage("demo_topic","SpringBoot kafka");
	}
}
