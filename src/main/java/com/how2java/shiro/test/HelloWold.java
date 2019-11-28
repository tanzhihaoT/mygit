package com.how2java.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWold {
    /**
     * 1.获取安全管理器
     * 2.获取用户
     * 3.用户登录验证
     * 4.权限管理
     * 5.角色管理
     * 6.session
     */
    public static void main(String[] args) {
        //1获取安全管理器
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager=factory.getInstance();
        //2.设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //3获取Subject对象,即将登录的用户
        Subject currentUser=SecurityUtils.getSubject();
        Session session=currentUser.getSession();
        session.setAttribute("name","谭芝豪");
        String value=(String)session.getAttribute("name");
        System.out.println(value);

        //判断用户是否登录 false没有登录
        if (currentUser.isAuthenticated()==false){
            //封装用户名和密码
            UsernamePasswordToken token=new UsernamePasswordToken("li4","abcde");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                System.out.println("登录成功");
            } catch (UnknownAccountException e) {
                System.out.println("用户不存在");
            }catch (IncorrectCredentialsException e){
                System.out.println("密码错误");
            }catch (LockedAccountException e){
                System.out.println("用户已锁死");
            }catch (AuthenticationException e){
                System.out.println("验证异常");
            }
        }

        //判断是否拥有指定的权限
        if(currentUser.isPermitted("addOrder")){
            System.out.println("有指定的权限");
        }else{
            System.out.println("没有指定的权限");
        }

        //退出登录
        currentUser.logout();
        System.out.println("退出登录");
    }

}
