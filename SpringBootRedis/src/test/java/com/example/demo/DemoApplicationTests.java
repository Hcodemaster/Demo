package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	StringRedisTemplate template;
	@Autowired
	RedisConnectionFactory factory;

	@Test
	void contextLoads() {
	}
	@Test
	void RedisTest()
	{
		String s = template.opsForValue().get("hello world");
		template.opsForValue().set("name","huang");
		String name = template.opsForValue().get("name");
		System.out.println(s);
		System.out.println(name);
		System.out.println(factory.getConnection().getClass());
		System.out.println("/redis的访问次数" + template.opsForValue().get("/redis"));
	}
}
