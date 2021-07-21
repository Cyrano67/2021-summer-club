package com.cestc.vspace.service.impl;

import com.cestc.vspace.pojo.*;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.CartMapper;
import com.cestc.vspace.service.CartService;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartmapper;
	
	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	// Find by cart id
	public Cart findById(int caid) {
		// TODO Auto-generated method stub
		return cartmapper.selectByPrimaryKey(caid);
	}

	@Override
	// Add an cart
	public boolean register(Cart cart) {
		// TODO Auto-generated method stub
		cartmapper.insert(cart);
		return false;
	}

	@Override
	// Delete by cart id
	public boolean deleteById(int caid){
		cartmapper.deleteByPrimaryKey(caid);
		return false;
	}

	@Override
	// Find by clothes id and user id
    public Cart findByCD(int cid,int uid){
		return cartmapper.selectByCD(cid,uid);
	}

	@Override
	// Update an cart record on quantity
	public int updateOfQuatity(int caid,int number){

		Cart cart_ori=findById(caid);
		cart_ori.setQuantity(number);

		CartExample example=new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andCidEqualTo(cart_ori.getCid());
		criteria.andUidEqualTo(cart_ori.getUid());

		return cartmapper.updateByExampleSelective(cart_ori,example);
	}

	@Override
	//
	public boolean delete(Integer caid){
		cartmapper.deleteByPrimaryKey(caid);
		return false;
	}

	@Override
	public List<Cart> findOfUser(Integer uid){
		CartExample cartExample=new CartExample();
		cartExample.createCriteria().andUidEqualTo(uid);
		List<Cart> carts = cartmapper.selectByExample(cartExample);
	  	return carts;
	}

	@Override
	public boolean deletebyUid(Integer uid){
		CartExample cartExample = new CartExample();
		cartExample.createCriteria().andUidEqualTo(uid);
		cartmapper.deleteByExample(cartExample);
		return true;
	}
}

