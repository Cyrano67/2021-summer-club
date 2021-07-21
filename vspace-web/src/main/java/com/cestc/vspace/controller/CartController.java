package com.cestc.vspace.controller;

import com.cestc.vspace.dto.Result;
import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.ClothesService;
import com.cestc.vspace.service.UserlistService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("incereseCart")
    public boolean incereseCart(Integer caid,Integer cid,Integer uid,Integer quantity){
        if(cartService.findByCD(cid,uid)!=null){
            cartService.updateOfQuatity(caid,quantity);
        }
        else {
            Cart cc=cartService.findById(caid);
            cartService.register(cc);
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
    public static String getCaid(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public CartController() {
        // TODO Auto-generated constructor stub
    }
}
