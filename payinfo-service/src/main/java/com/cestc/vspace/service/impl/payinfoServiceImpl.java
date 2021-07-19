package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.PayInfoMapper;
import com.cestc.vspace.pojo.PayInfo;
import com.cestc.vspace.service.payinfoService;


@Service
public class payinfoServiceImpl implements payinfoService{
	
	@Autowired
	private PayInfoMapper payinfomapper;
	
	public payinfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PayInfo findById(int id) {
		// TODO Auto-generated method stub
		return payinfomapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean register(PayInfo pay) {
		// TODO Auto-generated method stub
		payinfomapper.insert(pay);
		return true;
	}

}
