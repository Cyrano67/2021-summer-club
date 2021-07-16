package com.cestc.vspace.service;


import com.cestc.vspace.pojo.Cart;

import java.util.List;

public interface cartService {
	
	Cart findById(int caid);
	
	boolean register(Cart cart);

	boolean deleteById(int caid);
	int updateOfquality(Cart cart_ori,int number);
	Cart findbyCD(int cid,int uid);
	boolean delete(Integer caid);

	List<Cart> find_of_usre(Integer uid);
}
