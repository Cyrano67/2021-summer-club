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

	@Override
	public boolean deleteById(int caid){
		cartmapper.deleteByPrimaryKey(caid);
		return false;
	}
	@Override
    public Cart findbyCD(int cid,int uid){
		return cartmapper.selectByCD(cid,uid);
	}
	@Override
	public int updateOfquality(Cart cart_ori,int number){

		Integer quantity=cart_ori.getQuantity();
		cart_ori.setQuantity(number+quantity);

		CartExample example=new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andCidEqualTo(cart_ori.getCid());
		criteria.andUidEqualTo(cart_ori.getUid());

		return cartmapper.updateByExampleSelective(cart_ori,example);
	}

	@Override
	public boolean delete(Integer caid){
		cartmapper.deleteByPrimaryKey(caid);
		return false;
	}

	@Override
	public List<Cart> find_of_usre(Integer uid){
		CartExample cartExample=new CartExample();
		cartExample.createCriteria().andUidEqualTo(uid);
		List<Cart> carts = cartmapper.selectByExample(cartExample);
	  return carts;
	}
}

