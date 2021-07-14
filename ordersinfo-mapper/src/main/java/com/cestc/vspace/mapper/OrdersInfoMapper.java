package com.cestc.vspace.mapper;

import com.cestc.vspace.pojo.OrdersInfo;
import com.cestc.vspace.pojo.OrdersInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersInfoMapper {
    int countByExample(OrdersInfoExample example);

    int deleteByExample(OrdersInfoExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(OrdersInfo record);

    int insertSelective(OrdersInfo record);

    List<OrdersInfo> selectByExample(OrdersInfoExample example);

    OrdersInfo selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") OrdersInfo record, @Param("example") OrdersInfoExample example);

    int updateByExample(@Param("record") OrdersInfo record, @Param("example") OrdersInfoExample example);

    int updateByPrimaryKeySelective(OrdersInfo record);

    int updateByPrimaryKey(OrdersInfo record);
}