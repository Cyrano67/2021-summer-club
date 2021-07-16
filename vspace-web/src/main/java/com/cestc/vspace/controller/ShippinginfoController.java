package com.cestc.vspace.controller;/*
  author:wyj
  createDate:$(Dare) $(TIME)
*/

import com.cestc.vspace.pojo.ShippingInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cestc.vspace.service.ShippinginfoService;

@RestController
@RequestMapping("/shippinginfo")
public class ShippinginfoController {
    @Reference
    private ShippinginfoService shippinginfo;
    @RequestMapping("/findById")
    public ShippingInfo findbyId(int sid){
        ShippingInfo sh = shippinginfo.findById(sid);
        return sh;
    }
    @RequestMapping("/register")
    public boolean register(Integer sid,String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverStreet,String receiverAddress,String receiverZip){
        ShippingInfo sh=new ShippingInfo(sid,receiverName,receiverPhone,receiverProvince,receiverCity,receiverStreet,receiverAddress,receiverZip);
        shippinginfo.register(sh);
        return false;
    }
}
