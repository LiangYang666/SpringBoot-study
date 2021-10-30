package com.liang.controller;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping({"/", "/index"})
    public String toIndex(Model model){
        model.addAttribute("msg", "Hello, shiro");
        return "index";
    }
    @RequestMapping("/user/add")
    public String toAdd(){
        return "user/add";
    }
    @RequestMapping("/user/update")
    public String toUpdate(){
        return "user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        Subject user = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            user.login(token);
            model.addAttribute("msg", "成功登录");
            return "index";
        } catch (UnknownAccountException e){
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ice){
            model.addAttribute("msg", "用户密码错误");
            return "login";
        }
    }
    @RequestMapping("/noAuth")
    @ResponseBody
    public String noAuth(){
        return "未授权，无法访问";
    }

}
