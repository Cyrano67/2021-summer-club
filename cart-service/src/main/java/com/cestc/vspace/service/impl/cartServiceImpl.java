package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.CartMapper;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.cartService;


@Service
public class cartServiceImpl implements cartService{
	
	@Autowired
	private CartMapper cartmapper;
	
	public cartServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cart findById(int cait) {
		// TODO Auto-generated method stub
		return cartmapper.selectByPrimaryKey(cait);
	}

	@Override
	public boolean register(Cart cart) {
		// TODO Auto-generated method stub
		cartmapper.insert(cart);
		return false;
	}

}
