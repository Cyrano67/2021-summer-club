package com.cestc.vspace.service;

import com.cestc.vspace.pojo.ShippingInfo;

public interface ShippinginfoService {
	
	ShippingInfo findById(int id);
	
	int register(ShippingInfo user);

	boolean delete(Integer sid);
}
