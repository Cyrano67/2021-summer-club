package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.UserList;

public interface ordersinfoService {
	
	OrdersInfo findById(int id);
	
	boolean register(OrdersInfo order);
}
