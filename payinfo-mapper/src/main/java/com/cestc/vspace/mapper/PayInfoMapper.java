package com.cestc.vspace.mapper;

import com.cestc.vspace.pojo.PayInfo;
import com.cestc.vspace.pojo.PayInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayInfoMapper {
    int countByExample(PayInfoExample example);

    int deleteByExample(PayInfoExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    List<PayInfo> selectByExample(PayInfoExample example);

    PayInfo selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    int updateByExample(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);
}