package com.cestc.vspace.mapper;

import com.cestc.vspace.pojo.ShippingInfo;
import com.cestc.vspace.pojo.ShippingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingInfoMapper {
    int countByExample(ShippingInfoExample example);

    int deleteByExample(ShippingInfoExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(ShippingInfo record);

    int insertSelective(ShippingInfo record);

    List<ShippingInfo> selectByExample(ShippingInfoExample example);

    ShippingInfo selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") ShippingInfo record, @Param("example") ShippingInfoExample example);

    int updateByExample(@Param("record") ShippingInfo record, @Param("example") ShippingInfoExample example);

    int updateByPrimaryKeySelective(ShippingInfo record);

    int updateByPrimaryKey(ShippingInfo record);
}