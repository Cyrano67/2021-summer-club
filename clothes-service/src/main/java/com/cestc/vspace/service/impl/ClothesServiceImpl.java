package com.cestc.vspace.service.impl;

import com.cestc.vspace.dto.Condition;
import com.cestc.vspace.dto.PageResult;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cestc.vspace.pojo.ClothesExample;
import com.cestc.vspace.mapper.ClothesMapper;
import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.service.ClothesService;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {
	
	@Autowired
	private ClothesMapper closemapper;
	
	public ClothesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Clothes findById(int id) {
		// TODO Auto-generated method stub
		return closemapper.selectByPrimaryKey(id);
	}

	/*@Override
	public boolean register(Clothes cloth) {
		// TODO Auto-generated method stub
		closemapper.insert(cloth);
		return true;
	}
	*/

	@Override
	public int updateRecord(Clothes cloth) {
		// TODO Auto-generated method stub
		ClothesExample example =new ClothesExample();
		ClothesExample.Criteria criteria = example.createCriteria();
		criteria.andCidEqualTo(cloth.getCid());
		return closemapper.updateByExampleSelective(cloth, example);

	}

	@Override
	public List<Clothes> findTop9Clothes(){
		return closemapper.findTop9();
	}




}
