package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg", "<h2>Hello, thymeleaf</h2>");
        model.addAttribute("users", Arrays.asList("1", "2"));
        return "test";
    }

}
