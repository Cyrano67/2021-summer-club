package com.cestc.vspace.controller;/*
  author:wyj
  createDate:$(Dare) $(TIME)
*/

import com.cestc.vspace.pojo.OrdersInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cestc.vspace.service.OrdersinfoService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Orderinfo")
public class OrderinfoController {
    @Reference
    private OrdersinfoService ordersinfoservice;

    @RequestMapping("find_by_num")
    public OrdersInfo findOrder_By_Num(int num){
        return ordersinfoservice.findOrderByNum(num);
    }

    @RequestMapping("delete_by_id")
    public boolean deleteOrder_By_Id(Integer oid, Integer orderNo, Integer payment, Integer paymentType, Integer postage, Integer status, Integer shippingId, Date paymentTime, Date sendTime, Date endTime, Date closeTime, Date createTime, Date updateTime, Integer caid){
        OrdersInfo ord=new OrdersInfo(oid,orderNo,payment,paymentType,postage,status,shippingId,paymentTime,sendTime,endTime,closeTime,createTime,updateTime,caid);
        return ordersinfoservice.deleteOrderById(ord);
    }

    @RequestMapping("insert_orders")
    public boolean insertOrders(List<OrdersInfo> orders)
    {
        return ordersinfoservice.insertOrders(orders);
    }

    //欠缺：两个更新接口：updateOrderByNum&updateOrderById
}
