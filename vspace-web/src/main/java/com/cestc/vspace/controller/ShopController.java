package com.cestc.vspace.controller;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import com.cestc.vspace.service.SearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Reference
    private SearchService searchService;

    @RequestMapping("/searchPages")
    public PageResult searchPages(@RequestBody Condition condition){
        System.out.println(condition);
        PageResult pageResult=searchService.searchPageTest(condition);
        System.out.println(pageResult);
        return pageResult;
    }
}
