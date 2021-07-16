package com.cestc.vspace;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cestc.vspace.service.UserlistService;

@SpringBootTest(classes ={UserServiceApplication.class})
@RunWith(SpringRunner.class)
public class UserlistServiceTest {

	public UserlistServiceTest() {
		// TODO Auto-generated constructor stub
	}
	@Reference
	private UserlistService userservice;
	
	@Test
	public void test() {
		System.out.println(userservice.findById(2));

		System.out.println("1");

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
