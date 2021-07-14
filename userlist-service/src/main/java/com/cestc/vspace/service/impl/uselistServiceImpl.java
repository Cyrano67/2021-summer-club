package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.UserListMapper;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.userlistService;


@Service
public class uselistServiceImpl implements userlistService{
	
	@Autowired
	private UserListMapper usermapper;
	
	public uselistServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserList findById(int id) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean register(UserList user) {
		// TODO Auto-generated method stub
		usermapper.insert(user);
		return true;
	}

}
