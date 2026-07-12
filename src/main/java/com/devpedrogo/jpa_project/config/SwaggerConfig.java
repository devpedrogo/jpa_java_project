package com.devpedrogo.jpa_project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
                .info(new Info()
                    .title("Academia API - JpaProject")
                    .version("1.0.0")
                    .description("Sistema de gerenciamento de treinos, exercícios e avaliações físicas."))
                // Aplica a necessidade de autenticação globalmente no Swagger
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        // Define o formato do token (Bearer JWT)
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
