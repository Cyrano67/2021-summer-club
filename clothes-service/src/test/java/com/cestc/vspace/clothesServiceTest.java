package com.cestc.vspace;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cestc.vspace.service.clothesService;

@SpringBootTest(classes ={ClothServiceApplication.class})
@RunWith(SpringRunner.class)
public class clothesServiceTest {

	public clothesServiceTest() {
		// TODO Auto-generated constructor stub
	}
	@Reference
	private clothesService clothservice;
	
	@Test
	public void test() {
		System.out.println(clothservice.findById(1));
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
