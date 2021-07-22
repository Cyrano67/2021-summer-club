package com.cestc.vspace.service.impl;

import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.pojo.ShippingInfoExample;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.CartExample;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.OrdersInfoMapper;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.OrdersInfoExample;

import java.util.*;

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

	public static Integer getUUID(){
		UUID uuid=UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr=str.replace("-", "").substring(28).toUpperCase();
		return Integer.valueOf(uuidStr,16);
	}

	@Override
	public int insertOrder(OrdersInfo order){
		// 设置插入数据的id
//		OrdersInfoExample ordersInfoExample = new OrdersInfoExample();
//		ordersInfoExample.createCriteria().andCaidGreaterThanOrEqualTo(0);
//		List<OrdersInfo> ordersInfolist = ordersinfomapper.selectByExample(ordersInfoExample);
//		if(!ordersInfolist.isEmpty()){
//			Optional<OrdersInfo > infoOp = ordersInfolist.stream().max(Comparator.comparingInt(OrdersInfo ::getOid));
//			OrdersInfo maxOrder = infoOp.get();
//			order.setOid(maxOrder.getOid()+1);
//		}
		Integer orderInfoId = getUUID();
		order.setOid(orderInfoId);
		order.setOrderNo(orderInfoId);
//		// 获取当前时间
//		Date date = new Date();
//		order.setPaymentTime(date);
		System.out.println("成功插入订单: "+order.getPayment());
		ordersinfomapper.insert(order);
		return orderInfoId;
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
