package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.UserList;
import java.util.List;

public interface OrdersinfoService {
	
	OrdersInfo findById(int id);
	
	//boolean register(OrdersInfo order);

	//根据订单编号进行查询
	OrdersInfo findOrderByNum(int num);

	//创建方法根据订单id删除订单(本质是修改,并不真正删除订单数据)
	boolean deleteOrderById(OrdersInfo order);

	//批量增加订单
	boolean insertOrders(List<OrdersInfo> orders);

	//更新订单: 根据商户订单编号修改子订单的状态
	boolean updateOrderByNum(OrdersInfo order);

	//更新订单: 根据商户订单ID修改子订单的状态
	boolean updateOrderById(OrdersInfo order);

}
