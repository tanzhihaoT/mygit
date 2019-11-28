package com.how2java.shiro.service;

import com.how2java.shiro.entity.User;
import com.how2java.shiro.mapper.UserMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public User findUser(String userName) {
        return userMapper.findUser(userName);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int updatePwd(User user) {
        return userMapper.updatePwd(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=null;
        try {
            ValueOperations vo=redisTemplate.opsForValue();
            boolean hasKey=redisTemplate.hasKey("allUser");
            if (hasKey){
                userList=(List<User>)vo.get("allUser");
            }else {
                userList=userMapper.getAllUser();
                vo.set("allUser",userList,5, TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            System.out.println("redis服务异常");
            userList=userMapper.getAllUser();
        }
        return userList;
    }
}
