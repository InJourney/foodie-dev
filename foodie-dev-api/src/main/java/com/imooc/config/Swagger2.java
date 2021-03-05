package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @auther ljt
 * @date 2021/2/26 16:43
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    //http://localhost:8088/swagger-ui.html
    //配置swagger2核心配置
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)//指定api类型给为swagger2
                   .apiInfo(apiInfo())                //用于定义api文档汇总信息
                   .select().apis(RequestHandlerSelectors.basePackage("com.imooc.controller")) //指定controller包
                   .paths(PathSelectors.any())        //所有controller
                   .build();
    }
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("天天吃货 电商平台接口")      //文档页标题
                .contact(new Contact("imooc","https://www.baidu.com",
                        "abc@qq.com"))      //联系人信息
                .description("提供的接口文档")     //详细信息
                .version("1.0.1")                 //版本号信息
                .termsOfServiceUrl("https://www.baidu.com")//网址信息
                .build();
    }
}
