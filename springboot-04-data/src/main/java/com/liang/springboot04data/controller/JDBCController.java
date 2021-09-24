package com.liang.springboot04data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
