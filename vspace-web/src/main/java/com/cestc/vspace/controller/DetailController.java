package com.cestc.vspace.controller;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.ClothesService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;


@RestController
public class DetailController {
    @Reference
    private ClothesService clothesService;

    // 获取初始化信息
    @RequestMapping("/details/info")
    public Clothes getDetail(@RequestBody int cid){
        Clothes clothes=clothesService.findById(cid);
        System.out.println(clothes.getCname());
        return clothes;
    }

    public DetailController() {}

}
