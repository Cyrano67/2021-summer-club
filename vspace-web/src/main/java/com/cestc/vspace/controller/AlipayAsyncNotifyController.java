package com.cestc.vspace.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.cestc.vspace.conf.PaymentConfig;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.service.OrdersinfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/async")
public class AlipayAsyncNotifyController {
	//自动装配一个支付配置对象
	@Autowired
	private PaymentConfig paymentConfig;
	//远程调度引用一个OrderService
	@Reference
	private OrdersinfoService orderService;
	
	@RequestMapping("/notify")
	public void vspaceNotify(HttpServletRequest request,
	HttpServletResponse response){
	Map<String, String[]> parameterMap =
	request.getParameterMap();
	System.out.println("--------------------异步控制器消息----------------------");
	for (String key : parameterMap.keySet()) {
		System.out.println(key + "\t" +
		Arrays.toString(parameterMap.get(key)));
	}
	System.out.println("--------------------------------------------------");
	//通过支付宝sdk进行验签操作
	//1.新建一个Map集合用于存放所有的请求参数
	Map<String,String> params = new HashMap<>();
	//2.将请求参数集合parameterMap中的值全部获取并拼接成字符串之后统一保存到params集合中
	for (String key : parameterMap.keySet()) {
		String[] values = parameterMap.get(key);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			if (values.length - 1 == i) {
				valueStr += values[i];}
			else{
				valueStr += values[i] + ",";}
		}
	//存储到集合
		params.put(key,valueStr);
	}
	//3.调用支付宝sdk验证签名
	try {
		boolean verified =
		AlipaySignature.rsaCheckV1(params,
		paymentConfig.getAlipayPublicKey(),
		paymentConfig.getCharset(),
		paymentConfig.getSignType());
		//判断验签结果
		PrintWriter writer = response.getWriter();
		if (verified) {
			//验签成功之后通过refund_fee字段来判断是支付成功之后的通知还是退款成功之后的通知
			String tag = params.get("refund_fee");
			if (tag != null) {
			//退款(如果退款金额不为null说明是进行退款操作)
				System.out.println("退款成功!");
			}else{
			//支付
			//验签成功之后修改交易订单和子订单项目的状态,并减少库存量
			//①: 调用订单服务的方法更新交易记录表的数据
				//创建一个日期时间格式化对象
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//②: 调用订单服务方法更新订单子项中的状态数据
				OrdersInfo order = orderService.findById(Integer.parseInt(params.get("out_trade_no")) );
				order.setStatus(1);
				order.setEndTime(new Date());
				order.setUpdateTime(new Date());
				System.out.println("---------买家支付成功,请查看订单系统并发货!------------");
		}
		}else{
		System.out.println("验签失败");
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
}
