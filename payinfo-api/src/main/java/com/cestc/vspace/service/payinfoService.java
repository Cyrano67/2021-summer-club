package com.cestc.vspace.service;

import com.cestc.vspace.pojo.PayInfo;

public interface payinfoService {
	
	PayInfo findById(int id);
	
	boolean register(PayInfo pay);
}
