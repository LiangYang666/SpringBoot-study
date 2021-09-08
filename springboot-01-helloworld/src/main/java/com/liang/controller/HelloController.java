package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello/{p1}/{p2}")
    public String hello(@PathVariable int p1, @PathVariable int p2, HttpServletRequest request){

        return "hello"+p1+p2;
    }
}
