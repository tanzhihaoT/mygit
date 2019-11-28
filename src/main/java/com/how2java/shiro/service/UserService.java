package com.how2java.shiro.service;

import com.how2java.shiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User findUser(String userName);
    public int createUser(User user);
    public int updatePwd(User user);
    public List<User> getAllUser();
}
