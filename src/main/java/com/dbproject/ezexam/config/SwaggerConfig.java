package com.dbproject.ezexam.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI().info(new Info().title("Spring Doc").version("1").description("Spring Doc"));
    }
}