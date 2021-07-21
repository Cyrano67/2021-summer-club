package com.cestc.vspace.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.cestc.vspace.dto.Result;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.ClothesService;
import com.cestc.vspace.service.OrdersinfoService;
import com.cestc.vspace.service.ShippinginfoService;
import com.cestc.vspace.service.PaymentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckOutController {

    @Reference
    private ShippinginfoService shippinginfoService ;
    @Reference
    private OrdersinfoService ordersinfoService;
    @Reference
    private CartService cartService;
    @Reference
    private ClothesService clothesService;
	@Reference
	private PaymentService paymentService;
	
    @RequestMapping(value = "/AddShippingInfo",method = RequestMethod.POST)
    public boolean AddShippingInfo(@RequestBody ShippingInfo addressDetail, HttpServletResponse response){
        System.out.println("----------"+addressDetail.getReceiverName()+"----------------");
        int sid = shippinginfoService.register(addressDetail);
        return true;

    }

    @RequestMapping(value = "/GetCartData")
    public List<Result<Cart, Clothes>> GetCart(Integer userId, HttpServletResponse response){
        //System.out.println("uid: "+userId);
        List<Result<Cart, Clothes>> list1=new ArrayList<>();
        List<Cart> cart_data = cartService.findOfUser(userId);
        Iterator<Cart> iter = cart_data.iterator();
        while(iter.hasNext()) {
            Cart cart=iter.next();
            int cid=cart.getCid();
            //System.out.println(cid);
            Clothes clothes = clothesService.findById(cid);
            Result<Cart, Clothes> result=new Result<>();
            result.setEntity(cart);
            result.setRelateOne(clothes);
            list1.add(result);
            //Clothes clothes=iter.
        }
        // System.out.println("size: "+ list1.size());
        return list1;
    }



    @RequestMapping(value = "/AddOrderInfoShippingInfo",method = RequestMethod.POST)
    public Result<String, String> AddOrderInfoShippingInfo(@RequestBody Result<ShippingInfo,OrdersInfo> dataShippingInfoOrderInfo,HttpServletResponse response){
        // 删除购物车
        cartService.deletebyUid(dataShippingInfoOrderInfo.getRelateOne().getUid());
        Result<String,String> result = new Result<String, String>();
        // 插入地址
        System.out.println("----------"+dataShippingInfoOrderInfo.getEntity().getReceiverName()+"----------------");
        int sid = shippinginfoService.register(dataShippingInfoOrderInfo.getEntity());
//        result.setEntity(sid);
        //System.out.println("Address is fine!");
        // 插入订单
        OrdersInfo orders = dataShippingInfoOrderInfo.getRelateOne();
        orders.setShippingId(sid);
        int oid = ordersinfoService.insertOrder(dataShippingInfoOrderInfo.getRelateOne());
        String payResult = paymentService.pay(oid);
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	System.out.println(payResult);
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	result.setEntity("true");
    	result.setRelateOne(payResult);
    	return result;
//        result.setRelateOne(oid);
    }
//    @RequestMapping(value = "/AddOrderInfo",method = RequestMethod.POST)
//    public ResponseData AddOrderInfo(@RequestBody OrdersInfo orderdetail, HttpServletResponse response){
//        System.out.println("----------"+orderdetail.getPaymentTime()+"----------------");
//        //接收到了
//        ResponseData responseData = new ResponseData();
//        responseData.setNumber(12);
////ordersinfoService.insertOrder(orderdetail)
//        return responseData;
//    }


//    @RequestMapping(value = "/getpage")
//    public String GetPage(){
//        return "checkout.html";
//    }
}
