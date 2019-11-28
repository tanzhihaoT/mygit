package com.how2java.shiro.controller;
import com.how2java.shiro.entity.User;
import com.how2java.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("permission")
    public String permission(){
        return "permission";
    }

    @RequestMapping("toLogin")
    public String toLogin(User user, Model model){

        //System.out.println(newUser.getName()+newUser.getPassword());
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),user.getPassword());
        //执行登录方法,用捕捉异常去判断是否登录成功
        try {
            subject.login(userToken);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "main";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

    }

    @RequestMapping("addUser.html")
    public String adduser(){
        return "addUser";
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        user.setSalt(salt);
        String encodedPassword= new SimpleHash("md5",user.getPassword(),salt,2).toString();
        user.setPassword(encodedPassword);
        int i=userService.createUser(user);
        return "redirect:login";
    }

    @RequestMapping("updatePwd.html")
    public String updatePwd(){
        return "updatePwd";
    }
    @RequestMapping("updatePwd")
    public String updatePwd(User user,String oldPwd,Model model){
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),oldPwd);
        try {
            subject.login(userToken);
        } catch (AuthenticationException e) {
            model.addAttribute("error","原密码错误");
            return "updatePwd";
        }

        String password=user.getPassword();
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        int time=2;
        String algorithmName="md5";
        String encodedPassword=new SimpleHash(algorithmName,password,salt,time).toString();
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        int i=userService.updatePwd(user);
        return "redirect:login";
    }

    @RequestMapping("userInfo")
    public String userInfo(Model model){
        List<User> userList=userService.getAllUser();
        model.addAttribute("userList",userList);
        return "userInfo";
    }
}
