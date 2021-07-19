package com.cestc.vspace.service;

import com.cestc.vspace.pojo.ShippingInfo;

public interface ShippinginfoService {
	
	ShippingInfo findById(int id);
	
	boolean register(ShippingInfo user);

	boolean delete(Integer sid);
}
