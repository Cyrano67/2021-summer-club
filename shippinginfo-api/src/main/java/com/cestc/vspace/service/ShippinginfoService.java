package com.cestc.vspace.service;

import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.pojo.UserList;

public interface ShippinginfoService {
	
	ShippingInfo findById(int id);
	
	boolean register(ShippingInfo user);

	boolean delete(Integer sid);
}
