package com.liang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/*").hasRole("vip1")
                .antMatchers("/level2/*").hasRole("vip2")
                .antMatchers("/level3/*").hasRole("vip3");

        http.formLogin()                   //开启跳转login界面
                .loginPage("/toLogin")    // 指定请求登陆网址时的请求地址 如不指定默认为spring自带的/login 指定后为自己controller写的/toLogin
                .loginProcessingUrl("/usr/login")   // 登陆信息成功后，表单提交的地址，地址为自己写表单时定义的 spring配置这个进行信息校验
                .usernameParameter("username")      //登陆表单中的username字段名称 验证的话将由spring处理
                .passwordParameter("password");     //登陆表单中的password字段名称 验证的话将由spring处理

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");      //  开启一个注销功能

        http.rememberMe()   //开启记住我选项 若不退出 将登陆信息保存至cookie 默认保存两周
                .rememberMeParameter("remember");   // 配置记住我的参数 在表单中定义字段名称
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("liang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3");
    }

}
