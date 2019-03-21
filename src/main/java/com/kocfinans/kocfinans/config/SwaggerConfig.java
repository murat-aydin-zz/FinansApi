package com.kocfinans.kocfinans.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kocfinans.kocfinans"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

       return  new ApiInfo(
                "KocFinans API",
                "KocFinans Spring Boot REST API Services",
                "1.0",
                "Terms of Service",
               new Contact("Murat","Aydın","murataydın@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html",
               Collections.emptyList()
        );

    }
}
