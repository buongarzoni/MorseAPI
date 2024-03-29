package com.translator.morseapi.config;

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
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Translator")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.translator.morseapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "MeLi Challenge API",
                "API para traducir texto con caracteres latinos a morse (cada caracter en morse es separado con un ' ' y cada palabra con dos ' ')",
                "1.0",
                "",
                new Contact("Christian Ricardo Buongarzoni", "https://www.linkedin.com/in/christian-r-buongarzoni/", "christian.buongarzoni@gmail.com"),
                null, null,
                Collections.emptyList()
        );
    }
}
