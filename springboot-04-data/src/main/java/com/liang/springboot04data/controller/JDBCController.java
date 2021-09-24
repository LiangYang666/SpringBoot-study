package com.liang.springboot04data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/querytest")
    public String queryTest(){
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
        return listMap.toString();
    }
    @GetMapping("/add")
    public ModelAndView addUser(){
        String sql = "insert into mybatis.user values (6, 'test6', '123543')";
        jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/querytest");
    }

    @GetMapping("/edit/{id}")
    public void editUser(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        String sql = "update mybatis.user set name=?, pwd=? where id="+id;
        Object[] param = new Object[2];
        param[0] = "修改";
        param[1] = "000000";
        jdbcTemplate.update(sql, param);
        response.sendRedirect("/querytest");
    }
}
