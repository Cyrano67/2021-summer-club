package com.cestc.vspace;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 10:44
 * Description:
 */
//启用springboot注解
@SpringBootApplication
//启用dubbo
@EnableDubbo
public class SearchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class,args);
    }
}
