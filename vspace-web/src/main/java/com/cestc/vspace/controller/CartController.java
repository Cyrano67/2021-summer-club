package com.cestc.vspace.controller;

import com.cestc.vspace.dto.Result;
import com.cestc.vspace.pojo.*;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.ClothesService;
import com.cestc.vspace.service.UserlistService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference
    private CartService cartService;

    @Reference
    private ClothesService clothesService;

    @RequestMapping("findBycid")
    public Cart findBycid(int caid){
        Cart cart =cartService.findById(caid);
        System.out.println();
        return cart;
    }

    @RequestMapping("Register")
    public boolean Register(@RequestBody Cart recordd){
        boolean flag =cartService.register(recordd);
        return flag;
    }

    @RequestMapping("deleteById")
    public boolean deleteById(Integer caid){
        boolean flag=cartService.deleteById(caid);
        return flag;
    }

    @RequestMapping("insertCart")
    public boolean insertCart(@RequestBody Cart cart){

       Integer caid=cart.getCaid();
       Integer cid=cart.getCid();
       Integer uid=cart.getUid();
       Integer quantity=cart.getQuantity();

       System.out.println(caid);
       System.out.println(cid);
       Cart cc=cartService.findByCD(cid,uid);
        if(cc!=null){
            cartService.updateOfQuatity(cc.getCaid(),quantity+cc.getQuantity());
        }
        else {
            //Cart cc=cartService.findById(caid);
            cartService.register(cart);
        }
        return true;
    }
    @RequestMapping("/find_by_user")
    public List<Result<Cart, Clothes>> find_by_user(Integer uid){//@RequestBody UserList user){

//        Integer uid=user.getUid();
        System.out.println("输出uid");
        System.out.println(uid);
        List<Cart> carts=cartService.findOfUser(uid);
        Iterator<Cart> iter = carts.iterator();
        List<Result<Cart, Clothes>> results=new ArrayList<>();
        while(iter.hasNext()) {
            Cart tempCart = iter.next();
            System.out.println(tempCart.getCaid());
            Result<Cart, Clothes> result = new Result<>();
            result.setEntity(tempCart);
            result.setRelateOne(clothesService.findById(tempCart.getCid()));
            results.add(result);
        }
        return results;
    }
    @RequestMapping("/updateQuantity")
    public int updateQuantity(@RequestBody Cart cart){
        System.out.println("success");
        return cartService.updateOfQuatity(cart.getCaid(),cart.getQuantity());
    }
    @RequestMapping("getcart")
    public String getcart(){
        return "cart.html";
    }
    @RequestMapping("getCaid")
    public Integer getCaid(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "").substring(28).toUpperCase();
        return Integer.valueOf(uuidStr,16);
    }
    public CartController() {
        // TODO Auto-generated constructor stub
    }
}
