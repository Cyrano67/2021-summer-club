package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.clothesService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;


@RestController
public class DetailController {
    @Reference
    private clothesService clothesService;

    // 获取初始化信息
    @RequestMapping("/details/info")
    public Clothes getDetail(@RequestBody int cid){
        Clothes clothes=clothesService.findById(cid);
        System.out.println(clothes.getCname());
        return clothes;
    }

//    // 测试寻找服务页面
//    @RequestMapping("/test")
//    public Clothes test(){
//        Clothes temp1=clothesService.findById(1);
//        return temp1;
//    }

    public DetailController() {}

}
