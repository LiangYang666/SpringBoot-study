package com.liang.config;

import com.liang.pojo.User;
import com.liang.service.UserService;
import com.liang.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("==>执行了 1 doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();   //拿到当前登陆的对象
        User user = (User) subject.getPrincipal();  //拿到user对象

        info.addStringPermission(user.getPerms());  //设置当前用户的权限

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("==>执行了 2 doGetAuthorizationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null){
            return null;
        }
        //密码认证 可以加密 md5 MD5盐值加密
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");   //存入user 方便在subject中取
    }
}
