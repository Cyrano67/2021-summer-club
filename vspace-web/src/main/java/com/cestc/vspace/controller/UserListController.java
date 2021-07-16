package com.cestc.vspace.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.UserlistService;

@RestController
@RequestMapping("/user")
public class UserListController {
	
	@Reference
	private UserlistService userlistService;
	
	@RequestMapping("/findByUid")
	public UserList findUserById(){
		UserList user = userlistService.findById(1);
		System.out.println();
		return user;
	}


	public UserListController() {
		// TODO Auto-generated constructor stub

	}

}
