package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.clothesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @RequestMapping("")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/shop")
    public String goShop(){
        return "shop";
    }

    // 跳转details页面
    @RequestMapping("/details")
    public String goDetail(){
        return "product-details";
    }

    public IndexController() {}

}
