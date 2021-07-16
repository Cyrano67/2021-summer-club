package com.cestc.vspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping("/details")
    public String goDetails(){
        return "product-details";
    }

    public IndexController() {}

}
