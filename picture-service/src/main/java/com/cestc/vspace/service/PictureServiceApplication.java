package com.cestc.vspace.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableDubbo
@EnableTransactionManagement
public class PictureServiceApplication {

	public PictureServiceApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(PictureServiceApplication.class, args);
	}

}