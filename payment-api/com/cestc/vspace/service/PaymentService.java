package com.cestc.vspace.service;

import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.PayInfo;

public interface PaymentService {
	//支付方法
	String pay(int trade);
	//退款方法
	String refund(OrdersInfo trade);

}
