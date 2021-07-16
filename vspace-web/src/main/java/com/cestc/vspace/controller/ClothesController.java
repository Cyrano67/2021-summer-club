package com.cestc.vspace.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.ClothesService;

import java.util.List;

@RequestMapping("/clo")
public class ClothesController {
    //远程调度商品服务
    @Reference
    private ClothesService clothesService;
    @RequestMapping("/findByUid")
    public Clothes findUserById(int cid){
        Clothes clo = clothesService.findById(cid);
        System.out.println();
        return clo;
    }
    //更新商品信息
    @RequestMapping("/updateClothes")
    public int UpdateRecord(Integer cid,String cname,Integer price,String discription,String picAddr,String merchant,String size){
        Clothes cc=new Clothes(cid,cname,price,discription,picAddr,merchant,size);
        return clothesService.updateRecord(cc);
    }
    //查询全网价格最高的9种商品
    @RequestMapping("FindTop9")
    List<Clothes> FindTop9Clothes(){
        return clothesService.findTop9Clothes();
    }
    public ClothesController() {
        // TODO Auto-generated constructor stub
    }


}
