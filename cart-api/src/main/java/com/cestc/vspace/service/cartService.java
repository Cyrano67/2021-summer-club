package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;

public interface cartService {
	
	Cart findById(int caid);
	
	boolean register(Cart cart);
}
