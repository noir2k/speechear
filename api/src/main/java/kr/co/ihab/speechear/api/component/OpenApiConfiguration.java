package kr.co.ihab.speechear.api.component;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI SpeechEarOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpeechEar API")
                        .description("SpeechEar API Reference for Developers")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpeechEar GitHub")
                        .url("https://github.org"));
    }
}
