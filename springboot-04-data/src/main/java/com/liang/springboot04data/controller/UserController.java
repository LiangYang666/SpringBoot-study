package com.liang.springboot04data.controller;

import com.liang.springboot04data.dao.UserMapper;
import com.liang.springboot04data.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/query")
    public String queryUsers(){
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return "OK";
    }
}
