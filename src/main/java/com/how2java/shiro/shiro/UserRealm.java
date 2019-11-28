package com.how2java.shiro.shiro;

import com.how2java.shiro.entity.User;
import com.how2java.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 自定义realm
 * @author jianping.lu
 *
 */
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // TODO Auto-generated method stub
        System.out.println("授权");
        String userName=principalCollection.getPrimaryPrincipal().toString();
        User user=userService.findUser(userName);
        String perms=user.getPerms();
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(perms);
        return simpleAuthorizationInfo;
    }
    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken userToken) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("认证");

        //shiro判断逻辑
        UsernamePasswordToken token = (UsernamePasswordToken) userToken;
        String userName=token.getUsername();
        System.out.println(userName);
        User user=userService.findUser(userName);
        String pwd=user.getPassword();
        System.out.println(pwd);
        String salt=user.getSalt();
        System.out.println(salt);
        if(user == null){
            //用户名错误
            //shiro会抛出UnknownAccountException异常
          return null;
        }

        return new SimpleAuthenticationInfo(userName,pwd,ByteSource.Util.bytes(salt),getName());
    }
}
