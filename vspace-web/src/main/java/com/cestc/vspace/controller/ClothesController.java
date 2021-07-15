package com.cestc.vspace.controller;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import com.cestc.vspace.service.clothesService;
import com.cestc.vspace.service.SearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 11:42
 * Description:
 */

@RestController
@RequestMapping("/clothes")

public class ClothesController {
    //远程调度商品服务
    @Reference
    private clothesService clothesService;
    //远程调度搜索服务
    @Reference
    private SearchService searchService;

    //多条件分页查询
    @RequestMapping("/findPageByCondition")
    public PageResult findPageByCondition(@RequestBody Condition condition){
        //根据一级级类型编号,查询出所有的二级级类型编号
        /* if (condition.getCategoryId() != 0) {
            condition.setCategoryIdList(categoryService.findSecondCategoryIdList(condition.getCategoryId()));
        }*/
        //分页查询: 此处是直接从数据库查询的数据进行分页
        //PageResult pageResult = clothesService.findPageByCondition(condition);
        System.out.println("~~~~~~~~~~~~搜索关键字是: " + condition.getSearchString() + "~~~~~~~~~~~~~");
        //分页查询: 从solr索引库中查询
        PageResult pageResult = searchService.searchPage(condition);
        return pageResult;
    }
}
