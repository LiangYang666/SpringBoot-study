package com.liang.springboot04data;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("=====>>");
        //查看默认数据源 class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);     //HikariProxyConnection@163160871 wrapping com.mysql.cj.jdbc.ConnectionImpl@75a0c890

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druid数据源最大连接数 "+druidDataSource.getMaxActive());
        System.out.println("druid数据源最大初始化连接数 "+druidDataSource.getInitialSize());


    }

}
