package com.liang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置了Swagger 的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("Liang Yang", "https://github.com/LiangYang666", "mail.liangyang@qq.com");
        return new ApiInfo(
                "Liang的SwaggerAPI文档",
                "永远相信美好的事情即将发生",
                "1.0",
                "https://github.com/LiangYang666",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
