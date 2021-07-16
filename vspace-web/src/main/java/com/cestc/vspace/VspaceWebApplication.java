package com.cestc.vspace;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class VspaceWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(VspaceWebApplication.class,args);
	}
}
