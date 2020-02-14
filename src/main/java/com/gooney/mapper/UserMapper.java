package com.gooney.mapper;


import com.gooney.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    @Results({
         @Result(column = "createTime",property = "create_time")
    })
    List<User> findAll();
    @Select("select * from user where name=#{name}")
    User findUserByName(String name);
    @Update("update user set money=#{money},name=#{name},pwd=#{pwd} where id=#{id}")
    void updateUser(User user);
}
