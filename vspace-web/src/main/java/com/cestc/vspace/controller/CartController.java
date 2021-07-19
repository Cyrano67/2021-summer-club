package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.UserlistService;
import org.apache.dubbo.config.annotation.Reference;
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
    public Cart findBycid(int caid){
        Cart cart =cartService.findById(caid);
        System.out.println();
        return cart;
    }

    @RequestMapping("Register")
    public boolean Register(Cart recordd){
        boolean flag =cartService.register(recordd);
        return flag;
    }

    @RequestMapping("deleteById")
    public boolean deleteById(int caid){
        boolean flag=cartService.deleteById(caid);
        return flag;
    }

    @RequestMapping("incereseCart")
    public boolean incereseCart(Integer caid,Integer cid,Integer uid,Integer quantity){
        if(cartService.findByCD(cid,uid)!=null){
            Cart cc=cartService.findByCD(cid,uid);
            cartService.updateOfQuatity(cc,quantity);
        }
        else {
            Cart cc=cartService.findById(caid);
            cartService.register(cc);
        }
        return true;
    }
    @RequestMapping("find_by_user")
    public List<Cart> find_by_user(Integer uid){
        List<Cart> carts=cartService.findOfUser(uid);
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
