package com.burak.metro.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Metro API",
                description = "The client-server API provides an opportunity to view the interval of " +
                        "movement of trains of the Minsk metro in accordance with the current time",
                version = "1.0.0",
                contact = @Contact(
                        name = "Alexey Burak",
                        email = "burakalexey@yahoo.com",
                        url = "https://www.linkedin.com/in/alexey-burak/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/alexeyburak/metro/blob/main/LICENSE"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:3000/api",
                        description = "Development server"
                )
        },
        tags = {
                @Tag(
                        name = "Lines", description = "API for managing lines"
                )
        },
        externalDocs = @ExternalDocumentation(
                description = "API specification",
                url = "https://github.com/alexeyburak/metro/blob/main/docs/Specification-metro.md"
        )
)
public class SwaggerConfig {

}
