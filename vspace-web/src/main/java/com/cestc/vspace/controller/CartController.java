package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.service.CartService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Reference
    private CartService cartService;

    @RequestMapping("findBycid")
    public Cart findCartById(){
        Cart cart =cartService.findById(1);
        System.out.println();
        return cart;
    }

    @RequestMapping("Register")
    public boolean register(Cart recordd){
        boolean flag =cartService.register(recordd);
        return flag;
    }

    @RequestMapping("deleteById")
    public boolean delete(int caid){
        boolean flag=cartService.deleteById(caid);
        return flag;
    }
    @RequestMapping("incereseCart")
    public boolean increase(Integer caid,Integer cid,Integer uid,Integer quantity){
        if(cartService.findbyCD(cid,uid)!=null){
            Cart cc=cartService.findbyCD(cid,uid);
            cartService.updateOfquality(cc,quantity);
        }
        else {
            Cart cc=cartService.findById(caid);
            cartService.register(cc);
        }
        return true;
    }
    @RequestMapping("find_of_user")
    public List<Cart> find_by_user(Integer uid){
        List<Cart> carts=cartService.find_of_usre(uid);
        Iterator<Cart> iter = carts.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next().getCaid());
        }
        return carts;
    }

    public CartController() {
        // TODO Auto-generated constructor stub
    }
}
