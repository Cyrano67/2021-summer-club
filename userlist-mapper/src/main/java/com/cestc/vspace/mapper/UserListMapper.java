package com.cestc.vspace.mapper;

import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.pojo.UserListExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserListMapper {
    int countByExample(UserListExample example);

    int deleteByExample(UserListExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UserList record);

    int insertSelective(UserList record);

    List<UserList> selectByExampleWithBLOBs(UserListExample example);

    List<UserList> selectByExample(UserListExample example);

    UserList selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByExampleWithBLOBs(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByExample(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKeyWithBLOBs(UserList record);

    int updateByPrimaryKey(UserList record);
}