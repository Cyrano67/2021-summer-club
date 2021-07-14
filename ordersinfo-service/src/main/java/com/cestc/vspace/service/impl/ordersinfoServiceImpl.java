package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.OrdersInfoMapper;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.PayInfo;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.ordersinfoService;


@Service
public class ordersinfoServiceImpl implements ordersinfoService{
	
	@Autowired
	private OrdersInfoMapper ordersinfomapper;
	
	public ordersinfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public OrdersInfo findById(int id) {
		// TODO Auto-generated method stub
		return ordersinfomapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean register(OrdersInfo order) {
		// TODO Auto-generated method stub
		ordersinfomapper.insert(order);
		return true;
	}

}
