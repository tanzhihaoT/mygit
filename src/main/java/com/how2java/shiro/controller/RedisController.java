package com.how2java.shiro.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;
    @RequestMapping("addRedis.htmls")
    @ResponseBody
    public Object addRedis(String key,String value){
        ValueOperations operations=redisTemplate.opsForValue();
        operations.set(key,value);
        return "abc";
    }
    @RequestMapping("getRedis.htmls")
    @ResponseBody
    public Object getRedis(String key){
        ValueOperations operations=redisTemplate.opsForValue();
        return operations.get(key);
    }
}
