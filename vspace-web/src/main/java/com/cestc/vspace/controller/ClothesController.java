
package com.cestc.vspace.controller;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.ClothesService;
import com.cestc.vspace.service.SearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

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
    private ClothesService clothesService;
    //远程调度搜索服务
    @Reference
    private SearchService searchService;

    @RequestMapping("/findByUid")
    public Clothes findUserById(@RequestBody int cid){
        Clothes clo = clothesService.findById(cid);
        System.out.println();
        return clo;
    }
    //查询全网价格最高的9种商品
    @RequestMapping("/FindTop9")
    List<Clothes> FindTop9Clothes(){
        List<Clothes> temp = clothesService.findTop9Clothes();
        System.out.println(temp);
        return temp;
    }
    //更新商品信息
    @RequestMapping("/updateClothes")
    public int UpdateRecord(@RequestBody Integer cid,String cname,Integer price,String discription,String picAddr,String merchant,String size){
        Clothes cc=new Clothes(cid,cname,price,discription,picAddr,merchant,size);
        return clothesService.updateRecord(cc);
    }
    //多条件分页查询
    @RequestMapping("/demo")
    public PageResult findPageByCondition(@RequestBody Condition  condition){
        System.out.println("test access: ");
        //根据一级级类型编号,查询出所有的二级级类型编号
        /* if (condition.getCategoryId() != 0) {
            condition.setCategoryIdList(categoryService.findSecondCategoryIdList(condition.getCategoryId()));
        }*/
        //分页查询: 此处是直接从数据库查询的数据进行分页
        //PageResult pageResult = clothesService.findPageByCondition(condition);
        //分页查询: 从solr索引库中查询
        PageResult pageResult = searchService.searchPageTest(condition);
        System.out.println("dataList: " + pageResult.getDataList());
        return pageResult;
    }


}

