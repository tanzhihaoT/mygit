package com.how2java.shiro.mapper;

import com.how2java.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public User findUser(String userName);
    public int createUser(User user);
    public int updatePwd(User user);
    public List<User> getAllUser();
}
