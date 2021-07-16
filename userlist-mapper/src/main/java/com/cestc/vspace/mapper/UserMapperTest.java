package com.cestc.vspace.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes ={UserMapperApplication.class})
@RunWith(SpringRunner.class)
public class UserMapperTest {
	//自动装配一个TbUserMapper
	@Autowired
	private UserListMapper userMapper;
	@Test
	public void test(){
	System.out.println(userMapper.selectByPrimaryKey(1));
	}
}
