package com.cestc.vspace.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.service.OrdersinfoService;
import com.cestc.vspace.service.PaymentService;
import com.cestc.vspace.conf.PaymentConfig;


@Service
public class PaymentServiceImp implements PaymentService {
	//自动装配一个支付配置对象
	@Autowired
	private PaymentConfig paymentConfig;
	//远程调度订单服务
	@Reference
	private OrdersinfoService orderinfoService;
	
	@Override
	public synchronized String pay(int oid) {
		OrdersInfo trade = orderinfoService.findByOid(oid);
		// TODO Auto-generated method stub
		//创建一个支付客户端对象
		AlipayClient alipayClient = new DefaultAlipayClient(
			paymentConfig.getAlipayGateway(),
			paymentConfig.getAppId(),
			paymentConfig.getPrivateKey(),
			"json",
			paymentConfig.getCharset(),
			paymentConfig.getAlipayPublicKey(),
			paymentConfig.getSignType());
		//创建一个支付请求对象
		AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
		//设置请求参数
		alipayTradePagePayRequest.setNotifyUrl(paymentConfig.getNotifyUrl());
		alipayTradePagePayRequest.setReturnUrl(paymentConfig.getRedirectUrl());
		//创建一个Map集合对象用于存放订单交易业务数据
		Map<String,Object> bizParams = new HashMap<>();
		//封装必须的业务参数即可
		bizParams.put("out_trade_no",trade.getOid().toString()); // 商户订单号
		System.out.println("out_trade_no:"+trade.getOid().toString());
		bizParams.put("total_amount",trade.getPayment().toString());// 交易金额,支付宝支持小数点后两位小数
//		bizParams.put("total_amount",trade.getPayment().toString());// 交易金额,支付宝支持小数点后两位小数
		System.out.println("total_amount:"+trade.getPayment().toString());
		bizParams.put("subject", "Vspace Order"); //订单标题
		bizParams.put("body","Vspace goods list");// 对交易或商品的描述
		bizParams.put("product_code","FAST_INSTANT_TRADE_PAY");//销售产品码
//		bizParams.put("timeout_express","30m"); // 设置支付有效时间
//		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
//                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//设置支付请求需要的业务内容参数alipayTradePagePayRequest.setBizContent(JSON.toJSONString(bizParams));
		//请求支付并获取支付结果
		alipayTradePagePayRequest.setBizContent(JSON.toJSONString(bizParams));

		String result = null;
		try {
			result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String refund(OrdersInfo trade) {
		// TODO Auto-generated method stub
		return null;
	}

}
