package com.checkmate_portal.chessclub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customizeOpenApi(){
        return new OpenAPI().info(
                new Info()
                        .title("CheckMate Portal Club")
                        .version("Premium Version")
                        .description("REST API Backend section for managing Chess Player")
                        .contact(
                                new Contact()
                                        .name("Heshan Sandakelum")
                                        .email("heshansandakelum2018@gmail.com")

                        )
        );
    }
}
