package com.gooney.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooney.domain.User;
import com.gooney.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    public List<User> findAll() {

        List<User> users = null;
        try {
            Object userListObj=redisTemplate.opsForValue().get("userList");
            String userListStr = (String)userListObj;
            System.out.println(userListStr);
            ObjectMapper objectMapper = new ObjectMapper();
            if (userListStr == null || userListStr.length() == 0) {
                users = userMapper.findAll();
                userListStr=objectMapper.writeValueAsString(users);
                redisTemplate.opsForValue().set("userList",userListStr,5000,TimeUnit.SECONDS);
                System.out.println("不存在");
                System.out.println(users);
            } else {
                users = objectMapper.readValue(userListStr, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.REQUIRED)
    public boolean tranfer(String sourceName,String targetName,float money) throws Exception{
        User source = userMapper.findUserByName(sourceName);
        source.setMoney(source.getMoney() - money);
        userMapper.updateUser(source);
        User target = userMapper.findUserByName(targetName);
        target.setMoney(target.getMoney() + money);
        //int n = 10 / 0;
        userMapper.updateUser(target);
        return true;
    }
}
