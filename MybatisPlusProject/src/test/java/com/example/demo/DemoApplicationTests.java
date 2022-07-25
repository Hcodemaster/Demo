package com.example.demo;

import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
	}
	@Test
	public void testSelect()
	{
		System.out.println("-------SelectAll Method Test--------------");
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}


}
