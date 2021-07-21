package com.cestc.vspace.service;


import com.cestc.vspace.pojo.Cart;

import java.util.List;

public interface CartService {

	// 根据购物车ID查找
//	Cart findByCaid(int caid);
	Cart findById(int caid);

	// 加入一条购物车记录
//	boolean AddCartRecord(Cart cart);
	boolean register(Cart cart);

	// 根据购物车ID删除
//	boolean deleteByCaid(int caid);
	boolean deleteById(int caid);

	// 更新购物车记录中的数量
//	int updateQuantity(int caid,int quantity);
	int updateOfQuatity(int caid,int number);

	Cart findByCD(int cid,int uid);

	boolean delete(Integer caid);

	List<Cart> findOfUser(Integer uid);
}
