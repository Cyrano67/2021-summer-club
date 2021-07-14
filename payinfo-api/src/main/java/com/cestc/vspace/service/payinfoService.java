package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.PayInfo;
import com.cestc.vspace.pojo.UserList;

public interface payinfoService {
	
	PayInfo findById(int id);
	
	boolean register(PayInfo pay);
}
