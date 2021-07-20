package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Cart;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.dto.Result;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.ClothesService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("cart")
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
    //}
//    public List<Cart> find_by_user(Integer uid){
//        List<Cart> carts=cartService.findOfUser(uid);
//        Iterator<Cart> iter = carts.iterator();
//        while(iter.hasNext()) {
//            System.out.println(iter.next().getCaid());
//        }
//        return carts;
//    }


    @RequestMapping("getcart")
    public String getcart(){
        return "cart.html";
    }
    public CartController() {
        // TODO Auto-generated constructor stub
    }

    @RequestMapping("find_by_user")
    public List<Result<Cart, Clothes>> find_by_user(Integer uid){
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
}
