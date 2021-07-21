package com.cestc.vspace.controller;
import com.alipay.api.internal.util.AlipaySignature;
import com.cestc.vspace.pojo.OrdersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.cestc.vspace.conf.PaymentConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sync")
public class AliSyncNotifyController {
	@Autowired
	private PaymentConfig paymentConfig;
	 
	@RequestMapping("/notify")
	public String notice(HttpServletRequest request){
		//1.获取同步通知请求参数//2.拼接转换请求参数
		//3.请求验签
		//4.根据验签结果进行跳转处理
		Map<String, String[]> parameterMap =
		request.getParameterMap();
		System.out.println("---------------------同步控制器消息-------------------------");
		for (String key : parameterMap.keySet()) {
		System.out.println(key + "\t" +
		Arrays.toString(parameterMap.get(key)));
		}
		System.out.println("----------------------------------------------");
		//通过支付宝sdk进行验签操作
		//1.新建一个Map集合用于存放所有的请求参数
		Map<String,String> params = new HashMap<>();
		//2.将请求参数集合parameterMap中的值全部获取并拼接成字符串之后统一保存到params集合中
		for (String key : parameterMap.keySet()) {
			String[] values = parameterMap.get(key);
			String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			if (values.length - 1 == i) {
			valueStr += values[i];
		}else{
			valueStr += values[i] + ",";}
		}
		//存储到集合
		params.put(key,valueStr);
		}
		//3.调用支付宝sdk验证签名
		String returnUrl = "";
		try {
			boolean verified =
			AlipaySignature.rsaCheckV1(params,
			paymentConfig.getAlipayPublicKey(),
			paymentConfig.getCharset(),
			paymentConfig.getSignType());
			//判断验签结果
			if (verified) {
				//重定向到我的账户模块查看订单信息
				System.out.println("验签成功,即将跳转到我的订单页面!");
				returnUrl = "redirect:/index.html";}
			else{
				System.out.println("验签失败");
				returnUrl = "redirect:/checkout.html";}
				} 
		catch (Exception e) {
			returnUrl = "redirect:/check-fail.html";}
			return returnUrl;
	}


}
