package com.how2java.shiro.controller;

import com.how2java.shiro.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class DemoController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("demo")
    @ResponseBody
    public String[] demo(HttpServletRequest request){
        List<User2> userList = new ArrayList<User2>();

        User2 user1 = new User2();
        user1.setUserName("风雅颂");
        user1.setPassword("aw916132444");
        user1.setPhoneNum("13874877512");

        User2 user2 = new User2();
        user2.setUserName("水雷屯");
        user2.setPassword("xf82652215");
        user2.setPhoneNum("15576758485");

        User2 user3 = new User2();
        user3.setUserName("天山遁");
        user3.setPassword("sd555292222");
        user3.setPhoneNum("13515114556");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        try {
            redisTemplate.opsForValue().set("userList",userList,60,TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("出现异常");
        }
        return null;
    }

    @RequestMapping(value="getValue",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getValue(){
        Object object = redisTemplate.opsForValue().get("userList");
        return object;
    }
}
