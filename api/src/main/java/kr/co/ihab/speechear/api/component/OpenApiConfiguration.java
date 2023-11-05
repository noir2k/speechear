package kr.co.ihab.speechear.api.component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
//    public static final String BASIC_SCHEME = "basic";
    public static final String JWT_SCHEME = "Bearer";
    @Bean
    public OpenAPI SpeechEarOpenAPI() {
        SecurityScheme jwtScheme = new SecurityScheme()
                .name(JWT_SCHEME)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

//        SecurityScheme basicScheme = new SecurityScheme()
//                .name(BASIC_SCHEME)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("basic");

        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(JWT_SCHEME, jwtScheme)
//                                .addSecuritySchemes(BASIC_SCHEME, basicScheme)
                )
                .addSecurityItem(new SecurityRequirement()
//                        .addList(BASIC_SCHEME)
                        .addList(JWT_SCHEME)
                )
                .info(new Info().title("SpeechEar API")
                        .description("SpeechEar API Reference for Developers")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpeechEar GitHub")
                        .url("https://github.org"));
    }
}
