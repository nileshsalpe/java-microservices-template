package com.salpe.api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(
                new Components()
                        .addSecuritySchemes("bearer-key", new SecurityScheme().
                                type(SecurityScheme.Type.HTTP).
                                scheme("bearer").
                                bearerFormat("JWT")))
                .addServersItem(new Server().description("prod").url("http://prod.acme.com/"))
                .addServersItem(new Server().description("pre-prod").url("http://dev.acme.com/"))
                .addServersItem(new Server().description("dev").url("http://localhost:8080/"))
                .info(new Info()
                        .title("My Api")
                        .version("v2")
                        .description("My platform description").
                                contact(new io.swagger.v3.oas.models.info.Contact()
                                        .email("nilesh.salpe@gmail.com").name("Nilesh Salpe")));
    }
}

