package com.cestc.vspace.service.impl;

import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.CartExample;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.OrdersInfoMapper;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.OrdersInfoExample;
import java.util.List;
import com.cestc.vspace.service.OrdersinfoService;
@Service
public class OrdersinfoServiceImpl implements OrdersinfoService {
	
	@Autowired
	private OrdersInfoMapper ordersinfomapper;
	
	public OrdersinfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public OrdersInfo findByOid(int oid) {
		// TODO Auto-generated method stub
		return ordersinfomapper.selectByPrimaryKey(oid);
	}
//	public OrdersInfo findById(int id) {
//		// TODO Auto-generated method stub
//		return ordersinfomapper.selectByPrimaryKey(id);
//	}

	@Override
	public boolean insertOrders(List<OrdersInfo> orders){
		// TODO Auto-generated method stub
		//循环插入数据
		for (OrdersInfo order : orders) {
			ordersinfomapper.insert(order);
		}
		return true;
	}
	@Override
	public OrdersInfo findByOrderNO(int ono){
		OrdersInfoExample orderExample = new OrdersInfoExample();
		orderExample.createCriteria().andOrderNoEqualTo(ono);
		List<OrdersInfo> Orders = ordersinfomapper.selectByExample(orderExample);
		return Orders.get(0);
	}
//	public OrdersInfo findOrderByNum(int num){
//		OrdersInfoExample orderExample = new OrdersInfoExample();
//		orderExample.createCriteria().andOrderNoEqualTo(num);
//		List<OrdersInfo> Orders = ordersinfomapper.selectByExample(orderExample);
//		return Orders.get(0);
//	}

	@Override
	public boolean deleteOrderById(OrdersInfo order){
		//调用orderMapper接口方法进行数据删除("修改")操作
		int i = ordersinfomapper.updateByPrimaryKeySelective(order);
		if (i > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean updateOrderByNum(OrdersInfo order){
		OrdersInfoExample example = new OrdersInfoExample();
		example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
		int i = ordersinfomapper.updateByExampleSelective(order, example);
		return i > 0;
	}

	@Override
	public boolean updateOrderById(OrdersInfo order){
		OrdersInfoExample example = new OrdersInfoExample();
		example.createCriteria().andOidEqualTo(order.getOid());
		int i = ordersinfomapper.updateByExampleSelective(order, example);
		return i > 0;
	}

	@Override
	public List<OrdersInfo> findByUid(int uid){
		OrdersInfoExample ordersInfoExample=new OrdersInfoExample();
		ordersInfoExample.createCriteria().andUidEqualTo(uid);
		List<OrdersInfo> ordersInfos=ordersinfomapper.selectByExample(ordersInfoExample);
		return ordersInfos;
	}


}
