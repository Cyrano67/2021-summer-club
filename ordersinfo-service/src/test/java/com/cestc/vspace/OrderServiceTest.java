package com.cestc.vspace;/*
  author:wyj
  createDate:$(Dare) $(TIME)
*/

import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.service.CartService;
import com.cestc.vspace.service.OrdersinfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@SpringBootTest(classes ={OrdersInfoServiceApplication.class})
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    public OrderServiceTest() {
        // TODO Auto-generated constructor stub
    }

    @Reference
    private OrdersinfoService orderService;

    @Test
    public void test() {
//        if(cartservice.findbyCD(2,3)!=null){
//
//            Cart cc=cartservice.findbyCD(2,3);
//            System.out.println(cartservice.updateOfquality(cc,100));
//        }
//        cartservice.delete(1);
//        cartservice.delete(7);
//        cartservice.delete(10);
//        cartservice.delete(15);
//        cartservice.delete(17);
////        cartservice.delete(104);
        int uid=0;
        List<OrdersInfo> ordersInfos = orderService.findByUid(uid);
        Iterator<OrdersInfo> iter = ordersInfos.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getOid());
        }
    }
}
