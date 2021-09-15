package com.liang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//如果我们要扩展SpringMvc 官方建议我们这样去做
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // 试图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/liang").setViewName("test");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //配置的国际化解析器注册到bean中后就可以使用了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }





}
