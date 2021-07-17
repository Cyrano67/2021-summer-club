package com.cestc.vspace.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.UserListMapper;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.pojo.UserListExample;
import com.cestc.vspace.pojo.UserListExample.Criteria;
import com.cestc.vspace.service.UserlistService;


@Service
public class UselistServiceImpl implements UserlistService {
	
	@Autowired
	private UserListMapper usermapper;

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

	@Override
	public UserList Login(String phone, String password) {
		UserListExample example = new UserListExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		criteria.andPasswordEqualTo(password);
		System.out.println("select phone num:");
		System.out.println(phone);
		System.out.println("select pwd:");
		System.out.println(password);
		List<UserList> list = usermapper.selectByExample(example);
		//相当于：select * from user where username = 'wyw' and  username is null order by username asc,email desc
		// TODO Auto-generated method stub
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public UserList AutoLogin(int uid) {
		UserList usr = usermapper.selectByPrimaryKey(uid);
		// TODO Auto-generated method stub
		return usr;
	}

}
