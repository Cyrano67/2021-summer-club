package com.cestc.vspace.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.mapper.ClothesMapper;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.clothesService;


@Service
public class clothesServiceImpl implements clothesService{
	
	@Autowired
	private ClothesMapper closemapper;
	
	public clothesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Clothes findById(int id) {
		// TODO Auto-generated method stub
		return closemapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean register(Clothes cloth) {
		// TODO Auto-generated method stub
		closemapper.insert(cloth);
		return true;
	}

}
