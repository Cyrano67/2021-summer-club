package com.cestc.vspace.service;

import com.cestc.vspace.pojo.UserList;

public interface userlistService {
	
	UserList findById(int id);
	
	boolean register(UserList user);
}
