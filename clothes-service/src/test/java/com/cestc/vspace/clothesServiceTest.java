package com.cestc.vspace;

import com.cestc.vspace.service.ClothesService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cestc.vspace.pojo.Clothes;

import java.util.List;

@SpringBootTest(classes ={ClothServiceApplication.class})
@RunWith(SpringRunner.class)
public class clothesServiceTest {

	public clothesServiceTest() {
		// TODO Auto-generated constructor stub
	}
	@Reference
	private ClothesService clothservice;
	
	@Test
	public void test() {
		Clothes cloth;
		cloth=clothservice.findById(1);
		cloth.setCname("大码");

		List<Clothes> list;
		list=clothservice.findTop9Clothes();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCname());
		}

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
