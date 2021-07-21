package com.cestc.vspace.controller;/*
  author:wyj
  createDate:$(Dare) $(TIME)
*/

import com.cestc.vspace.dto.Result;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.OrdersInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cestc.vspace.service.OrdersinfoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Orderinfo")
public class OrderinfoController {
    @Reference
    private OrdersinfoService ordersinfoservice;

    @RequestMapping("find_by_num")
    public OrdersInfo findOrder_By_Num(int num){
        return ordersinfoservice.findByOrderNO(num);
    }

//    @RequestMapping("delete_by_id")
//    public boolean deleteOrder_By_Id(Integer oid, Integer orderNo, Integer payment, Integer paymentType, Integer postage, Integer status, Integer shippingId, Date paymentTime, Date sendTime, Date endTime, Date closeTime, Date createTime, Date updateTime, Integer caid){
//        OrdersInfo ord=new OrdersInfo(oid,orderNo,payment,paymentType,postage,status,shippingId,paymentTime,sendTime,endTime,closeTime,createTime,updateTime,caid);
//        return ordersinfoservice.deleteOrderById(ord);
//    }
    @RequestMapping("delete_by_id")
    public boolean deleteOrder_By_Id(OrdersInfo ord){
        return ordersinfoservice.deleteOrderById(ord);
    }

    @RequestMapping("insert_orders")
    public boolean insertOrders(List<OrdersInfo> orders)
    {
        return ordersinfoservice.insertOrders(orders);
    }

    @RequestMapping("find_ordersinfos")
    public List<OrdersInfo> find_ordersinfos(int uid) {
        return ordersinfoservice.findByUid(uid);
    }

    @RequestMapping("find_cinfos")
    public String[] find_cinfos(int oid) {
        String cinfos=ordersinfoservice.findByOid(oid).getCinfo();
        String[] cinfo = cinfos.split(";");
        return cinfo;
    }

    @RequestMapping("find_clinks")
    public String[] find_clinks(int oid) {
        String clinks=ordersinfoservice.findByOid(oid).getClink();
        String[] clink = clinks.split(";");
        return clink;
    }

    @RequestMapping("get_order_nums")
    public List<String> get_order_nums(int uid) {
        List<OrdersInfo> ordersInfos=ordersinfoservice.findByUid(uid);
        List<String> order_nums=new ArrayList<>();
        for(int i=0;i<ordersInfos.size();i++){
            order_nums.add(ordersInfos.get(i).getOrderNo().toString());
        }
        return order_nums;
    }

    @RequestMapping("get_total_price")
    public List<String> get_total_price(int uid) {
        List<OrdersInfo> ordersInfos=ordersinfoservice.findByUid(uid);
        List<String> total_prices=new ArrayList<>();
        for(int i=0;i<ordersInfos.size();i++){
            total_prices.add(ordersInfos.get(i).getPayment().toString());
        }
        return total_prices;
    }

    @RequestMapping("find_inactive_orders")
    public List<List<String>> find_inactive_orders(int uid) {
        List<OrdersInfo> ordersInfos=ordersinfoservice.findByUid(uid);
        List<List<String>> inactive_orders=new ArrayList<>();
        for(int i=0;i<ordersInfos.size();i++){
            Integer order_num_int=ordersInfos.get(i).getOrderNo();
            String order_num=Integer.toString(order_num_int);
            Integer total_price_int=ordersInfos.get(i).getPayment();
            String total_price=Integer.toString(total_price_int);

            String[] cinfos=ordersInfos.get(i).getCinfo().split(";");
            String[] clinks=ordersInfos.get(i).getClink().split(";");
            for(int j=0;j<cinfos.length;j++){
                List<String> inactive_order=new ArrayList<>();
                inactive_order.add(order_num);
                inactive_order.add(cinfos[j]);
                inactive_order.add(clinks[j]);
                inactive_order.add(total_price);
                inactive_orders.add(inactive_order);
            }
        }
        return inactive_orders;
    }

}
