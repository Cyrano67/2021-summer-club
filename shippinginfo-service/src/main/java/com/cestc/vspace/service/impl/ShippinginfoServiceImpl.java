package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.ShippingInfoMapper;
import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.service.ShippinginfoService;


@Service
public class ShippinginfoServiceImpl implements ShippinginfoService {
	
	@Autowired
	private ShippingInfoMapper shippinginfomapper;
	
	public ShippinginfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean delete(Integer sid){
		shippinginfomapper.deleteByPrimaryKey(sid);
		return false;
	}


	@Override
	public ShippingInfo findById(int id) {
		// TODO Auto-generated method stub
		return shippinginfomapper.selectByPrimaryKey(id);
	}


	@Override
	public boolean register(ShippingInfo user) {
//		// TODO Auto-generated method stub
//		System.out.println("============");
//		System.out.print("!!!!!!!!");
//		System.out.print("!!!!!!!!");
//		System.out.print("!!!!!!!!");
//		System.out.print("!!!!!!!!");
//		System.out.print("!!!!!!!!");
//		System.out.print("!!!!!!!!");
//		System.out.println("============");
		shippinginfomapper.insert(user);
		return true;
	}

}
