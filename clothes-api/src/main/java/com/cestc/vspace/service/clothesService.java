package com.cestc.vspace.service;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;
import java.util.List;

public interface clothesService {
	//根据商品编号查询商品信息
	Clothes findById(int id);
	
	//boolean register(Clothes cloth);

	//更新商品信息
	int updateRecord(Clothes cloth);

	//查询全网价格最贵的9种衣服
	List<Clothes> findTop9Clothes();

}
