package com.cestc.vspace.service;


import com.cestc.vspace.pojo.Cart;

import java.util.List;

public interface CartService {

	// 根据购物车ID查找
	Cart findById(int caid);

	// 加入购物车？
	boolean register(Cart cart);

	// 根据购物车ID删除
	boolean deleteById(int caid);

	// 更新购物车
	int updateOfQuatity(int caid,int number);

	Cart findByCD(int cid,int uid);

	boolean delete(Integer caid);

	List<Cart> findOfUser(Integer uid);
}
