package com.cestc.vspace.service.impl;

import com.cestc.vspace.pojo.ShippingInfoExample;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.ShippingInfoMapper;
import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.service.ShippinginfoService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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

	public static Integer getUUID(){
		UUID uuid=UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr=str.replace("-", "").substring(28).toUpperCase();
		return Integer.valueOf(uuidStr,16);
	}

// 返回sid
	@Override
	public int register(ShippingInfo user) {
//		// TODO Auto-generated method stub
		Integer shippingInfoId =  getUUID();
		//System.out.println(user.getSid());
		//System.out.println(shippingInfoId);
		user.setSid(shippingInfoId);
		shippinginfomapper.insert(user);
		return shippingInfoId;
	}
}
