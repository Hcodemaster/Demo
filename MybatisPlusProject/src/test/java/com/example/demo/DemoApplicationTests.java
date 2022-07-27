package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Service.UserService;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Autowired
	UserService userService;
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
	@Test
	public void testSelectOne()
	{
		System.out.println("-------SelectOne Method Test--------------");
		//Wrapper<User> wrapper = new QueryWrapper<User>().eq("name","huang");
		Wrapper<User> wrapper = new UpdateWrapper<User>().set("password","123456789");
		User updateUser = new User();
		userMapper.update(updateUser,wrapper);
		Wrapper<User> queryWrapper = new QueryWrapper<User>().eq("name","huang");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	@Test
	public void TestPage()
	{
		System.out.println("-------Page Method Test--------------");
		IPage<User> page = new Page<User>(1,2);
		/*Page<User> userPage = userService.page(page);
		System.out.println(userPage.getCurrent());
		System.out.println(userPage.getTotal());
		System.out.println(userPage.getSize());
		System.out.println(userPage.getPages());
		System.out.println(userPage.getRecords());*/
		//Wrapper<User> wrapper = new QueryWrapper<User>().eq("name","huang");
		IPage<User> userPage = userMapper.SelectUserOrderByName(page);
		System.out.println(userPage.getCurrent());
		System.out.println(userPage.getTotal());
		System.out.println(userPage.getSize());
		System.out.println(userPage.getPages());
		System.out.println(userPage.getRecords());
		System.out.println(userPage);

	}
	@Test
	public void TestSelectOrigin()
	{
		System.out.println("-------MyBatis Select Origin Method Test--------------");
		User user = userMapper.SelectUserByName("huang");
		System.out.println(user);
	}
}
