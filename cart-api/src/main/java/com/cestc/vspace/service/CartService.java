package com.cestc.vspace.service;


import com.cestc.vspace.pojo.Cart;

import java.util.List;

public interface CartService {
	
	Cart findById(int caid);
	
	boolean register(Cart cart);

	boolean deleteById(int caid);

	int updateOfQuality(Cart cart_ori,int number);

	Cart findByCD(int cid,int uid);

	boolean delete(Integer caid);

	List<Cart> findOfUser(Integer uid);
}
