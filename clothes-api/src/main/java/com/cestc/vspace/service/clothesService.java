package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;

public interface clothesService {
	
	Clothes findById(int id);
	
	boolean register(Clothes cloth);
}
