package com.cestc.vspace.mapper;

import com.cestc.vspace.pojo.Clothes;
import com.cestc.vspace.pojo.ClothesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClothesMapper {


    //自定义方法查询全网价格最高的9种商品
    List<Clothes> findTop9();

    int countByExample(ClothesExample example);

    int deleteByExample(ClothesExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Clothes record);

    int insertSelective(Clothes record);

    List<Clothes> selectByExample(ClothesExample example);

    Clothes selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByExample(@Param("record") Clothes record, @Param("example") ClothesExample example);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);
}